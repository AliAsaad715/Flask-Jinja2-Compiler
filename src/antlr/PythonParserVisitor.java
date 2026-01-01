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
	 * Visit a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(PythonParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(PythonParser.Import_stmtContext ctx);
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
	 * Visit a parse tree produced by {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_stmt(PythonParser.End_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#assign_target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_target(PythonParser.Assign_targetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer_no_call(PythonParser.Trailer_no_callContext ctx);
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
	 * Visit a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(PythonParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(PythonParser.Comp_opContext ctx);
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
	 * Visit a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(PythonParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(PythonParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(PythonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PythonParser.AtomContext ctx);
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