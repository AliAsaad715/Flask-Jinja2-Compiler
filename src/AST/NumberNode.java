package AST;

public class NumberNode extends ExprNode {
    public String literal;

    public NumberNode(int line, String literal) {
        super("Number", line);
        this.literal = literal;
    }

    @Override
    public String describe() {
        return literal;
    }
}
