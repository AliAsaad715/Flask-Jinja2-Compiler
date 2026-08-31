# Runs the compiler.
#
#   .\run.ps1                        compile the default project in Tests/
#   .\run.ps1 --nodes                also list every AST node with its children
#   .\run.ps1 Tests/errors/*.txt     compile a different source set
#
# With no file arguments the compiler reads the seven fixtures in Tests/.

Set-Location $PSScriptRoot

# Resolve a JDK, mirroring build.ps1: prefer JAVA_HOME, then ~/.jdks.
$Java = 'java'
if ($env:JAVA_HOME -and (Test-Path (Join-Path $env:JAVA_HOME 'bin\java.exe'))) {
    $Java = Join-Path $env:JAVA_HOME 'bin\java.exe'
} else {
    $jdk = Get-ChildItem "$env:USERPROFILE\.jdks" -Directory -ErrorAction SilentlyContinue |
        Sort-Object Name -Descending |
        Where-Object { Test-Path (Join-Path $_.FullName 'bin\java.exe') } |
        Select-Object -First 1
    if ($jdk) { $Java = Join-Path $jdk.FullName 'bin\java.exe' }
}

if (-not (Test-Path out/app/Main.class)) {
    Write-Host 'Not built yet - running build.ps1 first.' -ForegroundColor Yellow
    & "$PSScriptRoot/build.ps1"
}

# Main writes UTF-8 bytes to stdout. A console left on the legacy code page
# (437/1252) decodes them as mojibake - the Arabic strings in the fixtures come
# out as gibberish. Switch the console to UTF-8 for the run and put the old
# code page back afterwards, so the shell is left as it was found.
$previousEncoding = [Console]::OutputEncoding
try {
    [Console]::OutputEncoding = New-Object System.Text.UTF8Encoding $false
    # Quoted: PowerShell 5.1 splits a bare -Dfile.encoding=UTF-8 at the dot.
    & $Java '-Dfile.encoding=UTF-8' '-Dstdout.encoding=UTF-8' '-Dstderr.encoding=UTF-8' `
        -cp "out;lib/antlr-4.13.2-complete.jar" app.Main @args
} finally {
    [Console]::OutputEncoding = $previousEncoding
}
