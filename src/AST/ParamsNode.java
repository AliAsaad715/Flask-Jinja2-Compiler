package AST;

import java.util.ArrayList;
import java.util.List;

public class ParamsNode extends AstNode {
    public List<String> names = new ArrayList<>();

    public ParamsNode(int line) {
        super("Params", line);
    }

    @Override
    public String describe() {
        return names.toString();
    }
}
