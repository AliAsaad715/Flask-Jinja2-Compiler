param(
    [string]$SitePath = "generated\static_site"
)

$ErrorActionPreference = "Stop"
$siteRoot = (Resolve-Path -LiteralPath $SitePath).Path
$htmlFiles = @(Get-ChildItem -LiteralPath $siteRoot -Filter "*.html" -File)

if ($htmlFiles.Count -eq 0) {
    throw "No generated HTML files were found in $siteRoot"
}

$problems = [System.Collections.Generic.List[string]]::new()
$checkedLinks = 0
$linkPattern = [regex]'(?:href|src|action)="([^"]+)"'

foreach ($htmlFile in $htmlFiles) {
    $html = Get-Content -Raw -Encoding UTF8 -LiteralPath $htmlFile.FullName

    if ($html.Contains("{{") -or $html.Contains("{%")) {
        $problems.Add("Jinja syntax remains in $($htmlFile.Name)")
    }

    foreach ($match in $linkPattern.Matches($html)) {
        $target = $match.Groups[1].Value
        if ($target -match '^(https?:|mailto:|tel:|data:|#)') {
            continue
        }

        $pathPart = ($target -split '[?#]', 2)[0]
        if ([string]::IsNullOrWhiteSpace($pathPart)) {
            continue
        }

        $checkedLinks++
        $resolvedTarget = [IO.Path]::GetFullPath((Join-Path $htmlFile.DirectoryName $pathPart))
        if (-not $resolvedTarget.StartsWith($siteRoot + [IO.Path]::DirectorySeparatorChar)) {
            $problems.Add("Link leaves the generated site: $($htmlFile.Name) -> $target")
            continue
        }
        if (-not (Test-Path -LiteralPath $resolvedTarget)) {
            $problems.Add("Missing local target: $($htmlFile.Name) -> $target")
        }
    }
}

if ($problems.Count -gt 0) {
    $problems | ForEach-Object { Write-Error $_ }
    throw "Static site verification failed with $($problems.Count) problem(s)."
}

Write-Output "Static site verification passed."
Write-Output "HTML files: $($htmlFiles.Count)"
Write-Output "Local links and assets checked: $checkedLinks"
