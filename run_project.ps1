$ErrorActionPreference = "Stop"

Write-Output "Compiling Java sources..."
javac -encoding UTF-8 -cp "lib\antlr-4.13.2-complete.jar" -d out src\antlr\*.java src\AST\*.java src\AST\template\*.java src\AST\template\expr\*.java src\AST\css\*.java src\Symbol\*.java src\Analysis\*.java src\Generator\*.java src\Visitor\*.java src\app\*.java
if ($LASTEXITCODE -ne 0) {
    throw "Java compilation failed."
}

Write-Output "Running compiler pipeline..."
java "-Dfile.encoding=UTF-8" -cp "out;lib\antlr-4.13.2-complete.jar" app.Main
if ($LASTEXITCODE -ne 0) {
    throw "Compiler pipeline failed."
}

Write-Output "Verifying generated static site..."
& "$PSScriptRoot\Tests\verify_static_site.ps1"

Write-Output "Project build and verification completed successfully."
