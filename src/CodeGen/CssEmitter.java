package CodeGen;

import AST.css.CssDeclNode;
import AST.css.CssFileNode;
import AST.css.CssRuleNode;

import java.util.List;

/** Turns the CSS AST back into a stylesheet: one declaration per line, a blank line between rules. */
final class CssEmitter {

    private static final String INDENT = "  ";

    private CssEmitter() {
    }

    static String emit(CssFileNode file) {
        StringBuilder out = new StringBuilder();
        if (file == null) return out.toString();

        List<CssRuleNode> rules = file.getRules();
        for (int i = 0; i < rules.size(); i++) {
            if (i > 0) out.append('\n');
            rule(out, rules.get(i));
        }
        return out.toString();
    }

    private static void rule(StringBuilder out, CssRuleNode rule) {
        out.append(rule.getSelector()).append(" {\n");
        for (CssDeclNode decl : rule.getDecls()) {
            out.append(INDENT)
               .append(decl.getProperty())
               .append(": ")
               .append(decl.getValue())
               .append(";\n");
        }
        out.append("}\n");
    }
}
