package AST.template;

import AST.template.expr.ExprNode;

public class AttributeExprPartNode extends AttributeValuePartNode {
    private final ExprNode expr;

    public AttributeExprPartNode(int line, ExprNode expr) {
        super("AttrExprPart", line);
        this.expr = expr;
        addChild(expr);
    }

    public ExprNode getExpr() {
        return expr;
    }
}
