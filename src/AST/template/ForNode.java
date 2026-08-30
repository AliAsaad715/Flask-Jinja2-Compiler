package AST.template;

import AST.template.expr.ExprNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForNode extends JinjaNode {
    private final List<String> varNames = new ArrayList<>();
    private final ExprNode iterable;
    private final List<TemplateItemNode> body = new ArrayList<>();

    public ForNode(int line, List<String> varNames, ExprNode iterable) {
        super("JinjaFor", line);
        if (varNames != null) this.varNames.addAll(varNames);
        this.iterable = iterable;
        addChild(iterable);
    }

    public ForNode(int line, String varName, ExprNode iterable) {
        this(line, List.of(varName), iterable);
    }

    public List<String> getVarNames() {
        return Collections.unmodifiableList(varNames);
    }

    public String getVarName() {
        return varNames.isEmpty() ? "" : varNames.get(0);
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
    public String describe() {
        return "{var=" + String.join(", ", varNames) + "}";
    }
}
