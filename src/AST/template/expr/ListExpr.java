package AST.template.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExpr extends ExprNode {
    private final List<ExprNode> items = new ArrayList<>();

    public ListExpr(int line) {
        super("ListExpr", line);
    }

    public void addItem(ExprNode item) {
        if (item != null) {
            items.add(item);
            addChild(item);
        }
    }

    public List<ExprNode> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public String describe() {
        return "{items=" + items.size() + "}";
    }
}
