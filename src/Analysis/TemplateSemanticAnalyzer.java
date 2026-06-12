package Analysis;

import AST.AstNode;
import AST.template.BlockNode;
import AST.template.ExtendsNode;
import AST.template.ForNode;
import AST.template.IfNode;
import AST.template.TemplateFileNode;
import AST.template.TemplateItemNode;
import AST.template.WithNode;
import AST.template.expr.AttrExpr;
import AST.template.expr.CallArgNode;
import AST.template.expr.CallExpr;
import AST.template.expr.ExprNode;
import AST.template.expr.LiteralExpr;
import AST.template.expr.NameExpr;
import AST.template.expr.RawExpr;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateSemanticAnalyzer {
    private static final Pattern IDENTIFIER = Pattern.compile("[A-Za-z_][A-Za-z0-9_]*");
    private static final Pattern ATTR_ACCESS = Pattern.compile("([A-Za-z_][A-Za-z0-9_]*)\\s*\\.\\s*([A-Za-z_][A-Za-z0-9_]*)");
    private static final Pattern URL_FOR = Pattern.compile("url_for\\s*\\(\\s*['\"]([^'\"]+)['\"]");

    private static final Set<String> KEYWORDS = new LinkedHashSet<>(List.of(
            "if", "elif", "else", "for", "in", "and", "or", "not", "is",
            "True", "False", "None"
    ));

    private static final Set<String> BUILTINS = new LinkedHashSet<>(List.of(
            "url_for", "get_flashed_messages", "range", "len", "int", "float",
            "str", "list", "dict", "loop"
    ));

    private static final Set<String> BUILTIN_ENDPOINTS = new LinkedHashSet<>(List.of("static"));

    public List<SemanticDiagnostic> analyze(
            String templateName,
            TemplateFileNode file,
            Set<String> contextVars,
            Map<String, List<TemplateContextBinding>> bindings,
            Map<String, PythonDataSource> dataSources,
            Set<String> templateNames,
            Set<String> routeFunctionNames
    ) {
        List<SemanticDiagnostic> diagnostics = new ArrayList<>();
        TemplateState state = new TemplateState(templateName, diagnostics, templateNames, routeFunctionNames);
        TemplateScope root = new TemplateScope(null);

        Map<String, PythonDataSource> contextSources = contextSources(templateName, bindings, dataSources);
        if (contextVars != null) {
            for (String contextVar : contextVars) {
                root.define(contextVar, contextSources.get(contextVar));
            }
        }
        for (Map.Entry<String, PythonDataSource> entry : contextSources.entrySet()) {
            root.define(entry.getKey(), entry.getValue());
        }

        walk(file, root, state);
        return diagnostics;
    }

    private Map<String, PythonDataSource> contextSources(
            String templateName,
            Map<String, List<TemplateContextBinding>> bindings,
            Map<String, PythonDataSource> dataSources
    ) {
        Map<String, PythonDataSource> result = new LinkedHashMap<>();
        if (bindings == null || dataSources == null) return result;

        List<TemplateContextBinding> templateBindings = bindings.get(templateName);
        if (templateBindings == null) return result;

        for (TemplateContextBinding binding : templateBindings) {
            for (Map.Entry<String, String> context : binding.getContextValues().entrySet()) {
                PythonDataSource source = dataSources.get(context.getValue());
                if (source != null) {
                    result.put(context.getKey(), source);
                }
            }
        }
        return result;
    }

    private void walk(AstNode node, TemplateScope scope, TemplateState state) {
        if (node == null) return;

        if (node instanceof ExtendsNode) {
            ExtendsNode ext = (ExtendsNode) node;
            if (state.templateNames != null
                    && !state.templateNames.isEmpty()
                    && !state.templateNames.contains(ext.getTemplateName())) {
                state.error(
                        ext.getLine(),
                        "EXTENDS_TEMPLATE_NOT_FOUND",
                        "template extends '" + ext.getTemplateName() + "', but that template was not found"
                );
            }
            return;
        }

        if (node instanceof BlockNode) {
            BlockNode block = (BlockNode) node;
            Integer previousLine = state.blockLines.putIfAbsent(block.getBlockName(), block.getLine());
            if (previousLine != null) {
                state.error(
                        block.getLine(),
                        "DUPLICATE_TEMPLATE_BLOCK",
                        "block '" + block.getBlockName() + "' is already declared at line " + previousLine
                );
            }
            for (TemplateItemNode item : block.getBody()) {
                walk(item, new TemplateScope(scope), state);
            }
            return;
        }

        if (node instanceof ForNode) {
            ForNode forNode = (ForNode) node;
            analyzeExpr(forNode.getIterable(), scope, state);
            PythonDataSource iterableSource = dataSourceForExpr(forNode.getIterable(), scope);

            TemplateScope childScope = new TemplateScope(scope);
            childScope.define(forNode.getVarName(), iterableSource);
            for (TemplateItemNode item : forNode.getBody()) {
                walk(item, childScope, state);
            }
            return;
        }

        if (node instanceof IfNode) {
            IfNode ifNode = (IfNode) node;
            analyzeExpr(ifNode.getCondition(), scope, state);
            for (TemplateItemNode item : ifNode.getThenBody()) {
                walk(item, new TemplateScope(scope), state);
            }
            for (TemplateItemNode item : ifNode.getElseBody()) {
                walk(item, new TemplateScope(scope), state);
            }
            return;
        }

        if (node instanceof WithNode) {
            WithNode withNode = (WithNode) node;
            analyzeExpr(withNode.getValueExpr(), scope, state);
            TemplateScope childScope = new TemplateScope(scope);
            if (withNode.getVarName() != null && !withNode.getVarName().isBlank()) {
                childScope.define(withNode.getVarName(), dataSourceForExpr(withNode.getValueExpr(), scope));
            }
            for (TemplateItemNode item : withNode.getBody()) {
                walk(item, childScope, state);
            }
            return;
        }

        if (node instanceof ExprNode) {
            analyzeExpr((ExprNode) node, scope, state);
            return;
        }

        for (AstNode child : node.getChildren()) {
            walk(child, scope, state);
        }
    }

    private void analyzeExpr(ExprNode expr, TemplateScope scope, TemplateState state) {
        if (expr == null) return;

        if (expr instanceof NameExpr) {
            checkName(((NameExpr) expr).getName(), expr.getLine(), scope, state);
            return;
        }

        if (expr instanceof AttrExpr) {
            AttrExpr attr = (AttrExpr) expr;
            analyzeExpr(attr.getBase(), scope, state);
            checkFieldAccess(attr.getBase(), attr.getAttrName(), attr.getLine(), scope, state);
            return;
        }

        if (expr instanceof RawExpr) {
            analyzeRaw((RawExpr) expr, scope, state);
            return;
        }

        if (expr instanceof CallExpr) {
            analyzeCall((CallExpr) expr, scope, state);
            return;
        }

        for (AstNode child : expr.getChildren()) {
            if (child instanceof ExprNode) {
                analyzeExpr((ExprNode) child, scope, state);
            } else {
                walk(child, scope, state);
            }
        }
    }

    private void analyzeCall(CallExpr call, TemplateScope scope, TemplateState state) {
        if ("url_for".equals(call.getFunctionName())) {
            String endpoint = literalFirstArg(call);
            checkEndpoint(endpoint, call.getLine(), state);
        } else if (!BUILTINS.contains(call.getFunctionName())) {
            checkName(call.getFunctionName(), call.getLine(), scope, state);
        }

        for (CallArgNode arg : call.getArgs()) {
            analyzeExpr(arg.getValue(), scope, state);
        }
    }

    private String literalFirstArg(CallExpr call) {
        if (call.getArgs().isEmpty()) return null;
        ExprNode value = call.getArgs().get(0).getValue();
        if (value instanceof LiteralExpr) {
            return ((LiteralExpr) value).getLiteral();
        }
        return null;
    }

    private void analyzeRaw(RawExpr rawExpr, TemplateScope scope, TemplateState state) {
        String raw = rawExpr.getRaw();
        String withoutStrings = removeStringLiterals(raw);

        for (String endpoint : extractUrlForEndpoints(raw)) {
            checkEndpoint(endpoint, rawExpr.getLine(), state);
        }

        for (String name : extractBaseIdentifiers(withoutStrings)) {
            checkName(name, rawExpr.getLine(), scope, state);
        }

        Set<String> checked = new LinkedHashSet<>();
        Matcher matcher = ATTR_ACCESS.matcher(withoutStrings);
        while (matcher.find()) {
            String base = matcher.group(1);
            String attr = matcher.group(2);
            String key = base + "." + attr;
            if (checked.add(key)) {
                checkFieldAccess(base, attr, rawExpr.getLine(), scope, state);
            }
        }
    }

    private List<String> extractUrlForEndpoints(String raw) {
        List<String> endpoints = new ArrayList<>();
        if (raw == null) return endpoints;
        Matcher matcher = URL_FOR.matcher(raw);
        while (matcher.find()) {
            endpoints.add(matcher.group(1));
        }
        return endpoints;
    }

    private Set<String> extractBaseIdentifiers(String raw) {
        Set<String> names = new LinkedHashSet<>();
        if (raw == null || raw.isBlank()) return names;

        Matcher matcher = IDENTIFIER.matcher(raw);
        while (matcher.find()) {
            String name = matcher.group();
            char prev = prevNonSpace(raw, matcher.start() - 1);
            char next = nextNonSpace(raw, matcher.end());

            boolean isAttribute = prev == '.';
            boolean isFilter = prev == '|';
            boolean isKeywordArg = next == '=';

            if (!isAttribute && !isFilter && !isKeywordArg) {
                names.add(name);
            }
        }
        return names;
    }

    private void checkName(String name, int line, TemplateScope scope, TemplateState state) {
        if (name == null || name.isBlank()) return;
        if (KEYWORDS.contains(name) || BUILTINS.contains(name)) return;
        if (!scope.contains(name)) {
            state.error(
                    line,
                    "UNDEFINED_TEMPLATE_NAME",
                    "template variable '" + name + "' is used but was not defined by Python context, loop, or with block"
            );
        }
    }

    private void checkEndpoint(String endpoint, int line, TemplateState state) {
        if (endpoint == null || endpoint.isBlank()) return;
        if (BUILTIN_ENDPOINTS.contains(endpoint)) return;
        if (state.routeFunctionNames == null || state.routeFunctionNames.contains(endpoint)) return;
        state.error(
                line,
                "URL_FOR_UNKNOWN_ENDPOINT",
                "url_for references endpoint '" + endpoint + "', but no Flask route function has that name"
        );
    }

    private void checkFieldAccess(
            ExprNode baseExpr,
            String attr,
            int line,
            TemplateScope scope,
            TemplateState state
    ) {
        String base = rootName(baseExpr);
        if (base != null) {
            checkFieldAccess(base, attr, line, scope, state);
        }
    }

    private void checkFieldAccess(
            String baseName,
            String attr,
            int line,
            TemplateScope scope,
            TemplateState state
    ) {
        PythonDataSource source = scope.sourceFor(baseName);
        if (source == null || attr == null || attr.isBlank()) return;
        if (!source.getFieldNames().contains(attr)) {
            state.error(
                    line,
                    "UNKNOWN_DATA_FIELD",
                    "field '" + attr + "' is not declared in Python data source '" + source.getName() + "'"
            );
        }
    }

    private PythonDataSource dataSourceForExpr(ExprNode expr, TemplateScope scope) {
        if (expr instanceof NameExpr) {
            return scope.sourceFor(((NameExpr) expr).getName());
        }
        return null;
    }

    private String rootName(ExprNode expr) {
        if (expr instanceof NameExpr) return ((NameExpr) expr).getName();
        if (expr instanceof AttrExpr) return rootName(((AttrExpr) expr).getBase());
        return null;
    }

    private String removeStringLiterals(String text) {
        if (text == null || text.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        boolean inSingle = false;
        boolean inDouble = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '\'' && !inDouble) {
                inSingle = !inSingle;
                sb.append(' ');
            } else if (ch == '"' && !inSingle) {
                inDouble = !inDouble;
                sb.append(' ');
            } else if (inSingle || inDouble) {
                sb.append(' ');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private char prevNonSpace(String s, int idx) {
        for (int i = idx; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) return c;
        }
        return '\0';
    }

    private char nextNonSpace(String s, int idx) {
        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) return c;
        }
        return '\0';
    }

    private static final class TemplateState {
        final String templateName;
        final List<SemanticDiagnostic> diagnostics;
        final Set<String> templateNames;
        final Set<String> routeFunctionNames;
        final Map<String, Integer> blockLines = new LinkedHashMap<>();

        TemplateState(
                String templateName,
                List<SemanticDiagnostic> diagnostics,
                Set<String> templateNames,
                Set<String> routeFunctionNames
        ) {
            this.templateName = templateName;
            this.diagnostics = diagnostics;
            this.templateNames = templateNames;
            this.routeFunctionNames = routeFunctionNames;
        }

        void error(int line, String code, String message) {
            diagnostics.add(SemanticDiagnostic.error(templateName, line, code, message));
        }
    }

    private static final class TemplateScope {
        private final TemplateScope parent;
        private final Set<String> names = new LinkedHashSet<>();
        private final Map<String, PythonDataSource> dataSources = new LinkedHashMap<>();

        TemplateScope(TemplateScope parent) {
            this.parent = parent;
        }

        void define(String name, PythonDataSource dataSource) {
            if (name == null || name.isBlank()) return;
            names.add(name);
            if (dataSource != null) {
                dataSources.put(name, dataSource);
            }
        }

        boolean contains(String name) {
            for (TemplateScope scope = this; scope != null; scope = scope.parent) {
                if (scope.names.contains(name)) return true;
            }
            return false;
        }

        PythonDataSource sourceFor(String name) {
            for (TemplateScope scope = this; scope != null; scope = scope.parent) {
                PythonDataSource source = scope.dataSources.get(name);
                if (source != null) return source;
            }
            return null;
        }
    }
}
