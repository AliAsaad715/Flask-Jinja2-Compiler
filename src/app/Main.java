package app;

import AST.css.CssDeclNode;
import AST.css.CssFileNode;
import AST.css.CssRuleNode;
import AST.template.AttributeNode;
import AST.template.AttributeTextPartNode;
import AST.template.ElementNode;
import AST.template.PrintNode;
import AST.template.TemplateFileNode;
import AST.template.TextNode;
import AST.template.expr.AttrExpr;
import AST.template.expr.ExprNode;
import AST.template.expr.NameExpr;

public class Main {
    public static void main(String[] args) {
        TemplateFileNode template = new TemplateFileNode(1);

        ElementNode div = new ElementNode(1, "div");

        AttributeNode cls = new AttributeNode(1, "class");
        cls.addValuePart(new AttributeTextPartNode(1, "container"));
        div.addAttribute(cls);

        div.addBodyItem(new TextNode(2, "Hello "));

        ExprNode expr = new AttrExpr(3, new NameExpr(3, "product"), "name");
        div.addBodyItem(new PrintNode(3, expr));

        template.addItem(div);

        System.out.println("=== TEMPLATE AST ===");
        System.out.println(template.printTree());

        CssFileNode css = new CssFileNode(1);
        CssRuleNode rule = new CssRuleNode(1, ".container");
        rule.addDecl(new CssDeclNode(2, "width", "80%"));
        rule.addDecl(new CssDeclNode(3, "margin", "20px auto"));
        css.addRule(rule);

        System.out.println("=== CSS AST ===");
        System.out.println(css.printTree());
    }
}
