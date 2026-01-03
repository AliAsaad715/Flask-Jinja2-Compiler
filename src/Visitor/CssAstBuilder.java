package Visitor;

import AST.python.AstNode;
import AST.css.CssDeclNode;
import AST.css.CssFileNode;
import AST.css.CssRuleNode;
import antlr.CssParser;
import antlr.CssParserBaseVisitor;
import org.antlr.v4.runtime.Token;

public class CssAstBuilder extends CssParserBaseVisitor<AstNode> {

    @Override
    public AstNode visitStylesheet(CssParser.StylesheetContext ctx) {
        CssFileNode file = new CssFileNode(lineOf(ctx.getStart()));
        for (CssParser.CssRuleContext r : ctx.cssRule()) {
            AstNode node = visit(r);
            if (node instanceof CssRuleNode) {
                file.addRule((CssRuleNode) node);
            }
        }
        return file;
    }

    @Override
    public AstNode visitCssRuleDef(CssParser.CssRuleDefContext ctx) {
        String selector = buildSelectorText(ctx.selector());
        CssRuleNode rule = new CssRuleNode(lineOf(ctx.getStart()), selector);

        for (CssParser.DeclContext d : ctx.decl()) {
            AstNode node = visit(d);
            if (node instanceof CssDeclNode) {
                rule.addDecl((CssDeclNode) node);
            }
        }

        return rule;
    }

    @Override
    public AstNode visitDeclaration(CssParser.DeclarationContext ctx) {
        String prop = ctx.property.getText();
        String value = buildValueText(ctx.value());
        return new CssDeclNode(lineOf(ctx.getStart()), prop, value);
    }

    private String buildSelectorText(CssParser.SelectorContext ctx) {
        if (ctx instanceof CssParser.SelectorSeqContext) {
            CssParser.SelectorSeqContext sctx = (CssParser.SelectorSeqContext) ctx;
            StringBuilder sb = new StringBuilder();

            for (CssParser.SelectorPartContext p : sctx.selectorPart()) {
                String t = p.getText();
                if (t.equals(",")) {
                    trimTrailingSpaces(sb);
                    sb.append(", ");
                } else {
                    sb.append(t);
                }
            }

            return sb.toString().trim();
        }

        return ctx == null ? "" : ctx.getText();
    }

    private String buildValueText(CssParser.ValueContext ctx) {
        if (ctx instanceof CssParser.ValueSeqContext) {
            CssParser.ValueSeqContext vctx = (CssParser.ValueSeqContext) ctx;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < vctx.valuePart().size(); i++) {
                String cur = vctx.valuePart(i).getText();
                sb.append(cur);

                if (i + 1 < vctx.valuePart().size()) {
                    String next = vctx.valuePart(i + 1).getText();
                    if (shouldInsertSpace(cur, next)) sb.append(' ');
                }
            }

            return sb.toString().trim();
        }

        return ctx == null ? "" : ctx.getText();
    }

    private void trimTrailingSpaces(StringBuilder sb) {
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
    }

    private boolean shouldInsertSpace(String cur, String next) {
        if (cur.equals(",") || next.equals(",")) return false;
        if (cur.equals("(") || next.equals(")")) return false;
        if (cur.equals(".") || next.equals(".")) return false;
        if (cur.equals("#") || next.equals("#")) return false;

        boolean curWord = isWordish(cur);
        boolean nextWord = isWordish(next);

        if (curWord && nextWord) {
            if (isNumber(cur) && isIdent(next)) return false;
            return true;
        }
        return false;
    }

    private boolean isWordish(String s) {
        return isIdent(s) || isNumber(s) || isColor(s) || isString(s);
    }

    private boolean isIdent(String s) {
        return s.matches("[a-zA-Z_-][a-zA-Z0-9_-]*");
    }

    private boolean isNumber(String s) {
        return s.matches("[0-9]+(\\.[0-9]+)?");
    }

    private boolean isColor(String s) {
        return s.matches("#[0-9a-fA-F]{3,6}");
    }

    private boolean isString(String s) {
        return (s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"));
    }

    private int lineOf(Token t) {
        return t == null ? -1 : t.getLine();
    }

}
