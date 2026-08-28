package Semantic;

import AST.python.*;
import AST.template.BlockNode;
import AST.template.ExtendsNode;
import AST.template.TemplateFileNode;
import AST.template.expr.FilterExpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Checks meaning rather than shape, across both halves of the project.
 *
 * <p>Twelve checks run: six over the Python application, six over the templates
 * and the links between the two. Every diagnostic is collected, so one run
 * reports the whole picture instead of stopping at the first problem.
 */
public class SemanticAnalyzer {

    private final List<SemanticError> errors = new ArrayList<>();

    private final FlaskModel model;
    private final String pythonSource;

    /** Logical template name ("products.html") to its parsed tree. */
    private final Map<String, TemplateFileNode> templates = new LinkedHashMap<>();

    /** Logical template name to the context variables it uses, and where. */
    private final Map<String, Map<String, Integer>> templateContext = new LinkedHashMap<>();

    /** Logical template name to the source file it came from, for error messages. */
    private final Map<String, String> templateSources = new HashMap<>();

    private static final Set<String> PYTHON_BUILTINS = new HashSet<>(Arrays.asList(
            "print", "len", "range", "int", "float", "str", "bool", "list", "dict", "set",
            "tuple", "next", "enumerate", "sorted", "reversed", "sum", "min", "max", "abs",
            "any", "all", "zip", "map", "filter", "open", "type", "isinstance", "getattr",
            "setattr", "hasattr", "round", "format", "repr", "id", "iter", "super", "object",
            "Exception", "ValueError", "KeyError", "TypeError", "True", "False", "None",
            "__name__", "__file__", "__doc__", "self"
    ));

    private static final Set<String> JINJA_FILTERS = new HashSet<>(Arrays.asList(
            "abs", "attr", "batch", "capitalize", "center", "default", "d", "dictsort",
            "escape", "e", "filesizeformat", "first", "float", "forceescape", "format",
            "groupby", "indent", "int", "join", "last", "length", "count", "list", "lower",
            "map", "max", "min", "pprint", "random", "reject", "rejectattr", "replace",
            "reverse", "round", "safe", "select", "selectattr", "slice", "sort", "string",
            "striptags", "sum", "title", "tojson", "trim", "truncate", "unique", "upper",
            "urlencode", "urlize", "wordcount", "wordwrap", "xmlattr"
    ));

    public SemanticAnalyzer(FlaskModel model, String pythonSource) {
        this.model = model;
        this.pythonSource = pythonSource;
    }

    public void addTemplate(String logicalName, String sourcePath,
                            TemplateFileNode ast, Map<String, Integer> contextVars) {
        templates.put(logicalName, ast);
        templateSources.put(logicalName, sourcePath);
        templateContext.put(logicalName, contextVars == null ? Map.of() : contextVars);
    }

    public List<SemanticError> analyze(ProgramNode program) {
        errors.clear();

        checkUndefinedNames(program);
        checkDuplicateFunctions();
        checkDuplicateRoutes();
        checkRouteParameters();
        checkRenderedTemplatesExist();
        checkCallArgumentCounts();

        checkTemplateContextProvided();
        checkExtendsTargets();
        checkBlocksDeclaredInParent();
        checkKnownFilters();
        checkUnusedContext();
        checkOrphanTemplates();

        errors.sort((a, b) -> {
            int bySource = a.getSource().compareTo(b.getSource());
            return bySource != 0 ? bySource : Integer.compare(a.getLine(), b.getLine());
        });
        return Collections.unmodifiableList(errors);
    }

    // =====================================================================
    // Python side
    // =====================================================================

    /** SEM01 — a name is read that was never imported, assigned, or declared. */
    private void checkUndefinedNames(AstNode node) {
        if (node == null) return;

        if (node instanceof IdentifierNode) {
            IdentifierNode id = (IdentifierNode) node;
            if (id.symbol == null && !PYTHON_BUILTINS.contains(id.name)) {
                errors.add(SemanticError.error("SEM01", pythonSource, id.line,
                        "Undefined name '" + id.name + "' — it is never imported, assigned, or declared."));
            }
        }
        for (AstNode c : node.getChildren()) checkUndefinedNames(c);
    }

    /** SEM02 — two functions in the same module share a name. */
    private void checkDuplicateFunctions() {
        Map<String, Integer> seen = new HashMap<>();
        for (FunctionNode fn : model.getFunctions()) {
            Integer first = seen.get(fn.name);
            if (first != null) {
                errors.add(SemanticError.error("SEM02", pythonSource, fn.line,
                        "Duplicate definition of function '" + fn.name
                                + "' — already defined at line " + first + "."));
            } else {
                seen.put(fn.name, fn.line);
            }
        }
    }

    /** SEM03 — two routes claim the same URL, so one can never be reached. */
    private void checkDuplicateRoutes() {
        Map<String, RouteInfo> seen = new HashMap<>();
        for (RouteInfo r : model.getRoutes()) {
            if (r.getUrlPath() == null) continue;
            RouteInfo first = seen.get(r.getUrlPath());
            if (first != null) {
                errors.add(SemanticError.error("SEM03", pythonSource, r.getLine(),
                        "Duplicate route '" + r.getUrlPath() + "' on '" + r.getFunctionName()
                                + "' — already handled by '" + first.getFunctionName()
                                + "' at line " + first.getLine() + "."));
            } else {
                seen.put(r.getUrlPath(), r);
            }
        }
    }

    /** SEM04 — the URL declares parameters the view function does not accept. */
    private void checkRouteParameters() {
        for (RouteInfo r : model.getRoutes()) {
            List<String> urlParams = r.getUrlParams();
            List<String> fnParams = r.getFunctionParams();

            for (String p : urlParams) {
                if (!fnParams.contains(p)) {
                    errors.add(SemanticError.error("SEM04", pythonSource, r.getLine(),
                            "Route '" + r.getUrlPath() + "' declares URL parameter '" + p
                                    + "' but view function '" + r.getFunctionName()
                                    + "' does not accept it."));
                }
            }
            for (String p : fnParams) {
                if (!urlParams.contains(p)) {
                    errors.add(SemanticError.error("SEM04", pythonSource, r.getLine(),
                            "View function '" + r.getFunctionName() + "' expects parameter '" + p
                                    + "' but route '" + r.getUrlPath() + "' never supplies it."));
                }
            }
        }
    }

    /** SEM05 — render_template names a template that is not in the project. */
    private void checkRenderedTemplatesExist() {
        for (RouteInfo r : model.getRoutes()) {
            String t = r.getRenderedTemplate();
            if (t != null && !templates.containsKey(t)) {
                errors.add(SemanticError.error("SEM05", pythonSource, r.getRenderLine(),
                        "render_template('" + t + "') refers to a template that does not exist. "
                                + "Known templates: " + templates.keySet() + "."));
            }
        }
    }

    /** SEM06 — a locally defined function is called with the wrong argument count. */
    private void checkCallArgumentCounts() {
        Map<String, FunctionNode> byName = new HashMap<>();
        for (FunctionNode fn : model.getFunctions()) byName.putIfAbsent(fn.name, fn);

        for (FlaskModel.CallSite call : model.getCallSites()) {
            FunctionNode fn = byName.get(call.functionName);
            if (fn == null) continue;
            int expected = fn.parameters.size();
            if (call.argCount != expected) {
                errors.add(SemanticError.error("SEM06", pythonSource, call.line,
                        "Function '" + fn.name + "' takes " + expected + " argument"
                                + (expected == 1 ? "" : "s") + " but is called with "
                                + call.argCount + "."));
            }
        }
    }

    // =====================================================================
    // Template side, and the link between the two halves
    // =====================================================================

    /**
     * SEM07 — a template reads a variable that its route never passes.
     * Variables provided by an ancestor template through {% extends %} count as
     * supplied, since the child renders inside the parent's context.
     */
    private void checkTemplateContextProvided() {
        for (Map.Entry<String, Map<String, Integer>> entry : templateContext.entrySet()) {
            String templateName = entry.getKey();
            RouteInfo route = model.routeRendering(templateName);
            if (route == null) continue;

            Set<String> supplied = new HashSet<>(route.getContext().keySet());
            String source = templateSources.getOrDefault(templateName, templateName);

            for (Map.Entry<String, Integer> use : entry.getValue().entrySet()) {
                if (!supplied.contains(use.getKey())) {
                    errors.add(SemanticError.error("SEM07", source, use.getValue(),
                            "Template '" + templateName + "' uses '" + use.getKey()
                                    + "' but route '" + route.getFunctionName()
                                    + "' does not pass it to render_template."));
                }
            }
        }
    }

    /** SEM08 — {% extends %} points at a template that does not exist. */
    private void checkExtendsTargets() {
        for (Map.Entry<String, TemplateFileNode> e : templates.entrySet()) {
            String source = templateSources.getOrDefault(e.getKey(), e.getKey());
            for (ExtendsNode ext : findAll(e.getValue(), ExtendsNode.class)) {
                if (!templates.containsKey(ext.getTemplateName())) {
                    errors.add(SemanticError.error("SEM08", source, ext.getLine(),
                            "{% extends \"" + ext.getTemplateName()
                                    + "\" %} refers to a template that does not exist."));
                }
            }
        }
    }

    /** SEM09 — a child overrides a block the parent template never declares. */
    private void checkBlocksDeclaredInParent() {
        for (Map.Entry<String, TemplateFileNode> e : templates.entrySet()) {
            List<ExtendsNode> extendsNodes = findAll(e.getValue(), ExtendsNode.class);
            if (extendsNodes.isEmpty()) continue;

            String parentName = extendsNodes.get(0).getTemplateName();
            TemplateFileNode parent = templates.get(parentName);
            if (parent == null) continue; // already reported by SEM08

            Set<String> parentBlocks = new LinkedHashSet<>();
            for (BlockNode b : findAll(parent, BlockNode.class)) parentBlocks.add(b.getBlockName());

            String source = templateSources.getOrDefault(e.getKey(), e.getKey());
            for (BlockNode b : findAll(e.getValue(), BlockNode.class)) {
                if (!parentBlocks.contains(b.getBlockName())) {
                    errors.add(SemanticError.error("SEM09", source, b.getLine(),
                            "Block '" + b.getBlockName() + "' is not declared in parent template '"
                                    + parentName + "', so its content is never rendered. "
                                    + "Parent declares: " + parentBlocks + "."));
                }
            }
        }
    }

    /** SEM10 — a filter is applied that Jinja2 does not define. */
    private void checkKnownFilters() {
        for (Map.Entry<String, TemplateFileNode> e : templates.entrySet()) {
            String source = templateSources.getOrDefault(e.getKey(), e.getKey());
            for (FilterExpr f : findAll(e.getValue(), FilterExpr.class)) {
                if (!JINJA_FILTERS.contains(f.getFilterName())) {
                    errors.add(SemanticError.error("SEM10", source, f.getLine(),
                            "Unknown filter '" + f.getFilterName() + "'."));
                }
            }
        }
    }

    /** SEM11 (warning) — a route passes context the template never reads. */
    private void checkUnusedContext() {
        for (RouteInfo r : model.getRoutes()) {
            String t = r.getRenderedTemplate();
            if (t == null || !templateContext.containsKey(t)) continue;

            Set<String> used = templateContext.get(t).keySet();
            for (String key : r.getContext().keySet()) {
                if (!used.contains(key)) {
                    errors.add(SemanticError.warning("SEM11", pythonSource, r.getRenderLine(),
                            "Route '" + r.getFunctionName() + "' passes '" + key
                                    + "' to '" + t + "', which never uses it."));
                }
            }
        }
    }

    /** SEM12 (warning) — a template no route renders and no template extends. */
    private void checkOrphanTemplates() {
        Set<String> extended = new HashSet<>();
        for (TemplateFileNode t : templates.values()) {
            for (ExtendsNode ext : findAll(t, ExtendsNode.class)) extended.add(ext.getTemplateName());
        }

        for (String name : templates.keySet()) {
            if (model.routeRendering(name) == null && !extended.contains(name)) {
                errors.add(SemanticError.warning("SEM12",
                        templateSources.getOrDefault(name, name), 1,
                        "Template '" + name + "' is never rendered by a route and never extended."));
            }
        }
    }

    // ---------------------------------------------------------------- helpers

    /** Every node of the given type in the subtree, in document order. */
    private <T extends AstNode> List<T> findAll(AstNode root, Class<T> type) {
        List<T> out = new ArrayList<>();
        collect(root, type, out);
        return out;
    }

    private <T extends AstNode> void collect(AstNode node, Class<T> type, List<T> out) {
        if (node == null) return;
        if (type.isInstance(node)) out.add(type.cast(node));
        for (AstNode c : node.getChildren()) collect(c, type, out);
    }
}
