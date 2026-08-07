package Generator;

import AST.AstNode;
import AST.template.AttributeExprPartNode;
import AST.template.AttributeNode;
import AST.template.AttributeTextPartNode;
import AST.template.AttributeValuePartNode;
import AST.template.BlockNode;
import AST.template.ElementNode;
import AST.template.ExtendsNode;
import AST.template.ForNode;
import AST.template.IfNode;
import AST.template.PrintNode;
import AST.template.TemplateFileNode;
import AST.template.TemplateItemNode;
import AST.template.TextNode;
import AST.template.WithNode;
import AST.template.expr.AttrExpr;
import AST.template.expr.CallArgNode;
import AST.template.expr.CallExpr;
import AST.template.expr.ExprNode;
import AST.template.expr.LiteralExpr;
import AST.template.expr.NameExpr;
import AST.template.expr.RawExpr;
import Analysis.PythonValueExtractor;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/** Generates browser-ready HTML from the Python and template ASTs. */
public class StaticSiteGenerator {
    private static final Set<String> VOID_ELEMENTS = Set.of(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
    );
    private static final Pattern URL_FOR_ENDPOINT = Pattern.compile(
            "url_for\\(\\s*['\"]([^'\"]+)['\"]"
    );
    private static final Pattern SLICE = Pattern.compile("(.+)\\[:([0-9]+)]");
    private static final Pattern LENGTH_COMPARISON = Pattern.compile(
            "(.+)\\|length(>=|<=|==|!=|>|<)([0-9]+)"
    );
    private static final Pattern COMPARISON = Pattern.compile(
            "(.+?)(>=|<=|==|!=|>|<)(.+)"
    );

    private Map<String, TemplateFileNode> templates = Map.of();
    private Map<String, Path> templateSources = Map.of();

    public List<GeneratedFile> generate(
            AstNode pythonAst,
            Map<String, TemplateFileNode> templateAsts,
            Map<String, Path> sourceTemplates,
            List<Path> cssSources,
            Path outputRoot
    ) throws IOException {
        templates = new LinkedHashMap<>(templateAsts);
        templateSources = new LinkedHashMap<>(sourceTemplates);

        resetOutput(outputRoot);
        Path assets = outputRoot.resolve("assets");
        Files.createDirectories(assets);

        List<GeneratedFile> generated = new ArrayList<>();
        copyCss(cssSources, assets, generated);
        writePlaceholder(assets, generated);

        Map<String, Object> pythonValues = new PythonValueExtractor().collect(pythonAst);
        List<Map<String, Object>> products = productList(pythonValues.get("products"));
        validateProductIds(products);

        writeHtml(outputRoot.resolve("index.html"), indexPage(), null, "page", generated);

        if (templates.containsKey("products.html")) {
            Map<String, Object> context = new LinkedHashMap<>(pythonValues);
            context.put("products", products);
            writeRenderedTemplate("products.html", "products.html", context, outputRoot, generated);
        }

        for (Map<String, Object> product : products) {
            String id = filePart(product.get("id"));
            Map<String, Object> context = new LinkedHashMap<>(pythonValues);
            context.put("product", product);

            if (templates.containsKey("product_detail.html")) {
                writeRenderedTemplate(
                        "product_detail.html", "product-" + id + ".html",
                        context, outputRoot, generated
                );
            }

            if (templates.containsKey("delete_product.html")) {
                writeRenderedTemplate(
                        "delete_product.html", "delete-product-" + id + ".html",
                        context, outputRoot, generated
                );
            }
        }

        if (templates.containsKey("add_product.html")) {
            Map<String, Object> context = new LinkedHashMap<>(pythonValues);
            context.put("generation_note", "تُضاف البيانات إلى مصفوفة products ثم يُعاد تشغيل المولد.");
            writeRenderedTemplate("add_product.html", "add-product.html", context, outputRoot, generated);
        }

        Path readme = outputRoot.resolve("README.txt");
        Files.writeString(readme, generatedReadme(products.size()), StandardCharsets.UTF_8);
        generated.add(new GeneratedFile("readme", null, readme));

        verifyStaticHtml(outputRoot);
        return generated;
    }

    public static String format(List<GeneratedFile> files) {
        if (files == null || files.isEmpty()) return "No files generated.\n";
        StringBuilder output = new StringBuilder();
        for (GeneratedFile file : files) output.append("- ").append(file).append("\n");
        return output.toString();
    }

    private void writeRenderedTemplate(
            String templateName,
            String outputName,
            Map<String, Object> values,
            Path outputRoot,
            List<GeneratedFile> generated
    ) throws IOException {
        String html = renderTemplate(templateName, new RenderContext(values));
        writeHtml(
                outputRoot.resolve(outputName), html, templateSources.get(templateName),
                "page", generated
        );
    }

    private String renderTemplate(String templateName, RenderContext context) {
        TemplateFileNode template = templates.get(templateName);
        if (template == null) throw new IllegalArgumentException("Template AST was not found: " + templateName);

        ExtendsNode extendsNode = null;
        Map<String, BlockNode> overrides = new LinkedHashMap<>();
        for (TemplateItemNode item : template.getItems()) {
            if (item instanceof ExtendsNode node) extendsNode = node;
            if (item instanceof BlockNode block) overrides.put(block.getBlockName(), block);
        }

        if (extendsNode != null) {
            TemplateFileNode parent = templates.get(extendsNode.getTemplateName());
            if (parent == null) {
                throw new IllegalArgumentException(
                        "Parent template AST was not found: " + extendsNode.getTemplateName()
                );
            }
            return renderItems(parent.getItems(), context, overrides);
        }
        return renderItems(template.getItems(), context, Map.of());
    }

    private String renderItems(
            Collection<? extends TemplateItemNode> items,
            RenderContext context,
            Map<String, BlockNode> overrides
    ) {
        StringBuilder html = new StringBuilder();
        for (TemplateItemNode item : items) html.append(renderItem(item, context, overrides));
        return html.toString();
    }

    private String renderItem(
            TemplateItemNode item,
            RenderContext context,
            Map<String, BlockNode> overrides
    ) {
        if (item instanceof TextNode text) return text.getText();
        if (item instanceof ExtendsNode) return "";
        if (item instanceof PrintNode print) return escapeHtml(formatValue(evaluate(print.getExpr(), context)));

        if (item instanceof BlockNode block) {
            BlockNode selected = overrides.getOrDefault(block.getBlockName(), block);
            return renderItems(selected.getBody(), context, Map.of());
        }

        if (item instanceof ForNode loop) {
            Object iterable = evaluate(loop.getIterable(), context);
            if (!(iterable instanceof Iterable<?> values)) return "";
            StringBuilder html = new StringBuilder();
            int index = 0;
            for (Object value : values) {
                index++;
                Map<String, Object> loopInfo = new LinkedHashMap<>();
                loopInfo.put("index", index);
                loopInfo.put("index0", index - 1);
                RenderContext child = context.with(loop.getVarName(), value).with("loop", loopInfo);
                html.append(renderItems(loop.getBody(), child, overrides));
            }
            return html.toString();
        }

        if (item instanceof IfNode condition) {
            List<TemplateItemNode> branch = truthy(evaluate(condition.getCondition(), context))
                    ? condition.getThenBody() : condition.getElseBody();
            return renderItems(branch, context, overrides);
        }

        if (item instanceof WithNode with) {
            RenderContext child = context;
            if (with.getVarName() != null && !with.getVarName().isBlank()) {
                child = context.with(with.getVarName(), evaluate(with.getValueExpr(), context));
            }
            return renderItems(with.getBody(), child, overrides);
        }

        if (item instanceof ElementNode element) return renderElement(element, context, overrides);
        return "";
    }

    private String renderElement(
            ElementNode element,
            RenderContext context,
            Map<String, BlockNode> overrides
    ) {
        String tag = element.getTagName();
        if ("!DOCTYPE".equalsIgnoreCase(tag)) {
            StringBuilder declaration = new StringBuilder("<!DOCTYPE");
            for (AttributeNode attribute : element.getAttributes()) {
                declaration.append(" ").append(attribute.getName());
            }
            return declaration.append(">").toString();
        }

        StringBuilder html = new StringBuilder("<").append(tag);
        for (AttributeNode attribute : element.getAttributes()) {
            html.append(" ").append(attribute.getName());
            if (!attribute.getValueParts().isEmpty()) {
                html.append("=\"")
                        .append(escapeAttribute(renderAttribute(attribute, context)))
                        .append("\"");
            }
        }
        html.append(">");

        if (!VOID_ELEMENTS.contains(tag.toLowerCase())) {
            html.append(renderItems(element.getBody(), context, overrides));
            html.append("</").append(tag).append(">");
        }
        return html.toString();
    }

    private String renderAttribute(AttributeNode attribute, RenderContext context) {
        StringBuilder value = new StringBuilder();
        for (AttributeValuePartNode part : attribute.getValueParts()) {
            if (part instanceof AttributeTextPartNode text) value.append(text.getText());
            else if (part instanceof AttributeExprPartNode expression) {
                value.append(formatValue(evaluate(expression.getExpr(), context)));
            }
        }
        return value.toString();
    }

    private Object evaluate(ExprNode expression, RenderContext context) {
        if (expression == null) return null;
        if (expression instanceof NameExpr name) return context.get(name.getName());
        if (expression instanceof LiteralExpr literal) return literalValue(literal.getLiteral());
        if (expression instanceof AttrExpr attr) {
            return property(evaluate(attr.getBase(), context), attr.getAttrName());
        }
        if (expression instanceof CallExpr call) return evaluateCall(call, context);
        if (expression instanceof RawExpr raw) return evaluateRaw(raw.getRaw(), context);
        return null;
    }

    private Object evaluateCall(CallExpr call, RenderContext context) {
        if ("get_flashed_messages".equals(call.getFunctionName())) return List.of();
        if (!"url_for".equals(call.getFunctionName())) return null;

        String endpoint = "";
        Map<String, Object> arguments = new LinkedHashMap<>();
        for (int index = 0; index < call.getArgs().size(); index++) {
            CallArgNode argument = call.getArgs().get(index);
            Object value = evaluate(argument.getValue(), context);
            if (index == 0 && (argument.getName() == null || argument.getName().isBlank())) {
                endpoint = formatValue(value);
            } else if (argument.getName() != null && !argument.getName().isBlank()) {
                arguments.put(argument.getName(), value);
            }
        }
        return staticUrl(endpoint, arguments);
    }

    private Object evaluateRaw(String rawExpression, RenderContext context) {
        String raw = rawExpression == null ? "" : rawExpression.trim();
        if (raw.isEmpty()) return "";
        if (raw.startsWith("url_for(")) return evaluateRawUrlFor(raw, context);

        Matcher slice = SLICE.matcher(raw);
        if (slice.matches()) {
            String value = formatValue(evaluateRaw(slice.group(1), context));
            int end = Integer.parseInt(slice.group(2));
            return value.substring(0, Math.min(end, value.length()));
        }

        Matcher length = LENGTH_COMPARISON.matcher(raw);
        if (length.matches()) {
            int actual = lengthOf(evaluateRaw(length.group(1), context));
            int expected = Integer.parseInt(length.group(3));
            return compare(BigDecimal.valueOf(actual), BigDecimal.valueOf(expected), length.group(2));
        }

        Matcher comparison = COMPARISON.matcher(raw);
        if (comparison.matches()) {
            return compare(
                    evaluateRaw(comparison.group(1), context),
                    evaluateRaw(comparison.group(3), context),
                    comparison.group(2)
            );
        }

        List<String> additions = splitTopLevel(raw, '+');
        if (additions.size() > 1) {
            StringBuilder value = new StringBuilder();
            for (String part : additions) value.append(formatValue(evaluateRaw(part, context)));
            return value.toString();
        }

        if (isQuoted(raw)) return unquote(raw);
        if (raw.matches("-?[0-9]+(?:\\.[0-9]+)?")) return new BigDecimal(raw);
        if ("true".equalsIgnoreCase(raw)) return true;
        if ("false".equalsIgnoreCase(raw)) return false;
        if ("none".equalsIgnoreCase(raw) || "null".equalsIgnoreCase(raw)) return null;
        return resolveAccess(raw, context);
    }

    private String evaluateRawUrlFor(String raw, RenderContext context) {
        Matcher endpointMatcher = URL_FOR_ENDPOINT.matcher(raw);
        if (!endpointMatcher.find()) return "#";

        String endpoint = endpointMatcher.group(1);
        Map<String, Object> arguments = new LinkedHashMap<>();
        String inside = raw.substring(raw.indexOf('(') + 1, raw.lastIndexOf(')'));
        List<String> parts = splitTopLevel(inside, ',');
        for (int index = 1; index < parts.size(); index++) {
            String argument = parts.get(index);
            int equals = topLevelIndex(argument, '=');
            if (equals < 1) continue;
            String name = argument.substring(0, equals).trim();
            String value = argument.substring(equals + 1).trim();
            arguments.put(name, evaluateRaw(value, context));
        }
        return staticUrl(endpoint, arguments);
    }

    private String staticUrl(String endpoint, Map<String, Object> arguments) {
        return switch (endpoint) {
            case "index", "products_list" -> "products.html";
            case "add_product" -> "add-product.html";
            case "product_detail" -> "product-" + filePart(arguments.get("product_id")) + ".html";
            case "delete_product" -> "delete-product-" + filePart(arguments.get("product_id")) + ".html";
            case "static" -> staticAsset(formatValue(arguments.get("filename")));
            default -> "#";
        };
    }

    private String staticAsset(String filename) {
        String normalized = filename == null ? "" : filename.replace('\\', '/');
        while (normalized.startsWith("/")) normalized = normalized.substring(1);
        if (normalized.startsWith("static/")) normalized = normalized.substring("static/".length());
        return "assets/" + normalized;
    }

    private Object resolveAccess(String expression, RenderContext context) {
        String[] parts = expression.trim().split("\\.");
        Object value = context.get(parts[0]);
        for (int index = 1; index < parts.length; index++) value = property(value, parts[index]);
        return value;
    }

    private Object property(Object base, String name) {
        if (base instanceof Map<?, ?> map) return map.get(name);
        if ("length".equals(name)) return lengthOf(base);
        return null;
    }

    private int lengthOf(Object value) {
        if (value == null) return 0;
        if (value instanceof CharSequence text) return text.length();
        if (value instanceof Collection<?> collection) return collection.size();
        if (value instanceof Map<?, ?> map) return map.size();
        return 0;
    }

    private boolean compare(Object left, Object right, String operator) {
        if (left instanceof Number || right instanceof Number) {
            try {
                BigDecimal leftNumber = new BigDecimal(formatValue(left));
                BigDecimal rightNumber = new BigDecimal(formatValue(right));
                int result = leftNumber.compareTo(rightNumber);
                return switch (operator) {
                    case ">" -> result > 0;
                    case "<" -> result < 0;
                    case ">=" -> result >= 0;
                    case "<=" -> result <= 0;
                    case "==" -> result == 0;
                    case "!=" -> result != 0;
                    default -> false;
                };
            } catch (NumberFormatException ignored) {
                // Use text comparison when a value is not numeric.
            }
        }

        int result = formatValue(left).compareTo(formatValue(right));
        return switch (operator) {
            case ">" -> result > 0;
            case "<" -> result < 0;
            case ">=" -> result >= 0;
            case "<=" -> result <= 0;
            case "==" -> result == 0;
            case "!=" -> result != 0;
            default -> false;
        };
    }

    private boolean truthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean bool) return bool;
        if (value instanceof Number number) return number.doubleValue() != 0;
        if (value instanceof CharSequence text) return !text.isEmpty();
        if (value instanceof Collection<?> collection) return !collection.isEmpty();
        if (value instanceof Map<?, ?> map) return !map.isEmpty();
        return true;
    }

    private Object literalValue(String literal) {
        if (literal == null) return "";
        if (literal.matches("-?[0-9]+(?:\\.[0-9]+)?")) return new BigDecimal(literal);
        return literal;
    }

    private String formatValue(Object value) {
        if (value == null) return "";
        if (value instanceof BigDecimal number) return number.toPlainString();
        return String.valueOf(value);
    }

    private String filePart(Object value) {
        String text = formatValue(value).trim();
        String safe = text.replaceAll("[^A-Za-z0-9_-]", "-").replaceAll("-+", "-");
        if (safe.isBlank()) throw new IllegalArgumentException("A product has an empty or invalid id");
        return safe;
    }

    private List<Map<String, Object>> productList(Object value) {
        if (!(value instanceof List<?> list)) {
            throw new IllegalArgumentException("Python data source 'products' must be a list of dictionaries");
        }

        List<Map<String, Object>> products = new ArrayList<>();
        for (Object item : list) {
            if (!(item instanceof Map<?, ?> map)) {
                throw new IllegalArgumentException("Every product must be a dictionary");
            }
            Map<String, Object> product = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                product.put(String.valueOf(entry.getKey()), entry.getValue());
            }
            products.add(product);
        }
        return products;
    }

    private void validateProductIds(List<Map<String, Object>> products) {
        Set<String> ids = new LinkedHashSet<>();
        for (Map<String, Object> product : products) {
            String id = filePart(product.get("id"));
            if (!ids.add(id)) throw new IllegalArgumentException("Duplicate product id: " + id);
        }
    }

    private void copyCss(List<Path> sources, Path assets, List<GeneratedFile> generated) throws IOException {
        for (Path source : sources) {
            String name = cssOutputName(source.getFileName().toString());
            Path output = assets.resolve(name);
            Files.copy(source, output, StandardCopyOption.REPLACE_EXISTING);
            generated.add(new GeneratedFile("css", source, output));
        }
    }

    private void writePlaceholder(Path assets, List<GeneratedFile> generated) throws IOException {
        Path output = assets.resolve("product-placeholder.svg");
        String svg = """
                <svg xmlns="http://www.w3.org/2000/svg" width="800" height="520" viewBox="0 0 800 520">
                  <rect width="800" height="520" fill="#e9eef5"/>
                  <rect x="250" y="135" width="300" height="210" rx="24" fill="#c6d2e3"/>
                  <circle cx="335" cy="220" r="34" fill="#ffffff"/>
                  <path d="M270 320l92-82 68 58 46-40 54 64z" fill="#ffffff"/>
                  <text x="400" y="405" text-anchor="middle" font-family="Arial" font-size="28" fill="#46566e">Product image</text>
                </svg>
                """;
        Files.writeString(output, svg, StandardCharsets.UTF_8);
        generated.add(new GeneratedFile("asset", null, output));
    }

    private void writeHtml(
            Path output, String html, Path source, String kind, List<GeneratedFile> generated
    ) throws IOException {
        Files.writeString(output, html, StandardCharsets.UTF_8);
        generated.add(new GeneratedFile(kind, source, output));
    }

    private void verifyStaticHtml(Path outputRoot) throws IOException {
        try (Stream<Path> paths = Files.walk(outputRoot)) {
            for (Path path : paths.filter(file -> file.toString().endsWith(".html")).toList()) {
                String html = Files.readString(path, StandardCharsets.UTF_8);
                if (html.contains("{{") || html.contains("{%")) {
                    throw new IOException("Generated HTML still contains Jinja syntax: " + path);
                }
            }
        }
    }

    private void resetOutput(Path outputRoot) throws IOException {
        if (Files.exists(outputRoot)) {
            try (Stream<Path> paths = Files.walk(outputRoot)) {
                for (Path path : paths.sorted(Comparator.reverseOrder()).toList()) Files.delete(path);
            }
        }
        Files.createDirectories(outputRoot);
    }

    private String cssOutputName(String fileName) {
        if (fileName.endsWith("_css.txt")) {
            return fileName.substring(0, fileName.length() - "_css.txt".length()) + ".css";
        }
        return fileName;
    }

    private String indexPage() {
        return """
                <!DOCTYPE html>
                <html lang="ar" dir="rtl">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="refresh" content="0; url=products.html">
                    <title>متجر المنتجات</title>
                </head>
                <body><a href="products.html">الانتقال إلى المنتجات</a></body>
                </html>
                """;
    }

    private String generatedReadme(int productCount) {
        return """
                Static site generated successfully
                ==================================

                Open index.html or products.html directly in a browser.
                The generated HTML files contain no Jinja code and require no Flask server.

                Product count: %d

                To add, edit, or delete a product:
                1. Update the products array in Tests/app_py.txt.
                2. Run the Java compiler again.
                3. Reopen the generated files.
                """.formatted(productCount);
    }

    private List<String> splitTopLevel(String value, char separator) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int depth = 0;
        boolean singleQuoted = false;
        boolean doubleQuoted = false;

        for (int index = 0; index < value.length(); index++) {
            char character = value.charAt(index);
            if (character == '\'' && !doubleQuoted) singleQuoted = !singleQuoted;
            else if (character == '"' && !singleQuoted) doubleQuoted = !doubleQuoted;
            else if (!singleQuoted && !doubleQuoted) {
                if (character == '(' || character == '[' || character == '{') depth++;
                else if (character == ')' || character == ']' || character == '}') depth--;
                else if (character == separator && depth == 0) {
                    parts.add(current.toString().trim());
                    current.setLength(0);
                    continue;
                }
            }
            current.append(character);
        }
        parts.add(current.toString().trim());
        return parts;
    }

    private int topLevelIndex(String value, char target) {
        boolean singleQuoted = false;
        boolean doubleQuoted = false;
        int depth = 0;
        for (int index = 0; index < value.length(); index++) {
            char character = value.charAt(index);
            if (character == '\'' && !doubleQuoted) singleQuoted = !singleQuoted;
            else if (character == '"' && !singleQuoted) doubleQuoted = !doubleQuoted;
            else if (!singleQuoted && !doubleQuoted) {
                if (depth == 0 && character == target) return index;
                if (character == '(' || character == '[' || character == '{') depth++;
                else if (character == ')' || character == ']' || character == '}') depth--;
            }
        }
        return -1;
    }

    private boolean isQuoted(String value) {
        return value.length() >= 2
                && ((value.startsWith("'") && value.endsWith("'"))
                || (value.startsWith("\"") && value.endsWith("\"")));
    }

    private String unquote(String value) {
        return isQuoted(value) ? value.substring(1, value.length() - 1) : value;
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private String escapeAttribute(String value) {
        return escapeHtml(value);
    }

    private static final class RenderContext {
        private final Map<String, Object> values;

        private RenderContext(Map<String, Object> values) {
            this.values = new LinkedHashMap<>(values);
        }

        private Object get(String name) {
            return values.get(name);
        }

        private RenderContext with(String name, Object value) {
            Map<String, Object> copy = new LinkedHashMap<>(values);
            copy.put(name, value);
            return new RenderContext(copy);
        }
    }
}
