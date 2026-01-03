package AST.python;

public class NoneNode extends ExprNode {
    public NoneNode(int line) {
        super("None", line);
    }

    @Override
    public String describe() {
        return "None";
    }
}
