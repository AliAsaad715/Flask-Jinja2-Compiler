package AST.python;

public class IfNode extends AstNode {
    public BlockNode elseBlock;

    public IfNode(int line, AstNode condition, BlockNode thenBlock) {
        super("If", line);
        add(condition);
        add(thenBlock);
    }

    public void addElif(IfNode elif) {
        add(elif);
    }

    public void setElse(BlockNode elseBlock) {
        this.elseBlock = elseBlock;
        add(elseBlock);
    }

    @Override
    public String describe() {
        return "if ...";
    }
}
