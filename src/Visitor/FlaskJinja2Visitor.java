package Visitor;

import AST.*;
import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import symbol.SymbolTablePython;

import java.util.ArrayList;
import java.util.List;

public class FlaskJinja2Visitor extends PythonParserBaseVisitor<AstNode> {

    private final BufferedTokenStream tokens;
    private final SymbolTablePython symbolTable;
    private ProgramNode programRoot;

    public FlaskJinja2Visitor(BufferedTokenStream tokens) {
        this.tokens = tokens;
        this.symbolTable = new SymbolTablePython();
    }

    public ProgramNode getProgramRoot() {
        return programRoot;
    }

    public SymbolTablePython getSymbolTable() {
        return symbolTable;
    }

    @Override
    public AstNode visitProgram(PythonParser.ProgramContext ctx) {
        ProgramNode program = new ProgramNode(lineOf(ctx));
        for (PythonParser.StmtContext st : ctx.stmt()) {
            AstNode node = visit(st);
            if (node != null) program.add(node);
        }
        this.programRoot = program;
        return program;
    }

    @Override
    public AstNode visitStmtImport(PythonParser.StmtImportContext ctx) {
        return visit(ctx.import_stmt());
    }

    @Override
    public AstNode visitStmtAssign(PythonParser.StmtAssignContext ctx) {
        return visit(ctx.assign_stmt());
    }

    @Override
    public AstNode visitStmtDecoratedFuncdef(PythonParser.StmtDecoratedFuncdefContext ctx) {
        return visit(ctx.decorated_funcdef());
    }

    @Override
    public AstNode visitStmtFuncdef(PythonParser.StmtFuncdefContext ctx) {
        return visit(ctx.funcdef());
    }

    @Override
    public AstNode visitStmtIf(PythonParser.StmtIfContext ctx) {
        return visit(ctx.if_stmt());
    }

    @Override
    public AstNode visitStmtReturn(PythonParser.StmtReturnContext ctx) {
        return visit(ctx.return_stmt());
    }

    @Override
    public AstNode visitStmtExpr(PythonParser.StmtExprContext ctx) {
        return visit(ctx.expr_stmt());
    }

    @Override
    public AstNode visitStmtNewline(PythonParser.StmtNewlineContext ctx) {
        return null; // NEWLINE-only
    }


    @Override
    public AstNode visitReturn_stmt(PythonParser.Return_stmtContext ctx) {
        // return_stmt : RETURN expr (COMMA expr)* NEWLINE
        ReturnNode r = new ReturnNode(lineOf(ctx));
        for (PythonParser.ExprContext e : ctx.expr()) {
            r.addValue(visit(e));
        }
        return r;
    }

    @Override
    public AstNode visitImportFrom(PythonParser.ImportFromContext ctx) {
        String raw = textOf(ctx);
        List<String> names = new ArrayList<>();
        int line = lineOf(ctx);

        String pkg = textOf(ctx.dotted_name(0));
        for (int i = 1; i < ctx.dotted_name().size(); i++) {
            names.add(textOf(ctx.dotted_name(i)));
        }

        recordImportSymbols(names, pkg, raw, line, true);
        return new ImportNode(line, "from", pkg, names, raw);
    }

    @Override
    public AstNode visitImportDirect(PythonParser.ImportDirectContext ctx) {
        String raw = textOf(ctx);
        List<String> names = new ArrayList<>();
        int line = lineOf(ctx);

        for (int i = 0; i < ctx.dotted_name().size(); i++) {
            names.add(textOf(ctx.dotted_name(i)));
        }

        recordImportSymbols(names, null, raw, line, false);
        return new ImportNode(line, "import", null, names, raw);
    }


    @Override
    public AstNode visitAssign_stmt(PythonParser.Assign_stmtContext ctx) {
        // assign_stmt : assign_target EQUAL expr NEWLINE
        int line = lineOf(ctx);
        String target = textOf(ctx.assign_target());
        String baseName = ctx.assign_target().ID().getText();
        AstNode value = visit(ctx.expr());
        SymbolTablePython.SymbolEntry entry = defineInCurrentScope(baseName, SymbolTablePython.SymbolKind.VARIABLE, line);
        if (entry != null) {
            boolean isPlainNameAssignment = ctx.assign_target().trailer_no_call().isEmpty();
            if (isPlainNameAssignment) {
                entry.setAttribute("target", target);
            }
        }

        return new AssignNode(line, target, value);
    }

    @Override
    public AstNode visitDecorated_funcdef(PythonParser.Decorated_funcdefContext ctx) {
        // decorated_funcdef : decorator+ funcdef
        DecoratedFunctionNode node = new DecoratedFunctionNode(lineOf(ctx));

        for (PythonParser.DecoratorContext dec : ctx.decorator()) {
            AstNode d = visit(dec);
            if (d != null) node.addDecorator((DecoratorNode) d);
        }

        FunctionNode fn = (FunctionNode) visit(ctx.funcdef());
        node.setFunction(fn);

        RouteNode route = new RouteNode(lineOf(ctx));
        if (!node.decorators.isEmpty()) {
            route.setDecorator(node.decorators.get(0));
        }
        route.setFunction(fn);

        return route;
    }

    @Override
    public AstNode visitDecorator(PythonParser.DecoratorContext ctx) {
        String dotted = textOf(ctx.dotted_name());
        String[] parts = splitLastDot(dotted);
        String obj = parts[0];
        String method = parts[1];

        String path = "";
        if (ctx.arglist() != null && !ctx.arglist().argument().isEmpty()) {
            PythonParser.ArgumentContext a0 = ctx.arglist().argument(0);

            if (a0 instanceof PythonParser.ArgPositionalContext) {
                PythonParser.ArgPositionalContext pos = (PythonParser.ArgPositionalContext) a0;

                AstNode n = visit(pos.expr());
                if (n instanceof StringNode) path = ((StringNode) n).value;
                else path = textOf(pos.expr());

            } else {
                path = null;
            }

        }

        DecoratorNode dec = new DecoratorNode(lineOf(ctx), obj, method, path);

        // Optional: store all arguments as children for better AST visibility
        if (ctx.arglist() != null) {
            ArgsNode args = new ArgsNode(lineOf(ctx.arglist()));
            for (PythonParser.ArgumentContext a : ctx.arglist().argument()) {
                args.add(visit(a));
            }
            dec.add(args);
        }

        return dec;
    }

    @Override
    public AstNode visitFuncdef(PythonParser.FuncdefContext ctx) {
        // funcdef : DEFINETION ID OPEN_B params? CLOSE_B COLON suite
        String name = ctx.ID().getText();
        int line = lineOf(ctx);
        FunctionNode fn = new FunctionNode(line, name);
        SymbolTablePython.SymbolEntry fnEntry = defineInCurrentScope(name, SymbolTablePython.SymbolKind.FUNCTION, line);

        symbolTable.pushScope("func " + name);

        if (ctx.params() != null) {
            ParamsNode params = (ParamsNode) visit(ctx.params());
            fn.parameters.addAll(params.names);
        }

        fn.body = (BlockNode) visit(ctx.suite());
        fn.add(fn.body);
        symbolTable.popScope();

        if (fnEntry != null) {
            fnEntry.setAttribute("params", new ArrayList<>(fn.parameters));
        }
        return fn;
    }

    @Override
    public AstNode visitParams(PythonParser.ParamsContext ctx) {
        ParamsNode p = new ParamsNode(lineOf(ctx));
        for (int i = 0; i < ctx.ID().size(); i++) {
            String paramName = ctx.ID(i).getText();
            p.names.add(paramName);
            defineInCurrentScope(paramName, SymbolTablePython.SymbolKind.PARAMETER, ctx.ID(i).getSymbol().getLine());
        }
        return p;
    }

    @Override
    public AstNode visitSuite(PythonParser.SuiteContext ctx) {
        BlockNode block = new BlockNode(lineOf(ctx));
        for (PythonParser.StmtContext st : ctx.stmt()) {
            AstNode node = visit(st);
            if (node != null) block.add(node);
        }
        return block;
    }

    @Override
    public AstNode visitIf_stmt(PythonParser.If_stmtContext ctx) {
        // if_stmt : IF expr COLON suite (ELIF expr COLON suite)* (ELSE COLON suite)?
        IfNode root = new IfNode(lineOf(ctx), visit(ctx.expr(0)), (BlockNode) visit(ctx.suite(0)));

        int suiteIndex = 1;
        for (int i = 1; i < ctx.expr().size(); i++) { // elif conditions: expr(1..)
            BlockNode b = (BlockNode) visit(ctx.suite(suiteIndex++));
            root.addElif(new IfNode(lineOf(ctx), visit(ctx.expr(i)), b));
        }

        if (ctx.ELSE() != null) {
            BlockNode elseBlock = (BlockNode) visit(ctx.suite(ctx.suite().size() - 1));
            root.setElse(elseBlock);
        }

        return root;
    }

    @Override
    public AstNode visitExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        AstNode expr = visit(ctx.expr());
        return new ExprStmtNode(lineOf(ctx), expr);
    }

    // -------------------------
    // Expressions (new grammar)
    // -------------------------

    @Override
    public AstNode visitExpr(PythonParser.ExprContext ctx) {
        return visit(ctx.or_test());
    }

    @Override
    public AstNode visitOr_test(PythonParser.Or_testContext ctx) {
        AstNode left = visit(ctx.and_test(0));
        for (int i = 1; i < ctx.and_test().size(); i++) {
            left = new BinaryOpNode(lineOf(ctx), "or", left, visit(ctx.and_test(i)));
        }
        return left;
    }

    @Override
    public AstNode visitAnd_test(PythonParser.And_testContext ctx) {
        AstNode left = visit(ctx.not_test(0));
        for (int i = 1; i < ctx.not_test().size(); i++) {
            left = new BinaryOpNode(lineOf(ctx), "and", left, visit(ctx.not_test(i)));
        }
        return left;
    }

    @Override
    public AstNode visitNotUnary(PythonParser.NotUnaryContext ctx) {
        return new UnaryOpNode(lineOf(ctx), "not", visit(ctx.not_test()));
    }

    @Override
    public AstNode visitNotComparison(PythonParser.NotComparisonContext ctx) {
        return visit(ctx.comparison());
    }

    @Override
    public AstNode visitComparison(PythonParser.ComparisonContext ctx) {
        AstNode left = visit(ctx.arith_expr(0));
        for (int i = 1; i < ctx.arith_expr().size(); i++) {
            String op = ctx.comp_op(i - 1).getText();
            AstNode right = visit(ctx.arith_expr(i));
            left = new BinaryOpNode(lineOf(ctx), op, left, right);
        }
        return left;
    }

    @Override
    public AstNode visitArith_expr(PythonParser.Arith_exprContext ctx) {
        AstNode left = visit(ctx.atom_expr(0));
        for (int i = 1; i < ctx.atom_expr().size(); i++) {
            left = new BinaryOpNode(lineOf(ctx), "+", left, visit(ctx.atom_expr(i)));
        }
        return left;
    }

    @Override
    public AstNode visitAtom_expr(PythonParser.Atom_exprContext ctx) {
        AstNode current = visit(ctx.atom());
        if (current == null) current = new ErrorExprNode(lineOf(ctx), "null atom");

        for (PythonParser.TrailerContext tr : ctx.trailer()) {

            if (tr instanceof PythonParser.TrailerAttrContext) {
                PythonParser.TrailerAttrContext ta = (PythonParser.TrailerAttrContext) tr;
                current = new AttributeNode(lineOf(ta), current, ta.ID().getText());

            } else if (tr instanceof PythonParser.TrailerCallContext) {
                PythonParser.TrailerCallContext tc = (PythonParser.TrailerCallContext) tr;

                List<AstNode> args = new ArrayList<>();
                if (tc.arglist() != null) {
                    for (PythonParser.ArgumentContext a : tc.arglist().argument()) {
                        args.add(visit(a));
                    }
                }
                current = new CallNode(lineOf(tc), current, args);

            } else if (tr instanceof PythonParser.TrailerIndexContext) {
                PythonParser.TrailerIndexContext ti = (PythonParser.TrailerIndexContext) tr;

                AstNode index = (ti.expr() != null)
                        ? visit(ti.expr())
                        : new ErrorExprNode(lineOf(ti), "missing index");

                current = new SubscriptNode(lineOf(ti), current, index);
            }
        }

        return current;
    }


    @Override
    public AstNode visitArgKeyword(PythonParser.ArgKeywordContext ctx) {
        String name = ctx.ID().getText();
        AstNode value = visit(ctx.expr());
        return new KeywordArgNode(lineOf(ctx), name, value);
    }

    @Override
    public AstNode visitArgPositional(PythonParser.ArgPositionalContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public AstNode visitAtomId(PythonParser.AtomIdContext ctx) {
        int line = lineOf(ctx);
        String name = ctx.ID().getText();
        IdentifierNode node = new IdentifierNode(line, name);
        node.setSymbol(symbolTable.resolve(name, line));
        return node;
    }

    @Override
    public AstNode visitAtomString(PythonParser.AtomStringContext ctx) {
        return new StringNode(lineOf(ctx), stripQuotes(ctx.STRING().getText()));
    }

    @Override
    public AstNode visitAtomInt(PythonParser.AtomIntContext ctx) {
        return new NumberNode(lineOf(ctx), ctx.INT_VALUE().getText());
    }

    @Override
    public AstNode visitAtomFloat(PythonParser.AtomFloatContext ctx) {
        return new NumberNode(lineOf(ctx), ctx.FLOAT_VALUE().getText());
    }

    @Override
    public AstNode visitAtomNone(PythonParser.AtomNoneContext ctx) {
        return new NoneNode(lineOf(ctx));
    }

    @Override
    public AstNode visitAtomTrue(PythonParser.AtomTrueContext ctx) {
        return new BoolNode(lineOf(ctx), true);
    }

    @Override
    public AstNode visitAtomFalse(PythonParser.AtomFalseContext ctx) {
        return new BoolNode(lineOf(ctx), false);
    }

    @Override
    public AstNode visitAtomList(PythonParser.AtomListContext ctx) {
        return visit(ctx.list_literal());
    }

    @Override
    public AstNode visitAtomDictOrSet(PythonParser.AtomDictOrSetContext ctx) {
        return visit(ctx.dict_or_set_literal());
    }

    @Override
    public AstNode visitAtomParen(PythonParser.AtomParenContext ctx) {
        if (ctx.gen_expr() != null) return visit(ctx.gen_expr());
        if (ctx.expr() != null) return visit(ctx.expr());
        return null; // empty parentheses "()"
    }


    @Override
    public AstNode visitList_literal(PythonParser.List_literalContext ctx) {
        ListNode n = new ListNode(lineOf(ctx));
        for (PythonParser.ExprContext e : ctx.expr()) n.add(visit(e));
        return n;
    }

    @Override
    public AstNode visitDict_or_set_literal(PythonParser.Dict_or_set_literalContext ctx) {
        if (ctx.dict_entry() != null && !ctx.dict_entry().isEmpty()) {
            DictNode d = new DictNode(lineOf(ctx));
            for (PythonParser.Dict_entryContext de : ctx.dict_entry()) d.add(visit(de));
            return d;
        } else {
            SetNode s = new SetNode(lineOf(ctx));
            for (PythonParser.ExprContext e : ctx.expr()) s.add(visit(e));
            return s;
        }
    }

    @Override
    public AstNode visitDict_entry(PythonParser.Dict_entryContext ctx) {
        AstNode k = visit(ctx.expr(0));
        AstNode v = visit(ctx.expr(1));
        return new PairNode(lineOf(ctx), k, v);
    }

    @Override
    public AstNode visitGen_expr(PythonParser.Gen_exprContext ctx) {
        String var = ctx.ID().getText();
        int line = lineOf(ctx);
        AstNode iterable = visit(ctx.expr(1));
        symbolTable.pushScope("genexpr");
        SymbolTablePython.SymbolEntry varEntry = symbolTable.define(var, SymbolTablePython.SymbolKind.VARIABLE, line);
        AstNode element = visit(ctx.expr(0));
        AstNode cond = (ctx.expr().size() > 2) ? visit(ctx.expr(2)) : null;
        symbolTable.popScope();
        return new GeneratorNode(line, element, var, varEntry, iterable, cond);
    }

    // -------------------------
    // Helpers
    // -------------------------

    private int lineOf(ParserRuleContext ctx) {
        return (ctx != null && ctx.getStart() != null) ? ctx.getStart().getLine() : -1;
    }

    private String textOf(ParserRuleContext ctx) {
        if (ctx == null) return "";
        if (tokens != null) return tokens.getText(ctx);
        return ctx.getText();
    }

    private String stripQuotes(String s) {
        if (s == null || s.length() < 2) return s;
        char a = s.charAt(0);
        char b = s.charAt(s.length() - 1);
        if ((a == '\'' && b == '\'') || (a == '"' && b == '"')) return s.substring(1, s.length() - 1);
        return s;
    }

    private String[] splitLastDot(String dotted) {
        if (dotted == null) return new String[]{"", ""};
        int idx = dotted.lastIndexOf('.');
        if (idx < 0) return new String[]{"", dotted};
        String left = dotted.substring(0, idx);
        String right = dotted.substring(idx + 1);
        return new String[]{left, right};
    }

    private SymbolTablePython.SymbolEntry defineInCurrentScope(String name, SymbolTablePython.SymbolKind kind, int line) {
        SymbolTablePython.SymbolEntry entry = symbolTable.resolveCurrent(name);
        if (entry == null) {
            return symbolTable.define(name, kind, line);
        }
        return entry;
    }

    private void recordImportSymbols(List<String> names, String pkg, String raw, int line, boolean fromImport) {
        for (String n : names) {
            SymbolTablePython.SymbolEntry entry = defineInCurrentScope(n, SymbolTablePython.SymbolKind.IMPORT, line);
            if (entry != null) {
                if (fromImport) entry.setAttribute("from", pkg);
                entry.setAttribute("raw", raw);
            }
        }
    }
}