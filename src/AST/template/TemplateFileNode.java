package AST.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemplateFileNode extends TemplateNode {
    private final List<TemplateItemNode> items = new ArrayList<>();

    public TemplateFileNode(int line) {
        super("TemplateFile", line);
    }

    public void addItem(TemplateItemNode item) {
        if (item != null) {
            items.add(item);
            addChild(item);
        }
    }

    public List<TemplateItemNode> getItems() {
        return Collections.unmodifiableList(items);
    }
}
