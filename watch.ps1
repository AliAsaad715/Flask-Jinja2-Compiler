$ErrorActionPreference = 'Stop'

$Path = 'Tests'
$pathGiven = $false
$forward = @()
$i = 0
while ($i -lt $args.Count) {
    $a = $args[$i]
    if ($a -eq '-Path' -or $a -eq '--Path') {
        if ($i + 1 -ge $args.Count) { throw '-Path needs a directory argument.' }
        $Path = $args[$i + 1]
        $pathGiven = $true
        $i += 2
    } elseif ($a -match '^-{1,2}Path=(.+)$') {
        $Path = $Matches[1]
        $pathGiven = $true
        $i++
    } else {
        $forward += $a
        $i++
    }
}

$watchRoot = Resolve-Path $Path -ErrorAction SilentlyContinue
if (-not $watchRoot) { throw "Nothing to watch: '$Path' does not exist." }


foreach ($own in 'generated', 'out') {
    if (Test-Path (Join-Path $watchRoot.Path $own)) {
        Write-Host "warning: '$own' is inside the watched directory - its writes will re-trigger the watcher." -ForegroundColor Yellow
    }
}

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $watchRoot.Path
$watcher.IncludeSubdirectories = $true
$watcher.Filter = '*'


$state = [hashtable]::Synchronized(@{ dirty = $false })
foreach ($kind in 'Changed', 'Created', 'Renamed', 'Deleted') {
    Register-ObjectEvent $watcher $kind -Action { $event.MessageData.dirty = $true } -MessageData $state | Out-Null
}
$watcher.EnableRaisingEvents = $true

Write-Host "Watching $($watchRoot.Path) - Ctrl+C to stop." -ForegroundColor Cyan

function Invoke-Compile {
    if ($forward.Count -gt 0) {
        & "$PSScriptRoot/run.ps1" @forward
        return
    }
    if ($pathGiven) {
        $sources = @(Get-ChildItem -Path $watchRoot.Path -File -Recurse |
            Where-Object { $_.Extension -match '^\.(txt|py|html?|jinja|css)$' } |
            ForEach-Object { $_.FullName })
        if ($sources.Count -eq 0) {
            Write-Host "No fixture files under $($watchRoot.Path) - nothing to compile." -ForegroundColor Yellow
            return
        }
        & "$PSScriptRoot/run.ps1" @sources
        return
    }
    & "$PSScriptRoot/run.ps1"
}

Invoke-Compile

while ($true) {
    if (-not $state.dirty) { Start-Sleep -Milliseconds 250; continue }

    Start-Sleep -Milliseconds 300
    $state.dirty = $false
    Write-Host "`n=== change detected - recompiling ===`n" -ForegroundColor Cyan
    try {
        Invoke-Compile
    } catch {
        Write-Host "run.ps1 failed: $_" -ForegroundColor Red
    }

}