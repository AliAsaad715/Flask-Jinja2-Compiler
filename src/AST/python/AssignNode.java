package AST.python;

public class AssignNode extends AstNode {
    public String target;

    public AssignNode(int line, String target, AstNode value) {
        super("Assign", line);
        this.target = target;
        add(value);
    }

    @Override
    public String describe() {
        return target + " = ...";
    }
}
