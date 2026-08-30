package CodeGen;

import AST.template.*;
import AST.template.expr.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class TemplateEmitter {

    private static final Set<String> VOID_TAGS = new HashSet<>(Arrays.asList(
            "img", "input", "br", "hr", "meta", "link", "source",
            "area", "base", "col", "embed", "param", "track", "wbr"));

    private static final int P_COND = 1;
    private static final int P_OR = 2;
    private static final int P_AND = 3;
    private static final int P_NOT = 4;
    private static final int P_COMPARE = 5;
    private static final int P_FILTER = 6;
    private static final int P_ADD = 7;
    private static final int P_MUL = 8;
    private static final int P_UNARY = 9;
    private static final int P_ATOM = 100;

    private static final int P_POSTFIX_BASE = 90;

    private final StringBuilder out = new StringBuilder();

    private TemplateEmitter() {
    }

    static String emit(TemplateFileNode file) {
        TemplateEmitter emitter = new TemplateEmitter();
        if (file != null) emitter.items(file.getItems());
        return emitter.out.toString();
    }

    static String expressionText(ExprNode expr) {
        return new TemplateEmitter().renderExpr(expr, 0);
    }

    private void items(List<TemplateItemNode> list) {
        if (list == null) return;
        for (TemplateItemNode item : list) item(item);
    }

    private void item(TemplateItemNode node) {
        if (node == null) return;

        if (node instanceof TextNode) {
            String text = ((TextNode) node).getText();
            if (text != null) out.append(text);

        } else if (node instanceof ElementNode) {
            element((ElementNode) node);

        } else if (node instanceof ExtendsNode) {
            out.append("{% extends \"").append(((ExtendsNode) node).getTemplateName()).append("\" %}");

        } else if (node instanceof BlockNode) {
            BlockNode b = (BlockNode) node;
            out.append("{% block ").append(b.getBlockName()).append(" %}");
            items(b.getBody());
            out.append("{% endblock %}");

        } else if (node instanceof ForNode) {
            ForNode f = (ForNode) node;
            out.append("{% for ").append(String.join(", ", f.getVarNames()))
               .append(" in ").append(renderExpr(f.getIterable(), 0)).append(" %}");
            items(f.getBody());
            out.append("{% endfor %}");

        } else if (node instanceof IfNode) {
            ifNode((IfNode) node, true);

        } else if (node instanceof WithNode) {
            WithNode w = (WithNode) node;
            out.append("{% with");
            String var = w.getVarName();
            if (var != null && !var.isEmpty()) out.append(' ').append(var).append(" =");
            if (w.getValueExpr() != null) out.append(' ').append(renderExpr(w.getValueExpr(), 0));
            out.append(" %}");
            items(w.getBody());
            out.append("{% endwith %}");

        } else if (node instanceof PrintNode) {
            out.append("{{ ").append(renderExpr(((PrintNode) node).getExpr(), 0)).append(" }}");
        }
    }

    private void ifNode(IfNode node, boolean topLevel) {
        out.append(topLevel ? "{% if " : "{% elif ")
           .append(renderExpr(node.getCondition(), 0))
           .append(" %}");
        items(node.getThenBody());

        List<TemplateItemNode> elseBody = node.getElseBody();

        if (elseBody.size() == 1 && elseBody.get(0) instanceof IfNode) {
            ifNode((IfNode) elseBody.get(0), false);
        } else if (!elseBody.isEmpty()) {
            out.append("{% else %}");
            items(elseBody);
            out.append("{% endif %}");
        } else {
            out.append("{% endif %}");
        }

    }

    private void element(ElementNode node) {
        String tag = node.getTagName();

        StringBuilder open = new StringBuilder("<").append(tag);
        for (AttributeNode attr : node.getAttributes()) {
            open.append(' ').append(attribute(attr));
        }

        if (tag != null && tag.startsWith("!")) {
            out.append(open).append('>');
            return;
        }

        if (tag != null && VOID_TAGS.contains(tag.toLowerCase())) {
            out.append(open).append(" />");
            return;
        }

        out.append(open).append('>');
        items(node.getBody());
        out.append("</").append(tag).append('>');
    }

    private String attribute(AttributeNode attr) {
        List<AttributeValuePartNode> parts = attr.getValueParts();
        if (parts.isEmpty()) return attr.hasValue() ? attr.getName() + "=\"\"" : attr.getName();

        StringBuilder value = new StringBuilder();
        boolean hasDoubleQuote = false;

        for (AttributeValuePartNode part : parts) {
            if (part instanceof AttributeTextPartNode) {
                String text = ((AttributeTextPartNode) part).getText();
                if (text == null) continue;
                if (text.indexOf('"') >= 0) hasDoubleQuote = true;
                value.append(text);
            } else if (part instanceof AttributeExprPartNode) {
                value.append("{{ ")
                     .append(renderExpr(((AttributeExprPartNode) part).getExpr(), 0))
                     .append(" }}");
            }
        }

        char quote = hasDoubleQuote ? '\'' : '"';
        return attr.getName() + "=" + quote + value + quote;
    }

    private String renderExpr(ExprNode node, int parentPrecedence) {
        if (node == null) return "";
        String text = renderBare(node);
        return precedenceOf(node) < parentPrecedence ? "(" + text + ")" : text;
    }

    private String renderBare(ExprNode node) {
        if (node instanceof NameExpr) {
            return ((NameExpr) node).getName();
        }
        if (node instanceof LiteralExpr) {
            return literal(((LiteralExpr) node).getLiteral());
        }
        if (node instanceof AttrExpr) {
            AttrExpr a = (AttrExpr) node;
            return renderExpr(a.getBase(), P_POSTFIX_BASE) + "." + a.getAttrName();
        }
        if (node instanceof IndexExpr) {
            IndexExpr i = (IndexExpr) node;
            return renderExpr(i.getTarget(), P_POSTFIX_BASE) + "[" + renderExpr(i.getIndex(), 0) + "]";
        }
        if (node instanceof SliceExpr) {
            SliceExpr s = (SliceExpr) node;
            String start = s.getStart() == null ? "" : renderExpr(s.getStart(), 0);
            String stop = s.getStop() == null ? "" : renderExpr(s.getStop(), 0);
            return renderExpr(s.getTarget(), P_POSTFIX_BASE) + "[" + start + ":" + stop + "]";
        }
        if (node instanceof CallExpr) {
            CallExpr c = (CallExpr) node;
            return renderExpr(c.getCallee(), P_POSTFIX_BASE) + "(" + args(c.getArgs()) + ")";
        }
        if (node instanceof FilterExpr) {
            FilterExpr f = (FilterExpr) node;
            String text = renderExpr(f.getInput(), P_FILTER) + " | " + f.getFilterName();
            if (!f.getArgs().isEmpty()) text += "(" + args(f.getArgs()) + ")";
            return text;
        }
        if (node instanceof BinaryExpr) {
            BinaryExpr b = (BinaryExpr) node;
            int p = precedenceOf(node);
            boolean chainable = "and".equals(b.getOp()) || "or".equals(b.getOp());
            String right = renderExpr(b.getRight(), chainable ? p : p + 1);
            return renderExpr(b.getLeft(), p) + " " + b.getOp() + " " + right;
        }
        if (node instanceof UnaryExpr) {
            UnaryExpr u = (UnaryExpr) node;
            String operand = renderExpr(u.getOperand(), precedenceOf(node));
            return "not".equals(u.getOp()) ? "not " + operand : u.getOp() + operand;
        }
        if (node instanceof CondExpr) {
            CondExpr c = (CondExpr) node;
            String text = renderExpr(c.getThenExpr(), P_OR)
                    + " if " + renderExpr(c.getCondition(), P_OR);
            if (c.getElseExpr() != null) text += " else " + renderExpr(c.getElseExpr(), P_COND);
            return text;
        }
        if (node instanceof ListExpr) {
            StringBuilder sb = new StringBuilder("[");
            List<ExprNode> items = ((ListExpr) node).getItems();
            for (int i = 0; i < items.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(renderExpr(items.get(i), 0));
            }
            return sb.append(']').toString();
        }
        return "";
    }

    private String args(List<CallArgNode> args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.size(); i++) {
            if (i > 0) sb.append(", ");
            CallArgNode a = args.get(i);
            String name = a.getName();
            if (name != null && !name.isEmpty()) sb.append(name).append('=');
            sb.append(renderExpr(a.getValue(), 0));
        }
        return sb.toString();
    }

    private String literal(String text) {
        if (text == null) return "''";
        if (text.equals("True") || text.equals("False") || text.equals("None")) return text;
        if (text.matches("[0-9]+(\\.[0-9]+)?")) return text;

        StringBuilder sb = new StringBuilder("'");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '\\') sb.append("\\\\");
            else if (c == '\'') sb.append("\\'");
            else sb.append(c);
        }
        return sb.append('\'').toString();
    }

    private int precedenceOf(ExprNode node) {
        if (node instanceof CondExpr) return P_COND;
        if (node instanceof BinaryExpr) {
            String op = ((BinaryExpr) node).getOp();
            if ("or".equals(op)) return P_OR;
            if ("and".equals(op)) return P_AND;
            if ("+".equals(op) || "-".equals(op)) return P_ADD;
            if ("*".equals(op) || "/".equals(op) || "%".equals(op)) return P_MUL;
            return P_COMPARE;
        }
        if (node instanceof UnaryExpr) {
            return "not".equals(((UnaryExpr) node).getOp()) ? P_NOT : P_UNARY;
        }
        if (node instanceof FilterExpr) return P_FILTER;
        return P_ATOM;
    }
}
