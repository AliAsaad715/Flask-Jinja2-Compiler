package CodeGen;

import AST.python.*;

import java.util.ArrayList;
import java.util.List;

final class PythonEmitter {

    private static final String INDENT_UNIT = "    ";

    private static final int P_OR = 1;
    private static final int P_AND = 2;
    private static final int P_NOT = 3;
    private static final int P_COMPARE = 4;
    private static final int P_ADD = 5;
    private static final int P_MUL = 6;
    private static final int P_UNARY = 7;
    private static final int P_ATOM = 100;

    private static final int P_POSTFIX_BASE = 90;

    private final StringBuilder out = new StringBuilder();

    private PythonEmitter() {
    }

    static String emit(ProgramNode program) {
        PythonEmitter emitter = new PythonEmitter();
        emitter.program(program);
        return emitter.out.toString();
    }

    private void program(ProgramNode program) {
        if (program == null) return;

        AstNode previous = null;
        for (AstNode stmt : program.getChildren()) {
            if (previous != null && wantsBlankLine(previous, stmt)) out.append('\n');
            statement(stmt, 0);
            previous = stmt;
        }
    }

    private boolean wantsBlankLine(AstNode previous, AstNode current) {
        if (isDefinition(previous) || isDefinition(current)) return true;
        return previous instanceof ImportNode && !(current instanceof ImportNode);
    }

    private boolean isDefinition(AstNode n) {
        return n instanceof FunctionNode || n instanceof RouteNode || n instanceof DecoratedFunctionNode;
    }

    private void statement(AstNode node, int level) {
        if (node == null) return;

        if (node instanceof ImportNode) {
            importStmt((ImportNode) node, level);
        } else if (node instanceof AssignNode) {
            AssignNode a = (AssignNode) node;
            line(level, a.target + " = " + expression(firstChild(a), level));
        } else if (node instanceof RouteNode) {
            RouteNode r = (RouteNode) node;
            decorator(r.decorator, level);
            function(r.function, level);
        } else if (node instanceof DecoratedFunctionNode) {
            decoratedFunction((DecoratedFunctionNode) node, level);
        } else if (node instanceof FunctionNode) {
            function((FunctionNode) node, level);
        } else if (node instanceof IfNode) {
            ifStmt((IfNode) node, level, "if");
        } else if (node instanceof ReturnNode) {
            returnStmt((ReturnNode) node, level);
        } else if (node instanceof ExprStmtNode) {
            line(level, expression(firstChild(node), level));
        } else if (node instanceof BlockNode) {
            block((BlockNode) node, level);
        } else if (node instanceof DecoratorNode) {
            decorator((DecoratorNode) node, level);
        } else if (node instanceof ProgramNode) {
            for (AstNode child : node.getChildren()) statement(child, level);
        } else {
            line(level, expression(node, level));
        }
    }

    private void importStmt(ImportNode node, int level) {
        List<String> names = node.names == null ? new ArrayList<>() : node.names;

        if (names.isEmpty()) {
            line(level, node.raw == null ? "pass" : node.raw.trim());
            return;
        }
        if ("from".equals(node.kind)) {
            line(level, "from " + node.packageName + " import " + String.join(", ", names));
        } else {
            line(level, "import " + String.join(", ", names));
        }
    }

    private void decoratedFunction(DecoratedFunctionNode node, int level) {
        for (AstNode child : node.getChildren()) {
            if (child instanceof RouteNode) {
                decorator(((RouteNode) child).decorator, level);
            } else if (child instanceof DecoratorNode) {
                decorator((DecoratorNode) child, level);
            }
        }
        function(node.function, level);
    }

    private void decorator(DecoratorNode node, int level) {
        if (node == null) return;

        String head = (node.objectName == null || node.objectName.isBlank())
                ? node.methodName
                : node.objectName + "." + node.methodName;

        ArgsNode args = null;
        for (AstNode child : node.getChildren()) {
            if (child instanceof ArgsNode) args = (ArgsNode) child;
        }

        if (args != null) {
            line(level, "@" + head + "(" + argumentList(args.getChildren(), level) + ")");
        } else if (node.path != null && !node.path.isEmpty()) {
            line(level, "@" + head + "(" + pythonString(node.path) + ")");
        } else if (node.path != null) {
            line(level, "@" + head + "()");
        } else {
            line(level, "@" + head);
        }
    }

    private void function(FunctionNode node, int level) {
        if (node == null) return;
        line(level, "def " + node.name + "(" + String.join(", ", node.parameters) + "):");
        block(node.body, level + 1);
    }

    private void ifStmt(IfNode node, int level, String keyword) {
        List<AstNode> children = node.getChildren();
        AstNode condition = children.isEmpty() ? null : children.get(0);
        BlockNode thenBlock = (children.size() > 1 && children.get(1) instanceof BlockNode)
                ? (BlockNode) children.get(1) : null;

        line(level, keyword + " " + expression(condition, level) + ":");
        block(thenBlock, level + 1);

        for (int i = 2; i < children.size(); i++) {
            AstNode child = children.get(i);
            if (child instanceof IfNode) {
                ifStmt((IfNode) child, level, "elif");
            }
        }

        if (node.elseBlock != null) {
            line(level, "else:");
            block(node.elseBlock, level + 1);
        }
    }

    private void returnStmt(ReturnNode node, int level) {
        List<AstNode> values = node.getChildren();
        if (values.isEmpty()) {
            line(level, "return");
            return;
        }
        StringBuilder sb = new StringBuilder("return ");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(expression(values.get(i), level));
        }
        line(level, sb.toString());
    }

    private void block(BlockNode node, int level) {
        if (node == null || node.getChildren().isEmpty()) {
            line(level, "pass");
            return;
        }
        for (AstNode stmt : node.getChildren()) statement(stmt, level);
    }

    private String expression(AstNode node, int level) {
        return render(node, level);
    }

    private String render(AstNode node, int level) {
        if (node == null) return "None";

        if (node instanceof IdentifierNode) return ((IdentifierNode) node).name;
        if (node instanceof StringNode) return pythonString(((StringNode) node).value);
        if (node instanceof NumberNode) return ((NumberNode) node).literal;
        if (node instanceof BoolNode) return ((BoolNode) node).value ? "True" : "False";
        if (node instanceof NoneNode) return "None";

        if (node instanceof BinaryOpNode) {
            BinaryOpNode b = (BinaryOpNode) node;
            int p = precedenceOf(node);
            List<AstNode> kids = b.getChildren();
            AstNode left = kids.size() > 0 ? kids.get(0) : null;
            AstNode right = kids.size() > 1 ? kids.get(1) : null;
            boolean chainable = "and".equals(b.op) || "or".equals(b.op);
            return operand(left, level, p, false)
                    + " " + b.op + " "
                    + operand(right, level, p, !chainable);
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode u = (UnaryOpNode) node;
            int p = precedenceOf(node);
            String operand = operand(firstChild(u), level, p, false);
            return "not".equals(u.op) ? "not " + operand : u.op + operand;
        }

        if (node instanceof CallNode) {
            List<AstNode> kids = node.getChildren();
            String callee = kids.isEmpty() ? "" : operand(kids.get(0), level, P_POSTFIX_BASE, false);
            return callee + "(" + argumentList(kids.subList(Math.min(1, kids.size()), kids.size()), level) + ")";
        }

        if (node instanceof AttributeNode) {
            AttributeNode a = (AttributeNode) node;
            return operand(firstChild(a), level, P_POSTFIX_BASE, false) + "." + a.attr;
        }

        if (node instanceof SubscriptNode) {
            List<AstNode> kids = node.getChildren();
            String base = kids.isEmpty() ? "" : operand(kids.get(0), level, P_POSTFIX_BASE, false);
            String index = kids.size() > 1 ? render(kids.get(1), level) : "";
            return base + "[" + index + "]";
        }

        if (node instanceof KeywordArgNode) {
            KeywordArgNode k = (KeywordArgNode) node;
            return k.name + "=" + render(firstChild(k), level);
        }

        if (node instanceof PairNode) {
            List<AstNode> kids = node.getChildren();
            String key = kids.size() > 0 ? render(kids.get(0), level) : "None";
            String value = kids.size() > 1 ? render(kids.get(1), level) : "None";
            return key + ": " + value;
        }

        if (node instanceof ListNode) {
            return collection(node.getChildren(), level, "[", "]", listWantsBreaks(node));
        }
        if (node instanceof DictNode) {
            return collection(node.getChildren(), level, "{", "}", node.getChildren().size() >= 2);
        }
        if (node instanceof SetNode) {
            return collection(node.getChildren(), level, "{", "}", false);
        }

        if (node instanceof GeneratorNode) {
            return "(" + generatorBody((GeneratorNode) node, level) + ")";
        }

        if (node instanceof ArgsNode) {
            return argumentList(node.getChildren(), level);
        }
        if (node instanceof ParamsNode) {
            return String.join(", ", ((ParamsNode) node).names);
        }

        if (node instanceof ErrorExprNode) {
            return "None";
        }

        return "None";
    }

    private String generatorBody(GeneratorNode node, int level) {
        List<AstNode> kids = node.getChildren();
        String element = kids.size() > 0 ? render(kids.get(0), level) : "None";
        String iterable = kids.size() > 2 ? render(kids.get(2), level) : "[]";
        String text = element + " for " + node.var + " in " + iterable;
        if (kids.size() > 3) text += " if " + render(kids.get(3), level);
        return text;
    }

    private String argumentList(List<AstNode> args, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(render(args.get(i), level));
        }
        return sb.toString();
    }

    private String collection(List<AstNode> items, int level, String open, String close, boolean multiline) {
        if (items.isEmpty()) return open + close;

        if (!multiline) {
            StringBuilder sb = new StringBuilder(open);
            for (int i = 0; i < items.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(render(items.get(i), level));
            }
            return sb.append(close).toString();
        }

        StringBuilder sb = new StringBuilder(open).append('\n');
        for (int i = 0; i < items.size(); i++) {
            sb.append(indent(level + 1)).append(render(items.get(i), level + 1));
            if (i < items.size() - 1) sb.append(',');
            sb.append('\n');
        }
        return sb.append(indent(level)).append(close).toString();
    }

    private boolean listWantsBreaks(AstNode list) {
        for (AstNode item : list.getChildren()) {
            boolean nested = item instanceof DictNode || item instanceof ListNode;
            if (nested && !item.getChildren().isEmpty()) return true;
        }
        return false;
    }

    private String operand(AstNode child, int level, int parentPrecedence, boolean tighterOnRight) {
        String text = render(child, level);
        int p = precedenceOf(child);
        boolean needsParens = tighterOnRight ? p <= parentPrecedence : p < parentPrecedence;
        return needsParens ? "(" + text + ")" : text;
    }

    private int precedenceOf(AstNode node) {
        if (node instanceof BinaryOpNode) {
            String op = ((BinaryOpNode) node).op;
            if ("or".equals(op)) return P_OR;
            if ("and".equals(op)) return P_AND;
            if ("+".equals(op) || "-".equals(op)) return P_ADD;
            if ("*".equals(op) || "/".equals(op) || "//".equals(op) || "%".equals(op)) return P_MUL;
            return P_COMPARE;
        }
        if (node instanceof UnaryOpNode) {
            return "not".equals(((UnaryOpNode) node).op) ? P_NOT : P_UNARY;
        }
        return P_ATOM;
    }

    private AstNode firstChild(AstNode node) {
        return node.getChildren().isEmpty() ? null : node.getChildren().get(0);
    }

    private void line(int level, String text) {
        out.append(indent(level)).append(text).append('\n');
    }

    private String indent(int level) {
        return INDENT_UNIT.repeat(Math.max(0, level));
    }

    static String pythonString(String value) {
        StringBuilder sb = new StringBuilder("'");
        if (value != null) {
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                switch (c) {
                    case '\\': sb.append("\\\\"); break;
                    case '\'': sb.append("\\'"); break;
                    case '\n': sb.append("\\n"); break;
                    case '\r': sb.append("\\r"); break;
                    case '\t': sb.append("\\t"); break;
                    default: sb.append(c);
                }
            }
        }
        return sb.append('\'').toString();
    }
}
