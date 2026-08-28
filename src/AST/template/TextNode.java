package AST.template;

public class TextNode extends HtmlNode {
    private final String text;

    public TextNode(int line, String text) {
        super("Text", line);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String describe() {
        String t = text == null ? "" : text;
        t = t.replace("\n", "\\n");
        if (t.length() > 40) t = t.substring(0, 40) + "...";
        return "{text=\"" + t + "\"}";
    }
}
