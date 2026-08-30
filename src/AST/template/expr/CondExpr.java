package AST.template.expr;

public class CondExpr extends ExprNode {
    private final ExprNode thenExpr;
    private final ExprNode condition;
    private final ExprNode elseExpr;

    public CondExpr(int line, ExprNode thenExpr, ExprNode condition, ExprNode elseExpr) {
        super("CondExpr", line);
        this.thenExpr = thenExpr;
        this.condition = condition;
        this.elseExpr = elseExpr;
        addChild(thenExpr);
        addChild(condition);
        addChild(elseExpr);
    }

    public ExprNode getThenExpr() {
        return thenExpr;
    }

    public ExprNode getCondition() {
        return condition;
    }

    public ExprNode getElseExpr() {
        return elseExpr;
    }

    @Override
    public String describe() {
        return "{ternary}";
    }
}
