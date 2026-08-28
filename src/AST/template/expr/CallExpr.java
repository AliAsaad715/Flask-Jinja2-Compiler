package AST.template.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A call inside a template expression, e.g. {@code url_for('products_list')}.
 * The callee is an expression rather than a bare name so that method calls on
 * an attribute chain, such as {@code product.name.strip()}, are representable.
 */
public class CallExpr extends ExprNode {
    private final ExprNode callee;
    private final List<CallArgNode> args = new ArrayList<>();

    public CallExpr(int line, ExprNode callee) {
        super("CallExpr", line);
        this.callee = callee;
        addChild(callee);
    }

    public ExprNode getCallee() {
        return callee;
    }

    /** The plain function name when the callee is a simple identifier, else null. */
    public String getFunctionName() {
        return (callee instanceof NameExpr) ? ((NameExpr) callee).getName() : null;
    }

    public void addArg(CallArgNode arg) {
        if (arg != null) {
            args.add(arg);
            addChild(arg);
        }
    }

    public List<CallArgNode> getArgs() {
        return Collections.unmodifiableList(args);
    }

    @Override
    public String describe() {
        String fn = getFunctionName();
        return "{fn=" + (fn != null ? fn : "<expr>") + ", args=" + args.size() + "}";
    }
}
