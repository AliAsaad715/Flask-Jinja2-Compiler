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
    public String describe() {
        return "{value=" + literal + "}";
    }
}
