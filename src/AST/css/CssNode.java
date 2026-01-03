package AST.css;

import AST.python.AstNode;

public abstract class CssNode extends AstNode {
    protected CssNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
