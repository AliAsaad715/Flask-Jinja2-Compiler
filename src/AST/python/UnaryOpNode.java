package AST.python;

public class UnaryOpNode extends ExprNode {
    public String op;

    public UnaryOpNode(int line, String op, AstNode operand) {
        super("UnaryOp", line);
        this.op = op;
        add(operand);
    }

    @Override
    public String describe() {
        return op;
    }
}
