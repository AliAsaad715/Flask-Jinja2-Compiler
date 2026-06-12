package Analysis;

import AST.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PythonDataSourceExtractor {
    public Map<String, PythonDataSource> collect(AstNode root) {
        Map<String, PythonDataSource> sources = new LinkedHashMap<>();
        walk(root, sources);
        return sources;
    }

    public static String format(Map<String, PythonDataSource> sources) {
        if (sources == null || sources.isEmpty()) {
            return "No Python data sources found.\n";
        }

        StringBuilder sb = new StringBuilder();
        for (PythonDataSource source : sources.values()) {
            sb.append("- ").append(source.getName())
                    .append(" (line ").append(source.getLine()).append(")")
                    .append(": ").append(source.getShape())
                    .append(", items=").append(source.getItemCount())
                    .append("\n");

            if (source.getFields().isEmpty()) {
                sb.append("  fields: (none)\n");
            } else {
                sb.append("  fields:\n");
                for (Map.Entry<String, java.util.Set<String>> field : source.getFields().entrySet()) {
                    sb.append("    ")
                            .append(field.getKey())
                            .append(": ")
                            .append(field.getValue())
                            .append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static String formatTemplateDataFlow(
            Map<String, List<TemplateContextBinding>> bindings,
            Map<String, PythonDataSource> sources
    ) {
        if (bindings == null || bindings.isEmpty() || sources == null || sources.isEmpty()) {
            return "No template data source links found.\n";
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (Map.Entry<String, List<TemplateContextBinding>> entry : bindings.entrySet()) {
            for (TemplateContextBinding binding : entry.getValue()) {
                for (Map.Entry<String, String> context : binding.getContextValues().entrySet()) {
                    PythonDataSource source = sources.get(context.getValue());
                    if (source == null) continue;

                    found = true;
                    sb.append("- ").append(entry.getKey())
                            .append(": context '").append(context.getKey())
                            .append("' receives data source '").append(source.getName())
                            .append("' fields ").append(source.getFieldNames())
                            .append("\n");
                }
            }
        }

        return found ? sb.toString() : "No template data source links found.\n";
    }

    private void walk(AstNode node, Map<String, PythonDataSource> sources) {
        if (node == null) return;

        if (node instanceof AssignNode) {
            PythonDataSource source = extractDataSource((AssignNode) node);
            if (source != null) {
                sources.put(source.getName(), source);
            }
        }

        for (AstNode child : node.getChildren()) {
            walk(child, sources);
        }
    }

    private PythonDataSource extractDataSource(AssignNode assign) {
        if (!isSimpleName(assign.target)) return null;
        List<AstNode> children = assign.getChildren();
        if (children.isEmpty()) return null;

        AstNode value = children.get(0);
        if (value instanceof ListNode) {
            return extractListOfDicts(assign.target, assign.getLine(), (ListNode) value);
        }
        if (value instanceof DictNode) {
            PythonDataSource source = new PythonDataSource(assign.target, assign.getLine(), "dict");
            source.setItemCount(1);
            collectDictFields(source, (DictNode) value);
            return source;
        }
        return null;
    }

    private PythonDataSource extractListOfDicts(String name, int line, ListNode list) {
        PythonDataSource source = new PythonDataSource(name, line, "list<dict>");
        int dictCount = 0;

        for (AstNode child : list.getChildren()) {
            if (child instanceof DictNode) {
                dictCount++;
                collectDictFields(source, (DictNode) child);
            }
        }

        if (dictCount == 0) return null;
        source.setItemCount(dictCount);
        return source;
    }

    private void collectDictFields(PythonDataSource source, DictNode dict) {
        for (AstNode child : dict.getChildren()) {
            if (!(child instanceof PairNode)) continue;
            List<AstNode> parts = child.getChildren();
            if (parts.size() < 2) continue;

            String key = fieldName(parts.get(0));
            if (key == null) continue;
            source.addField(key, typeName(parts.get(1)));
        }
    }

    private String fieldName(AstNode node) {
        if (node instanceof StringNode) return ((StringNode) node).value;
        if (node instanceof IdentifierNode) return ((IdentifierNode) node).name;
        return null;
    }

    private String typeName(AstNode node) {
        if (node instanceof StringNode) return "string";
        if (node instanceof NumberNode) return "number";
        if (node instanceof BoolNode) return "bool";
        if (node instanceof NoneNode) return "none";
        if (node instanceof ListNode) return "list";
        if (node instanceof DictNode) return "dict";
        if (node instanceof SetNode) return "set";
        if (node instanceof IdentifierNode) return "identifier";
        if (node instanceof CallNode) return "call";
        return node == null ? "unknown" : node.getNodeName();
    }

    private boolean isSimpleName(String target) {
        return target != null && target.matches("[A-Za-z_][A-Za-z0-9_]*");
    }
}
