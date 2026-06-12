package Analysis;

import AST.AstNode;
import AST.AttributeNode;
import AST.CallNode;
import AST.FunctionNode;
import AST.IdentifierNode;
import AST.KeywordArgNode;
import AST.RouteNode;
import AST.StringNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlaskSemanticAnalyzer {
    private static final Pattern ROUTE_PARAM =
            Pattern.compile("<(?:[A-Za-z_][A-Za-z0-9_]*:)?([A-Za-z_][A-Za-z0-9_]*)>");

    private static final Set<String> PYTHON_BUILTINS = new LinkedHashSet<>(List.of(
            "__name__", "next", "len", "float", "int", "str", "list", "dict", "set",
            "range", "print", "True", "False", "None"
    ));

    public List<SemanticDiagnostic> analyze(
            AstNode root,
            Set<String> templateNames,
            String sourceName
    ) {
        List<SemanticDiagnostic> diagnostics = new ArrayList<>();
        checkRoutes(root, diagnostics, sourceName);
        walkPython(root, diagnostics, templateNames, sourceName);
        return diagnostics;
    }

    public Set<String> routeFunctionNames(AstNode root) {
        Set<String> names = new LinkedHashSet<>();
        collectRouteFunctionNames(root, names);
        return names;
    }

    private void checkRoutes(AstNode root, List<SemanticDiagnostic> diagnostics, String sourceName) {
        Map<String, RouteNode> routesByPath = new LinkedHashMap<>();
        collectRoutes(root, routesByPath, diagnostics, sourceName);
    }

    private void collectRoutes(
            AstNode node,
            Map<String, RouteNode> routesByPath,
            List<SemanticDiagnostic> diagnostics,
            String sourceName
    ) {
        if (node == null) return;

        if (node instanceof RouteNode) {
            RouteNode route = (RouteNode) node;
            String path = route.decorator == null ? "" : route.decorator.path;
            if (path != null && !path.isBlank()) {
                RouteNode previous = routesByPath.putIfAbsent(path, route);
                if (previous != null) {
                    diagnostics.add(SemanticDiagnostic.error(
                            sourceName,
                            route.getLine(),
                            "DUPLICATE_ROUTE",
                            "route '" + path + "' is already declared at line " + previous.getLine()
                    ));
                }
            }
            checkRouteParameters(route, diagnostics, sourceName);
            return;
        }

        for (AstNode child : node.getChildren()) {
            collectRoutes(child, routesByPath, diagnostics, sourceName);
        }
    }

    private void checkRouteParameters(RouteNode route, List<SemanticDiagnostic> diagnostics, String sourceName) {
        if (route == null || route.decorator == null || route.function == null) return;

        Set<String> routeParams = routeParams(route.decorator.path);
        Set<String> functionParams = new LinkedHashSet<>(route.function.parameters);

        for (String param : routeParams) {
            if (!functionParams.contains(param)) {
                diagnostics.add(SemanticDiagnostic.error(
                        sourceName,
                        route.getLine(),
                        "ROUTE_PARAM_MISSING",
                        "route parameter '" + param + "' is not declared in function '" + route.function.name + "'"
                ));
            }
        }

        for (String param : functionParams) {
            if (!routeParams.contains(param)) {
                diagnostics.add(SemanticDiagnostic.error(
                        sourceName,
                        route.function.getLine(),
                        "FUNCTION_PARAM_NOT_IN_ROUTE",
                        "function parameter '" + param + "' is not provided by route '" + route.decorator.path + "'"
                ));
            }
        }
    }

    private Set<String> routeParams(String path) {
        Set<String> params = new LinkedHashSet<>();
        if (path == null) return params;

        Matcher matcher = ROUTE_PARAM.matcher(path);
        while (matcher.find()) {
            params.add(matcher.group(1));
        }
        return params;
    }

    private void walkPython(
            AstNode node,
            List<SemanticDiagnostic> diagnostics,
            Set<String> templateNames,
            String sourceName
    ) {
        if (node == null) return;

        if (node instanceof IdentifierNode) {
            IdentifierNode id = (IdentifierNode) node;
            if (id.symbol == null && !PYTHON_BUILTINS.contains(id.name)) {
                diagnostics.add(SemanticDiagnostic.error(
                        sourceName,
                        id.getLine(),
                        "UNDEFINED_PYTHON_NAME",
                        "identifier '" + id.name + "' is used before it is defined or imported"
                ));
            }
        }

        if (node instanceof CallNode) {
            checkRenderTemplateCall((CallNode) node, diagnostics, templateNames, sourceName);
        }

        for (AstNode child : node.getChildren()) {
            walkPython(child, diagnostics, templateNames, sourceName);
        }
    }

    private void checkRenderTemplateCall(
            CallNode call,
            List<SemanticDiagnostic> diagnostics,
            Set<String> templateNames,
            String sourceName
    ) {
        List<AstNode> children = call.getChildren();
        if (children.isEmpty() || !"render_template".equals(callableName(children.get(0)))) {
            return;
        }

        String templateName = null;
        Set<String> keywordNames = new LinkedHashSet<>();

        for (int i = 1; i < children.size(); i++) {
            AstNode arg = children.get(i);
            if (templateName == null && arg instanceof StringNode) {
                templateName = ((StringNode) arg).value;
            }
            if (arg instanceof KeywordArgNode) {
                KeywordArgNode keyword = (KeywordArgNode) arg;
                if (!keywordNames.add(keyword.name)) {
                    diagnostics.add(SemanticDiagnostic.error(
                            sourceName,
                            keyword.getLine(),
                            "DUPLICATE_TEMPLATE_CONTEXT",
                            "render_template passes context variable '" + keyword.name + "' more than once"
                    ));
                }
            }
        }

        if (templateName == null) {
            diagnostics.add(SemanticDiagnostic.error(
                    sourceName,
                    call.getLine(),
                    "TEMPLATE_NAME_NOT_LITERAL",
                    "render_template should receive a literal template file name"
            ));
            return;
        }

        if (templateNames != null && !templateNames.isEmpty() && !templateNames.contains(templateName)) {
            diagnostics.add(SemanticDiagnostic.error(
                    sourceName,
                    call.getLine(),
                    "TEMPLATE_NOT_FOUND",
                    "template '" + templateName + "' is rendered by Python but was not found in the template files"
            ));
        }
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

    private void collectRouteFunctionNames(AstNode node, Set<String> names) {
        if (node == null) return;
        if (node instanceof RouteNode) {
            RouteNode route = (RouteNode) node;
            if (route.function != null && route.function.name != null) {
                names.add(route.function.name);
            }
            return;
        }
        if (node instanceof FunctionNode) {
            return;
        }
        for (AstNode child : node.getChildren()) {
            collectRouteFunctionNames(child, names);
        }
    }
}
