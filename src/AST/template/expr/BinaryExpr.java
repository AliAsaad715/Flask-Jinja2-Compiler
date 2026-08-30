package AST.template.expr;

public class BinaryExpr extends ExprNode {
    private final String op;
    private final ExprNode left;
    private final ExprNode right;

    public BinaryExpr(int line, String op, ExprNode left, ExprNode right) {
        super("BinaryExpr", line);
        this.op = op;
        this.left = left;
        this.right = right;
        addChild(left);
        addChild(right);
    }

    public String getOp() {
        return op;
    }

    public ExprNode getLeft() {
        return left;
    }

    public ExprNode getRight() {
        return right;
    }

    @Override
    public String describe() {
        return "{op=" + op + "}";
    }
}
