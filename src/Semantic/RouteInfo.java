package Semantic;

import AST.python.AstNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteInfo {

    private static final Pattern URL_PARAM = Pattern.compile("<(?:([a-zA-Z_]+):)?([a-zA-Z_][a-zA-Z0-9_]*)>");

    private final String urlPath;
    private final String functionName;
    private final List<String> functionParams = new ArrayList<>();
    private final int line;

    private String renderedTemplate;
    private int renderLine = -1;

    private final Map<String, AstNode> context = new LinkedHashMap<>();

    public RouteInfo(String urlPath, String functionName, List<String> functionParams, int line) {
        this.urlPath = urlPath;
        this.functionName = functionName;
        if (functionParams != null) this.functionParams.addAll(functionParams);
        this.line = line;
    }

    public String getUrlPath() { return urlPath; }
    public String getFunctionName() { return functionName; }
    public List<String> getFunctionParams() { return Collections.unmodifiableList(functionParams); }
    public int getLine() { return line; }

    public String getRenderedTemplate() { return renderedTemplate; }
    public int getRenderLine() { return renderLine; }

    public void setRendered(String templateName, int atLine) {
        this.renderedTemplate = templateName;
        this.renderLine = atLine;
    }

    public void putContext(String key, AstNode value) {
        context.put(key, value);
    }

    public Map<String, AstNode> getContext() {
        return Collections.unmodifiableMap(context);
    }

    public List<String> getUrlParams() {
        List<String> out = new ArrayList<>();
        if (urlPath == null) return out;
        Matcher m = URL_PARAM.matcher(urlPath);
        while (m.find()) out.add(m.group(2));
        return out;
    }
}
