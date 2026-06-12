package Analysis;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TemplateContextBinding {
    private final String templateName;
    private final String routePath;
    private final String functionName;
    private final int line;
    private final Map<String, String> contextValues = new LinkedHashMap<>();

    public TemplateContextBinding(String templateName, String routePath, String functionName, int line) {
        this.templateName = templateName;
        this.routePath = routePath;
        this.functionName = functionName;
        this.line = line;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getRoutePath() {
        return routePath;
    }

    public String getFunctionName() {
        return functionName;
    }

    public int getLine() {
        return line;
    }

    public void addContextValue(String name, String sourceExpr) {
        if (name == null || name.isBlank()) return;
        contextValues.put(name, sourceExpr == null ? "" : sourceExpr);
    }

    public Map<String, String> getContextValues() {
        return Collections.unmodifiableMap(contextValues);
    }
}
