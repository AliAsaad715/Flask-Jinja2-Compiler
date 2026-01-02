package AST.template;

public abstract class JinjaNode extends TemplateItemNode {
    protected JinjaNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
