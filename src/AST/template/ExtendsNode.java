package AST.template;

public class ExtendsNode extends JinjaNode {
    private final String templateName;

    public ExtendsNode(int line, String templateName) {
        super("JinjaExtends", line);
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    @Override
    public String describe() {
        return "{template=" + templateName + "}";
    }
}
