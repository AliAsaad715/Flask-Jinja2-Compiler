package AST.template;

public class AttributeTextPartNode extends AttributeValuePartNode {
    private final String text;

    public AttributeTextPartNode(int line, String text) {
        super("AttrTextPart", line);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    protected String details() {
        String t = text == null ? "" : text;
        if (t.length() > 40) t = t.substring(0, 40) + "...";
        return "{text=\"" + t + "\"}";
    }
}
