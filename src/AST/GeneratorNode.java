package AST;

import Symbol.SymbolTablePython;

public class GeneratorNode extends ExprNode {
    public String var;

    public GeneratorNode(int line, AstNode element, String var, SymbolTablePython.SymbolEntry loopSymbol, AstNode iterable, AstNode cond) {
        super("GeneratorExpr", line);
        this.var = var;
        add(element);
        IdentifierNode loopVar = new IdentifierNode(line, var);
        loopVar.setSymbol(loopSymbol);
        add(loopVar);
        add(iterable);
        if (cond != null) add(cond);
    }

    @Override
    public String describe() {
        return "for " + var + " in ...";
    }
}
