package AST;

public class KeywordArgNode extends ExprNode {
    public String name;

    public KeywordArgNode(int line, String name, AstNode value) {
        super("KeywordArg", line);
        this.name = name;
        add(value);
    }

    @Override
    public String describe() {
        return name + " = ...";
    }
}
