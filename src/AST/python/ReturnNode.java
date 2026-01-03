package AST.python;

public class ReturnNode extends ExprNode {
    public ReturnNode(int line) {
        super("Return", line);
    }

    public ReturnNode(int line, AstNode value) {
        super("Return", line);
        add(value);
    }

    public void addValue(AstNode v) {
        add(v);
    }

    @Override
    public String describe() {
        return "return";
    }
}
