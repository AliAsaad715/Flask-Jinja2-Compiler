package symbol;

import java.util.*;

/**
 * Simple scoped symbol table used during AST construction.
 * Symbols are recorded when we see declarations (imports, assignments, functions)
 * and looked up for identifier references. Each scope keeps its own set of names,
 * with lookup walking outward through parents.
 */
public class SymbolTablePython {

    public enum SymbolKind { VARIABLE, FUNCTION, PARAMETER, IMPORT }

    public static final class SymbolEntry {
        private final String name;
        private final SymbolKind kind;
        private final String scopeName;
        private final int line;
        private final Map<String, Object> attributes = new HashMap<>();

        SymbolEntry(String name, SymbolKind kind, String scopeName, int line) {
            this.name = name;
            this.kind = kind;
            this.scopeName = scopeName;
            this.line = line;
        }

        public String getName() { return name; }
        public SymbolKind getKind() { return kind; }
        public String getScopeName() { return scopeName; }
        public int getLine() { return line; }

        public void setAttribute(String key, Object value) {
            attributes.put(key, value);
        }

        public Object getAttribute(String key) {
            return attributes.get(key);
        }

        public Map<String, Object> getAttributes() {
            return Collections.unmodifiableMap(attributes);
        }

        @Override
        public String toString() {
            if (attributes.isEmpty()) {
                return kind + " " + name + " (line " + line + ")";
            }
            return kind + " " + name + " (line " + line + ", attrs=" + attributes + ")";
        }
    }

    private static final class Scope {
        final String name;
        final Map<String, SymbolEntry> symbols = new LinkedHashMap<>();
        Scope(String name) { this.name = name; }
    }

    private final Deque<Scope> scopes = new ArrayDeque<>();
    private final List<String> diagnostics = new ArrayList<>();

    public SymbolTablePython() {
        pushScope("global");
    }

    public void pushScope(String name) {
        scopes.push(new Scope(name));
    }

    public void popScope() {
        if (scopes.size() <= 1) {
            diagnostics.add("attempted to pop the global scope");
            return;
        }
        scopes.pop();
    }

    public SymbolEntry define(String name, SymbolKind kind, int line) {
        Scope scope = currentScope();
        SymbolEntry existing = scope.symbols.get(name);
        if (existing != null) {
            diagnostics.add("line " + line + ": symbol '" + name + "' already defined in scope '" + scope.name + "'");
            return existing;
        }

        SymbolEntry entry = new SymbolEntry(name, kind, scope.name, line);
        scope.symbols.put(name, entry);
        return entry;
    }

    public SymbolEntry resolve(String name, int line) {
        for (Scope scope : scopes) {
            SymbolEntry entry = scope.symbols.get(name);
            if (entry != null) return entry;
        }
        diagnostics.add("line " + line + ": symbol '" + name + "' not defined in any visible scope");
        return null;
    }

    public SymbolEntry resolveCurrent(String name) {
        Scope scope = currentScope();
        if (scope == null) return null;
        return scope.symbols.get(name);
    }

    public String currentScopeName() {
        Scope scope = currentScope();
        return scope != null ? scope.name : "";
    }

    public List<String> getDiagnostics() {
        return Collections.unmodifiableList(diagnostics);
    }

    public String format() {
        StringBuilder sb = new StringBuilder();
        List<Scope> ordered = new ArrayList<>(scopes);
        Collections.reverse(ordered); // print global first
        for (Scope scope : ordered) {
            sb.append(scope.name).append(" scope:\n");
            if (scope.symbols.isEmpty()) {
                sb.append("  (empty)\n");
                continue;
            }
            for (SymbolEntry entry : scope.symbols.values()) {
                sb.append("  - ").append(entry).append("\n");
            }
        }
        if (!diagnostics.isEmpty()) {
            sb.append("diagnostics:\n");
            for (String diag : diagnostics) {
                sb.append("  * ").append(diag).append("\n");
            }
        }
        return sb.toString();
    }

    private Scope currentScope() {
        return scopes.peek();
    }
}

