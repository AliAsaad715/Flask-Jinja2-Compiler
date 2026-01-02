package Visitor;

import AST.AstNode;
import AST.template.*;
import AST.template.expr.CallExpr;
import AST.template.expr.NameExpr;
import AST.template.expr.RawExpr;
import Symbol.SymbolKind;
import Symbol.SymbolTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TemplateSymbolCollector {
    private final SymbolTable table = new SymbolTable();
    private final Set<String> contextVars = new LinkedHashSet<>();

     private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
            "if", "elif", "else", "for", "in", "and", "or", "not",
            "True", "False", "None"
    ));

    private static final Set<String> BUILTINS = new HashSet<>(Arrays.asList(
            "url_for", "get_flashed_messages",
            "range", "len", "int", "float", "str", "list", "dict"
    ));

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

         if (node instanceof NameExpr) {
            NameExpr n = (NameExpr) node;
            markIdentifier(n.getName());
            return;
        }
        if (node instanceof RawExpr) {
            RawExpr r = (RawExpr) node;
            for (String id : extractBaseIdentifiers(r.getRaw())) {
                markIdentifier(id);
            }
            return;
        }

        if (node instanceof CallExpr) {
            CallExpr call = (CallExpr) node;


            for (String id : extractBaseIdentifiers(call.getFunctionName())) {
                 if (!BUILTINS.contains(id)) {
                    markIdentifier(id);
                }
            }

            for (AstNode c : call.getChildren()) walk(c);
            return;
        }

        for (AstNode c : node.getChildren()) {
            walk(c);
        }
    }

    private void markIdentifier(String name) {
        if (!isValidIdentifier(name)) return;
        if (KEYWORDS.contains(name) || BUILTINS.contains(name)) return;

        if (table.resolve(name) == null) {
            contextVars.add(name);
        }
    }

    private boolean isValidIdentifier(String s) {
        return s != null && s.matches("[A-Za-z_][A-Za-z0-9_]*");
    }


    private Set<String> extractBaseIdentifiers(String raw) {
        Set<String> out = new LinkedHashSet<>();
        if (raw == null || raw.isEmpty()) return out;

        boolean inS = false;
        boolean inD = false;

        for (int i = 0; i < raw.length(); i++) {
            char ch = raw.charAt(i);

            if (ch == '\'' && !inD) {
                inS = !inS;
                continue;
            }
            if (ch == '"' && !inS) {
                inD = !inD;
                continue;
            }
            if (inS || inD) continue;

            if (Character.isLetter(ch) || ch == '_') {
                int start = i;
                int j = i + 1;
                while (j < raw.length()) {
                    char cj = raw.charAt(j);
                    if (Character.isLetterOrDigit(cj) || cj == '_') j++;
                    else break;
                }
                String id = raw.substring(start, j);

                char prev = prevNonSpace(raw, start - 1);
                char next = nextNonSpace(raw, j);

                boolean isAttr = prev == '.';
                boolean isFilterName = prev == '|';
                boolean isKwArgKey = next == '='; // e.g. filename=...

                if (!isAttr && !isFilterName && !isKwArgKey) {
                    out.add(id);
                }

                i = j - 1;
            }
        }

        return out;
    }

    private char prevNonSpace(String s, int idx) {
        for (int i = idx; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) return c;
        }
        return '\0';
    }

    private char nextNonSpace(String s, int idx) {
        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) return c;
        }
        return '\0';
    }
}