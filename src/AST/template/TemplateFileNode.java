package AST.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TemplateFileNode extends TemplateNode {
    private final List<TemplateItemNode> items = new ArrayList<>();

    private final Map<String, BoundDataNode> bindings = new LinkedHashMap<>();

    public TemplateFileNode(int line) {
        super("TemplateFile", line);
    }

    public void bindContext(BoundDataNode binding) {
        if (binding == null) return;
        bindings.put(binding.getName(), binding);
        addChild(binding);
    }

    public Map<String, BoundDataNode> getBindings() {
        return Collections.unmodifiableMap(bindings);
    }

    @Override
    public String describe() {
        return bindings.isEmpty() ? "" : "{context=" + bindings.keySet() + "}";
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
