package Semantic;

import AST.python.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Flattens the Python AST into the facts that later stages need: the module's
 * top-level data, every view function, and every route with the template it
 * renders and the context it passes.
 *
 * <p>Building this once means the semantic analyser and the data generator work
 * from the same view of the application instead of each re-walking the tree.
 */
public class FlaskModel {

    /** Top-level `name = value` assignments — this is where the data array lives. */
    private final Map<String, AstNode> globals = new LinkedHashMap<>();
    private final Map<String, Integer> globalLines = new LinkedHashMap<>();

    private final List<RouteInfo> routes = new ArrayList<>();
    private final List<FunctionNode> functions = new ArrayList<>();

    /** Call sites of locally defined functions, for the argument-count check. */
    private final List<CallSite> callSites = new ArrayList<>();

    public static class CallSite {
        public final String functionName;
        public final int argCount;
        public final int line;

        CallSite(String functionName, int argCount, int line) {
            this.functionName = functionName;
            this.argCount = argCount;
            this.line = line;
        }
    }

    public static FlaskModel from(ProgramNode program) {
        FlaskModel model = new FlaskModel();
        if (program == null) return model;

        for (AstNode child : program.getChildren()) {
            if (child instanceof AssignNode) {
                AssignNode a = (AssignNode) child;
                // Only simple targets — `app.config['X'] = ...` is not a data binding.
                if (a.target != null && a.target.matches("[A-Za-z_][A-Za-z0-9_]*")) {
                    model.globals.put(a.target, firstChild(a));
                    model.globalLines.put(a.target, a.line);
                }
            }
        }

        Set<DecoratorNode> claimed = Collections.newSetFromMap(new IdentityHashMap<>());
        model.collectRoutes(program, claimed);
        model.collectFunctionsAndCalls(program);
        return model;
    }

    // ------------------------------------------------------------------ routes

    private void collectRoutes(AstNode node, Set<DecoratorNode> claimed) {
        if (node == null) return;

        if (node instanceof DecoratedFunctionNode) {
            DecoratedFunctionNode d = (DecoratedFunctionNode) node;
            for (DecoratorNode dec : d.decorators) {
                claimed.add(dec);
                if (isRouteDecorator(dec)) addRoute(dec, d.function);
            }
            if (d.function != null) collectRoutes(d.function, claimed);
            return;
        }

        if (node instanceof RouteNode) {
            RouteNode r = (RouteNode) node;
            if (r.decorator != null && !claimed.contains(r.decorator)) {
                claimed.add(r.decorator);
                if (isRouteDecorator(r.decorator)) addRoute(r.decorator, r.function);
            }
            if (r.function != null) collectRoutes(r.function, claimed);
            return;
        }

        for (AstNode c : node.getChildren()) collectRoutes(c, claimed);
    }

    private boolean isRouteDecorator(DecoratorNode dec) {
        return dec != null && "route".equals(dec.methodName);
    }

    private void addRoute(DecoratorNode dec, FunctionNode fn) {
        if (fn == null) return;
        RouteInfo info = new RouteInfo(dec.path, fn.name, fn.parameters, dec.line);
        findRenderTemplate(fn.body, info);
        routes.add(info);
    }

    /** Locates the render_template(...) call inside a view function's body. */
    private void findRenderTemplate(AstNode node, RouteInfo info) {
        if (node == null || info.getRenderedTemplate() != null) return;

        if (node instanceof CallNode && "render_template".equals(calleeName(node))) {
            List<AstNode> children = node.getChildren();
            for (int i = 1; i < children.size(); i++) {
                AstNode arg = children.get(i);
                if (i == 1 && arg instanceof StringNode) {
                    info.setRendered(((StringNode) arg).value, node.getLine());
                } else if (arg instanceof KeywordArgNode) {
                    KeywordArgNode k = (KeywordArgNode) arg;
                    info.putContext(k.name, firstChild(k));
                }
            }
            if (info.getRenderedTemplate() != null) return;
        }

        for (AstNode c : node.getChildren()) findRenderTemplate(c, info);
    }

    // -------------------------------------------------------- functions, calls

    private void collectFunctionsAndCalls(AstNode node) {
        if (node == null) return;

        if (node instanceof FunctionNode) functions.add((FunctionNode) node);

        if (node instanceof CallNode) {
            String name = calleeName(node);
            if (name != null) {
                callSites.add(new CallSite(name, countArgs(node), node.getLine()));
            }
        }

        for (AstNode c : node.getChildren()) collectFunctionsAndCalls(c);
    }

    private int countArgs(AstNode call) {
        return Math.max(0, call.getChildren().size() - 1);
    }

    /** The simple name being called, or null when the callee is not a bare identifier. */
    public static String calleeName(AstNode call) {
        List<AstNode> children = call.getChildren();
        if (children.isEmpty()) return null;
        AstNode callee = children.get(0);
        return (callee instanceof IdentifierNode) ? ((IdentifierNode) callee).name : null;
    }

    private static AstNode firstChild(AstNode n) {
        return n.getChildren().isEmpty() ? null : n.getChildren().get(0);
    }

    // ----------------------------------------------------------------- getters

    public Map<String, AstNode> getGlobals() { return Collections.unmodifiableMap(globals); }
    public int globalLine(String name) { return globalLines.getOrDefault(name, -1); }
    public List<RouteInfo> getRoutes() { return Collections.unmodifiableList(routes); }
    public List<FunctionNode> getFunctions() { return Collections.unmodifiableList(functions); }
    public List<CallSite> getCallSites() { return Collections.unmodifiableList(callSites); }

    /** The route that renders the given template file, or null if none does. */
    public RouteInfo routeRendering(String templateName) {
        for (RouteInfo r : routes) {
            if (templateName.equals(r.getRenderedTemplate())) return r;
        }
        return null;
    }
}
