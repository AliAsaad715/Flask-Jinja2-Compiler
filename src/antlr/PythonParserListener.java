// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Compiler/src/antlr/PythonParser.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtImport(PythonParser.StmtImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtImport(PythonParser.StmtImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtAssign(PythonParser.StmtAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtAssign(PythonParser.StmtAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtDecoratedFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtDecoratedFuncdef(PythonParser.StmtDecoratedFuncdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtDecoratedFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtDecoratedFuncdef(PythonParser.StmtDecoratedFuncdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtFuncdef(PythonParser.StmtFuncdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtFuncdef}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtFuncdef(PythonParser.StmtFuncdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtIf(PythonParser.StmtIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtIf(PythonParser.StmtIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtReturn(PythonParser.StmtReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtReturn(PythonParser.StmtReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtExpr}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtExpr(PythonParser.StmtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtExpr}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtExpr(PythonParser.StmtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtNewline}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtNewline(PythonParser.StmtNewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtNewline}
	 * labeled alternative in {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtNewline(PythonParser.StmtNewlineContext ctx);
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
	 * Enter a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImportFrom(PythonParser.ImportFromContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImportFrom(PythonParser.ImportFromContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportDirect}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImportDirect(PythonParser.ImportDirectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportDirect}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImportDirect(PythonParser.ImportDirectContext ctx);
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
	 * Enter a parse tree produced by the {@code EndNewline}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 */
	void enterEndNewline(PythonParser.EndNewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndNewline}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 */
	void exitEndNewline(PythonParser.EndNewlineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndEOF}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 */
	void enterEndEOF(PythonParser.EndEOFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndEOF}
	 * labeled alternative in {@link PythonParser#end_stmt}.
	 * @param ctx the parse tree
	 */
	void exitEndEOF(PythonParser.EndEOFContext ctx);
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
	 * Enter a parse tree produced by the {@code TrailerNoCallAttr}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void enterTrailerNoCallAttr(PythonParser.TrailerNoCallAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerNoCallAttr}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void exitTrailerNoCallAttr(PythonParser.TrailerNoCallAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerNoCallIndex}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void enterTrailerNoCallIndex(PythonParser.TrailerNoCallIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerNoCallIndex}
	 * labeled alternative in {@link PythonParser#trailer_no_call}.
	 * @param ctx the parse tree
	 */
	void exitTrailerNoCallIndex(PythonParser.TrailerNoCallIndexContext ctx);
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
	 * Enter a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNotUnary(PythonParser.NotUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotUnary}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNotUnary(PythonParser.NotUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotComparison}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNotComparison(PythonParser.NotComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotComparison}
	 * labeled alternative in {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNotComparison(PythonParser.NotComparisonContext ctx);
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
	 * Enter a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterCompEq(PythonParser.CompEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitCompEq(PythonParser.CompEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterCompNotEq(PythonParser.CompNotEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompNotEq}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitCompNotEq(PythonParser.CompNotEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterCompIn(PythonParser.CompInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIn}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitCompIn(PythonParser.CompInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterCompIs(PythonParser.CompIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIs}
	 * labeled alternative in {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitCompIs(PythonParser.CompIsContext ctx);
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
	 * Enter a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerAttr(PythonParser.TrailerAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerAttr}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerAttr(PythonParser.TrailerAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerCall(PythonParser.TrailerCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerCall}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerCall(PythonParser.TrailerCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailerIndex(PythonParser.TrailerIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrailerIndex}
	 * labeled alternative in {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailerIndex(PythonParser.TrailerIndexContext ctx);
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
	 * Enter a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgKeyword(PythonParser.ArgKeywordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgKeyword}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgKeyword(PythonParser.ArgKeywordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgPositional(PythonParser.ArgPositionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgPositional}
	 * labeled alternative in {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgPositional(PythonParser.ArgPositionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomId(PythonParser.AtomIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomId}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomId(PythonParser.AtomIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomString(PythonParser.AtomStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomString}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomString(PythonParser.AtomStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomInt(PythonParser.AtomIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomInt}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomInt(PythonParser.AtomIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomFloat}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomFloat(PythonParser.AtomFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomFloat}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomFloat(PythonParser.AtomFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomNone}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomNone(PythonParser.AtomNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomNone}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomNone(PythonParser.AtomNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomTrue}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomTrue(PythonParser.AtomTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomTrue}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomTrue(PythonParser.AtomTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomFalse}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomFalse(PythonParser.AtomFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomFalse}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomFalse(PythonParser.AtomFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomList}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomList(PythonParser.AtomListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomList}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomList(PythonParser.AtomListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomDictOrSet}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomDictOrSet(PythonParser.AtomDictOrSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomDictOrSet}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomDictOrSet(PythonParser.AtomDictOrSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomParen(PythonParser.AtomParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomParen}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomParen(PythonParser.AtomParenContext ctx);
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
	 * Enter a parse tree produced by {@link PythonParser#nl}.
	 * @param ctx the parse tree
	 */
	void enterNl(PythonParser.NlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#nl}.
	 * @param ctx the parse tree
	 */
	void exitNl(PythonParser.NlContext ctx);
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