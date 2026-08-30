package Visitor;

import AST.python.AstNode;
import AST.template.*;
import AST.template.expr.*;
import antlr.TemplateParser;
import antlr.TemplateParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

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
    public AstNode visitJinjaWithItem(TemplateParser.JinjaWithItemContext ctx) {
        return visit(ctx.jinjaWith());
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
        ElementNode el = new ElementNode(lineOf(open.getStart()), open.TAG_NAME().getText());

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
        String tagName = sc.TAG_NAME() != null ? sc.TAG_NAME().getText() : sc.VOID_TAG_NAME().getText();
        ElementNode el = new ElementNode(lineOf(sc.getStart()), tagName);

        for (TemplateParser.AttributeContext a : sc.attribute()) {
            AstNode attr = visit(a);
            if (attr instanceof AttributeNode) el.addAttribute((AttributeNode) attr);
        }
        return el;
    }

    @Override
    public AstNode visitHtmlVoidElement(TemplateParser.HtmlVoidElementContext ctx) {
        TemplateParser.VoidElementContext v = ctx.voidElement();
        ElementNode el = new ElementNode(lineOf(v.getStart()), v.VOID_TAG_NAME().getText());

        for (TemplateParser.AttributeContext a : v.attribute()) {
            AstNode attr = visit(a);
            if (attr instanceof AttributeNode) el.addAttribute((AttributeNode) attr);
        }
        return el;
    }

    @Override
    public AstNode visitAttributeKV(TemplateParser.AttributeKVContext ctx) {
        AttributeNode attr = new AttributeNode(
                lineOf(ctx.getStart()), ctx.TAG_NAME().getText(), ctx.attrValue() != null);

        if (ctx.attrValue() != null) {
            List<TemplateParser.AttrValuePartContext> parts;
            if (ctx.attrValue() instanceof TemplateParser.AttrDoubleQuotedContext) {
                parts = ((TemplateParser.AttrDoubleQuotedContext) ctx.attrValue()).attrValuePart();
            } else {
                parts = ((TemplateParser.AttrSingleQuotedContext) ctx.attrValue()).attrValuePart();
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
        ExprNode expr = buildExpr(ctx.jinjaPrint().expr());
        return new AttributeExprPartNode(lineOf(ctx.getStart()), expr);
    }

    @Override
    public AstNode visitJinjaPrint(TemplateParser.JinjaPrintContext ctx) {
        return new PrintNode(lineOf(ctx.getStart()), buildExpr(ctx.expr()));
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
        List<String> vars = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) vars.add(id.getText());

        ForNode node = new ForNode(lineOf(ctx.getStart()), vars, buildExpr(ctx.expr()));
        for (TemplateParser.ForBodyItemContext b : ctx.forBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) node.addBodyItem((TemplateItemNode) n);
        }
        return node;
    }

    @Override
    public AstNode visitJinjaIf(TemplateParser.JinjaIfContext ctx) {
        IfNode root = new IfNode(lineOf(ctx.getStart()), buildExpr(ctx.expr()));

        for (TemplateParser.IfThenBodyItemContext b : ctx.ifThenBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) root.addThenItem((TemplateItemNode) n);
        }

        IfNode current = root;
        for (TemplateParser.JinjaElifContext e : ctx.jinjaElif()) {
            IfNode nested = new IfNode(lineOf(e.getStart()), buildExpr(e.expr()));
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
    public AstNode visitJinjaWith(TemplateParser.JinjaWithContext ctx) {
        int line = lineOf(ctx.getStart());
        String varName = ctx.name != null ? ctx.name.getText() : null;
        ExprNode value = ctx.value != null ? buildExpr(ctx.value) : null;

        WithNode w = new WithNode(line, varName, value);
        for (TemplateParser.WithBodyItemContext b : ctx.withBodyItem()) {
            AstNode n = visit(b.item());
            if (n instanceof TemplateItemNode) w.addBodyItem((TemplateItemNode) n);
        }
        return w;
    }

    private ExprNode buildExpr(TemplateParser.ExprContext ctx) {
        if (ctx == null) return null;
        return buildCond(ctx.condExpr());
    }

    private ExprNode buildCond(TemplateParser.CondExprContext ctx) {
        if (ctx == null || ctx.orExpr().isEmpty()) return null;

        ExprNode value = buildOr(ctx.orExpr(0));
        if (ctx.IF() == null || ctx.orExpr().size() < 2) return value;

        ExprNode condition = buildOr(ctx.orExpr(1));
        ExprNode fallback = ctx.condExpr() != null ? buildCond(ctx.condExpr()) : null;
        return new CondExpr(lineOf(ctx.getStart()), value, condition, fallback);
    }

    private ExprNode buildOr(TemplateParser.OrExprContext ctx) {
        if (ctx == null || ctx.andExpr().isEmpty()) return null;

        ExprNode left = buildAnd(ctx.andExpr(0));
        for (int i = 1; i < ctx.andExpr().size(); i++) {
            left = new BinaryExpr(lineOf(ctx.getStart()), "or", left, buildAnd(ctx.andExpr(i)));
        }
        return left;
    }

    private ExprNode buildAnd(TemplateParser.AndExprContext ctx) {
        if (ctx == null || ctx.notExpr().isEmpty()) return null;

        ExprNode left = buildNot(ctx.notExpr(0));
        for (int i = 1; i < ctx.notExpr().size(); i++) {
            left = new BinaryExpr(lineOf(ctx.getStart()), "and", left, buildNot(ctx.notExpr(i)));
        }
        return left;
    }

    private ExprNode buildNot(TemplateParser.NotExprContext ctx) {
        if (ctx instanceof TemplateParser.NotUnaryContext) {
            TemplateParser.NotUnaryContext n = (TemplateParser.NotUnaryContext) ctx;
            return new UnaryExpr(lineOf(n.getStart()), "not", buildNot(n.notExpr()));
        }
        if (ctx instanceof TemplateParser.NotPassthroughContext) {
            return buildComparison(((TemplateParser.NotPassthroughContext) ctx).comparison());
        }
        return null;
    }

    private ExprNode buildComparison(TemplateParser.ComparisonContext ctx) {
        if (ctx == null || ctx.filterExpr().isEmpty()) return null;

        ExprNode left = buildFilter(ctx.filterExpr(0));
        for (int i = 1; i < ctx.filterExpr().size(); i++) {
            String op = compOpText(ctx.compOp(i - 1));
            left = new BinaryExpr(lineOf(ctx.getStart()), op, left, buildFilter(ctx.filterExpr(i)));
        }
        return left;
    }

    private String compOpText(TemplateParser.CompOpContext ctx) {
        if (ctx instanceof TemplateParser.CompEqContext)    return "==";
        if (ctx instanceof TemplateParser.CompNotEqContext) return "!=";
        if (ctx instanceof TemplateParser.CompLeContext)    return "<=";
        if (ctx instanceof TemplateParser.CompGeContext)    return ">=";
        if (ctx instanceof TemplateParser.CompLtContext)    return "<";
        if (ctx instanceof TemplateParser.CompGtContext)    return ">";
        if (ctx instanceof TemplateParser.CompNotInContext) return "not in";
        if (ctx instanceof TemplateParser.CompInContext)    return "in";
        if (ctx instanceof TemplateParser.CompIsNotContext) return "is not";
        return "is";
    }

    private ExprNode buildFilter(TemplateParser.FilterExprContext ctx) {
        if (ctx == null) return null;

        ExprNode value = buildAdditive(ctx.additive());
        for (TemplateParser.FilterCallContext f : ctx.filterCall()) {
            FilterExpr filter = new FilterExpr(lineOf(f.getStart()), value, f.ID().getText());
            if (f.argList() != null) {
                for (CallArgNode a : buildArgs(f.argList())) filter.addArg(a);
            }
            value = filter;
        }
        return value;
    }

    private ExprNode buildAdditive(TemplateParser.AdditiveContext ctx) {
        if (ctx == null || ctx.multiplicative().isEmpty()) return null;

        ExprNode left = buildMultiplicative(ctx.multiplicative(0));
        for (int i = 1; i < ctx.multiplicative().size(); i++) {
            String op = operatorBetween(ctx, ctx.multiplicative(i - 1), ctx.multiplicative(i));
            left = new BinaryExpr(lineOf(ctx.getStart()), op, left, buildMultiplicative(ctx.multiplicative(i)));
        }
        return left;
    }

    private ExprNode buildMultiplicative(TemplateParser.MultiplicativeContext ctx) {
        if (ctx == null || ctx.unary().isEmpty()) return null;

        ExprNode left = buildUnary(ctx.unary(0));
        for (int i = 1; i < ctx.unary().size(); i++) {
            String op = operatorBetween(ctx, ctx.unary(i - 1), ctx.unary(i));
            left = new BinaryExpr(lineOf(ctx.getStart()), op, left, buildUnary(ctx.unary(i)));
        }
        return left;
    }

    private String operatorBetween(ParserRuleContext parent, ParserRuleContext left, ParserRuleContext right) {
        boolean seenLeft = false;
        for (int i = 0; i < parent.getChildCount(); i++) {
            Object child = parent.getChild(i);
            if (child == left) { seenLeft = true; continue; }
            if (child == right) break;
            if (seenLeft && child instanceof TerminalNode) {
                return ((TerminalNode) child).getText();
            }
        }
        return "?";
    }

    private ExprNode buildUnary(TemplateParser.UnaryContext ctx) {
        if (ctx instanceof TemplateParser.UnaryMinusContext) {
            TemplateParser.UnaryMinusContext m = (TemplateParser.UnaryMinusContext) ctx;
            return new UnaryExpr(lineOf(m.getStart()), "-", buildUnary(m.unary()));
        }
        if (ctx instanceof TemplateParser.UnaryPassthroughContext) {
            return buildPostfix(((TemplateParser.UnaryPassthroughContext) ctx).postfix());
        }
        return null;
    }

    private ExprNode buildPostfix(TemplateParser.PostfixContext ctx) {
        if (ctx == null) return null;

        ExprNode current = buildPrimary(ctx.primary());

        for (TemplateParser.TrailerContext tr : ctx.trailer()) {
            int line = lineOf(tr.getStart());

            if (tr instanceof TemplateParser.TrailerAttrContext) {
                TemplateParser.TrailerAttrContext ta = (TemplateParser.TrailerAttrContext) tr;
                current = new AttrExpr(line, current, ta.ID().getText());

            } else if (tr instanceof TemplateParser.TrailerCallContext) {
                TemplateParser.TrailerCallContext tc = (TemplateParser.TrailerCallContext) tr;
                CallExpr call = new CallExpr(line, current);
                if (tc.argList() != null) {
                    for (CallArgNode a : buildArgs(tc.argList())) call.addArg(a);
                }
                current = call;

            } else {
                TemplateParser.TrailerIndexContext ti = (TemplateParser.TrailerIndexContext) tr;
                current = buildSubscript(line, current, ti.subscript());
            }
        }
        return current;
    }

    private ExprNode buildSubscript(int line, ExprNode target, TemplateParser.SubscriptContext ctx) {
        if (ctx instanceof TemplateParser.SubscriptIndexContext) {
            TemplateParser.SubscriptIndexContext idx = (TemplateParser.SubscriptIndexContext) ctx;
            return new IndexExpr(line, target, buildExpr(idx.expr()));
        }
        if (ctx instanceof TemplateParser.SubscriptSliceContext) {
            TemplateParser.SubscriptSliceContext s = (TemplateParser.SubscriptSliceContext) ctx;
            return new SliceExpr(line, target, buildExpr(s.start), buildExpr(s.stop));
        }
        return target;
    }

    private ExprNode buildPrimary(TemplateParser.PrimaryContext ctx) {
        if (ctx == null) return null;
        int line = lineOf(ctx.getStart());

        if (ctx instanceof TemplateParser.PrimaryIdContext) {
            return new NameExpr(line, ((TemplateParser.PrimaryIdContext) ctx).ID().getText());
        }
        if (ctx instanceof TemplateParser.PrimaryIntContext) {
            return new LiteralExpr(line, ((TemplateParser.PrimaryIntContext) ctx).INT().getText());
        }
        if (ctx instanceof TemplateParser.PrimaryFloatContext) {
            return new LiteralExpr(line, ((TemplateParser.PrimaryFloatContext) ctx).FLOAT().getText());
        }
        if (ctx instanceof TemplateParser.PrimaryStringContext) {
            return new LiteralExpr(line, unquote(((TemplateParser.PrimaryStringContext) ctx).STRING().getText()));
        }
        if (ctx instanceof TemplateParser.PrimaryTrueContext)  return new LiteralExpr(line, "True");
        if (ctx instanceof TemplateParser.PrimaryFalseContext) return new LiteralExpr(line, "False");
        if (ctx instanceof TemplateParser.PrimaryNoneContext)  return new LiteralExpr(line, "None");

        if (ctx instanceof TemplateParser.PrimaryParenContext) {
            return buildExpr(((TemplateParser.PrimaryParenContext) ctx).expr());
        }

        if (ctx instanceof TemplateParser.PrimaryListContext) {
            TemplateParser.PrimaryListContext list = (TemplateParser.PrimaryListContext) ctx;
            ListExpr items = new ListExpr(line);
            if (list.exprList() != null) {
                for (TemplateParser.ExprContext e : list.exprList().expr()) items.addItem(buildExpr(e));
            }
            return items;
        }
        return null;
    }

    private List<CallArgNode> buildArgs(TemplateParser.ArgListContext ctx) {
        List<CallArgNode> out = new ArrayList<>();
        for (TemplateParser.ArgumentContext a : ctx.argument()) {
            if (a instanceof TemplateParser.ArgKeywordContext) {
                TemplateParser.ArgKeywordContext k = (TemplateParser.ArgKeywordContext) a;
                out.add(new CallArgNode(lineOf(k.getStart()), k.ID().getText(), buildExpr(k.expr())));
            } else {
                TemplateParser.ArgPositionalContext p = (TemplateParser.ArgPositionalContext) a;
                out.add(new CallArgNode(lineOf(p.getStart()), "", buildExpr(p.expr())));
            }
        }
        return out;
    }

    private String unquote(String s) {
        String t = s == null ? "" : s.trim();
        if (t.length() >= 2
                && ((t.startsWith("\"") && t.endsWith("\"")) || (t.startsWith("'") && t.endsWith("'")))) {
            return t.substring(1, t.length() - 1);
        }
        return t;
    }

    private int lineOf(Token t) {
        return t == null ? -1 : t.getLine();
    }
}
