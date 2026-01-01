package AST;

public class StringNode extends ExprNode {
    public String value;

    public StringNode(int line, String value) {
        super("String", line);
        this.value = value;
    }

    @Override
    public String describe() {
        return "\"" + value + "\"";
    }
}
