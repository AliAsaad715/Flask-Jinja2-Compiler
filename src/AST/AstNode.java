package AST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AstNode {
    private final String nodeName;
    private final int line;
    private final List<AstNode> children = new ArrayList<>();

    protected AstNode(String nodeName, int line) {
        this.nodeName = nodeName;
        this.line = line;
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

    protected void addChild(AstNode child) {
        if (child != null) {
            children.add(child);
        }
    }

    protected void addChildren(List<? extends AstNode> nodes) {
        if (nodes == null) return;
        for (AstNode n : nodes) addChild(n);
    }

    protected String details() {
        return "";
    }

    public final String printTree() {
        return printTree("");
    }

    public final String printTree(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent)
                .append(nodeName)
                .append(" [line=")
                .append(line)
                .append("]");

        String d = details();
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
}
