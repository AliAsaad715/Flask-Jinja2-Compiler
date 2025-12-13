package app;

import AST.Program;
import Visitor.FlaskJinja2Visitor;
import antlr.PythonLexer;
import antlr.PythonParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "Tests/test_py.txt";
        CharStream charStream = fromFileName(source);
        PythonLexer lexer = new PythonLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonParser parser = new PythonParser(tokens);
        ParseTree ast = parser.program();
        FlaskJinja2Visitor visitor = new FlaskJinja2Visitor();
        Program program = (Program) visitor.visit(ast);
        System.out.println(program);
    }
}