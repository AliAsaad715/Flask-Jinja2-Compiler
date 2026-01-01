package AST;

import symbol.SymbolTable;

public class IdentifierNode extends AstNode {
    public String name;
    public SymbolTable.SymbolEntry symbol;

    public IdentifierNode(int line, String name) {
        super("Identifier", line);
        this.name = name;
    }

    public void setSymbol(SymbolTable.SymbolEntry symbol) {
        this.symbol = symbol;
    }

    @Override
    public String describe() {
        if (symbol != null) return name + "@" + symbol.getScopeName();
        return name;
    }
}
