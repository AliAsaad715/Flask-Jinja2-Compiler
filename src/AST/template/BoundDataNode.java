package AST.template;

import AST.python.AstNode;

/**
 * A context value carried across from the Python tree into the template tree.
 *
 * <p>The Python value node is attached as this node's child, so printing the
 * template AST shows the actual data the view passes in — the data array from
 * app.py appears inside the Jinja tree it feeds.
 */
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
