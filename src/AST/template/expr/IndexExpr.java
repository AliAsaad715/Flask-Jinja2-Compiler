package AST.template.expr;

/** Subscript access: `products[0]`. */
public class IndexExpr extends ExprNode {
    private final ExprNode target;
    private final ExprNode index;

    public IndexExpr(int line, ExprNode target, ExprNode index) {
        super("IndexExpr", line);
        this.target = target;
        this.index = index;
        addChild(target);
        addChild(index);
    }

    public ExprNode getTarget() {
        return target;
    }

    public ExprNode getIndex() {
        return index;
    }

    @Override
    public String describe() {
        return "{[]}";
    }
}
