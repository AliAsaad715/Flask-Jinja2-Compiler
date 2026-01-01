package AST;

import java.util.List;

public class ImportNode extends AstNode {
    public String kind;
    public String packageName;
    public List<String> names;
    public String raw;

    public ImportNode(int line, String kind, String packageName, List<String> names, String raw) {
        super("Import", line);
        this.kind = kind;
        this.packageName = packageName;
        this.names = names;
        this.raw = raw;
    }

    @Override
    public String describe() {
        if ("from".equals(kind)) return "from " + packageName + " import " + names;
        return "import " + names;
    }
}