package AST.css;

public class CssDeclNode extends CssNode {
    private final String property;
    private final String value;

    public CssDeclNode(int line, String property, String value) {
        super("CssDecl", line);
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String describe() {
        return "{prop=" + property + ", value=" + value + "}";
    }
}
