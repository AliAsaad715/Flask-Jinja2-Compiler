package AST.template.expr;

import AST.python.AstNode;

public class CallArgNode extends AstNode {
    private final String name;
    private final ExprNode value;

    public CallArgNode(int line, String name, ExprNode value) {
        super("CallArg", line);
        this.name = name;
        this.value = value;
        addChild(value);
    }

    public String getName() {
        return name;
    }

    public ExprNode getValue() {
        return value;
    }

    @Override
    protected String details() {
        if (name == null || name.isEmpty()) return "";
        return "{name=" + name + "}";
    }
}
