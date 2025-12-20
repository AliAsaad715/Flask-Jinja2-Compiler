// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/TemplateParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplateParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplateParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(TemplateParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlElementItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementItem(TemplateParser.HtmlElementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaBlockItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockItem(TemplateParser.JinjaBlockItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaForItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForItem(TemplateParser.JinjaForItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIfItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfItem(TemplateParser.JinjaIfItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaWithItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaWithItem(TemplateParser.JinjaWithItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExtendsItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExtendsItem(TemplateParser.JinjaExtendsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaPrintItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaPrintItem(TemplateParser.JinjaPrintItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlTextItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTextItem(TemplateParser.HtmlTextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlainText}
	 * labeled alternative in {@link TemplateParser#htmlText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainText(TemplateParser.PlainTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlVoidElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlVoidElement(TemplateParser.HtmlVoidElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlNormalElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlNormalElement(TemplateParser.HtmlNormalElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlSelfClosingElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlSelfClosingElement(TemplateParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#openTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenTag(TemplateParser.OpenTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#selfClosingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingElement(TemplateParser.SelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#closeTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseTag(TemplateParser.CloseTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElement(TemplateParser.VoidElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeKV}
	 * labeled alternative in {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeKV(TemplateParser.AttributeKVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrDoubleQuoted(TemplateParser.AttrDoubleQuotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrSingleQuoted(TemplateParser.AttrSingleQuotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrTextValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrTextValuePart(TemplateParser.AttrTextValuePartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaPrintValuePart}
	 * labeled alternative in {@link TemplateParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaPrintValuePart(TemplateParser.AttrJinjaPrintValuePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExtends(TemplateParser.JinjaExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlock(TemplateParser.JinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#blockBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockBodyItem(TemplateParser.BlockBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaFor(TemplateParser.JinjaForContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#forBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBodyItem(TemplateParser.ForBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIf(TemplateParser.JinjaIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#ifThenBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenBodyItem(TemplateParser.IfThenBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaElif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElif(TemplateParser.JinjaElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#elifBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifBodyItem(TemplateParser.ElifBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElse(TemplateParser.JinjaElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaWith(TemplateParser.JinjaWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#withBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithBodyItem(TemplateParser.WithBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#elseBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBodyItem(TemplateParser.ElseBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaPrint(TemplateParser.JinjaPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSequence}
	 * labeled alternative in {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSequence(TemplateParser.ExprSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAtomUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAtomUnit(TemplateParser.ExprAtomUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOpUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOpUnit(TemplateParser.ExprOpUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPunctUnit}
	 * labeled alternative in {@link TemplateParser#exprUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPunctUnit(TemplateParser.ExprPunctUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomId(TemplateParser.AtomIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomInt(TemplateParser.AtomIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomString(TemplateParser.AtomStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomParen(TemplateParser.AtomParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomBracket}
	 * labeled alternative in {@link TemplateParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomBracket(TemplateParser.AtomBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(TemplateParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#punct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPunct(TemplateParser.PunctContext ctx);
}