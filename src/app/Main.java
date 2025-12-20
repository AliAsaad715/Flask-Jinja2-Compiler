package app;

import AST.AstNode;
import Visitor.TemplateAstBuilder;
import antlr.TemplateLexer;
import antlr.TemplateParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = args.length > 0 ? args[0] : "Tests/products_html.txt";
        String input = Files.readString(Path.of(filePath));

        TemplateLexer lexer = new TemplateLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TemplateParser parser = new TemplateParser(tokens);

        AstNode ast = new TemplateAstBuilder().visit(parser.template());

        System.out.println(ast.printTree());
    }
}
