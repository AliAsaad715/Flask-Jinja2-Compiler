package AST.template;

import AST.python.AstNode;

public class BoundDataNode extends TemplateNode {

    private final String name;
    private final String fromRoute;
    private final String shape;
    private final AstNode value;

    public BoundDataNode(int line, String name, String fromRoute, String shape, AstNode value) {
        super("BoundData", line);
        this.name = name;
        this.fromRoute = fromRoute;
        this.shape = shape;
        this.value = value;
        addChild(value);
    }

    public String getName() { return name; }
    public String getFromRoute() { return fromRoute; }
    public String getShape() { return shape; }
    public AstNode getValue() { return value; }

    @Override
    public String describe() {
        return "{name=" + name + ", from=" + fromRoute + "(), type=" + shape + "}";
    }
}
