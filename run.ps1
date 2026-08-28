# Runs the compiler.
#
#   .\run.ps1                        compile the default project in Tests/
#   .\run.ps1 --nodes                also list every AST node with its children
#   .\run.ps1 Tests/errors/*.txt     compile a different source set
#
# With no file arguments the compiler reads the seven fixtures in Tests/.

Set-Location $PSScriptRoot

if (-not (Test-Path out/app/Main.class)) {
    Write-Host 'Not built yet - running build.ps1 first.' -ForegroundColor Yellow
    & "$PSScriptRoot/build.ps1"
}

java -cp "out;lib/antlr-4.13.2-complete.jar" app.Main @args
