package app;

import AST.python.AstNode;
import AST.template.ElementNode;
import AST.template.TextNode;
import Visitor.CssAstBuilder;
import antlr.CssLexer;
import antlr.CssParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class InlineCssRunner {

    public static List<AstNode> parseInlineCss(AstNode templateAst) {
        List<AstNode> out = new ArrayList<>();
        collectAndParse(templateAst, out);
        return out;
    }

    private static void collectAndParse(AstNode node, List<AstNode> out) {
        if (node == null) return;

        if (node instanceof ElementNode) {
            ElementNode el = (ElementNode) node;
            if ("style".equalsIgnoreCase(el.getTagName())) {
                String cssText = extractDirectText(el);
                if (!cssText.isBlank()) {
                    AstNode cssAst = parseCss(cssText);
                    if (cssAst != null) out.add(cssAst);
                }
            }
        }

        for (AstNode c : node.getChildren()) {
            collectAndParse(c, out);
        }
    }

    private static String extractDirectText(AstNode styleElement) {
        StringBuilder sb = new StringBuilder();
        for (AstNode c : styleElement.getChildren()) {
            if (c instanceof TextNode) {
                sb.append(((TextNode) c).getText());
            }
        }
        return sb.toString();
    }

    private static AstNode parseCss(String cssText) {
        CssLexer lexer = new CssLexer(CharStreams.fromString(cssText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CssParser parser = new CssParser(tokens);

        AstNode ast = new CssAstBuilder().visit(parser.stylesheet());
        return ast;
    }
}
