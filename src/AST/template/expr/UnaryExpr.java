package AST.template.expr;

public class UnaryExpr extends ExprNode {
    private final String op;
    private final ExprNode operand;

    public UnaryExpr(int line, String op, ExprNode operand) {
        super("UnaryExpr", line);
        this.op = op;
        this.operand = operand;
        addChild(operand);
    }

    public String getOp() {
        return op;
    }

    public ExprNode getOperand() {
        return operand;
    }

    @Override
    public String describe() {
        return "{op=" + op + "}";
    }
}
