package AST.template;

import AST.template.expr.ExprNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WithNode extends JinjaNode {
    private final String varName;
    private final ExprNode valueExpr;
    private final List<TemplateItemNode> body = new ArrayList<>();

    public WithNode(int line, String varName, ExprNode valueExpr) {
        super("JinjaWith", line);
        this.varName = varName;
        this.valueExpr = valueExpr;
        if (valueExpr != null) {
            addChild(valueExpr);
        }
    }

    public String getVarName() {
        return varName;
    }
    public ExprNode getValueExpr() {
        return valueExpr;
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
    public String describe() {
        return varName == null || varName.isEmpty() ? "" : "{var=" + varName + "}";
    }
}
