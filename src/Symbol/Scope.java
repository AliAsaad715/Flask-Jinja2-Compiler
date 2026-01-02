package symbol;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    private final String name;
    private final int line;
    private final Scope parent;
    private final Map<String, symbol.SymbolInfo> symbols = new LinkedHashMap<>();

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

    public void define(symbol.SymbolInfo info) {
        symbols.put(info.getName(), info);
    }

    public symbol.SymbolInfo lookupLocal(String name) {
        return symbols.get(name);
    }

    public Map<String, symbol.SymbolInfo> getSymbols() {
        return Collections.unmodifiableMap(symbols);
    }
}
