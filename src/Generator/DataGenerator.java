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

/**
 * The bridge between the two syntax trees.
 *
 * <p>For every {@code render_template('page.html', key=value)} in the Flask
 * application this resolves each context value against the module's top-level
 * data — the products array, for instance — and attaches the resolved Python
 * node to the matching template's tree. After this pass the Jinja tree holds
 * the data it will be rendered with, rather than only the names of variables it
 * hopes someone will supply.
 */
public class DataGenerator {

    private final FlaskModel model;
    private final List<String> log = new ArrayList<>();

    public DataGenerator(FlaskModel model) {
        this.model = model;
    }

    /**
     * Carries context data from the Python tree into each template tree.
     *
     * @param templates logical template name ("products.html") to its tree
     * @return the number of values transferred
     */
    public int generate(Map<String, TemplateFileNode> templates) {
        int transferred = 0;

        for (RouteInfo route : model.getRoutes()) {
            String templateName = route.getRenderedTemplate();
            if (templateName == null) continue;

            TemplateFileNode template = templates.get(templateName);
            if (template == null) continue; // reported as SEM05

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

    /**
     * Follows an identifier back to the value it was assigned at module level, so
     * `render_template('products.html', products=products)` resolves to the actual
     * list literal. Values that are already literals are returned unchanged.
     */
    private AstNode resolve(AstNode value) {
        if (value == null) return null;

        if (value instanceof IdentifierNode) {
            String name = ((IdentifierNode) value).name;
            AstNode global = model.getGlobals().get(name);
            // A local such as `product` inside a view has no module-level binding;
            // keep the identifier so the template still records what it receives.
            return global != null ? global : value;
        }
        return value;
    }

    /** A short human-readable description of what kind of value was passed. */
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

    /** One line per transferred value, for the compiler's report. */
    public List<String> getTransferLog() {
        return Collections.unmodifiableList(log);
    }
}
