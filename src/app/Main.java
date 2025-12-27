package app;

import antlr.PythonLexer;
import antlr.PythonParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Visitor.FlaskJinja2Visitor;

public class Main {
    public static void main(String[] args) throws Exception {

        // Choose test file
        String file = (args.length > 0) ? args[0] : "Tests/app_py.txt";

        CharStream input = CharStreams.fromFileName(file);

        PythonLexer lexer = new PythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // (1) Print tokens to confirm INDENT/DEDENT/NEWLINE exist
        for (Token t : tokens.getTokens()) {
            String type = PythonLexer.VOCABULARY.getSymbolicName(t.getType());
            System.out.printf("%-12s line=%-3d col=%-3d text=%s%n",
                    type, t.getLine(), t.getCharPositionInLine(), t.getText().replace("\n","\\n"));
        }

        // (2) Parse and print parse tree
        PythonParser parser = new PythonParser(tokens);
        ParseTree tree = parser.program();

        System.out.println("\n=== PARSE TREE ===");
        System.out.println(tree.toStringTree(parser));

// Build + print AST
        FlaskJinja2Visitor v = new FlaskJinja2Visitor(tokens);
        FlaskJinja2Visitor.AstNode ast = v.visit(tree);

        System.out.println("\n=== AST TREE ===");
        System.out.println(ast.pretty());
    }
}
