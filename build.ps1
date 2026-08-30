# Builds the compiler.
#
#   .\build.ps1             incremental compile - only changed sources are recompiled
#   .\build.ps1 -Grammar    regenerate out-of-date ANTLR parsers first, then compile
#   .\build.ps1 -Clean      full rebuild: regenerate every parser, wipe out/,
#                           recompile everything

param(
    [switch]$Grammar,
    [switch]$Clean
)

$ErrorActionPreference = 'Stop'
Set-Location $PSScriptRoot

$Antlr = 'lib/antlr-4.13.2-complete.jar'

# Resolve a JDK. The machine's PATH `java` can be a broken Oracle javapath
# shim, so prefer JAVA_HOME and the JDKs IntelliJ downloads into ~/.jdks.
$Java  = 'java'
$Javac = 'javac'
if ($env:JAVA_HOME -and (Test-Path (Join-Path $env:JAVA_HOME 'bin\java.exe'))) {
    $Java  = Join-Path $env:JAVA_HOME 'bin\java.exe'
    $Javac = Join-Path $env:JAVA_HOME 'bin\javac.exe'
} else {
    $jdk = Get-ChildItem "$env:USERPROFILE\.jdks" -Directory -ErrorAction SilentlyContinue |
        Sort-Object Name -Descending |
        Where-Object { Test-Path (Join-Path $_.FullName 'bin\java.exe') } |
        Select-Object -First 1
    if ($jdk) {
        $Java  = Join-Path $jdk.FullName 'bin\java.exe'
        $Javac = Join-Path $jdk.FullName 'bin\javac.exe'
        Write-Host "Using JDK: $($jdk.FullName)" -ForegroundColor DarkGray
    }
}

# ---------------------------------------------------------------------------
# Stage 1 - regenerate the ANTLR parsers, but only the pairs that are stale.
# ---------------------------------------------------------------------------

# Base names of the artifacts ANTLR generates for each pair, the .g4 inputs,
# and a label for messages. PythonLexer.g4 has no @header, so its pair is
# generated with -package antlr; the template and CSS grammars declare
# `@header { package antlr; }` themselves - passing -package as well would
# emit it twice.
$grammarPairs = @(
    @{ Label = 'Python';   Files = @('src/antlr/PythonLexer.g4', 'src/antlr/PythonParser.g4');       Names = @('PythonLexer', 'PythonParser');     Pkg = @('-package', 'antlr') }
    @{ Label = 'template'; Files = @('src/antlr/TemplateLexer.g4', 'src/antlr/TemplateParser.g4');   Names = @('TemplateLexer', 'TemplateParser'); Pkg = @() }
    @{ Label = 'CSS';      Files = @('src/antlr/CssLexer.g4', 'src/antlr/CssParser.g4');             Names = @('CssLexer', 'CssParser');           Pkg = @() }
)

function Test-GrammarUpToDate($pair) {
    # A pair is up to date when every artifact ANTLR generates from it exists
    # and is newer than the newest .g4 input of the pair.
    $newestInput = $pair.Files |
        ForEach-Object { (Get-Item $_).LastWriteTimeUtc.Ticks } |
        Measure-Object -Maximum |
        Select-Object -ExpandProperty Maximum

    foreach ($name in $pair.Names) {
        foreach ($ext in 'java', 'tokens', 'interp') {
            $artifact = "src/antlr/$name.$ext"
            if (-not (Test-Path $artifact)) { return $false }
            if ((Get-Item $artifact).LastWriteTimeUtc.Ticks -lt $newestInput) { return $false }
        }
        # -visitor also generates four listener/visitor files per parser.
        # Lexers get none, so only parser names are checked - a missing or
        # stale one would break compilation.
        if ($name -like '*Parser') {
            foreach ($suffix in 'Listener', 'BaseListener', 'Visitor', 'BaseVisitor') {
                $artifact = "src/antlr/$name$suffix.java"
                if (-not (Test-Path $artifact)) { return $false }
                if ((Get-Item $artifact).LastWriteTimeUtc.Ticks -lt $newestInput) { return $false }
            }
        }
    }
    return $true
}

function Invoke-Antlr($pair) {
    $pkg   = $pair.Pkg
    $files = $pair.Files
    & $Java -jar $Antlr -Dlanguage=Java -visitor @pkg -o src/antlr -lib src/antlr @files
    if ($LASTEXITCODE -ne 0) { throw "ANTLR failed on the $($pair.Label) grammar" }
}

$regenerated = 0
if ($Grammar -or $Clean) {
    foreach ($pair in $grammarPairs) {
        if ($Clean -or -not (Test-GrammarUpToDate $pair)) {
            Write-Host "Regenerating the $($pair.Label) parsers..." -ForegroundColor Cyan
            Invoke-Antlr $pair
            $regenerated++
        } else {
            Write-Host "The $($pair.Label) parsers are up to date - skipping." -ForegroundColor DarkGray
        }
    }
    if ($regenerated -eq 0) {
        Write-Host 'No grammar needs regenerating.' -ForegroundColor DarkGray
    }
}

# ---------------------------------------------------------------------------
# Stage 2 - compile only the sources that changed since the last build.
# ---------------------------------------------------------------------------

Write-Host 'Compiling...' -ForegroundColor Cyan

# State of every source at the last successful build:
# path|mtime ticks|size|class files (relative to out/, comma separated).
# The class list covers the main class plus every nested one - anonymous
# classes and generated ANTLR context classes included. It lives inside out/,
# so wiping out/ also resets the incremental state.
$stateFile = Join-Path $PSScriptRoot 'out\.buildstate'
$outRoot   = Join-Path $PSScriptRoot 'out'
$state = @{}
if (-not $Clean -and (Test-Path $stateFile)) {
    foreach ($line in (Get-Content $stateFile)) {
        $parts = $line -split '\|', 4
        if ($parts.Count -eq 4) {
            $state[$parts[0]] = @{ Time = [long]$parts[1]; Size = [long]$parts[2]; Classes = $parts[3] }
        }
    }
}

$all = Get-ChildItem -Path src -Filter *.java -Recurse | ForEach-Object {
    [pscustomobject]@{
        Rel  = $_.FullName.Substring($PSScriptRoot.Length + 1).Replace('\', '/')
        Time = $_.LastWriteTimeUtc.Ticks
        Size = $_.Length
        Full = $_.FullName
    }
}

# Where a source's main class file lives in out/ (nested ones sit next to it).
function Get-ClassPath($rel) {
    Join-Path $outRoot (($rel -replace '^src/', '') -replace '\.java$', '.class')
}

# A grammar regeneration rewrites parser sources that other classes build on
# (e.g. CssAstBuilder extends CssParserBaseVisitor), so dependents must be
# recompiled too - a full compile is the only safe response, and it is rare.
$fullBuild = $Clean -or ($state.Count -eq 0) -or ($regenerated -gt 0)

if (-not $fullBuild) {
    # Sources deleted or renamed since the last build.
    $currentRels = @($all | ForEach-Object { $_.Rel })
    $removed = @($state.Keys | Where-Object { $currentRels -notcontains $_ })

    $changed = @($all | Where-Object {
        $prev = $state[$_.Rel]
        if (-not $prev -or $prev.Time -ne $_.Time -or $prev.Size -ne $_.Size) { return $true }
        # The state can claim a file was built while one of its class files is
        # gone (e.g. out/ was tidied by hand) - such sources must be
        # recompiled, nested and ANTLR context classes included.
        $classes = @($prev.Classes -split ',' | Where-Object { $_ })
        if ($classes.Count -eq 0) {
            return -not (Test-Path (Get-ClassPath $_.Rel))
        }
        foreach ($cf in $classes) {
            if (-not (Test-Path (Join-Path $outRoot $cf))) { return $true }
        }
        return $false
    })

    # Sources that reference a changed OR deleted class must be recompiled
    # too, or javac would leave their class files stale - against new
    # signatures (NoSuchMethodError) or against classes that no longer exist
    # (NoClassDefFoundError, unnoticed because the stale class file is never
    # rebuilt). References are found by simple class name, which covers
    # imports and same-package uses; over-matching only recompiles a few
    # extra files. The closure is transitive: a file pulled in this way can
    # pull in its own users. Recompiling a file that still names a deleted
    # class makes javac fail loudly - which is the point.
    $directChanges = $changed.Count
    $needed = @{}
    foreach ($c in $changed) { $needed[$c.Rel] = $true }
    $pending = New-Object System.Collections.Queue
    foreach ($c in $changed) { $pending.Enqueue([IO.Path]::GetFileNameWithoutExtension($c.Rel)) }
    foreach ($rel in $removed) { $pending.Enqueue([IO.Path]::GetFileNameWithoutExtension($rel)) }
    $contents = @{}
    while ($pending.Count -gt 0) {
        $name = $pending.Dequeue()
        $namePattern = '\b' + [regex]::Escape($name) + '\b'
        foreach ($s in $all) {
            if ($needed.ContainsKey($s.Rel)) { continue }
            if (-not $contents.ContainsKey($s.Rel)) {
                $contents[$s.Rel] = Get-Content $s.Full -Raw
            }
            if ($contents[$s.Rel] -match $namePattern) {
                $needed[$s.Rel] = $true
                $pending.Enqueue([IO.Path]::GetFileNameWithoutExtension($s.Rel))
            }
        }
    }
    $changed = @($all | Where-Object { $needed.ContainsKey($_.Rel) })

    # Drop the class files of deleted sources, including nested ones, so no
    # stale classes linger in out/.
    foreach ($rel in $removed) {
        $classPath = Get-ClassPath $rel
        Get-Item $classPath -ErrorAction SilentlyContinue | Remove-Item -Force
        Get-Item ($classPath -replace '\.class$', '$*.class') -ErrorAction SilentlyContinue | Remove-Item -Force
    }
    if ($removed.Count -gt 0) {
        Write-Host "Removed classes of $($removed.Count) deleted source(s) from out/." -ForegroundColor DarkGray
    }

    if ($changed.Count -eq 0 -and $removed.Count -eq 0) {
        Write-Host 'All sources are up to date - nothing to compile.' -ForegroundColor Green
        exit 0
    }
}

if ($fullBuild) {
    if (Test-Path out) { Remove-Item out -Recurse -Force }
    New-Item -ItemType Directory out | Out-Null
    Write-Host '  full build: compiling all sources.' -ForegroundColor DarkGray
    $toCompile = $all
} else {
    if ($changed.Count -gt $directChanges) {
        Write-Host "  incremental: compiling $($changed.Count) file(s) ($directChanges changed, $($changed.Count - $directChanges) dependents)." -ForegroundColor DarkGray
    } elseif ($changed.Count -gt 0) {
        Write-Host "  incremental: compiling $($changed.Count) changed file(s)." -ForegroundColor DarkGray
    } else {
        Write-Host '  no changed sources - only stale classes were removed.' -ForegroundColor DarkGray
    }
    $toCompile = $changed
}

if ($toCompile.Count -gt 0) {
    # Forward slashes and no BOM: javac treats a backslash in an argfile as an
    # escape, and refuses an argfile that starts with a byte-order mark.
    $listPath = Join-Path $PSScriptRoot 'sources.txt'
    [System.IO.File]::WriteAllLines($listPath, @($toCompile | ForEach-Object { $_.Full.Replace('\', '/') }))

    # Held in a variable so PowerShell does not read the leading '@' as splatting.
    # out/ is on the classpath so unchanged classes resolve without recompiling.
    $argFile = '@' + $listPath.Replace('\', '/')
    & $Javac -encoding UTF-8 -cp "out;$Antlr" -d out $argFile
    $compileExit = $LASTEXITCODE

    Remove-Item $listPath
    if ($compileExit -ne 0) { throw 'Compilation failed' }
}

# Record the state only after a successful compile, so a failed build leaves
# the previous state intact and the next run retries the same files. For each
# source, remember every class file it produced - the main class plus all
# nested ones (anonymous classes and generated ANTLR context classes included)
# - so later builds detect it when any of them goes missing.
$compiled = @{}
foreach ($t in $toCompile) { $compiled[$t.Rel] = $true }

$stateLines = foreach ($s in $all) {
    $classes = $state[$s.Rel].Classes
    if ($compiled.ContainsKey($s.Rel)) {
        $dir  = Split-Path (Get-ClassPath $s.Rel) -Parent
        $base = [IO.Path]::GetFileNameWithoutExtension($s.Rel)
        $produced = @(Get-ChildItem -Path $dir -Filter "$base.class" -ErrorAction SilentlyContinue) +
                    @(Get-ChildItem -Path $dir -Filter "$base`$*.class" -ErrorAction SilentlyContinue)
        $classes = ($produced | ForEach-Object { $_.FullName.Substring($outRoot.Length + 1).Replace('\', '/') }) -join ','
    }
    '{0}|{1}|{2}|{3}' -f $s.Rel, $s.Time, $s.Size, $classes
}
[System.IO.File]::WriteAllLines($stateFile, @($stateLines))

Write-Host 'Build succeeded.' -ForegroundColor Green
