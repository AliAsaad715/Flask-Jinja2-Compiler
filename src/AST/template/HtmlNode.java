package AST.template;

public abstract class HtmlNode extends TemplateItemNode {
    protected HtmlNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
