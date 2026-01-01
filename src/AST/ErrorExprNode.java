package AST;

public class ErrorExprNode extends ExprNode {
    public String message;

    public ErrorExprNode(int line, String message) {
        super("ErrorExpr", line);
        this.message = message;
    }

    @Override
    public String describe() {
        return message;
    }
}
