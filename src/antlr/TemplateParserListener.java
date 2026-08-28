// Generated from src/antlr/TemplateParser.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by the {@code JinjaWithItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void enterJinjaWithItem(TemplateParser.JinjaWithItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaWithItem}
	 * labeled alternative in {@link TemplateParser#item}.
	 * @param ctx the parse tree
	 */
	void exitJinjaWithItem(TemplateParser.JinjaWithItemContext ctx);
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
	 * Enter a parse tree produced by the {@code HtmlVoidElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlVoidElement(TemplateParser.HtmlVoidElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlVoidElement}
	 * labeled alternative in {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlVoidElement(TemplateParser.HtmlVoidElementContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElement(TemplateParser.VoidElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElement(TemplateParser.VoidElementContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#blockBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockBodyItem(TemplateParser.BlockBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#blockBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockBodyItem(TemplateParser.BlockBodyItemContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#forBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterForBodyItem(TemplateParser.ForBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#forBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitForBodyItem(TemplateParser.ForBodyItemContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#ifThenBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterIfThenBodyItem(TemplateParser.IfThenBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#ifThenBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitIfThenBodyItem(TemplateParser.IfThenBodyItemContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#elifBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterElifBodyItem(TemplateParser.ElifBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#elifBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitElifBodyItem(TemplateParser.ElifBodyItemContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#jinjaWith}.
	 * @param ctx the parse tree
	 */
	void enterJinjaWith(TemplateParser.JinjaWithContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaWith}.
	 * @param ctx the parse tree
	 */
	void exitJinjaWith(TemplateParser.JinjaWithContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#withBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterWithBodyItem(TemplateParser.WithBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#withBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitWithBodyItem(TemplateParser.WithBodyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#elseBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterElseBodyItem(TemplateParser.ElseBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#elseBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitElseBodyItem(TemplateParser.ElseBodyItemContext ctx);
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
	 * Enter a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TemplateParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TemplateParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(TemplateParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(TemplateParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(TemplateParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(TemplateParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(TemplateParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(TemplateParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotUnary(TemplateParser.NotUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotUnary(TemplateParser.NotUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotPassthrough}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotPassthrough(TemplateParser.NotPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotPassthrough}
	 * labeled alternative in {@link TemplateParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotPassthrough(TemplateParser.NotPassthroughContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(TemplateParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(TemplateParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompEq(TemplateParser.CompEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompEq(TemplateParser.CompEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompNotEq(TemplateParser.CompNotEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompNotEq(TemplateParser.CompNotEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompLe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompLe(TemplateParser.CompLeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompLe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompLe(TemplateParser.CompLeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompGe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompGe(TemplateParser.CompGeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompGe}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompGe(TemplateParser.CompGeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompLt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompLt(TemplateParser.CompLtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompLt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompLt(TemplateParser.CompLtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompGt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompGt(TemplateParser.CompGtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompGt}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompGt(TemplateParser.CompGtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompNotIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompNotIn(TemplateParser.CompNotInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompNotIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompNotIn(TemplateParser.CompNotInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompIn(TemplateParser.CompInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompIn(TemplateParser.CompInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIsNot}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompIsNot(TemplateParser.CompIsNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIsNot}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompIsNot(TemplateParser.CompIsNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompIs(TemplateParser.CompIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link TemplateParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompIs(TemplateParser.CompIsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#filterExpr}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpr(TemplateParser.FilterExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#filterExpr}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpr(TemplateParser.FilterExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#filterCall}.
	 * @param ctx the parse tree
	 */
	void enterFilterCall(TemplateParser.FilterCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#filterCall}.
	 * @param ctx the parse tree
	 */
	void exitFilterCall(TemplateParser.FilterCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(TemplateParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(TemplateParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(TemplateParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(TemplateParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(TemplateParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(TemplateParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPassthrough}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPassthrough(TemplateParser.UnaryPassthroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPassthrough}
	 * labeled alternative in {@link TemplateParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPassthrough(TemplateParser.UnaryPassthroughContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(TemplateParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(TemplateParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerAttr(TemplateParser.TrailerAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerAttr(TemplateParser.TrailerAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerIndex(TemplateParser.TrailerIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerIndex(TemplateParser.TrailerIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerCall(TemplateParser.TrailerCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link TemplateParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerCall(TemplateParser.TrailerCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubscriptIndex}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptIndex(TemplateParser.SubscriptIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubscriptIndex}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptIndex(TemplateParser.SubscriptIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubscriptSlice}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptSlice(TemplateParser.SubscriptSliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubscriptSlice}
	 * labeled alternative in {@link TemplateParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptSlice(TemplateParser.SubscriptSliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(TemplateParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(TemplateParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgKeyword(TemplateParser.ArgKeywordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgKeyword(TemplateParser.ArgKeywordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgPositional(TemplateParser.ArgPositionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link TemplateParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgPositional(TemplateParser.ArgPositionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryId}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryId(TemplateParser.PrimaryIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryId}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryId(TemplateParser.PrimaryIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryInt}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryInt(TemplateParser.PrimaryIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryInt}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryInt(TemplateParser.PrimaryIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryFloat}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryFloat(TemplateParser.PrimaryFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryFloat}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryFloat(TemplateParser.PrimaryFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryString}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryString(TemplateParser.PrimaryStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryString}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryString(TemplateParser.PrimaryStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryTrue}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryTrue(TemplateParser.PrimaryTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryTrue}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryTrue(TemplateParser.PrimaryTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryFalse}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryFalse(TemplateParser.PrimaryFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryFalse}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryFalse(TemplateParser.PrimaryFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryNone}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNone(TemplateParser.PrimaryNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryNone}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNone(TemplateParser.PrimaryNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryParen}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryParen(TemplateParser.PrimaryParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryParen}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryParen(TemplateParser.PrimaryParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryList}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryList(TemplateParser.PrimaryListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryList}
	 * labeled alternative in {@link TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryList(TemplateParser.PrimaryListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(TemplateParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(TemplateParser.ExprListContext ctx);
}