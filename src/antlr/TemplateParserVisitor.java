// Generated from src/antlr/TemplateParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TemplateParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(TemplateParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(TemplateParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(TemplateParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotUnary(TemplateParser.NotUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotPassthrough}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotPassthrough(TemplateParser.NotPassthroughContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(TemplateParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompEq(TemplateParser.CompEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompNotEq(TemplateParser.CompNotEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompLe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompLe(TemplateParser.CompLeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompGe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompGe(TemplateParser.CompGeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompLt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompLt(TemplateParser.CompLtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompGt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompGt(TemplateParser.CompGtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompNotIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompNotIn(TemplateParser.CompNotInContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIn(TemplateParser.CompInContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIsNot}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIsNot(TemplateParser.CompIsNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIs(TemplateParser.CompIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#filterExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpr(TemplateParser.FilterExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#filterCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterCall(TemplateParser.FilterCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(TemplateParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(TemplateParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(TemplateParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPassthrough}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPassthrough(TemplateParser.UnaryPassthroughContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(TemplateParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerAttr(TemplateParser.TrailerAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerIndex(TemplateParser.TrailerIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerCall(TemplateParser.TrailerCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubscriptIndex}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptIndex(TemplateParser.SubscriptIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubscriptSlice}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptSlice(TemplateParser.SubscriptSliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(TemplateParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgKeyword(TemplateParser.ArgKeywordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgPositional(TemplateParser.ArgPositionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryId}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryId(TemplateParser.PrimaryIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryInt}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryInt(TemplateParser.PrimaryIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryFloat}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryFloat(TemplateParser.PrimaryFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryString}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryString(TemplateParser.PrimaryStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryTrue}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTrue(TemplateParser.PrimaryTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryFalse}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryFalse(TemplateParser.PrimaryFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryNone}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNone(TemplateParser.PrimaryNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryParen}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryParen(TemplateParser.PrimaryParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryList}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryList(TemplateParser.PrimaryListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(TemplateParser.ExprListContext ctx);
}