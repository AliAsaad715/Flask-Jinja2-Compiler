// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/TemplateParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplateParser}.
 */
public interface TemplateParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplateParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(TemplateParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(TemplateParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlElementItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementItem(TemplateParser.HtmlElementItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlElementItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementItem(TemplateParser.HtmlElementItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaBlockItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockItem(TemplateParser.JinjaBlockItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaBlockItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockItem(TemplateParser.JinjaBlockItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaForItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForItem(TemplateParser.JinjaForItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaForItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForItem(TemplateParser.JinjaForItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIfItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfItem(TemplateParser.JinjaIfItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIfItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfItem(TemplateParser.JinjaIfItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaExtendsItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExtendsItem(TemplateParser.JinjaExtendsItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaExtendsItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExtendsItem(TemplateParser.JinjaExtendsItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaPrintItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaPrintItem(TemplateParser.JinjaPrintItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaPrintItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaPrintItem(TemplateParser.JinjaPrintItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlTextItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextItem(TemplateParser.HtmlTextItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlTextItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextItem(TemplateParser.HtmlTextItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlainText}
	 * labeled alternative in {@link TemplateParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void enterPlainText(TemplateParser.PlainTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlainText}
	 * labeled alternative in {@link TemplateParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void exitPlainText(TemplateParser.PlainTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlNormalElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlNormalElement(TemplateParser.HtmlNormalElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlNormalElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlNormalElement(TemplateParser.HtmlNormalElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlSelfClosingElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSelfClosingElement(TemplateParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlSelfClosingElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSelfClosingElement(TemplateParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 */
	void enterNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 */
	void exitNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#openTag}.
	 * @param ctx the parse tree
	 */
	void enterOpenTag(TemplateParser.OpenTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#openTag}.
	 * @param ctx the parse tree
	 */
	void exitOpenTag(TemplateParser.OpenTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#closeTag}.
	 * @param ctx the parse tree
	 */
	void enterCloseTag(TemplateParser.CloseTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#closeTag}.
	 * @param ctx the parse tree
	 */
	void exitCloseTag(TemplateParser.CloseTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#selfClosingElement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingElement(TemplateParser.SelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#selfClosingElement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingElement(TemplateParser.SelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeKV}
	 * labeled alternative in {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeKV(TemplateParser.AttributeKVContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeKV}
	 * labeled alternative in {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeKV(TemplateParser.AttributeKVContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrDoubleQuoted(TemplateParser.AttrDoubleQuotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrDoubleQuoted(TemplateParser.AttrDoubleQuotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrSingleQuoted(TemplateParser.AttrSingleQuotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrSingleQuoted(TemplateParser.AttrSingleQuotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrTextValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrTextValuePart(TemplateParser.AttrTextValuePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrTextValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrTextValuePart(TemplateParser.AttrTextValuePartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaPrintValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaPrintValuePart(TemplateParser.AttrJinjaPrintValuePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaPrintValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaPrintValuePart(TemplateParser.AttrJinjaPrintValuePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaExtends}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExtends(TemplateParser.JinjaExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaExtends}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExtends(TemplateParser.JinjaExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlock(TemplateParser.JinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlock(TemplateParser.JinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void enterJinjaFor(TemplateParser.JinjaForContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void exitJinjaFor(TemplateParser.JinjaForContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIf(TemplateParser.JinjaIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIf(TemplateParser.JinjaIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaElif}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElif(TemplateParser.JinjaElifContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaElif}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElif(TemplateParser.JinjaElifContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElse(TemplateParser.JinjaElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElse(TemplateParser.JinjaElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaPrint}.
	 * @param ctx the parse tree
	 */
	void enterJinjaPrint(TemplateParser.JinjaPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaPrint}.
	 * @param ctx the parse tree
	 */
	void exitJinjaPrint(TemplateParser.JinjaPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSequence}
	 * labeled alternative in {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSequence(TemplateParser.ExprSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSequence}
	 * labeled alternative in {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSequence(TemplateParser.ExprSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAtomUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void enterExprAtomUnit(TemplateParser.ExprAtomUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAtomUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void exitExprAtomUnit(TemplateParser.ExprAtomUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOpUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void enterExprOpUnit(TemplateParser.ExprOpUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOpUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void exitExprOpUnit(TemplateParser.ExprOpUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPunctUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void enterExprPunctUnit(TemplateParser.ExprPunctUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPunctUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 */
	void exitExprPunctUnit(TemplateParser.ExprPunctUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomId(TemplateParser.AtomIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomId(TemplateParser.AtomIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomInt(TemplateParser.AtomIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomInt(TemplateParser.AtomIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomString(TemplateParser.AtomStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomString(TemplateParser.AtomStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomParen(TemplateParser.AtomParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomParen(TemplateParser.AtomParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomBracket}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomBracket(TemplateParser.AtomBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomBracket}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomBracket(TemplateParser.AtomBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(TemplateParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(TemplateParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#punct}.
	 * @param ctx the parse tree
	 */
	void enterPunct(TemplateParser.PunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#punct}.
	 * @param ctx the parse tree
	 */
	void exitPunct(TemplateParser.PunctContext ctx);
}