package AST.python;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * The node's own detail line — the tag name, the operator, the literal value.
     * Subclasses override this and nothing else; both printers below read it, so
     * a node described once prints correctly in every format.
     */
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
    public String getNodeName() {
        return nodeName;
    }

    public int getLine() {
        return line;
    }

    public List<AstNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

   public void addChild(AstNode child) {
        if (child != null) {
            children.add(child);
        }
    }

    protected void addChildren(List<? extends AstNode> nodes) {
        if (nodes == null) return;
        for (AstNode n : nodes) addChild(n);
    }

    public final String printTree() {
        return printTree("");
    }

    public final String printTree(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent)
                .append(getClass().getSimpleName())
                .append(" [line=")
                .append(line)
                .append("]");

        String d = describe();
        if (d != null && !d.isEmpty()) {
            sb.append(" ").append(d);
        }
        sb.append("\n");

        String childIndent = indent + "  ";
        for (AstNode c : children) {
            sb.append(c.printTree(childIndent));
        }
        return sb.toString();
    }

    /** One node and its immediate children only, for inspecting a single node. */
    public final String printNode() {
        StringBuilder sb = new StringBuilder();
        sb.append(header()).append("\n");
        for (int i = 0; i < children.size(); i++) {
            AstNode c = children.get(i);
            sb.append(i == children.size() - 1 ? "└── " : "├── ")
              .append(c.header())
              .append("\n");
        }
        if (children.isEmpty()) sb.append("(no children)\n");
        return sb.toString();
    }

    private String header() {
        String d = describe();
        return nodeName + " (line " + line + ")" + (d == null || d.isBlank() ? "" : " : " + d);
    }
}
