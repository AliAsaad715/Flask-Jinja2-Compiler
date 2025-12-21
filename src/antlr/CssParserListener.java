// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/CssParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CssParser}.
 */
public interface CssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRuleDef}
	 * labeled alternative in {@link CssParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRuleDef(CssParser.CssRuleDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRuleDef}
	 * labeled alternative in {@link CssParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRuleDef(CssParser.CssRuleDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorSeq}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorSeq(CssParser.SelectorSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorSeq}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorSeq(CssParser.SelectorSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelIdent}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void enterSelIdent(CssParser.SelIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelIdent}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void exitSelIdent(CssParser.SelIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelClass}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void enterSelClass(CssParser.SelClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelClass}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void exitSelClass(CssParser.SelClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelId}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void enterSelId(CssParser.SelIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelId}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void exitSelId(CssParser.SelIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelComma}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void enterSelComma(CssParser.SelCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelComma}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void exitSelComma(CssParser.SelCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link CssParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link CssParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueSeq}
	 * labeled alternative in {@link CssParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueSeq(CssParser.ValueSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueSeq}
	 * labeled alternative in {@link CssParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueSeq(CssParser.ValueSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValIdent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValIdent(CssParser.ValIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValIdent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValIdent(CssParser.ValIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValNumber}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValNumber(CssParser.ValNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValNumber}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValNumber(CssParser.ValNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValString(CssParser.ValStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValString(CssParser.ValStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValColor}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValColor(CssParser.ValColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValColor}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValColor(CssParser.ValColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValDot}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValDot(CssParser.ValDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValDot}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValDot(CssParser.ValDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValHash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValHash(CssParser.ValHashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValHash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValHash(CssParser.ValHashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValComma}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValComma(CssParser.ValCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValComma}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValComma(CssParser.ValCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValPercent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValPercent(CssParser.ValPercentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValPercent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValPercent(CssParser.ValPercentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValPlus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValPlus(CssParser.ValPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValPlus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValPlus(CssParser.ValPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValMinus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValMinus(CssParser.ValMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValMinus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValMinus(CssParser.ValMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValStar}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValStar(CssParser.ValStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValStar}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValStar(CssParser.ValStarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValSlash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValSlash(CssParser.ValSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValSlash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValSlash(CssParser.ValSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValLParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValLParen(CssParser.ValLParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValLParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValLParen(CssParser.ValLParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValRParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterValRParen(CssParser.ValRParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValRParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitValRParen(CssParser.ValRParenContext ctx);
}