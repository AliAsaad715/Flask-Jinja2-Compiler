package AST.template.expr;

public class RawExpr extends ExprNode {
    private final String raw;

    public RawExpr(int line, String raw) {
        super("RawExpr", line);
        this.raw = raw == null ? "" : raw;
    }

    public String getRaw() {
        return raw;
    }

    @Override
    protected String details() {
        String t = raw.replace("\n", " ").trim();
        if (t.length() > 60) t = t.substring(0, 57) + "...";
        return "{raw=" + t + "}";
    }
}