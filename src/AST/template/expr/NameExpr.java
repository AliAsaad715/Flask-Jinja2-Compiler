package AST.template.expr;

public class NameExpr extends ExprNode {
    private final String name;

    public NameExpr(int line, String name) {
        super("NameExpr", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String describe() {
        return "{name=" + name + "}";
    }
}
