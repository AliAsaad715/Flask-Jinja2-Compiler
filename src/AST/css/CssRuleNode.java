package AST.css;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CssRuleNode extends CssNode {
    private final String selector;
    private final List<CssDeclNode> decls = new ArrayList<>();

    public CssRuleNode(int line, String selector) {
        super("CssRule", line);
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }

    public void addDecl(CssDeclNode decl) {
        if (decl != null) {
            decls.add(decl);
            addChild(decl);
        }
    }

    public List<CssDeclNode> getDecls() {
        return Collections.unmodifiableList(decls);
    }

    @Override
    protected String details() {
        return "{selector=" + selector + "}";
    }
}
