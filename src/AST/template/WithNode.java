package AST.template;

import AST.template.expr.ExprNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WithNode extends JinjaNode {
    /** Assigned variable name in: {% with var = expr %}. Null if no assignment form was used. */
    private final String varName;

    /** The header/value expression (either the whole header expression, or the RHS in assignment form). */
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

    /** @return assigned variable name, or null if the header was not an assignment. */
    public String getVarName() {
        return varName;
    }

    /** @return the header/value expression (RHS if assignment form is used). */
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
    protected String details() {
        return varName == null || varName.isEmpty() ? "" : "{var=" + varName + "}";
    }
}
