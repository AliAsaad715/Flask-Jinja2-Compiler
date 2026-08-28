package AST.template.expr;

/** Slice access: `details[:100]`, `items[1:5]`, `items[2:]`. Either bound may be absent. */
public class SliceExpr extends ExprNode {
    private final ExprNode target;
    private final ExprNode start;
    private final ExprNode stop;

    public SliceExpr(int line, ExprNode target, ExprNode start, ExprNode stop) {
        super("SliceExpr", line);
        this.target = target;
        this.start = start;
        this.stop = stop;
        addChild(target);
        addChild(start);
        addChild(stop);
    }

    public ExprNode getTarget() {
        return target;
    }

    public ExprNode getStart() {
        return start;
    }

    public ExprNode getStop() {
        return stop;
    }

    @Override
    public String describe() {
        return "{slice}";
    }
}
