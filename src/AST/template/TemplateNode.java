package AST.template;

import AST.python.AstNode;

public abstract class TemplateNode extends AstNode {
    protected TemplateNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
