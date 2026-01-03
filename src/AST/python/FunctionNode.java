package AST.python;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode extends AstNode {
    public String name;
    public final List<String> parameters = new ArrayList<>();
    public BlockNode body;

    public FunctionNode(int line, String name) {
        super("Function", line);
        this.name = name;
    }

    @Override
    public String describe() {
        return name + "(" + parameters + ")";
    }
}
