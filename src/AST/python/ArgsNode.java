package AST.python;

public class ArgsNode extends AstNode {
    public ArgsNode(int line) {
        super("Args", line);
    }

    @Override
    public String describe() {
        return "arguments";
    }
}