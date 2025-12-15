// Generated from C:/Users/LEGION/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PythonParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PythonParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_name(PythonParser.Dotted_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_name(PythonParser.Dotted_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(PythonParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(PythonParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#assign_target}.
	 * @param ctx the parse tree
	 */
	void enterAssign_target(PythonParser.Assign_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#assign_target}.
	 * @param ctx the parse tree
	 */
	void exitAssign_target(PythonParser.Assign_targetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void enterTrailer_no_call(PythonParser.Trailer_no_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void exitTrailer_no_call(PythonParser.Trailer_no_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorated_funcdef}.
	 * @param ctx the parse tree
	 */
	void enterDecorated_funcdef(PythonParser.Decorated_funcdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorated_funcdef}.
	 * @param ctx the parse tree
	 */
	void exitDecorated_funcdef(PythonParser.Decorated_funcdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(PythonParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(PythonParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(PythonParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(PythonParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(PythonParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(PythonParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(PythonParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(PythonParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(PythonParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(PythonParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(PythonParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(PythonParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(PythonParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(PythonParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(PythonParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(PythonParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_expr(PythonParser.Atom_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_expr(PythonParser.Atom_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailer(PythonParser.TrailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailer(PythonParser.TrailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(PythonParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(PythonParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PythonParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PythonParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PythonParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PythonParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#gen_expr}.
	 * @param ctx the parse tree
	 */
	void enterGen_expr(PythonParser.Gen_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#gen_expr}.
	 * @param ctx the parse tree
	 */
	void exitGen_expr(PythonParser.Gen_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void enterList_literal(PythonParser.List_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void exitList_literal(PythonParser.List_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_or_set_literal}.
	 * @param ctx the parse tree
	 */
	void enterDict_or_set_literal(PythonParser.Dict_or_set_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_or_set_literal}.
	 * @param ctx the parse tree
	 */
	void exitDict_or_set_literal(PythonParser.Dict_or_set_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_entry}.
	 * @param ctx the parse tree
	 */
	void enterDict_entry(PythonParser.Dict_entryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_entry}.
	 * @param ctx the parse tree
	 */
	void exitDict_entry(PythonParser.Dict_entryContext ctx);
}