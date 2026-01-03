package AST.template;

import AST.python.AstNode;

public abstract class AttributeValuePartNode extends AstNode {
    protected AttributeValuePartNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
