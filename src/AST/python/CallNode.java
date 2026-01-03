package AST.python;

import java.util.List;

public class CallNode extends ExprNode {
    public CallNode(int line, AstNode callee, List<AstNode> args) {
        super("Call", line);
        add(callee);
        if (args != null) for (AstNode a : args) add(a);
    }
}
