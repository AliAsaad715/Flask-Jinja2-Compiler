package AST.template;

import AST.AstNode;

public abstract class TemplateNode extends AstNode {
    protected TemplateNode(String nodeName, int line) {
        super(nodeName, line);
    }

    @Override
    public String describe() {
        return details();
    }
}
