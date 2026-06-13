package AST.css;

import AST.AstNode;

public abstract class CssNode extends AstNode {
    protected CssNode(String nodeName, int line) {
        super(nodeName, line);
    }

    @Override
    public String describe() {
        return details();
    }
}
