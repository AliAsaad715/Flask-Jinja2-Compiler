package AST.template.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterExpr extends ExprNode {
    private final String filterName;
    private final ExprNode input;
    private final List<CallArgNode> args = new ArrayList<>();

    public FilterExpr(int line, ExprNode input, String filterName) {
        super("FilterExpr", line);
        this.input = input;
        this.filterName = filterName;
        addChild(input);
    }

    public String getFilterName() {
        return filterName;
    }

    public ExprNode getInput() {
        return input;
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
        return "{filter=" + filterName + "}";
    }
}
