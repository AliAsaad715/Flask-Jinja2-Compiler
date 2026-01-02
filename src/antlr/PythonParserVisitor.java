// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Compiler/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtImport(PythonParser.StmtImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtAssign(PythonParser.StmtAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtDecoratedFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtDecoratedFuncdef(PythonParser.StmtDecoratedFuncdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtFuncdef(PythonParser.StmtFuncdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtIf(PythonParser.StmtIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtReturn(PythonParser.StmtReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtExpr}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExpr(PythonParser.StmtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtNewline}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtNewline(PythonParser.StmtNewlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFrom(PythonParser.ImportFromContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportDirect}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDirect(PythonParser.ImportDirectContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_name(PythonParser.Dotted_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(PythonParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndNewline}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndNewline(PythonParser.EndNewlineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndEOF}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndEOF(PythonParser.EndEOFContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#assign_target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_target(PythonParser.Assign_targetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerNoCallAttr}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerNoCallAttr(PythonParser.TrailerNoCallAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerNoCallIndex}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerNoCallIndex(PythonParser.TrailerNoCallIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#decorated_funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated_funcdef(PythonParser.Decorated_funcdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(PythonParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(PythonParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(PythonParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PythonParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(PythonParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(PythonParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotUnary(PythonParser.NotUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotComparison}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotComparison(PythonParser.NotComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompEq(PythonParser.CompEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompNotEq(PythonParser.CompNotEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIn(PythonParser.CompInContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIs(PythonParser.CompIsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(PythonParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#atom_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_expr(PythonParser.Atom_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerAttr(PythonParser.TrailerAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerCall(PythonParser.TrailerCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailerIndex(PythonParser.TrailerIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(PythonParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgKeyword(PythonParser.ArgKeywordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgPositional(PythonParser.ArgPositionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomId(PythonParser.AtomIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomString(PythonParser.AtomStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomInt(PythonParser.AtomIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomFloat}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomFloat(PythonParser.AtomFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomNone}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomNone(PythonParser.AtomNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomTrue}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomTrue(PythonParser.AtomTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomFalse}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomFalse(PythonParser.AtomFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomList}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomList(PythonParser.AtomListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomDictOrSet}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomDictOrSet(PythonParser.AtomDictOrSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomParen(PythonParser.AtomParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#gen_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_expr(PythonParser.Gen_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#nl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNl(PythonParser.NlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#list_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_literal(PythonParser.List_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dict_or_set_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_or_set_literal(PythonParser.Dict_or_set_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dict_entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_entry(PythonParser.Dict_entryContext ctx);
}