package AST;

public class ExprStmtNode extends AstNode {
    public ExprStmtNode(int line, AstNode expr) {
        super("ExprStmt", line);
        add(expr);
    }
}