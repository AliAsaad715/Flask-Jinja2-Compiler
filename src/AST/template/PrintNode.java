package AST.template;

import AST.template.expr.ExprNode;

public class PrintNode extends JinjaNode {
    private final ExprNode expr;

    public PrintNode(int line, ExprNode expr) {
        super("JinjaPrint", line);
        this.expr = expr;
        addChild(expr);
    }

    public ExprNode getExpr() {
        return expr;
    }
}
