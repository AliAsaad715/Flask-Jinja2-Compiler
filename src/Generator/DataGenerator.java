package Generator;

import AST.python.*;
import AST.template.BoundDataNode;
import AST.template.TemplateFileNode;
import Semantic.FlaskModel;
import Semantic.RouteInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataGenerator {

    private final FlaskModel model;
    private final List<String> log = new ArrayList<>();

    public DataGenerator(FlaskModel model) {
        this.model = model;
    }

    public int generate(Map<String, TemplateFileNode> templates) {
        int transferred = 0;

        for (RouteInfo route : model.getRoutes()) {
            String templateName = route.getRenderedTemplate();
            if (templateName == null) continue;

            TemplateFileNode template = templates.get(templateName);
            if (template == null) continue;

            for (Map.Entry<String, AstNode> entry : route.getContext().entrySet()) {
                String key = entry.getKey();
                AstNode resolved = resolve(entry.getValue());
                if (resolved == null) continue;

                BoundDataNode binding = new BoundDataNode(
                        resolved.getLine(), key, route.getFunctionName(), shapeOf(resolved), resolved);
                template.bindContext(binding);
                transferred++;

                log.add(String.format("%-22s %-12s <- %s.%s  (%s)",
                        templateName, key, route.getFunctionName(), key, shapeOf(resolved)));
            }
        }
        return transferred;
    }

    private AstNode resolve(AstNode value) {
        if (value == null) return null;

        if (value instanceof IdentifierNode) {
            String name = ((IdentifierNode) value).name;
            AstNode global = model.getGlobals().get(name);
            return global != null ? global : value;
        }
        return value;
    }

    private String shapeOf(AstNode value) {
        if (value instanceof ListNode)   return "list[" + value.getChildren().size() + "]";
        if (value instanceof DictNode)   return "dict[" + value.getChildren().size() + "]";
        if (value instanceof SetNode)    return "set[" + value.getChildren().size() + "]";
        if (value instanceof StringNode) return "str";
        if (value instanceof NumberNode) return "number";
        if (value instanceof BoolNode)   return "bool";
        if (value instanceof NoneNode)   return "None";
        if (value instanceof CallNode)   return "call result";
        if (value instanceof IdentifierNode) return "runtime value";
        return value.getNodeName();
    }

    public List<String> getTransferLog() {
        return Collections.unmodifiableList(log);
    }
}
