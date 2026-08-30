

$ErrorActionPreference = 'Stop'

$Path = 'Tests'
$forward = @()
$i = 0
while ($i -lt $args.Count) {
    $a = $args[$i]
    if ($a -eq '-Path' -or $a -eq '--Path') {
        if ($i + 1 -ge $args.Count) { throw '-Path needs a directory argument.' }
        $Path = $args[$i + 1]
        $i += 2
    } elseif ($a -match '^-{1,2}Path=(.+)$') {
        $Path = $Matches[1]
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


& "$PSScriptRoot/run.ps1" @forward

while ($true) {
    if (-not $state.dirty) { Start-Sleep -Milliseconds 250; continue }

    Start-Sleep -Milliseconds 300   # debounce: one save, one compile
    $state.dirty = $false
    Write-Host "`n=== change detected - recompiling ===`n" -ForegroundColor Cyan
    try {
        & "$PSScriptRoot/run.ps1" @forward
    } catch {
        Write-Host "run.ps1 failed: $_" -ForegroundColor Red
    }

}