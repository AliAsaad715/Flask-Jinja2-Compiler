package AST;

public class PairNode extends ExprNode {
    public PairNode(int line, AstNode key, AstNode value) {
        super("Pair", line);
        add(key);
        add(value);
    }

    @Override
    public String describe() {
        return "key:value";
    }
}
