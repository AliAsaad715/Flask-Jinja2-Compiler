
package AST.template.expr;

import AST.python.AstNode;

public abstract class ExprNode extends AstNode {
    protected ExprNode(String nodeName, int line) {
        super(nodeName, line);
    }
}
