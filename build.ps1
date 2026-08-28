# Regenerates the ANTLR parsers, then compiles the compiler into out/.
#
#   .\build.ps1            compile only
#   .\build.ps1 -Grammar   regenerate the parsers first, then compile

param([switch]$Grammar)

$ErrorActionPreference = 'Stop'
Set-Location $PSScriptRoot

$Antlr = 'lib/antlr-4.13.2-complete.jar'

if ($Grammar) {
    Write-Host 'Regenerating parsers...' -ForegroundColor Cyan

    # PythonLexer.g4 has no @header, so its package comes from -package.
    java -jar $Antlr -Dlanguage=Java -visitor -package antlr -o src/antlr -lib src/antlr `
        src/antlr/PythonLexer.g4 src/antlr/PythonParser.g4
    if ($LASTEXITCODE -ne 0) { throw 'ANTLR failed on the Python grammar' }

    # The template and CSS grammars declare `@header { package antlr; }`
    # themselves - passing -package as well would emit it twice.
    java -jar $Antlr -Dlanguage=Java -visitor -o src/antlr -lib src/antlr `
        src/antlr/TemplateLexer.g4 src/antlr/TemplateParser.g4
    if ($LASTEXITCODE -ne 0) { throw 'ANTLR failed on the template grammar' }

    java -jar $Antlr -Dlanguage=Java -visitor -o src/antlr -lib src/antlr `
        src/antlr/CssLexer.g4 src/antlr/CssParser.g4
    if ($LASTEXITCODE -ne 0) { throw 'ANTLR failed on the CSS grammar' }
}

Write-Host 'Compiling...' -ForegroundColor Cyan

if (Test-Path out) { Remove-Item out -Recurse -Force }
New-Item -ItemType Directory out | Out-Null

# Forward slashes and no BOM: javac treats a backslash in an argfile as an
# escape, and refuses an argfile that starts with a byte-order mark.
$sources = Get-ChildItem -Path src -Filter *.java -Recurse |
    ForEach-Object { $_.FullName.Replace('\', '/') }

$listPath = Join-Path $PSScriptRoot 'sources.txt'
[System.IO.File]::WriteAllLines($listPath, $sources)

# Held in a variable so PowerShell does not read the leading '@' as splatting.
$argFile = '@' + $listPath.Replace('\', '/')
javac -encoding UTF-8 -cp $Antlr -d out $argFile
$compileExit = $LASTEXITCODE

Remove-Item $listPath
if ($compileExit -ne 0) { throw 'Compilation failed' }
Write-Host 'Build succeeded.' -ForegroundColor Green
