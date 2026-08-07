package Analysis;

import AST.AssignNode;
import AST.AstNode;
import AST.BoolNode;
import AST.DictNode;
import AST.IdentifierNode;
import AST.ListNode;
import AST.NoneNode;
import AST.NumberNode;
import AST.PairNode;
import AST.SetNode;
import AST.StringNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Extracts literal Python values from the Python AST for code generation. */
public class PythonValueExtractor {
    public Map<String, Object> collect(AstNode root) {
        Map<String, Object> values = new LinkedHashMap<>();
        walk(root, values);
        return values;
    }

    private void walk(AstNode node, Map<String, Object> values) {
        if (node == null) return;

        if (node instanceof AssignNode assign && isSimpleName(assign.target)) {
            List<AstNode> children = assign.getChildren();
            if (!children.isEmpty() && isLiteralValue(children.get(0))) {
                values.put(assign.target, convert(children.get(0)));
            }
        }

        for (AstNode child : node.getChildren()) {
            walk(child, values);
        }
    }

    private Object convert(AstNode node) {
        if (node instanceof StringNode stringNode) return stringNode.value;
        if (node instanceof NumberNode numberNode) {
            try {
                return new BigDecimal(numberNode.literal);
            } catch (NumberFormatException ignored) {
                return numberNode.literal;
            }
        }
        if (node instanceof BoolNode boolNode) return boolNode.value;
        if (node instanceof NoneNode) return null;
        if (node instanceof IdentifierNode identifierNode) return identifierNode.name;

        if (node instanceof ListNode || node instanceof SetNode) {
            List<Object> values = new ArrayList<>();
            for (AstNode child : node.getChildren()) {
                values.add(convert(child));
            }
            return values;
        }

        if (node instanceof DictNode) {
            Map<String, Object> values = new LinkedHashMap<>();
            for (AstNode child : node.getChildren()) {
                if (!(child instanceof PairNode)) continue;
                List<AstNode> pair = child.getChildren();
                if (pair.size() < 2) continue;
                Object key = convert(pair.get(0));
                values.put(String.valueOf(key), convert(pair.get(1)));
            }
            return values;
        }

        return node.describe();
    }

    private boolean isLiteralValue(AstNode node) {
        return node instanceof StringNode
                || node instanceof NumberNode
                || node instanceof BoolNode
                || node instanceof NoneNode
                || node instanceof ListNode
                || node instanceof DictNode
                || node instanceof SetNode;
    }

    private boolean isSimpleName(String name) {
        return name != null && name.matches("[A-Za-z_][A-Za-z0-9_]*");
    }
}
