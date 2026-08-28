package AST.template.expr;

public class AttrExpr extends ExprNode {
    private final ExprNode base;
    private final String attrName;

    public AttrExpr(int line, ExprNode base, String attrName) {
        super("AttrExpr", line);
        this.base = base;
        this.attrName = attrName;
        addChild(base);
    }

    public ExprNode getBase() {
        return base;
    }

    public String getAttrName() {
        return attrName;
    }

    @Override
    public String describe() {
        return "{attr=" + attrName + "}";
    }
}
