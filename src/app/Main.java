package app;

import Analysis.PythonTemplateBinder;
import Analysis.TemplateContextBinding;
import Analysis.PythonDataSource;
import Analysis.PythonDataSourceExtractor;
import Analysis.FlaskSemanticAnalyzer;
import Analysis.SemanticDiagnostic;
import Analysis.TemplateSemanticAnalyzer;
import AST.AstNode;
import AST.template.TemplateFileNode;
import Visitor.CssAstBuilder;
import Visitor.TemplateAstBuilder;
import Visitor.TemplateSymbolCollector;
import antlr.*;
import Symbol.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Visitor.FlaskJinja2Visitor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        String file = (args.length > 0) ? args[0] : "Tests/app_py.txt";

        CharStream input = CharStreams.fromFileName(file);

        PythonLexer lexer = new PythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        PythonParser parser = new PythonParser(tokens);
        ParseTree tree = parser.program();

        FlaskJinja2Visitor v = new FlaskJinja2Visitor(tokens);
        AstNode ast = v.visit(tree);

        System.out.println("\n=== AST TREE ===");
        System.out.println(ast.pretty());

        System.out.println("\n=== SYMBOL TABLE ===");
        System.out.println(v.getSymbolTable().format());

        PythonDataSourceExtractor dataSourceExtractor = new PythonDataSourceExtractor();
        Map<String, PythonDataSource> dataSources = dataSourceExtractor.collect(ast);

        System.out.println("\n=== PYTHON DATA SOURCES ===");
        System.out.println(PythonDataSourceExtractor.format(dataSources));

        PythonTemplateBinder binder = new PythonTemplateBinder();
        Map<String, List<TemplateContextBinding>> templateBindings = binder.collect(ast);

        System.out.println("\n=== TEMPLATE CONTEXT BINDINGS ===");
        System.out.println(PythonTemplateBinder.format(templateBindings));

        System.out.println("\n=== TEMPLATE DATA FLOW ===");
        System.out.println(PythonDataSourceExtractor.formatTemplateDataFlow(templateBindings, dataSources));

        List<String> paths = new ArrayList<>();
        if (args.length == 0) {
            paths.add("Tests/base_html.txt");
            paths.add("Tests/products_html.txt");
            paths.add("Tests/product_detail_html.txt");
            paths.add("Tests/add_product_html.txt");
            paths.add("Tests/style_css.txt");
        } else {
            paths.addAll(Arrays.asList(args));
        }

        Set<String> templateNames = templateNamesForPaths(paths);
        FlaskSemanticAnalyzer flaskSemanticAnalyzer = new FlaskSemanticAnalyzer();
        Set<String> routeFunctionNames = flaskSemanticAnalyzer.routeFunctionNames(ast);
        List<SemanticDiagnostic> semanticDiagnostics = new ArrayList<>(
                flaskSemanticAnalyzer.analyze(ast, templateNames, file)
        );

        for (String p : paths) {
            semanticDiagnostics.addAll(runFile(
                    p,
                    templateBindings,
                    dataSources,
                    templateNames,
                    routeFunctionNames
            ));
        }

        printSemanticDiagnostics(semanticDiagnostics);
    }

    private static List<SemanticDiagnostic> runFile(
            String filePath,
            Map<String, List<TemplateContextBinding>> templateBindings,
            Map<String, PythonDataSource> dataSources,
            Set<String> templateNames,
            Set<String> routeFunctionNames
    ) {
        List<SemanticDiagnostic> diagnostics = new ArrayList<>();
        System.out.println("==================================================");
        System.out.println("FILE: " + filePath);

        String input;
        try {
            input = Files.readString(Path.of(filePath));
        } catch (Exception e) {
            System.out.println("Cannot read file: " + e.getMessage());
            return diagnostics;
        }

        boolean css = looksLikeCss(filePath, input);

        try {
            if (css) {
                runCss(input);
            } else {
                diagnostics.addAll(runTemplate(
                        input,
                        templateNameForPath(filePath),
                        contextForTemplate(filePath, templateBindings),
                        templateBindings,
                        dataSources,
                        templateNames,
                        routeFunctionNames
                ));
            }
        } catch (Exception e) {
            System.out.println("Runtime error: " + e.getMessage());
        }
        return diagnostics;
    }

    private static List<SemanticDiagnostic> runTemplate(
            String input,
            String templateName,
            Set<String> contextVars,
            Map<String, List<TemplateContextBinding>> templateBindings,
            Map<String, PythonDataSource> dataSources,
            Set<String> templateNames,
            Set<String> routeFunctionNames
    ) {
        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TemplateParser parser = new TemplateParser(tokens);

        AstNode ast = new TemplateAstBuilder().visit(parser.template());

        System.out.println("=== TEMPLATE AST ===");
        System.out.println(ast.pretty());

        List<SemanticDiagnostic> diagnostics = new ArrayList<>();
        if (ast instanceof TemplateFileNode) {
            TemplateFileNode templateAst = (TemplateFileNode) ast;
            Symbol.SymbolTable table = new TemplateSymbolCollector(contextVars).collect(templateAst);
            System.out.println("=== SYMBOL TABLE ===");
            System.out.println(table.print());

            diagnostics.addAll(new TemplateSemanticAnalyzer().analyze(
                    templateName,
                    templateAst,
                    contextVars,
                    templateBindings,
                    dataSources,
                    templateNames,
                    routeFunctionNames
            ));
        }

        List<AstNode> inlineCssAsts = InlineCssRunner.parseInlineCss(ast);
        if (!inlineCssAsts.isEmpty()) {
            for (int i = 0; i < inlineCssAsts.size(); i++) {
                System.out.println("=== INLINE CSS AST " + (i + 1) + " ===");
                System.out.println(inlineCssAsts.get(i).pretty());
            }
        }
        return diagnostics;
    }

    private static void runCss(String input) {
        CssLexer lexer = new CssLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CssParser parser = new CssParser(tokens);

        AstNode ast = new CssAstBuilder().visit(parser.stylesheet());

        System.out.println("=== CSS AST ===");
        System.out.println(ast.pretty());
    }

    private static boolean looksLikeCss(String filePath, String input) {
        String p = filePath.toLowerCase();
        if (p.contains("css")) return true;
        if (input.contains("{%") || input.contains("{{") || input.contains("<")) return false;
        return input.contains("{") && input.contains(":");
    }

    private static Set<String> contextForTemplate(
            String filePath,
            Map<String, List<TemplateContextBinding>> templateBindings
    ) {
        if (templateBindings == null || templateBindings.isEmpty()) {
            return new LinkedHashSet<>();
        }
        String templateName = templateNameForPath(filePath);
        List<TemplateContextBinding> bindings = templateBindings.get(templateName);
        return PythonTemplateBinder.contextNames(bindings);
    }

    private static String templateNameForPath(String filePath) {
        String name = Path.of(filePath).getFileName().toString();
        if (name.endsWith("_html.txt")) {
            return name.substring(0, name.length() - "_html.txt".length()) + ".html";
        }
        if (name.endsWith(".html")) {
            return name;
        }
        return name;
    }

    private static Set<String> templateNamesForPaths(List<String> paths) {
        Set<String> names = new LinkedHashSet<>();
        for (String path : paths) {
            String fileName = Path.of(path).getFileName().toString();
            if (fileName.endsWith("_html.txt") || fileName.endsWith(".html")) {
                names.add(templateNameForPath(path));
            }
        }
        return names;
    }

    private static void printSemanticDiagnostics(List<SemanticDiagnostic> diagnostics) {
        System.out.println("\n=== SEMANTIC DIAGNOSTICS ===");
        if (diagnostics == null || diagnostics.isEmpty()) {
            System.out.println("No semantic errors found.");
            return;
        }
        for (SemanticDiagnostic diagnostic : diagnostics) {
            System.out.println(diagnostic);
        }
    }
}
