package symbol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SymbolTable {
    private final Deque<Scope> stack = new ArrayDeque<>();
    private final List<Scope> allScopes = new ArrayList<>();

    public void enterScope(String name, int line) {
        Scope parent = stack.peek();
        Scope scope = new Scope(name, line, parent);
        stack.push(scope);
        allScopes.add(scope);
    }

    public void exitScope() {
        if (!stack.isEmpty()) stack.pop();
    }

    public Scope currentScope() {
        return stack.peek();
    }

    public void define(String name, int line, SymbolKind kind) {
        Scope cur = currentScope();
        if (cur == null) return;
        cur.define(new SymbolInfo(name, line, kind));
    }

    public SymbolInfo resolve(String name) {
        Scope cur = currentScope();
        while (cur != null) {
            SymbolInfo found = cur.lookupLocal(name);
            if (found != null) return found;
            cur = cur.getParent();
        }
        return null;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allScopes.size(); i++) {
            Scope s = allScopes.get(i);
            sb.append("Scope ").append(i + 1)
                    .append(": ").append(s.getName())
                    .append(" [line=").append(s.getLine()).append("]\n");

            if (s.getSymbols().isEmpty()) {
                sb.append("  (empty)\n");
            } else {
                for (SymbolInfo info : s.getSymbols().values()) {
                    sb.append("  ").append(info.toString()).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
