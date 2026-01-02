package symbol;

public class SymbolInfo {
    private final String name;
    private final int line;
    private final SymbolKind kind;

    public SymbolInfo(String name, int line, SymbolKind kind) {
        this.name = name;
        this.line = line;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public SymbolKind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return name + " (line=" + line + ", kind=" + kind + ")";
    }
}
