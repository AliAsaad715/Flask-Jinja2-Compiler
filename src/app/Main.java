package app;

import AST.AstNode;
import antlr.PythonLexer;
import antlr.PythonParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Visitor.FlaskJinja2Visitor;

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
    }
}
