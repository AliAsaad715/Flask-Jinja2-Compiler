package AST.css;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CssFileNode extends CssNode {
    private final List<CssRuleNode> rules = new ArrayList<>();

    public CssFileNode(int line) {
        super("CssFile", line);
    }

    public void addRule(CssRuleNode rule) {
        if (rule != null) {
            rules.add(rule);
            addChild(rule);
        }
    }

    public List<CssRuleNode> getRules() {
        return Collections.unmodifiableList(rules);
    }
}
