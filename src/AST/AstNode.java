package AST;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    public String nodeName;
    public int line;
    public List<AstNode> children = new ArrayList<>();

    public AstNode(String nodeName, int line) {
        this.nodeName = nodeName;
        this.line = line;
    }

    public void add(AstNode child) {
        if (child != null) children.add(child);
    }

    public String describe() { return ""; }

    public String pretty() {
        StringBuilder sb = new StringBuilder();
        prettyInto(sb, "", true);
        return sb.toString();
    }

    public void prettyInto(StringBuilder sb, String indent, boolean last) {
        sb.append(indent);
        sb.append(last ? "└── " : "├── ");
        sb.append(nodeName).append(" (line ").append(line).append(")");
        String d = describe();
        if (d != null && !d.isBlank()) sb.append(" : ").append(d);
        sb.append("\n");

        String childIndent = indent + (last ? "    " : "│   ");
        for (int i = 0; i < children.size(); i++) {
            children.get(i).prettyInto(sb, childIndent, i == children.size() - 1);
        }
    }
}
