package AST;

import java.util.ArrayList;
import java.util.List;

public class DecoratedFunctionNode extends AstNode {
    public final List<DecoratorNode> decorators = new ArrayList<>();
    public FunctionNode function;

    public DecoratedFunctionNode(int line) { super("DecoratedFunction", line); }

    public void addDecorator(DecoratorNode d) {
        decorators.add(d);
        add(d);
    }

    public void setFunction(FunctionNode f) {
        this.function = f;
        add(f);
    }
}
