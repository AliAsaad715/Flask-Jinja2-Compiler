package AST.template;

import AST.AstNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttributeNode extends AstNode {
    private final String name;
    private final List<AttributeValuePartNode> valueParts = new ArrayList<>();

    public AttributeNode(int line, String name) {
        super("Attribute", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addValuePart(AttributeValuePartNode part) {
        if (part != null) {
            valueParts.add(part);
            addChild(part);
        }
    }

    public List<AttributeValuePartNode> getValueParts() {
        return Collections.unmodifiableList(valueParts);
    }

    @Override
    protected String details() {
        return "{name=" + name + "}";
    }
}
