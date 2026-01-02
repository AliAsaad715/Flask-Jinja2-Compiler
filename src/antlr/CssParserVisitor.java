// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/CssParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRuleDef}
	 * labeled alternative in {@link CssParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRuleDef(CssParser.CssRuleDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorSeq}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorSeq(CssParser.SelectorSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelIdent}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelIdent(CssParser.SelIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelClass}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelClass(CssParser.SelClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelId}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelId(CssParser.SelIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelComma}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelComma(CssParser.SelCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelPseudo}
	 * labeled alternative in {@link CssParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelPseudo(CssParser.SelPseudoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link CssParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueSeq}
	 * labeled alternative in {@link CssParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSeq(CssParser.ValueSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValIdent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValIdent(CssParser.ValIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValNumber}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValNumber(CssParser.ValNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValString(CssParser.ValStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValColor}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValColor(CssParser.ValColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValDot}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValDot(CssParser.ValDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValHash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValHash(CssParser.ValHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValComma}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValComma(CssParser.ValCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValPercent}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValPercent(CssParser.ValPercentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValPlus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValPlus(CssParser.ValPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValMinus}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValMinus(CssParser.ValMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValStar}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValStar(CssParser.ValStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValSlash}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValSlash(CssParser.ValSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValLParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValLParen(CssParser.ValLParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValRParen}
	 * labeled alternative in {@link CssParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValRParen(CssParser.ValRParenContext ctx);
}