package Visitor;

import AST.python.AstNode;
import AST.template.*;
import AST.template.expr.CallExpr;
import AST.template.expr.FilterExpr;
import AST.template.expr.NameExpr;
import Symbol.SymbolKind;
import Symbol.SymbolTable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Walks a template AST and builds its symbol table.
 *
 * <p>Anything a template uses but never binds itself is a <em>context variable</em>:
 * a value the Flask view must pass in via {@code render_template}. Those are what
 * the semantic analyser checks against the Python side, and what the data
 * generator fills in.
 */
public class TemplateSymbolCollector {

    private final SymbolTable table = new SymbolTable();

    /** Context variable name to the line where it was first used. */
    private final Map<String, Integer> contextVars = new LinkedHashMap<>();

    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
            "if", "elif", "else", "for", "in", "and", "or", "not",
            "is", "True", "False", "None", "true", "false", "none"
    ));

    /** Names Jinja and Flask provide, so they are never reported as missing. */
    private static final Set<String> BUILTINS = new HashSet<>(Arrays.asList(
            "url_for", "get_flashed_messages", "config", "request", "session", "g",
            "loop", "range", "len", "int", "float", "str", "list", "dict", "super"
    ));

    public SymbolTable collect(TemplateFileNode file) {
        table.enterScope("Global", file.getLine());
        walk(file);
        // Defined last, but each keeps the line where it was actually used
        // rather than the line of the file node.
        for (Map.Entry<String, Integer> e : contextVars.entrySet()) {
            if (table.resolve(e.getKey()) == null) {
                table.define(e.getKey(), e.getValue(), SymbolKind.CONTEXT);
            }
        }
        table.exitScope();
        return table;
    }

    /** Context variables the template expects, mapped to their first-use line. */
    public Map<String, Integer> getContextVariables() {
        return Collections.unmodifiableMap(contextVars);
    }

    private void walk(AstNode node) {
        if (node == null) return;

        if (node instanceof BlockNode) {
            BlockNode b = (BlockNode) node;
            table.enterScope("Block(" + b.getBlockName() + ")", b.getLine());
            walkChildren(node);
            table.exitScope();
            return;
        }

        if (node instanceof ForNode) {
            ForNode f = (ForNode) node;
            table.enterScope("For(" + String.join(", ", f.getVarNames()) + ")", f.getLine());
            for (String v : f.getVarNames()) {
                table.define(v, f.getLine(), SymbolKind.LOOP_VAR);
            }
            // The iterable is evaluated in the enclosing scope conceptually, but
            // resolving it here is harmless: a loop variable never shadows it.
            walk(f.getIterable());
            for (TemplateItemNode item : f.getBody()) walk(item);
            table.exitScope();
            return;
        }

        if (node instanceof IfNode) {
            IfNode i = (IfNode) node;
            table.enterScope("If", i.getLine());
            walk(i.getCondition());
            for (TemplateItemNode t : i.getThenBody()) walk(t);
            for (TemplateItemNode e : i.getElseBody()) walk(e);
            table.exitScope();
            return;
        }

        if (node instanceof WithNode) {
            WithNode w = (WithNode) node;
            String scopeName = w.getVarName() != null ? "With(" + w.getVarName() + ")" : "With";
            table.enterScope(scopeName, w.getLine());
            if (w.getVarName() != null && isValidIdentifier(w.getVarName())) {
                table.define(w.getVarName(), w.getLine(), SymbolKind.WITH_VAR);
            }
            walk(w.getValueExpr());
            for (TemplateItemNode it : w.getBody()) walk(it);
            table.exitScope();
            return;
        }

        // Only a bare name is a variable reference. Attribute names, filter names
        // and keyword-argument names live in fields rather than children, so the
        // generic descent below can never mistake them for variables.
        if (node instanceof NameExpr) {
            NameExpr n = (NameExpr) node;
            markIdentifier(n.getName(), n.getLine());
            return;
        }

        if (node instanceof CallExpr || node instanceof FilterExpr) {
            walkChildren(node);
            return;
        }

        walkChildren(node);
    }

    private void walkChildren(AstNode node) {
        for (AstNode c : node.getChildren()) walk(c);
    }

    private void markIdentifier(String name, int line) {
        if (!isValidIdentifier(name)) return;
        if (KEYWORDS.contains(name) || BUILTINS.contains(name)) return;
        if (table.resolve(name) != null) return;
        contextVars.putIfAbsent(name, line);
    }

    private boolean isValidIdentifier(String s) {
        return s != null && s.matches("[A-Za-z_][A-Za-z0-9_]*");
    }
}
