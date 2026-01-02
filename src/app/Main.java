package app;

import AST.AstNode;
import AST.template.TemplateFileNode;
import Symbol.SymbolTable;
import Visitor.CssAstBuilder;
import Visitor.TemplateAstBuilder;
import Visitor.TemplateSymbolCollector;
import antlr.CssLexer;
import antlr.CssParser;
import antlr.TemplateLexer;
import antlr.TemplateParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> paths = new ArrayList<>();
        if (args.length == 0) {
//            paths.add("Tests/base_html.txt");
//            paths.add("Tests/product_detail_html.txt");
            paths.add("Tests/products_html.txt");

//            paths.add("Tests/add_product_html.txt");
//            paths.add("Tests/style_css.txt");

        } else {
            for (String a : args) paths.add(a);
        }

        for (String p : paths) {
            runFile(p);
        }
    }

    private static void runFile(String filePath) {
        System.out.println("==================================================");
        System.out.println("FILE: " + filePath);

        String input;
        try {
            input = Files.readString(Path.of(filePath));
        } catch (Exception e) {
            System.out.println("Cannot read file: " + e.getMessage());
            return;
        }

        boolean css = looksLikeCss(filePath, input);

        try {
            if (css) {
                runCss(input);
            } else {
                runTemplate(input);
            }
        } catch (Exception e) {
            System.out.println("Runtime error: " + e.getMessage());
        }
    }

    private static void runTemplate(String input) {
        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TemplateParser parser = new TemplateParser(tokens);

        ErrorCollectorListener errors = new ErrorCollectorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errors);

        AstNode ast = new TemplateAstBuilder().visit(parser.template());

        if (errors.hasErrors()) {
            System.out.println("PARSER ERRORS:");
            System.out.println(errors.report());
        }

        System.out.println("=== TEMPLATE AST ===");
        System.out.println(ast.printTree());

        if (ast instanceof TemplateFileNode) {
            SymbolTable table = new TemplateSymbolCollector().collect((TemplateFileNode) ast);
            System.out.println("=== SYMBOL TABLE ===");
            System.out.println(table.print());
        }

        List<AstNode> inlineCssAsts = InlineCssRunner.parseInlineCss(ast);
        if (!inlineCssAsts.isEmpty()) {
            for (int i = 0; i < inlineCssAsts.size(); i++) {
                System.out.println("=== INLINE CSS AST " + (i + 1) + " ===");
                System.out.println(inlineCssAsts.get(i).printTree());
            }
        }
    }

    private static void runCss(String input) {
        CssLexer lexer = new CssLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CssParser parser = new CssParser(tokens);

        ErrorCollectorListener errors = new ErrorCollectorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errors);

        AstNode ast = new CssAstBuilder().visit(parser.stylesheet());

        if (errors.hasErrors()) {
            System.out.println("PARSER ERRORS:");
            System.out.println(errors.report());
        }

        System.out.println("=== CSS AST ===");
        System.out.println(ast.printTree());
    }

    private static boolean looksLikeCss(String filePath, String input) {
        String p = filePath.toLowerCase();
        if (p.contains("css")) return true;
        if (input.contains("{%") || input.contains("{{") || input.contains("<")) return false;
        return input.contains("{") && input.contains(":");
    }
}
