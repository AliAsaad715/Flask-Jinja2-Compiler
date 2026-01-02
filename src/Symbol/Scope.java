package Symbol;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    private final String name;
    private final int line;
    private final Scope parent;
    private final Map<String, Symbol.SymbolInfo> symbols = new LinkedHashMap<>();

    public Scope(String name, int line, Scope parent) {
        this.name = name;
        this.line = line;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public Scope getParent() {
        return parent;
    }

    public void define(Symbol.SymbolInfo info) {
        symbols.put(info.getName(), info);
    }

    public Symbol.SymbolInfo lookupLocal(String name) {
        return symbols.get(name);
    }

    public Map<String, Symbol.SymbolInfo> getSymbols() {
        return Collections.unmodifiableMap(symbols);
    }
}
