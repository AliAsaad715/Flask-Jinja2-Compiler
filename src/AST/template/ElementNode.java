package AST.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementNode extends HtmlNode {
    private final String tagName;
    private final List<AttributeNode> attributes = new ArrayList<>();
    private final List<TemplateItemNode> body = new ArrayList<>();

    public ElementNode(int line, String tagName) {
        super("Element", line);
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public void addAttribute(AttributeNode attr) {
        if (attr != null) {
            attributes.add(attr);
            addChild(attr);
        }
    }

    public void addBodyItem(TemplateItemNode item) {
        if (item != null) {
            body.add(item);
            addChild(item);
        }
    }

    public List<AttributeNode> getAttributes() {
        return Collections.unmodifiableList(attributes);
    }

    public List<TemplateItemNode> getBody() {
        return Collections.unmodifiableList(body);
    }

    @Override
    protected String details() {
        return "{tag=" + tagName + "}";
    }
}
