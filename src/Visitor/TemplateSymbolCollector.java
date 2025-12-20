package Visitor;

import AST.AstNode;
import AST.template.*;
import AST.template.expr.*;
import Symbol.SymbolKind;
import Symbol.SymbolTable;

import java.util.HashSet;
import java.util.Set;

public class TemplateSymbolCollector {
    private final SymbolTable table = new SymbolTable();
    private final Set<String> contextVars = new HashSet<>();

    public SymbolTable collect(TemplateFileNode file) {
        table.enterScope("Global", file.getLine());
        walk(file);
        for (String n : contextVars) {
            if (table.resolve(n) == null) {
                table.define(n, file.getLine(), SymbolKind.CONTEXT);
            }
        }
        table.exitScope();
        return table;
    }

    private void walk(AstNode node) {
        if (node == null) return;

        if (node instanceof BlockNode) {
            BlockNode b = (BlockNode) node;
            table.enterScope("Block(" + b.getBlockName() + ")", b.getLine());
            for (AstNode c : b.getChildren()) walk(c);
            table.exitScope();
            return;
        }

        if (node instanceof ForNode) {
            ForNode f = (ForNode) node;
            table.enterScope("For(" + f.getVarName() + ")", f.getLine());
            table.define(f.getVarName(), f.getLine(), SymbolKind.LOOP_VAR);
            walk(f.getIterable());
            for (AstNode c : f.getChildren()) {
                if (c == f.getIterable()) continue;
                walk(c);
            }
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

        if (node instanceof NameExpr) {
            NameExpr n = (NameExpr) node;
            String name = n.getName();
            if (table.resolve(name) == null) {
                contextVars.add(name);
            } else {
                table.define(name, n.getLine(), SymbolKind.USED);
            }
            return;
        }
        if (node instanceof WithNode) {
            WithNode w = (WithNode) node;
            table.enterScope("With", w.getLine());
            walk(w.getHeader());
            for (TemplateItemNode it : w.getBody()) walk(it);
            table.exitScope();
            return;
        }

        for (AstNode c : node.getChildren()) {
            walk(c);
        }
    }
}
