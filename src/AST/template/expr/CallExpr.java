package AST.template.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CallExpr extends ExprNode {
    private final String functionName;
    private final List<CallArgNode> args = new ArrayList<>();

    public CallExpr(int line, String functionName) {
        super("CallExpr", line);
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
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
    protected String details() {
        return "{fn=" + functionName + "}";
    }
}
