package AST.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockNode extends JinjaNode {
    private final String blockName;
    private final List<TemplateItemNode> body = new ArrayList<>();

    public BlockNode(int line, String blockName) {
        super("JinjaBlock", line);
        this.blockName = blockName;
    }

    public String getBlockName() {
        return blockName;
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
        return "{name=" + blockName + "}";
    }
}
