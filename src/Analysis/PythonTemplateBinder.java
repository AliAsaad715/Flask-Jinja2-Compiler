package Analysis;

import AST.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PythonTemplateBinder {
    public Map<String, List<TemplateContextBinding>> collect(AstNode root) {
        Map<String, List<TemplateContextBinding>> bindings = new LinkedHashMap<>();
        walk(root, null, null, bindings);
        return bindings;
    }

    public static Set<String> contextNames(List<TemplateContextBinding> bindings) {
        Set<String> names = new LinkedHashSet<>();
        if (bindings == null) return names;
        for (TemplateContextBinding binding : bindings) {
            names.addAll(binding.getContextValues().keySet());
        }
        return names;
    }

    public static String format(Map<String, List<TemplateContextBinding>> bindings) {
        if (bindings == null || bindings.isEmpty()) {
            return "No render_template bindings found.\n";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<TemplateContextBinding>> entry : bindings.entrySet()) {
            sb.append("- ").append(entry.getKey()).append("\n");
            for (TemplateContextBinding binding : entry.getValue()) {
                sb.append("  line ").append(binding.getLine())
                        .append(": ");
                if (binding.getRoutePath() != null && !binding.getRoutePath().isBlank()) {
                    sb.append(binding.getRoutePath()).append(" -> ");
                }
                sb.append(binding.getFunctionName() == null ? "<unknown>" : binding.getFunctionName())
                        .append(" passes ");

                if (binding.getContextValues().isEmpty()) {
                    sb.append("(no context)");
                } else {
                    sb.append(binding.getContextValues());
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void walk(
            AstNode node,
            String currentRoute,
            String currentFunction,
            Map<String, List<TemplateContextBinding>> bindings
    ) {
        if (node == null) return;

        if (node instanceof RouteNode) {
            RouteNode route = (RouteNode) node;
            String routePath = route.decorator == null ? currentRoute : route.decorator.path;
            String functionName = route.function == null ? currentFunction : route.function.name;
            if (route.function != null) {
                walk(route.function, routePath, functionName, bindings);
            }
            return;
        }

        if (node instanceof FunctionNode) {
            FunctionNode function = (FunctionNode) node;
            currentFunction = function.name;
        }

        TemplateContextBinding binding = extractRenderTemplateBinding(node, currentRoute, currentFunction);
        if (binding != null) {
            bindings.computeIfAbsent(binding.getTemplateName(), k -> new ArrayList<>()).add(binding);
        }

        for (AstNode child : node.getChildren()) {
            walk(child, currentRoute, currentFunction, bindings);
        }
    }

    private TemplateContextBinding extractRenderTemplateBinding(
            AstNode node,
            String currentRoute,
            String currentFunction
    ) {
        if (!(node instanceof CallNode)) return null;
        List<AstNode> children = node.getChildren();
        if (children.isEmpty()) return null;

        AstNode callee = children.get(0);
        if (!"render_template".equals(callableName(callee))) return null;

        String templateName = null;
        for (int i = 1; i < children.size(); i++) {
            AstNode arg = children.get(i);
            if (arg instanceof StringNode) {
                templateName = ((StringNode) arg).value;
                break;
            }
        }

        if (templateName == null || templateName.isBlank()) return null;

        TemplateContextBinding binding = new TemplateContextBinding(
                templateName,
                currentRoute,
                currentFunction,
                node.getLine()
        );

        for (int i = 1; i < children.size(); i++) {
            AstNode arg = children.get(i);
            if (arg instanceof KeywordArgNode) {
                KeywordArgNode keyword = (KeywordArgNode) arg;
                List<AstNode> keywordChildren = keyword.getChildren();
                AstNode value = keywordChildren.isEmpty() ? null : keywordChildren.get(0);
                binding.addContextValue(keyword.name, expressionText(value));
            }
        }

        return binding;
    }

    private String callableName(AstNode node) {
        if (node instanceof IdentifierNode) {
            return ((IdentifierNode) node).name;
        }
        if (node instanceof AttributeNode) {
            return ((AttributeNode) node).attr;
        }
        return "";
    }

    private String expressionText(AstNode node) {
        if (node == null) return "";
        if (node instanceof IdentifierNode) return ((IdentifierNode) node).name;
        if (node instanceof StringNode) return "'" + ((StringNode) node).value + "'";
        if (node instanceof NumberNode) return ((NumberNode) node).literal;
        if (node instanceof BoolNode) return node.describe();
        if (node instanceof NoneNode) return "None";
        if (node instanceof AttributeNode) {
            List<AstNode> children = node.getChildren();
            String base = children.isEmpty() ? "" : expressionText(children.get(0));
            if (base.isBlank()) return ((AttributeNode) node).attr;
            return base + "." + ((AttributeNode) node).attr;
        }
        if (node instanceof CallNode) {
            return callText((CallNode) node);
        }
        if (node instanceof KeywordArgNode) {
            KeywordArgNode keyword = (KeywordArgNode) node;
            List<AstNode> children = keyword.getChildren();
            String value = children.isEmpty() ? "" : expressionText(children.get(0));
            return keyword.name + "=" + value;
        }
        if (node instanceof BinaryOpNode) {
            List<AstNode> children = node.getChildren();
            if (children.size() == 2) {
                return expressionText(children.get(0)) + " " + ((BinaryOpNode) node).op + " " + expressionText(children.get(1));
            }
        }
        if (node instanceof ListNode) return listText(node.getChildren(), "[", "]");
        if (node instanceof SetNode) return listText(node.getChildren(), "{", "}");
        if (node instanceof DictNode) return listText(node.getChildren(), "{", "}");
        return node.getNodeName();
    }

    private String callText(CallNode call) {
        List<AstNode> children = call.getChildren();
        if (children.isEmpty()) return "()";
        StringBuilder sb = new StringBuilder(expressionText(children.get(0)));
        sb.append("(");
        List<String> args = new ArrayList<>();
        for (int i = 1; i < children.size(); i++) {
            args.add(expressionText(children.get(i)));
        }
        sb.append(String.join(", ", args));
        sb.append(")");
        return sb.toString();
    }

    private String listText(List<AstNode> nodes, String open, String close) {
        if (nodes == null) nodes = Collections.emptyList();
        List<String> parts = new ArrayList<>();
        for (AstNode node : nodes) {
            parts.add(expressionText(node));
        }
        return open + String.join(", ", parts) + close;
    }
}
