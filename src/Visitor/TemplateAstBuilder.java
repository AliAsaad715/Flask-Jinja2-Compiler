package Visitor;

import AST.AstNode;
import AST.template.*;
import AST.template.expr.*;
import antlr.TemplateParser;
import antlr.TemplateParserBaseVisitor;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class TemplateAstBuilder extends TemplateParserBaseVisitor<AstNode> {

    @Override
    public AstNode visitTemplate(TemplateParser.TemplateContext ctx) {
        TemplateFileNode file = new TemplateFileNode(lineOf(ctx.getStart()));
        for (TemplateParser.ItemContext it : ctx.item()) {
            AstNode n = visit(it);
            if (n instanceof TemplateItemNode) file.addItem((TemplateItemNode) n);
        }
        return file;
    }

    @Override
    public AstNode visitHtmlElementItem(TemplateParser.HtmlElementItemContext ctx) {
        return visit(ctx.htmlElement());
    }

    @Override
    public AstNode visitHtmlTextItem(TemplateParser.HtmlTextItemContext ctx) {
        return visit(ctx.htmlText());
    }

    @Override
    public AstNode visitJinjaBlockItem(TemplateParser.JinjaBlockItemContext ctx) {
        return visit(ctx.jinjaBlock());
    }

    @Override
    public AstNode visitJinjaForItem(TemplateParser.JinjaForItemContext ctx) {
        return visit(ctx.jinjaFor());
    }

    @Override
    public AstNode visitJinjaIfItem(TemplateParser.JinjaIfItemContext ctx) {
        return visit(ctx.jinjaIf());
    }

    @Override
    public AstNode visitJinjaExtendsItem(TemplateParser.JinjaExtendsItemContext ctx) {
        return visit(ctx.jinjaExtends());
    }

    @Override
    public AstNode visitJinjaPrintItem(TemplateParser.JinjaPrintItemContext ctx) {
        return visit(ctx.jinjaPrint());
    }

    @Override
    public AstNode visitPlainText(TemplateParser.PlainTextContext ctx) {
        return new TextNode(lineOf(ctx.getStart()), ctx.TEXT().getText());
    }

    @Override
    public AstNode visitHtmlNormalElement(TemplateParser.HtmlNormalElementContext ctx) {
        TemplateParser.OpenTagContext open = ctx.normalElement().openTag();
        String tagName = open.TAG_NAME().getText();
        ElementNode el = new ElementNode(lineOf(open.getStart()), tagName);

        for (TemplateParser.AttributeContext a : open.attribute()) {
            AstNode attr = visit(a);
            if (attr instanceof AttributeNode) el.addAttribute((AttributeNode) attr);
        }

        for (TemplateParser.ItemContext it : ctx.normalElement().item()) {
            AstNode child = visit(it);
            if (child instanceof TemplateItemNode) el.addBodyItem((TemplateItemNode) child);
        }

        return el;
    }

    @Override
    public AstNode visitHtmlSelfClosingElement(TemplateParser.HtmlSelfClosingElementContext ctx) {
        TemplateParser.SelfClosingElementContext sc = ctx.selfClosingElement();
        String tagName = sc.TAG_NAME().getText();
        ElementNode el = new ElementNode(lineOf(sc.getStart()), tagName);

        for (TemplateParser.AttributeContext a : sc.attribute()) {
            AstNode attr = visit(a);
            if (attr instanceof AttributeNode) el.addAttribute((AttributeNode) attr);
        }

        return el;
    }

    @Override
    public AstNode visitAttributeKV(TemplateParser.AttributeKVContext ctx) {
        String name = ctx.TAG_NAME().getText();
        AttributeNode attr = new AttributeNode(lineOf(ctx.getStart()), name);

        if (ctx.attrValue() != null) {
            TemplateParser.AttrValueContext v = ctx.attrValue();
            List<TemplateParser.AttrValuePartContext> parts;

            if (v instanceof TemplateParser.AttrDoubleQuotedContext) {
                parts = ((TemplateParser.AttrDoubleQuotedContext) v).attrValuePart();
            } else {
                parts = ((TemplateParser.AttrSingleQuotedContext) v).attrValuePart();
            }

            for (TemplateParser.AttrValuePartContext p : parts) {
                AstNode part = visit(p);
                if (part instanceof AttributeValuePartNode) attr.addValuePart((AttributeValuePartNode) part);
            }
        }

        return attr;
    }

    @Override
    public AstNode visitAttrTextValuePart(TemplateParser.AttrTextValuePartContext ctx) {
        return new AttributeTextPartNode(lineOf(ctx.getStart()), ctx.ATTR_TEXT().getText());
    }

    @Override
    public AstNode visitAttrJinjaPrintValuePart(TemplateParser.AttrJinjaPrintValuePartContext ctx) {
        ExprNode expr = buildExpr(ctx.jinjaPrint().expr(), ctx.getStart());
        return new AttributeExprPartNode(lineOf(ctx.getStart()), expr);
    }

    @Override
    public AstNode visitJinjaPrint(TemplateParser.JinjaPrintContext ctx) {
        return new PrintNode(lineOf(ctx.getStart()), buildExpr(ctx.expr(), ctx.getStart()));
    }

    @Override
    public AstNode visitJinjaExtends(TemplateParser.JinjaExtendsContext ctx) {
        String raw = ctx.STRING() != null ? ctx.STRING().getText() : ctx.ID().getText();
        return new ExtendsNode(lineOf(ctx.getStart()), unquote(raw));
    }

    @Override
    public AstNode visitJinjaBlock(TemplateParser.JinjaBlockContext ctx) {
        BlockNode block = new BlockNode(lineOf(ctx.getStart()), ctx.ID().getText());
        for (TemplateParser.BlockBodyItemContext b : ctx.blockBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) block.addBodyItem((TemplateItemNode) n);
        }
        return block;
    }

    @Override
    public AstNode visitJinjaFor(TemplateParser.JinjaForContext ctx) {
        ForNode node = new ForNode(lineOf(ctx.getStart()), ctx.ID().getText(), buildExpr(ctx.expr(), ctx.getStart()));
        for (TemplateParser.ForBodyItemContext b : ctx.forBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) node.addBodyItem((TemplateItemNode) n);
        }
        return node;
    }

    @Override
    public AstNode visitJinjaIf(TemplateParser.JinjaIfContext ctx) {
        IfNode root = new IfNode(lineOf(ctx.getStart()), buildExpr(ctx.expr(), ctx.getStart()));

        for (TemplateParser.IfThenBodyItemContext b : ctx.ifThenBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) root.addThenItem((TemplateItemNode) n);
        }

        IfNode current = root;

        for (TemplateParser.JinjaElifContext e : ctx.jinjaElif()) {
            IfNode nested = new IfNode(lineOf(e.getStart()), buildExpr(e.expr(), e.getStart()));
            for (TemplateParser.ElifBodyItemContext b : e.elifBodyItem()) {
                AstNode n = visit(b.item());
                if (n instanceof TemplateItemNode) nested.addThenItem((TemplateItemNode) n);
            }
            current.addElseItem(nested);
            current = nested;
        }

        if (ctx.jinjaElse() != null) {
            for (TemplateParser.ElseBodyItemContext b : ctx.jinjaElse().elseBodyItem()) {
                AstNode n = visit(b.item());
                if (n instanceof TemplateItemNode) current.addElseItem((TemplateItemNode) n);
            }
        }

        return root;
    }

    @Override
    public AstNode visitHtmlVoidElement(antlr.TemplateParser.HtmlVoidElementContext ctx) {
        antlr.TemplateParser.VoidElementContext v = ctx.voidElement();
        String tagName = v.VOID_TAG_NAME().getText();
        ElementNode el = new ElementNode(lineOf(v.getStart()), tagName);

        for (antlr.TemplateParser.AttributeContext a : v.attribute()) {
            AstNode attr = visit(a);
            if (attr instanceof AttributeNode) el.addAttribute((AttributeNode) attr);
        }

        return el;
    }

    @Override
    public AstNode visitJinjaWithItem(TemplateParser.JinjaWithItemContext ctx) {
        return visit(ctx.jinjaWith());
    }

    @Override
    public AstNode visitJinjaWith(TemplateParser.JinjaWithContext ctx) {
        // Support: {% with messages = get_flashed_messages() %} ... {% endwith %}
        int line = lineOf(ctx.getStart());
        String raw = ctx.expr() != null ? ctx.expr().getText() : "";

        String varName = null;
        ExprNode headerOrValue;

        int eq = indexOfTopLevel(raw, '=');
        // Avoid treating '==' as assignment
        boolean isAssignment = eq > 0 && !(eq + 1 < raw.length() && raw.charAt(eq + 1) == '=');

        if (isAssignment) {
            String left = raw.substring(0, eq).trim();
            String right = raw.substring(eq + 1).trim();
            if (left.matches("[A-Za-z_][A-Za-z0-9_]*")) {
                varName = left;
                headerOrValue = buildExprFromText(line, right);
            } else {
                // Fallback: keep the whole expression as-is
                headerOrValue = buildExprFromText(line, raw);
            }
        } else {
            headerOrValue = buildExprFromText(line, raw);
        }

        WithNode w = new WithNode(line, varName, headerOrValue);
        for (TemplateParser.WithBodyItemContext b : ctx.withBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) {
                w.addBodyItem((TemplateItemNode) n);
            }
        }
        return w;
    }

    private ExprNode buildExpr(TemplateParser.ExprContext ctx, Token fallback) {
        int line = lineOf(ctx != null ? ctx.getStart() : fallback);
        String text = ctx != null ? ctx.getText() : "";
        return buildExprFromText(line, text);
    }

    private ExprNode buildExprFromText(int line, String text) {
        String s = text == null ? "" : text.trim();
        if (s.isEmpty()) return new LiteralExpr(line, "");
        if (isQuoted(s)) return new LiteralExpr(line, unquote(s));
        if (s.matches("[0-9]+")) return new LiteralExpr(line, s);

        // If the expression contains operators/syntax we don't model in the Expr AST yet,
        // keep it as a RawExpr so SymbolTable extraction can still work.
        if (shouldUseRawExpr(s)) {
            return new RawExpr(line, s);
        }

        int paren = indexOfTopLevel(s, '(');
        if (paren > 0 && s.endsWith(")")) {
            String head = s.substring(0, paren);
            String inside = s.substring(paren + 1, s.length() - 1);

            ExprNode base = buildAccessChain(line, head);
            String fn = base instanceof NameExpr ? ((NameExpr) base).getName() : head;

            CallExpr call = new CallExpr(line, fn);
            for (CallArgNode a : parseArgs(line, inside)) call.addArg(a);
            return call;
        }

        return buildAccessChain(line, s);
    }

    private boolean shouldUseRawExpr(String s) {
        // We currently support: ID, ID.ID, and simple calls with basic arguments.
        // Anything containing these chars is considered "complex" for now.
        return s.indexOf('+') >= 0
                || s.indexOf('-') >= 0
                || s.indexOf('*') >= 0
                || s.indexOf('/') >= 0
                || s.indexOf('>') >= 0
                || s.indexOf('<') >= 0
                || s.indexOf('=') >= 0
                || s.indexOf('!') >= 0
                || s.indexOf('|') >= 0
                || s.indexOf('[') >= 0
                || s.indexOf(']') >= 0
                || s.indexOf(':') >= 0;
    }

    private ExprNode buildAccessChain(int line, String s) {
        String[] parts = s.split("\\.");
        ExprNode base = new NameExpr(line, parts[0]);
        for (int i = 1; i < parts.length; i++) base = new AttrExpr(line, base, parts[i]);
        return base;
    }

    private List<CallArgNode> parseArgs(int line, String inside) {
        List<String> chunks = splitTopLevelCommas(inside);
        List<CallArgNode> args = new ArrayList<>();
        for (String c : chunks) {
            String part = c.trim();
            if (part.isEmpty()) continue;

            int eq = indexOfTopLevel(part, '=');
            if (eq > 0) {
                String name = part.substring(0, eq).trim();
                String valueText = part.substring(eq + 1).trim();
                ExprNode value = buildExprFromText(line, valueText);
                args.add(new CallArgNode(line, name, value));
            } else {
                ExprNode value = buildExprFromText(line, part);
                args.add(new CallArgNode(line, "", value));
            }
        }
        return args;
    }

    private List<String> splitTopLevelCommas(String s) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int depth = 0;
        boolean inS = false;
        boolean inD = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '\'' && !inD) inS = !inS;
            else if (ch == '"' && !inS) inD = !inD;
            else if (!inS && !inD) {
                if (ch == '(' || ch == '[' || ch == '{') depth++;
                else if (ch == ')' || ch == ']' || ch == '}') depth--;
                else if (ch == ',' && depth == 0) {
                    out.add(cur.toString());
                    cur.setLength(0);
                    continue;
                }
            }

            cur.append(ch);
        }

        if (cur.length() > 0) out.add(cur.toString());
        return out;
    }

    private int indexOfTopLevel(String s, char target) {
        int depth = 0;
        boolean inS = false;
        boolean inD = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '\'' && !inD) { inS = !inS; continue; }
            if (ch == '"'  && !inS) { inD = !inD; continue; }
            if (inS || inD) continue;

            // ✅ check target first at top-level
            if (depth == 0 && ch == target) return i;

            // then update depth
            if (ch == '(' || ch == '[' || ch == '{') depth++;
            else if (ch == ')' || ch == ']' || ch == '}') depth--;
        }
        return -1;
    }

    private boolean isQuoted(String s) {
        return (s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"));
    }

    private String unquote(String s) {
        String t = s == null ? "" : s.trim();
        if (isQuoted(t) && t.length() >= 2) return t.substring(1, t.length() - 1);
        return t;
    }

    private int lineOf(Token t) {
        return t == null ? -1 : t.getLine();
    }

}
