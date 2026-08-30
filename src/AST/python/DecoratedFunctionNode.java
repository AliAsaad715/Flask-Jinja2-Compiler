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
