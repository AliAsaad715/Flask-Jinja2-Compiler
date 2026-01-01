package AST;

public class SubscriptNode extends ExprNode {
    public SubscriptNode(int line, AstNode base, AstNode index) {
        super("Subscript", line);
        add(base);
        add(index);
    }

    @Override
    public String describe() {
        return "[]";
    }
}
