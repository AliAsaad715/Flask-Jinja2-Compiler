package Visitor;

import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import symbol.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class FlaskJinja2Visitor extends PythonParserBaseVisitor<FlaskJinja2Visitor.AstNode> {

    private final BufferedTokenStream tokens;
    private final SymbolTable symbolTable;
    private ProgramNode programRoot; // stored correctly at end of execution

    public FlaskJinja2Visitor(BufferedTokenStream tokens) {
        this.tokens = tokens;
        this.symbolTable = new SymbolTable();
    }

    public ProgramNode getProgramRoot() {
        return programRoot;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    // -------------------------
    // Program / Statements
    // -------------------------

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
    public AstNode visitStmt(PythonParser.StmtContext ctx) {
        if (ctx.import_stmt() != null) return visit(ctx.import_stmt());
        if (ctx.assign_stmt() != null) return visit(ctx.assign_stmt());
        if (ctx.decorated_funcdef() != null) return visit(ctx.decorated_funcdef());
        if (ctx.funcdef() != null) return visit(ctx.funcdef());       // NEW
        if (ctx.if_stmt() != null) return visit(ctx.if_stmt());       // NEW
        if (ctx.return_stmt() != null) return visit(ctx.return_stmt());
        if (ctx.expr_stmt() != null) return visit(ctx.expr_stmt());
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
    public AstNode visitImport_stmt(PythonParser.Import_stmtContext ctx) {
        // import_stmt
        //  : FROM dotted_name IMPORT dotted_name (COMMA dotted_name)* NEWLINE
        //  | IMPORT dotted_name (COMMA dotted_name)* NEWLINE
        String raw = textOf(ctx);
        List<String> names = new ArrayList<>();
        int line = lineOf(ctx);

        if (ctx.FROM() != null) {
            String pkg = textOf(ctx.dotted_name(0));
            for (int i = 1; i < ctx.dotted_name().size(); i++) {
                names.add(textOf(ctx.dotted_name(i)));
            }
            recordImportSymbols(names, pkg, raw, line, true);
            return new ImportNode(line, "from", pkg, names, raw);
        } else {
            for (int i = 0; i < ctx.dotted_name().size(); i++) {
                names.add(textOf(ctx.dotted_name(i)));
            }
            recordImportSymbols(names, null, raw, line, false);
            return new ImportNode(line, "import", null, names, raw);
        }
    }

    @Override
    public AstNode visitAssign_stmt(PythonParser.Assign_stmtContext ctx) {
        // assign_stmt : assign_target EQUAL expr NEWLINE
        int line = lineOf(ctx);
        String target = textOf(ctx.assign_target()); // supports: app.config['UPLOAD_FOLDER']
        String baseName = ctx.assign_target().ID().getText();
        AstNode value = visit(ctx.expr());
        SymbolTable.SymbolEntry entry = defineInCurrentScope(baseName, SymbolTable.SymbolKind.VARIABLE, line);
        if (entry != null) {
            entry.setAttribute("target", target);
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

        // Common Flask usage: route decorator -> RouteNode
        RouteNode route = new RouteNode(lineOf(ctx));
        if (!node.decorators.isEmpty()) {
            route.setDecorator(node.decorators.get(0));
        }
        route.setFunction(fn);

        return route;
    }

    @Override
    public AstNode visitDecorator(PythonParser.DecoratorContext ctx) {
        // decorator : DECORATOR dotted_name OPEN_B arglist? CLOSE_B NEWLINE
        String dotted = textOf(ctx.dotted_name()); // example: app.route
        String[] parts = splitLastDot(dotted);
        String obj = parts[0];
        String method = parts[1];

        // for Flask: first positional arg is usually the route path string
        String path = "";
        if (ctx.arglist() != null && !ctx.arglist().argument().isEmpty()) {
            PythonParser.ArgumentContext a0 = ctx.arglist().argument(0);
            // positional argument => a0.expr()
            if (a0.expr() != null) {
                AstNode n = visit(a0.expr());
                if (n instanceof StringNode) path = ((StringNode) n).value;
                else path = textOf(a0.expr());
            } else {
                path = textOf(a0);
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
        SymbolTable.SymbolEntry fnEntry = defineInCurrentScope(name, SymbolTable.SymbolKind.FUNCTION, line);

        symbolTable.pushScope("func " + name);

        if (ctx.params() != null) {
            ParamsNode params = (ParamsNode) visit(ctx.params());
            fn.parameters.addAll(params.names);
        }

        fn.body = (BlockNode) visit(ctx.suite());
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
            defineInCurrentScope(paramName, SymbolTable.SymbolKind.PARAMETER, ctx.ID(i).getSymbol().getLine());
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
    public AstNode visitNot_test(PythonParser.Not_testContext ctx) {
        if (ctx.NOT() != null) {
            return new UnaryOpNode(lineOf(ctx), "not", visit(ctx.not_test()));
        }
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
            if (tr.DOT() != null) {
                current = new AttributeNode(lineOf(tr), current, tr.ID().getText());
            } else if (tr.OPEN_B() != null) {
                List<AstNode> args = new ArrayList<>();
                if (tr.arglist() != null) {
                    for (PythonParser.ArgumentContext a : tr.arglist().argument()) {
                        args.add(visit(a));
                    }
                }
                current = new CallNode(lineOf(tr), current, args);
            } else if (tr.LBRACK() != null) {
                AstNode index = (tr.expr() != null) ? visit(tr.expr()) : new ErrorExprNode(lineOf(tr), "missing index");
                current = new SubscriptNode(lineOf(tr), current, index);
            }
        }
        return current;
    }

    @Override
    public AstNode visitArgument(PythonParser.ArgumentContext ctx) {
        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            AstNode value = visit(ctx.expr());
            return new KeywordArgNode(lineOf(ctx), name, value);
        }
        return visit(ctx.expr());
    }

    @Override
    public AstNode visitAtom(PythonParser.AtomContext ctx) {
        int line = lineOf(ctx);
        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            IdentifierNode node = new IdentifierNode(line, name);
            node.setSymbol(symbolTable.resolve(name, line));
            return node;
        }
        if (ctx.STRING() != null) return new StringNode(line, stripQuotes(ctx.STRING().getText()));
        if (ctx.INT_VALUE() != null) return new NumberNode(line, ctx.INT_VALUE().getText());
        if (ctx.FLOAT_VALUE() != null) return new NumberNode(line, ctx.FLOAT_VALUE().getText());
        if (ctx.NONE() != null) return new NoneNode(line);
        if (ctx.TRUE() != null) return new BoolNode(line, true);
        if (ctx.FALSE() != null) return new BoolNode(line, false);

        if (ctx.list_literal() != null) return visit(ctx.list_literal());
        if (ctx.dict_or_set_literal() != null) return visit(ctx.dict_or_set_literal());
        if (ctx.gen_expr() != null) return visit(ctx.gen_expr());
        if (ctx.expr() != null) return visit(ctx.expr()); // parenthesized expr

        return new ErrorExprNode(lineOf(ctx), "unknown atom: " + ctx.getText());
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
        SymbolTable.SymbolEntry varEntry = symbolTable.define(var, SymbolTable.SymbolKind.VARIABLE, line);
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

    // ============================================================
    // AST Node Hierarchy (OOP + inheritance + polymorphism)
    // ============================================================

    public static abstract class AstNode {
        public final String nodeName;
        public final int line;
        public final List<AstNode> children = new ArrayList<>();

        protected AstNode(String nodeName, int line) {
            this.nodeName = nodeName;
            this.line = line;
        }

        public void add(AstNode child) {
            if (child != null) children.add(child);
        }

        protected String describe() { return ""; }

        public final String pretty() {
            StringBuilder sb = new StringBuilder();
            prettyInto(sb, "", true);
            return sb.toString();
        }

        private void prettyInto(StringBuilder sb, String indent, boolean last) {
            sb.append(indent);
            sb.append(last ? "└── " : "├── ");
            sb.append(nodeName).append(" (line ").append(line).append(")");
            String d = describe();
            if (d != null && !d.isBlank()) sb.append(" : ").append(d);
            sb.append("\n");

            String childIndent = indent + (last ? "    " : "│   ");
            for (int i = 0; i < children.size(); i++) {
                children.get(i).prettyInto(sb, childIndent, i == children.size() - 1);
            }
        }
    }

    public static final class ProgramNode extends AstNode {
        public ProgramNode(int line) { super("Program", line); }
    }

    public static final class ImportNode extends AstNode {
        public final String kind;
        public final String packageName;
        public final List<String> names;
        public final String raw;

        public ImportNode(int line, String kind, String packageName, List<String> names, String raw) {
            super("Import", line);
            this.kind = kind;
            this.packageName = packageName;
            this.names = names;
            this.raw = raw;
        }

        @Override protected String describe() {
            if ("from".equals(kind)) return "from " + packageName + " import " + names;
            return "import " + names;
        }
    }

    public static final class AssignNode extends AstNode {
        public final String target;

        public AssignNode(int line, String target, AstNode value) {
            super("Assign", line);
            this.target = target;
            add(value);
        }

        @Override protected String describe() { return target + " = ..."; }
    }

    public static final class RouteNode extends AstNode {
        public DecoratorNode decorator;
        public FunctionNode function;

        public RouteNode(int line) { super("Route", line); }

        public void setDecorator(DecoratorNode decorator) {
            this.decorator = decorator;
            if (decorator != null) add(decorator);
        }

        public void setFunction(FunctionNode function) {
            this.function = function;
            if (function != null) add(function);
        }

        @Override protected String describe() {
            if (decorator != null) return decorator.objectName + "." + decorator.methodName + "(" + decorator.path + ")";
            return "";
        }
    }

    public static final class DecoratedFunctionNode extends AstNode {
        public final List<DecoratorNode> decorators = new ArrayList<>();
        public FunctionNode function;

        public DecoratedFunctionNode(int line) { super("DecoratedFunction", line); }

        public void addDecorator(DecoratorNode d) {
            decorators.add(d);
            add(d);
        }

        public void setFunction(FunctionNode f) {
            this.function = f;
            add(f);
        }
    }

    public static final class ArgsNode extends AstNode {
        public ArgsNode(int line) { super("Args", line); }
        @Override protected String describe() { return "arguments"; }
    }

    public static final class DecoratorNode extends AstNode {
        public final String objectName; // may be "" if none
        public final String methodName;
        public final String path;

        public DecoratorNode(int line, String objectName, String methodName, String path) {
            super("Decorator", line);
            this.objectName = objectName;
            this.methodName = methodName;
            this.path = path;
        }

        @Override protected String describe() {
            String head = objectName == null || objectName.isBlank() ? methodName : (objectName + "." + methodName);
            return "@" + head + "(" + (path == null ? "" : ("'" + path + "'")) + ")";
        }
    }

    public static final class FunctionNode extends AstNode {
        public final String name;
        public final List<String> parameters = new ArrayList<>();
        public BlockNode body;

        public FunctionNode(int line, String name) {
            super("Function", line);
            this.name = name;
        }

        @Override protected String describe() {
            return name + "(" + parameters + ")";
        }
    }

    public static final class ParamsNode extends AstNode {
        public final List<String> names = new ArrayList<>();
        public ParamsNode(int line) { super("Params", line); }
        @Override protected String describe() { return names.toString(); }
    }

    public static final class BlockNode extends AstNode {
        public BlockNode(int line) { super("Block", line); }
    }

    public static final class ExprStmtNode extends AstNode {
        public ExprStmtNode(int line, AstNode expr) {
            super("ExprStmt", line);
            add(expr);
        }
    }

    // -------- Expressions (polymorphic) --------

    public static abstract class ExprNode extends AstNode {
        protected ExprNode(String nodeName, int line) { super(nodeName, line); }
    }

    public static final class IdentifierNode extends ExprNode {
        public final String name;
        private SymbolTable.SymbolEntry symbol;
        public IdentifierNode(int line, String name) {
            super("Identifier", line);
            this.name = name;
        }
        public void setSymbol(SymbolTable.SymbolEntry symbol) { this.symbol = symbol; }
        @Override protected String describe() {
            if (symbol != null) return name + "@" + symbol.getScopeName();
            return name;
        }
    }

    public static final class StringNode extends ExprNode {
        public final String value;
        public StringNode(int line, String value) {
            super("String", line);
            this.value = value;
        }
        @Override protected String describe() { return "\"" + value + "\""; }
    }

    public static final class AttributeNode extends ExprNode {
        public final String attr;
        public AttributeNode(int line, AstNode base, String attr) {
            super("Attribute", line);
            this.attr = attr;
            add(base);
        }
        @Override protected String describe() { return "." + attr; }
    }

    public static final class CallNode extends ExprNode {
        public CallNode(int line, AstNode callee, List<AstNode> args) {
            super("Call", line);
            add(callee);
            if (args != null) for (AstNode a : args) add(a);
        }
    }

    public static final class ReturnNode extends AstNode {
        public ReturnNode(int line) {
            super("Return", line);
        }
        public ReturnNode(int line, AstNode value) { // keep old signature compatibility
            super("Return", line);
            add(value);
        }
        public void addValue(AstNode v) { add(v); }
        @Override protected String describe() { return "return"; }
    }

    public static final class ErrorExprNode extends ExprNode {
        public final String message;
        public ErrorExprNode(int line, String message) {
            super("ErrorExpr", line);
            this.message = message;
        }
        @Override protected String describe() { return message; }
    }

    public static final class NumberNode extends ExprNode {
        public final String literal;
        public NumberNode(int line, String literal) {
            super("Number", line);
            this.literal = literal;
        }
        @Override protected String describe() { return literal; }
    }

    public static final class NoneNode extends ExprNode {
        public NoneNode(int line) { super("None", line); }
        @Override protected String describe() { return "None"; }
    }

    public static final class BoolNode extends ExprNode {
        public final boolean value;
        public BoolNode(int line, boolean value) {
            super("Bool", line);
            this.value = value;
        }
        @Override protected String describe() { return Boolean.toString(value); }
    }

    public static final class ListNode extends ExprNode {
        public ListNode(int line) { super("List", line); }
    }

    public static final class SetNode extends ExprNode {
        public SetNode(int line) { super("Set", line); }
    }

    public static final class DictNode extends ExprNode {
        public DictNode(int line) { super("Dict", line); }
    }

    public static final class PairNode extends ExprNode {
        public PairNode(int line, AstNode key, AstNode value) {
            super("Pair", line);
            add(key);
            add(value);
        }
        @Override protected String describe() { return "key:value"; }
    }

    public static final class SubscriptNode extends ExprNode {
        public SubscriptNode(int line, AstNode base, AstNode index) {
            super("Subscript", line);
            add(base);
            add(index);
        }
        @Override protected String describe() { return "[]"; }
    }

    public static final class KeywordArgNode extends ExprNode {
        public final String name;
        public KeywordArgNode(int line, String name, AstNode value) {
            super("KeywordArg", line);
            this.name = name;
            add(value);
        }
        @Override protected String describe() { return name + " = ..."; }
    }

    public static final class UnaryOpNode extends ExprNode {
        public final String op;
        public UnaryOpNode(int line, String op, AstNode operand) {
            super("UnaryOp", line);
            this.op = op;
            add(operand);
        }
        @Override protected String describe() { return op; }
    }

    public static final class BinaryOpNode extends ExprNode {
        public final String op;
        public BinaryOpNode(int line, String op, AstNode left, AstNode right) {
            super("BinaryOp", line);
            this.op = op;
            add(left);
            add(right);
        }
        @Override protected String describe() { return op; }
    }

    public static final class GeneratorNode extends ExprNode {
        public final String var;
        public GeneratorNode(int line, AstNode element, String var, SymbolTable.SymbolEntry loopSymbol, AstNode iterable, AstNode cond) {
            super("GeneratorExpr", line);
            this.var = var;
            add(element);
            IdentifierNode loopVar = new IdentifierNode(line, var);
            loopVar.setSymbol(loopSymbol);
            add(loopVar);
            add(iterable);
            if (cond != null) add(cond);
        }
        @Override protected String describe() { return "for " + var + " in ..."; }
    }

    public static final class IfNode extends AstNode {
        private BlockNode elseBlock;

        public IfNode(int line, AstNode condition, BlockNode thenBlock) {
            super("If", line);
            add(condition);
            add(thenBlock);
        }

        public void addElif(IfNode elif) {
            add(elif);
        }

        public void setElse(BlockNode elseBlock) {
            this.elseBlock = elseBlock;
            add(elseBlock);
        }

        @Override protected String describe() { return "if ..."; }
    }
}
