package AST.python;

public class DecoratorNode extends AstNode {
    public String objectName;
    public String methodName;
    public String path;

    public DecoratorNode(int line, String objectName, String methodName, String path) {
        super("Decorator", line);
        this.objectName = objectName;
        this.methodName = methodName;
        this.path = path;
    }

    @Override
    public String describe() {
        String head = objectName == null || objectName.isBlank() ? methodName : (objectName + "." + methodName);
        return "@" + head + "(" + (path == null ? "" : ("'" + path + "'")) + ")";
    }
}
