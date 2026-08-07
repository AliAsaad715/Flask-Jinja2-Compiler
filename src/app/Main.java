package app;

import AST.AstNode;
import AST.template.TemplateFileNode;
import Analysis.FlaskSemanticAnalyzer;
import Analysis.PythonDataSource;
import Analysis.PythonDataSourceExtractor;
import Analysis.PythonTemplateBinder;
import Analysis.SemanticDiagnostic;
import Analysis.SyntaxErrorCollector;
import Analysis.TemplateContextBinding;
import Analysis.TemplateSemanticAnalyzer;
import Generator.GeneratedFile;
import Generator.StaticSiteGenerator;
import Symbol.SymbolTable;
import Visitor.CssAstBuilder;
import Visitor.FlaskJinja2Visitor;
import Visitor.TemplateAstBuilder;
import Visitor.TemplateSymbolCollector;
import antlr.CssLexer;
import antlr.CssParser;
import antlr.PythonLexer;
import antlr.PythonParser;
import antlr.TemplateLexer;
import antlr.TemplateParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        String pythonPath = args.length > 0 ? args[0] : "Tests/app_py.txt";
        List<String> sourcePaths = inputPaths(args);
        List<String> syntaxErrors = new ArrayList<>();

        PythonParseResult python;
        try {
            python = parsePython(pythonPath, syntaxErrors);
        } catch (RuntimeException exception) {
            syntaxErrors.add(pythonPath + ": " + exception.getMessage());
            printSyntaxDiagnostics(syntaxErrors);
            System.out.println("\n=== CODE GENERATION ===");
            System.out.println("Skipped because syntax errors were found.");
            return;
        }
        AstNode pythonAst = python.ast;

        System.out.println("\n=== PYTHON AST ===");
        System.out.println(pythonAst.pretty());
        System.out.println("\n=== PYTHON SYMBOL TABLE ===");
        System.out.println(python.visitor.getSymbolTable().format());

        PythonDataSourceExtractor dataSourceExtractor = new PythonDataSourceExtractor();
        Map<String, PythonDataSource> dataSources = dataSourceExtractor.collect(pythonAst);
        System.out.println("\n=== PYTHON DATA SOURCES ===");
        System.out.println(PythonDataSourceExtractor.format(dataSources));

        PythonTemplateBinder binder = new PythonTemplateBinder();
        Map<String, List<TemplateContextBinding>> templateBindings = binder.collect(pythonAst);
        System.out.println("\n=== TEMPLATE CONTEXT BINDINGS ===");
        System.out.println(PythonTemplateBinder.format(templateBindings));
        System.out.println("\n=== TEMPLATE DATA FLOW ===");
        System.out.println(PythonDataSourceExtractor.formatTemplateDataFlow(templateBindings, dataSources));

        Set<String> templateNames = templateNamesForPaths(sourcePaths);
        FlaskSemanticAnalyzer flaskAnalyzer = new FlaskSemanticAnalyzer();
        Set<String> routeNames = flaskAnalyzer.routeFunctionNames(pythonAst);
        List<SemanticDiagnostic> semanticDiagnostics = new ArrayList<>(
                flaskAnalyzer.analyze(pythonAst, templateNames, pythonPath)
        );

        Map<String, TemplateFileNode> templateAsts = new LinkedHashMap<>();
        Map<String, Path> templateSources = new LinkedHashMap<>();
        List<Path> cssSources = new ArrayList<>();

        for (String sourcePath : sourcePaths) {
            semanticDiagnostics.addAll(analyzeSource(
                    sourcePath,
                    templateBindings,
                    dataSources,
                    templateNames,
                    routeNames,
                    syntaxErrors,
                    templateAsts,
                    templateSources,
                    cssSources
            ));
        }

        printSyntaxDiagnostics(syntaxErrors);
        printSemanticDiagnostics(semanticDiagnostics);

        if (syntaxErrors.isEmpty() && semanticDiagnostics.isEmpty()) {
            generateStaticSite(pythonAst, templateAsts, templateSources, cssSources);
        } else {
            System.out.println("\n=== CODE GENERATION ===");
            System.out.println("Skipped because syntax or semantic errors were found.");
        }
    }

    private static PythonParseResult parsePython(
            String filePath,
            List<String> syntaxErrors
    ) throws Exception {
        PythonLexer lexer = new PythonLexer(CharStreams.fromFileName(filePath));
        SyntaxErrorCollector collector = new SyntaxErrorCollector(filePath);
        lexer.removeErrorListeners();
        lexer.addErrorListener(collector);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonParser parser = new PythonParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(collector);
        ParseTree tree = parser.program();
        syntaxErrors.addAll(collector.getErrors());

        FlaskJinja2Visitor visitor = new FlaskJinja2Visitor(tokens);
        AstNode ast = visitor.visit(tree);
        return new PythonParseResult(ast, visitor);
    }

    private static List<SemanticDiagnostic> analyzeSource(
            String filePath,
            Map<String, List<TemplateContextBinding>> templateBindings,
            Map<String, PythonDataSource> dataSources,
            Set<String> templateNames,
            Set<String> routeNames,
            List<String> syntaxErrors,
            Map<String, TemplateFileNode> templateAsts,
            Map<String, Path> templateSources,
            List<Path> cssSources
    ) {
        List<SemanticDiagnostic> diagnostics = new ArrayList<>();
        System.out.println("==================================================");
        System.out.println("FILE: " + filePath);

        String input;
        try {
            input = Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (Exception exception) {
            syntaxErrors.add(filePath + ": cannot read input: " + exception.getMessage());
            return diagnostics;
        }

        if (looksLikeCss(filePath, input)) {
            AstNode cssAst = parseCss(filePath, input, syntaxErrors);
            System.out.println("=== CSS AST ===");
            System.out.println(cssAst.pretty());
            cssSources.add(Path.of(filePath));
            return diagnostics;
        }

        String templateName = templateNameForPath(filePath);
        TemplateFileNode templateAst = parseTemplate(filePath, input, syntaxErrors);
        templateAsts.put(templateName, templateAst);
        templateSources.put(templateName, Path.of(filePath));

        System.out.println("=== TEMPLATE AST ===");
        System.out.println(templateAst.pretty());
        Set<String> context = contextForTemplate(filePath, templateBindings);
        SymbolTable table = new TemplateSymbolCollector(context).collect(templateAst);
        System.out.println("=== TEMPLATE SYMBOL TABLE ===");
        System.out.println(table.print());

        diagnostics.addAll(new TemplateSemanticAnalyzer().analyze(
                templateName,
                templateAst,
                context,
                templateBindings,
                dataSources,
                templateNames,
                routeNames
        ));

        List<AstNode> inlineCssAsts = InlineCssRunner.parseInlineCss(templateAst);
        for (int index = 0; index < inlineCssAsts.size(); index++) {
            System.out.println("=== INLINE CSS AST " + (index + 1) + " ===");
            System.out.println(inlineCssAsts.get(index).pretty());
        }
        return diagnostics;
    }

    private static TemplateFileNode parseTemplate(
            String filePath,
            String input,
            List<String> syntaxErrors
    ) {
        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(input));
        SyntaxErrorCollector collector = new SyntaxErrorCollector(filePath);
        lexer.removeErrorListeners();
        lexer.addErrorListener(collector);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TemplateParser parser = new TemplateParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(collector);
        AstNode ast = new TemplateAstBuilder().visit(parser.template());
        syntaxErrors.addAll(collector.getErrors());
        if (!(ast instanceof TemplateFileNode)) {
            throw new IllegalStateException("Template AST could not be built for " + filePath);
        }
        return (TemplateFileNode) ast;
    }

    private static AstNode parseCss(String filePath, String input, List<String> syntaxErrors) {
        CssLexer lexer = new CssLexer(CharStreams.fromString(input));
        SyntaxErrorCollector collector = new SyntaxErrorCollector(filePath);
        lexer.removeErrorListeners();
        lexer.addErrorListener(collector);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CssParser parser = new CssParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(collector);
        AstNode ast = new CssAstBuilder().visit(parser.stylesheet());
        syntaxErrors.addAll(collector.getErrors());
        return ast;
    }

    private static List<String> inputPaths(String[] args) {
        List<String> paths = new ArrayList<>();
        if (args.length == 0) {
            paths.add("Tests/base_html.txt");
            paths.add("Tests/products_html.txt");
            paths.add("Tests/product_detail_html.txt");
            paths.add("Tests/add_product_html.txt");
            paths.add("Tests/delete_product_html.txt");
            paths.add("Tests/style_css.txt");
        } else {
            for (int index = 1; index < args.length; index++) paths.add(args[index]);
        }
        return paths;
    }

    private static boolean looksLikeCss(String filePath, String input) {
        String path = filePath.toLowerCase();
        if (path.endsWith(".css") || path.endsWith("_css.txt")) return true;
        if (input.contains("{%") || input.contains("{{") || input.contains("<")) return false;
        return input.contains("{") && input.contains(":");
    }

    private static Set<String> contextForTemplate(
            String filePath,
            Map<String, List<TemplateContextBinding>> bindings
    ) {
        return PythonTemplateBinder.contextNames(bindings.get(templateNameForPath(filePath)));
    }

    private static String templateNameForPath(String filePath) {
        String name = Path.of(filePath).getFileName().toString();
        if (name.endsWith("_html.txt")) {
            return name.substring(0, name.length() - "_html.txt".length()) + ".html";
        }
        return name;
    }

    private static Set<String> templateNamesForPaths(List<String> paths) {
        Set<String> names = new LinkedHashSet<>();
        for (String path : paths) {
            String name = Path.of(path).getFileName().toString();
            if (name.endsWith("_html.txt") || name.endsWith(".html")) {
                names.add(templateNameForPath(path));
            }
        }
        return names;
    }

    private static void printSyntaxDiagnostics(List<String> diagnostics) {
        System.out.println("\n=== SYNTAX DIAGNOSTICS ===");
        if (diagnostics.isEmpty()) {
            System.out.println("No syntax errors found.");
            return;
        }
        for (String diagnostic : new LinkedHashSet<>(diagnostics)) {
            System.out.println("ERROR " + diagnostic);
        }
    }

    private static void printSemanticDiagnostics(List<SemanticDiagnostic> diagnostics) {
        System.out.println("\n=== SEMANTIC DIAGNOSTICS ===");
        if (diagnostics.isEmpty()) {
            System.out.println("No semantic errors found.");
            return;
        }
        for (SemanticDiagnostic diagnostic : diagnostics) System.out.println(diagnostic);
    }

    private static void generateStaticSite(
            AstNode pythonAst,
            Map<String, TemplateFileNode> templateAsts,
            Map<String, Path> templateSources,
            List<Path> cssSources
    ) {
        System.out.println("\n=== STATIC CODE GENERATION ===");
        try {
            StaticSiteGenerator generator = new StaticSiteGenerator();
            List<GeneratedFile> generated = generator.generate(
                    pythonAst,
                    templateAsts,
                    templateSources,
                    cssSources,
                    Path.of("generated", "static_site")
            );
            System.out.println(StaticSiteGenerator.format(generated));
        } catch (Exception exception) {
            System.out.println("Code generation failed: " + exception.getMessage());
        }
    }

    private static final class PythonParseResult {
        private final AstNode ast;
        private final FlaskJinja2Visitor visitor;

        private PythonParseResult(AstNode ast, FlaskJinja2Visitor visitor) {
            this.ast = ast;
            this.visitor = visitor;
        }
    }
}
