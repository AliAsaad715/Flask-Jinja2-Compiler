# Semantic Error Fixtures

Run these fixtures with:

```powershell
java -cp "out;lib\antlr-4.13.2-complete.jar" app.Main Tests\semantic\bad_app_py.txt Tests\semantic\bad_products_html.txt Tests\semantic\bad_detail_html.txt
```

They intentionally trigger Python/Flask and Jinja semantic diagnostics.
