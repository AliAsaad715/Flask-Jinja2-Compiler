package AST;

public class AttributeNode extends ExprNode {
    public String attr;

    public AttributeNode(int line, AstNode base, String attr) {
        super("Attribute", line);
        this.attr = attr;
        add(base);
    }

    @Override
    public String describe() {
        return "." + attr;
    }
}
