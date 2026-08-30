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

& $Java -cp "out;lib/antlr-4.13.2-complete.jar" app.Main @args
