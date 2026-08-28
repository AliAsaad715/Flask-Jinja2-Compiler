package AST.python;

import java.util.ArrayList;
import java.util.List;

public class DecoratedFunctionNode extends AstNode {
    public final List<DecoratorNode> decorators = new ArrayList<>();
    public FunctionNode function;

    public DecoratedFunctionNode(int line) { super("DecoratedFunction", line); }

    public void addDecorator(DecoratorNode d) {
        addDecorator(d, d);
    }

    /**
     * Registers {@code d} as one of this function's decorators while putting
     * {@code child} in the tree instead - used when a decorator is wrapped in a
     * more specific node (e.g. a RouteNode for @app.route(...)).
     */
    public void addDecorator(DecoratorNode d, AstNode child) {
        if (d == null) return;
        decorators.add(d);
        add(child == null ? d : child);
    }

    public void setFunction(FunctionNode f) {
        this.function = f;
        add(f);
    }
}
