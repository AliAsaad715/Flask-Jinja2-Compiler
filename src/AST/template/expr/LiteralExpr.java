package AST.template.expr;

public class LiteralExpr extends ExprNode {
    private final String literal;

    public LiteralExpr(int line, String literal) {
        super("LiteralExpr", line);
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

    @Override
    protected String details() {
        return "{value=" + literal + "}";
    }
}
