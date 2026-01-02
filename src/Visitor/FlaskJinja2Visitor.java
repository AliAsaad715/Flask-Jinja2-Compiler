package Visitor;

import AST.*;
import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import symbol.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class FlaskJinja2Visitor extends PythonParserBaseVisitor<AstNode> {

    private final BufferedTokenStream tokens;
    private final SymbolTable symbolTable;
    private ProgramNode programRoot;

    // Constructor
    public FlaskJinja2Visitor(BufferedTokenStream tokens) {
        this.tokens = tokens;
        this.symbolTable = new SymbolTable();
    }

    @Override
    public AstNode visitProgram(PythonParser.ProgramContext ctx) {
        int line = lineOf(ctx);
        ProgramNode program = new ProgramNode(line);
        this.programRoot = program;

        // Visit all statements
        if (ctx.stmt() != null) {
            for (PythonParser.StmtContext stmt : ctx.stmt()) {
                AstNode stmtNode = visit(stmt);
                if (stmtNode != null) {
                    program.add(stmtNode);
                }
            }
        }

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
        // Ignore empty lines
        return null;
    }

    @Override
    public AstNode visitReturn_stmt(PythonParser.Return_stmtContext ctx) {
        int line = lineOf(ctx);
        ReturnNode returnNode = new ReturnNode(line);

        // Handle multiple return values
        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (PythonParser.ExprContext expr : ctx.expr()) {
                AstNode exprNode = visit(expr);
                if (exprNode != null) {
                    returnNode.addValue(exprNode);
                }
            }
        }

        return returnNode;
    }

    @Override
    public AstNode visitImportFrom(PythonParser.ImportFromContext ctx) {
        int line = lineOf(ctx);

        // Get package name
        String packageName = textOf(ctx.dotted_name(0));

        // Get imported names
        List<String> names = new ArrayList<>();
        for (int i = 1; i < ctx.dotted_name().size(); i++) {
            names.add(textOf(ctx.dotted_name(i)));
        }

        // Record symbols
        recordImportSymbols(names, packageName, textOf(ctx), line, true);

        return new ImportNode(line, "from", packageName, names, textOf(ctx));
    }

    @Override
    public AstNode visitImportDirect(PythonParser.ImportDirectContext ctx) {
        int line = lineOf(ctx);

        // Get imported names
        List<String> names = new ArrayList<>();
        for (PythonParser.Dotted_nameContext dn : ctx.dotted_name()) {
            names.add(textOf(dn));
        }

        // Record symbols
        recordImportSymbols(names, "", textOf(ctx), line, false);

        return new ImportNode(line, "import", "", names, textOf(ctx));
    }

    @Override
    public AstNode visitDotted_name(PythonParser.Dotted_nameContext ctx) {
        // This is usually used within other nodes, not as standalone
        return new IdentifierNode(lineOf(ctx), textOf(ctx));
    }

    @Override
    public AstNode visitAssign_stmt(PythonParser.Assign_stmtContext ctx) {
        int line = lineOf(ctx);

        // Visit target
        String target = textOf(ctx.assign_target());

        // Visit value
        AstNode value = visit(ctx.expr());

        // Create assignment node
        AssignNode assignNode = new AssignNode(line, target, value);

        // Define symbol for the target
        String targetName = extractSimpleName(target);
        if (targetName != null && !targetName.isEmpty()) {
            defineInCurrentScope(targetName, SymbolTable.SymbolKind.VARIABLE, line);
        }

        return assignNode;
    }

    @Override
    public AstNode visitEndNewline(PythonParser.EndNewlineContext ctx) {
        return null; // Just a terminator, no AST node
    }

    @Override
    public AstNode visitEndEOF(PythonParser.EndEOFContext ctx) {
        return null; // Just a terminator, no AST node
    }

    @Override
    public AstNode visitAssign_target(PythonParser.Assign_targetContext ctx) {
        // Usually handled within assign_stmt
        return new IdentifierNode(lineOf(ctx), textOf(ctx));
    }

    @Override
    public AstNode visitTrailerNoCallAttr(PythonParser.TrailerNoCallAttrContext ctx) {
        // This represents attribute access in assignment target
        return new AttributeNode(lineOf(ctx), null, ctx.ID().getText());
    }

    @Override
    public AstNode visitTrailerNoCallIndex(PythonParser.TrailerNoCallIndexContext ctx) {
        // This represents subscript access in assignment target
        AstNode indexExpr = visit(ctx.expr());
        return new SubscriptNode(lineOf(ctx), null, indexExpr);
    }

    @Override
    public AstNode visitDecorated_funcdef(PythonParser.Decorated_funcdefContext ctx) {
        int line = lineOf(ctx);
        DecoratedFunctionNode decoratedFunc = new DecoratedFunctionNode(line);

        // Process decorators
        for (PythonParser.DecoratorContext decoratorCtx : ctx.decorator()) {
            DecoratorNode decoratorNode = (DecoratorNode) visit(decoratorCtx);
            if (decoratorNode != null) {
                decoratedFunc.addDecorator(decoratorNode);
            }
        }

        // Process function
        FunctionNode funcNode = (FunctionNode) visit(ctx.funcdef());
        if (funcNode != null) {
            decoratedFunc.setFunction(funcNode);
        }

        return decoratedFunc;
    }

    @Override
    public AstNode visitDecorator(PythonParser.DecoratorContext ctx) {
        int line = lineOf(ctx);

        // Get the dotted name (e.g., "app.route")
        String fullName = textOf(ctx.dotted_name());
        String[] parts = splitLastDot(fullName);
        String objectName = parts[0];
        String methodName = parts[1];

        // Extract path from arguments - مع التحقق من null
        String path = "";
        if (ctx.arglist() != null) {
            path = extractPathFromArgs(ctx.arglist());
        }

        return new DecoratorNode(line, objectName, methodName, path);
    }

    @Override
    public AstNode visitFuncdef(PythonParser.FuncdefContext ctx) {
        int line = lineOf(ctx);

        // Enter new scope for function
        symbolTable.pushScope(ctx.ID().getText());

        // Create function node
        FunctionNode funcNode = new FunctionNode(line, ctx.ID().getText());

        // Process parameters
        if (ctx.params() != null) {
            ParamsNode paramsNode = (ParamsNode) visit(ctx.params());
            if (paramsNode != null) {
                funcNode.parameters.addAll(paramsNode.names);
                funcNode.add(paramsNode);

                // Define parameters as symbols in function scope
                for (String param : paramsNode.names) {
                    symbolTable.define(param, SymbolTable.SymbolKind.PARAMETER, line);
                }
            }
        }

        // Process body (suite)
        BlockNode body = (BlockNode) visit(ctx.suite());
        if (body != null) {
            funcNode.body = body;
            funcNode.add(body);
        }

        // Exit function scope
        symbolTable.popScope();

        return funcNode;
    }

    @Override
    public AstNode visitParams(PythonParser.ParamsContext ctx) {
        int line = lineOf(ctx);
        ParamsNode paramsNode = new ParamsNode(line);

        // Collect parameter names
        if (ctx.ID() != null) {
            for (TerminalNode idToken : ctx.ID()) {
                paramsNode.names.add(idToken.getText());
            }
        }

        return paramsNode;
    }

    @Override
    public AstNode visitSuite(PythonParser.SuiteContext ctx) {
        int line = lineOf(ctx);
        BlockNode block = new BlockNode(line);

        // Visit all statements in the block
        if (ctx.stmt() != null) {
            for (PythonParser.StmtContext stmt : ctx.stmt()) {
                AstNode stmtNode = visit(stmt);
                if (stmtNode != null) {
                    block.add(stmtNode);
                }
            }
        }

        return block;
    }

    @Override
    public AstNode visitIf_stmt(PythonParser.If_stmtContext ctx) {
        int line = lineOf(ctx);

        // Visit condition
        AstNode condition = visit(ctx.expr(0));

        // Visit then block
        BlockNode thenBlock = (BlockNode) visit(ctx.suite(0));

        // Create if node
        IfNode ifNode = new IfNode(line, condition, thenBlock);

        // Process elif branches
        for (int i = 1; i < ctx.expr().size(); i++) {
            AstNode elifCondition = visit(ctx.expr(i));
            BlockNode elifBlock = (BlockNode) visit(ctx.suite(i));
            IfNode elifNode = new IfNode(line, elifCondition, elifBlock);
            ifNode.addElif(elifNode);
        }

        // Process else branch
        if (ctx.ELSE() != null) {
            BlockNode elseBlock = (BlockNode) visit(ctx.suite(ctx.suite().size() - 1));
            ifNode.setElse(elseBlock);
        }

        return ifNode;
    }

    @Override
    public AstNode visitExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        int line = lineOf(ctx);
        AstNode expr = visit(ctx.expr());
        return new ExprStmtNode(line, expr);
    }

    @Override
    public AstNode visitExpr(PythonParser.ExprContext ctx) {
        return visit(ctx.or_test());
    }

    @Override
    public AstNode visitOr_test(PythonParser.Or_testContext ctx) {
        if (ctx.and_test().size() == 1) {
            return visit(ctx.and_test(0));
        }

        // Handle OR expressions
        int line = lineOf(ctx);
        AstNode left = visit(ctx.and_test(0));
        for (int i = 1; i < ctx.and_test().size(); i++) {
            AstNode right = visit(ctx.and_test(i));
            left = new BinaryOpNode(line, "or", left, right);
        }
        return left;
    }

    @Override
    public AstNode visitAnd_test(PythonParser.And_testContext ctx) {
        if (ctx.not_test().size() == 1) {
            return visit(ctx.not_test(0));
        }

        // Handle AND expressions
        int line = lineOf(ctx);
        AstNode left = visit(ctx.not_test(0));
        for (int i = 1; i < ctx.not_test().size(); i++) {
            AstNode right = visit(ctx.not_test(i));
            left = new BinaryOpNode(line, "and", left, right);
        }
        return left;
    }

    @Override
    public AstNode visitNotUnary(PythonParser.NotUnaryContext ctx) {
        int line = lineOf(ctx);
        AstNode operand = visit(ctx.not_test());
        return new UnaryOpNode(line, "not", operand);
    }

    @Override
    public AstNode visitNotComparison(PythonParser.NotComparisonContext ctx) {
        return visit(ctx.comparison());
    }

    @Override
    public AstNode visitComparison(PythonParser.ComparisonContext ctx) {
        if (ctx.arith_expr().size() == 1) {
            return visit(ctx.arith_expr(0));
        }

        // Handle comparison chains
        int line = lineOf(ctx);
        AstNode left = visit(ctx.arith_expr(0));

        for (int i = 0; i < ctx.comp_op().size(); i++) {
            String op = getCompOpText(ctx.comp_op(i));
            AstNode right = visit(ctx.arith_expr(i + 1));
            left = new BinaryOpNode(line, op, left, right);
        }

        return left;
    }

    @Override
    public AstNode visitArith_expr(PythonParser.Arith_exprContext ctx) {
        if (ctx.atom_expr().size() == 1) {
            return visit(ctx.atom_expr(0));
        }

        // Handle addition
        int line = lineOf(ctx);
        AstNode left = visit(ctx.atom_expr(0));
        for (int i = 1; i < ctx.atom_expr().size(); i++) {
            AstNode right = visit(ctx.atom_expr(i));
            left = new BinaryOpNode(line, "+", left, right);
        }
        return left;
    }

    @Override
    public AstNode visitAtom_expr(PythonParser.Atom_exprContext ctx) {
        AstNode atom = visit(ctx.atom());

        // Apply trailers (attribute access, calls, subscripts)
        if (ctx.trailer() != null) {
            for (PythonParser.TrailerContext trailer : ctx.trailer()) {
                atom = visitTrailerWithBase(atom, trailer);
            }
        }

        return atom;
    }

    private AstNode visitTrailerWithBase(AstNode base, PythonParser.TrailerContext ctx) {
        int line = lineOf(ctx);

        if (ctx instanceof PythonParser.TrailerAttrContext) {
            String attr = ((PythonParser.TrailerAttrContext) ctx).ID().getText();
            return new AttributeNode(line, base, attr);
        }
        else if (ctx instanceof PythonParser.TrailerCallContext) {
            PythonParser.TrailerCallContext callCtx = (PythonParser.TrailerCallContext) ctx;
            ArgsNode args = null;
            if (callCtx.arglist() != null) {
                args = (ArgsNode) visitArglist(callCtx.arglist());
            } else {
                args = new ArgsNode(line); // Empty args
            }
            return new CallNode(line, base, args != null ? args.children : null);
        }
        else if (ctx instanceof PythonParser.TrailerIndexContext) {
            AstNode index = visit(((PythonParser.TrailerIndexContext) ctx).expr());
            return new SubscriptNode(line, base, index);
        }

        return base;
    }

    @Override
    public AstNode visitArglist(PythonParser.ArglistContext ctx) {
        int line = lineOf(ctx);
        ArgsNode argsNode = new ArgsNode(line);

        if (ctx != null && ctx.argument() != null) {  // ← التحقق من null هنا
            for (PythonParser.ArgumentContext arg : ctx.argument()) {
                AstNode argNode = visit(arg);
                if (argNode != null) {
                    argsNode.add(argNode);
                }
            }
        }

        return argsNode;
    }

    @Override
    public AstNode visitArgKeyword(PythonParser.ArgKeywordContext ctx) {
        int line = lineOf(ctx);
        String name = ctx.ID().getText();
        AstNode value = visit(ctx.expr());
        return new KeywordArgNode(line, name, value);
    }

    @Override
    public AstNode visitArgPositional(PythonParser.ArgPositionalContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public AstNode visitAtomId(PythonParser.AtomIdContext ctx) {
        int line = lineOf(ctx);
        String name = ctx.ID().getText();

        // Look up symbol
        SymbolTable.SymbolEntry symbol = symbolTable.resolve(name, line);
        IdentifierNode idNode = new IdentifierNode(line, name);
        if (symbol != null) {
            idNode.setSymbol(symbol);
        }

        return idNode;
    }

    @Override
    public AstNode visitAtomString(PythonParser.AtomStringContext ctx) {
        int line = lineOf(ctx);
        String text = stripQuotes(ctx.STRING().getText());
        return new StringNode(line, text);
    }

    @Override
    public AstNode visitAtomInt(PythonParser.AtomIntContext ctx) {
        int line = lineOf(ctx);
        return new NumberNode(line, ctx.INT_VALUE().getText());
    }

    @Override
    public AstNode visitAtomFloat(PythonParser.AtomFloatContext ctx) {
        int line = lineOf(ctx);
        return new NumberNode(line, ctx.FLOAT_VALUE().getText());
    }

    @Override
    public AstNode visitAtomNone(PythonParser.AtomNoneContext ctx) {
        int line = lineOf(ctx);
        return new NoneNode(line);
    }

    @Override
    public AstNode visitAtomTrue(PythonParser.AtomTrueContext ctx) {
        int line = lineOf(ctx);
        return new BoolNode(line, true);
    }

    @Override
    public AstNode visitAtomFalse(PythonParser.AtomFalseContext ctx) {
        int line = lineOf(ctx);
        return new BoolNode(line, false);
    }

    @Override
    public AstNode visitAtomList(PythonParser.AtomListContext ctx) {
        int line = lineOf(ctx);
        ListNode listNode = new ListNode(line);

        if (ctx.list_literal() != null) {
            PythonParser.List_literalContext listCtx = ctx.list_literal();

            // Visit all expressions in the list
            if (listCtx.expr() != null) {
                for (PythonParser.ExprContext expr : listCtx.expr()) {
                    AstNode elem = visit(expr);
                    if (elem != null) {
                        listNode.add(elem);
                    }
                }
            }
        }

        return listNode;
    }

    @Override
    public AstNode visitAtomDictOrSet(PythonParser.AtomDictOrSetContext ctx) {
        if (ctx.dict_or_set_literal() == null) {
            return null;
        }

        PythonParser.Dict_or_set_literalContext dictSetCtx = ctx.dict_or_set_literal();
        int line = lineOf(ctx);

        // Check if it's a dict or set
        boolean hasColon = false;
        if (dictSetCtx.dict_entry() != null && !dictSetCtx.dict_entry().isEmpty()) {
            hasColon = true;
        }

        if (hasColon) {
            // It's a dictionary
            DictNode dictNode = new DictNode(line);
            for (PythonParser.Dict_entryContext entry : dictSetCtx.dict_entry()) {
                AstNode key = visit(entry.expr(0));
                AstNode value = visit(entry.expr(1));
                dictNode.add(new PairNode(line, key, value));
            }
            return dictNode;
        } else {
            // It's a set
            SetNode setNode = new SetNode(line);
            if (dictSetCtx.expr() != null) {
                for (PythonParser.ExprContext expr : dictSetCtx.expr()) {
                    AstNode elem = visit(expr);
                    if (elem != null) {
                        setNode.add(elem);
                    }
                }
            }
            return setNode;
        }
    }

    @Override
    public AstNode visitAtomParen(PythonParser.AtomParenContext ctx) {
        // Parentheses just group expressions
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.gen_expr() != null) {
            return visit(ctx.gen_expr());
        }
        return null;
    }

    @Override
    public AstNode visitGen_expr(PythonParser.Gen_exprContext ctx) {
        int line = lineOf(ctx);

        // Get element expression
        AstNode element = visit(ctx.expr(0));

        // Get loop variable name
        String varName = ctx.ID().getText();

        // Get iterable
        AstNode iterable = visit(ctx.expr(1));

        // Get condition if present
        AstNode condition = null;
        if (ctx.expr().size() > 2) {
            condition = visit(ctx.expr(2));
        }

        // Define loop variable in symbol table
        symbolTable.pushScope("gen_expr");
        SymbolTable.SymbolEntry loopSymbol = symbolTable.define(varName,
                SymbolTable.SymbolKind.VARIABLE, line);
        symbolTable.popScope();

        return new GeneratorNode(line, element, varName, loopSymbol, iterable, condition);
    }

    // -------------------------
    // Helper methods
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
        if ((a == '\'' && b == '\'') || (a == '"' && b == '"')) {
            return s.substring(1, s.length() - 1);
        }
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

    private String extractSimpleName(String target) {
        if (target == null || target.isEmpty()) return target;
        // Remove array access, attribute access, etc.
        if (target.contains(".")) {
            return target.substring(target.lastIndexOf('.') + 1);
        }
        if (target.contains("[")) {
            return target.substring(0, target.indexOf('['));
        }
        return target;
    }

    private String extractPathFromArgs(PythonParser.ArglistContext arglist) {
        if (arglist == null) {
            return "";
        }

        // Look for string argument (usually the first positional arg)
        if (arglist.argument() != null) {
            for (PythonParser.ArgumentContext arg : arglist.argument()) {
                if (arg instanceof PythonParser.ArgPositionalContext) {
                    String text = textOf(((PythonParser.ArgPositionalContext) arg).expr());
                    if (text.startsWith("'") || text.startsWith("\"")) {
                        return stripQuotes(text);
                    }
                }
            }
        }

        return "";
    }

    private String getCompOpText(PythonParser.Comp_opContext ctx) {
        if (ctx instanceof PythonParser.CompEqContext) return "==";
        if (ctx instanceof PythonParser.CompNotEqContext) return "!=";
        if (ctx instanceof PythonParser.CompInContext) return "in";
        if (ctx instanceof PythonParser.CompIsContext) return "is";
        return "";
    }

    private SymbolTable.SymbolEntry defineInCurrentScope(String name, SymbolTable.SymbolKind kind, int line) {
        SymbolTable.SymbolEntry entry = symbolTable.resolveCurrent(name);
        if (entry == null) {
            return symbolTable.define(name, kind, line);
        }
        return entry;
    }

    private void recordImportSymbols(List<String> names, String pkg, String raw, int line, boolean fromImport) {
        for (String n : names) {
            SymbolTable.SymbolEntry entry = defineInCurrentScope(n, SymbolTable.SymbolKind.IMPORT, line);
            if (entry != null) {
                if (fromImport) entry.setAttribute("from", pkg);
                entry.setAttribute("raw", raw);
            }
        }
    }

    public ProgramNode getProgramRoot() {
        return programRoot;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}
