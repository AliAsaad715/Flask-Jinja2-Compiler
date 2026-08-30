package AST.template;

import AST.python.AstNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttributeNode extends AstNode {
    private final String name;
    private final boolean hasValue;
    private final List<AttributeValuePartNode> valueParts = new ArrayList<>();

    public AttributeNode(int line, String name, boolean hasValue) {
        super("Attribute", line);
        this.name = name;
        this.hasValue = hasValue;
    }

    public AttributeNode(int line, String name) {
        this(line, name, true);
    }

    public String getName() {
        return name;
    }

    public boolean hasValue() {
        return hasValue;
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
    public String describe() {
        return "{name=" + name + "}";
    }
}
