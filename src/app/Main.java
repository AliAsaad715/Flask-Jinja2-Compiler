package app;

import AST.AstNode;
import AST.template.TemplateFileNode;
import Visitor.TemplateAstBuilder;
import Visitor.TemplateSymbolCollector;
import Symbol.SymbolTable;
import antlr.TemplateLexer;
import antlr.TemplateParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = args.length > 0 ? args[0] : "Tests/product_detail_html.txt";
        String input = Files.readString(Path.of(filePath));

        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TemplateParser parser = new TemplateParser(tokens);

        AstNode ast = new TemplateAstBuilder().visit(parser.template());

        System.out.println("=== TEMPLATE AST ===");
        System.out.println(ast.printTree());

        if (ast instanceof TemplateFileNode) {
            SymbolTable table = new TemplateSymbolCollector().collect((TemplateFileNode) ast);
            System.out.println("=== SYMBOL TABLE ===");
            System.out.println(table.print());
        }
    }
}
