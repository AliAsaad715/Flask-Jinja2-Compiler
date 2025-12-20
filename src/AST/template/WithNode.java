package AST.template;

import AST.template.expr.ExprNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WithNode extends JinjaNode {
    private final ExprNode header;
    private final List<TemplateItemNode> body = new ArrayList<>();

    public WithNode(int line, ExprNode header) {
        super("JinjaWith", line);
        this.header = header;
        addChild(header);
    }

    public ExprNode getHeader() {
        return header;
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
}
