package AST;

public class BinaryOpNode extends ExprNode {
    public String op;

    public BinaryOpNode(int line, String op, AstNode left, AstNode right) {
        super("BinaryOp", line);
        this.op = op;
        add(left);
        add(right);
    }

    @Override
    public String describe() {
        return op;
    }
}
