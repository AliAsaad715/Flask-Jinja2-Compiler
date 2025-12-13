package Visitor;

import AST.*;
import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;

import java.awt.*;

public class FlaskJinja2Visitor extends PythonParserBaseVisitor {
    @Override
    public Program visitProg(PythonParser.ProgContext ctx) {
        Program program = new Program();
        for (int i = 0; i < ctx.importing().size(); i++) {
            program.addImport(visitImport((PythonParser.ImportContext) ctx.importing().get(i)));
        }
        for (int i = 0; i < ctx.declaration().size(); i++) {
            program.addDeclaration(visitDecl((PythonParser.DeclContext) ctx.declaration().get(i)));
        }
        for (int i = 0; i < ctx.route().size(); i++) {
            program.addRoute(visitRoutes((PythonParser.RoutesContext) ctx.route().get(i)));
        }
        return program;
    }

    @Override
    public String visitLibrary(PythonParser.LibraryContext ctx) {
        return ctx.FLASK_LIBRARY().toString();
    }

    @Override
    public Importing visitImport(PythonParser.ImportContext ctx) {
        Importing importing = new Importing(ctx.FLASK().toString());
        for (int i = 0; i < ctx.libraries().size(); i++) {
            importing.addObject((String) visit(ctx.libraries(i)));
        }
        return importing;
    }

    @Override
    public StringValue visitString_Value(PythonParser.String_ValueContext ctx) {
        String value = ctx.STRING_VALUE() != null ? ctx.STRING_VALUE().toString() : "";
        return new StringValue(value);
    }

    @Override
    public AppValue visitAppValue(PythonParser.AppValueContext ctx) {
        return new AppValue(ctx.APP_NAME().toString());
    }

    @Override
    public IntValue visitInt_Value(PythonParser.Int_ValueContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT_VALUE().toString()));
    }

    @Override
    public Parameter visitParams(PythonParser.ParamsContext ctx) {
        return new Parameter(ctx.ID().toString());
    }

    @Override
    public Route visitRoutes(PythonParser.RoutesContext ctx) {
        String path = '/' + (ctx.STRING_VALUE() != null ? ctx.STRING_VALUE().toString() : "");
        return new Route(path, (Function) visit(ctx.function()));
    }

    @Override
    public Declaration visitDecl(PythonParser.DeclContext ctx) {
        return new Declaration(ctx.ID().toString(), (Value) visit(ctx.value()));
    }

    @Override
    public Function visitFunctions(PythonParser.FunctionsContext ctx) {
        Function function = new Function(ctx.ID(0).toString(), (Value) visit(ctx.value()));
        for (int i = 0; i < ctx.parameter().size(); i++) {
            function.addParameter(visitParams((PythonParser.ParamsContext)ctx.parameter().get(i)));
        }
        return function;
    }

    @Override
    public Object visitRunServer(PythonParser.RunServerContext ctx) {
        return super.visitRunServer(ctx);
    }
}
