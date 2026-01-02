package AST.template;

import AST.template.expr.ExprNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForNode extends JinjaNode {
    private final String varName;
    private final ExprNode iterable;
    private final List<TemplateItemNode> body = new ArrayList<>();

    public ForNode(int line, String varName, ExprNode iterable) {
        super("JinjaFor", line);
        this.varName = varName;
        this.iterable = iterable;
        addChild(iterable);
    }

    public String getVarName() {
        return varName;
    }

    public ExprNode getIterable() {
        return iterable;
    }

    public void addBodyItem(TemplateItemNode item) {
        if (item != null) {
            body.add(item);
            addChild(item);
        }
    }

    public List<TemplateItemNode> getBody() {
        return Collections.unmodifiableList(body);
    }

    @Override
    protected String details() {
        return "{var=" + varName + "}";
    }
}
