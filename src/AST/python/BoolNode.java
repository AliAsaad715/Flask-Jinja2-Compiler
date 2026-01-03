package AST.python;

public class BoolNode extends ExprNode {
    public boolean value;

    public BoolNode(int line, boolean value) {
        super("Bool", line);
        this.value = value;
    }

    @Override
    public String describe() {
        return Boolean.toString(value);
    }
}
