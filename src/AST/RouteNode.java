package AST;

public class RouteNode extends AstNode {
    public DecoratorNode decorator;
    public FunctionNode function;

    public RouteNode(int line) {
        super("Route", line);
    }

    public void setDecorator(DecoratorNode decorator) {
        this.decorator = decorator;
        if (decorator != null) add(decorator);
    }

    public void setFunction(FunctionNode function) {
        this.function = function;
        if (function != null) add(function);
    }

    @Override
    public String describe() {
        if (decorator != null) return decorator.objectName + "." + decorator.methodName + "(" + decorator.path + ")";
        return "";
    }
}
