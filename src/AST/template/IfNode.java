package AST.template;

import AST.template.expr.ExprNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IfNode extends JinjaNode {
    private final ExprNode condition;
    private final List<TemplateItemNode> thenBody = new ArrayList<>();
    private final List<TemplateItemNode> elseBody = new ArrayList<>();

    public IfNode(int line, ExprNode condition) {
        super("JinjaIf", line);
        this.condition = condition;
        addChild(condition);
    }

    public ExprNode getCondition() {
        return condition;
    }

    public void addThenItem(TemplateItemNode item) {
        if (item != null) {
            thenBody.add(item);
            addChild(item);
        }
    }

    public void addElseItem(TemplateItemNode item) {
        if (item != null) {
            elseBody.add(item);
            addChild(item);
        }
    }

    public List<TemplateItemNode> getThenBody() {
        return Collections.unmodifiableList(thenBody);
    }

    public List<TemplateItemNode> getElseBody() {
        return Collections.unmodifiableList(elseBody);
    }
}
