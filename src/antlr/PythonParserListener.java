// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Project/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProg(PythonParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProg(PythonParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import}
	 * labeled alternative in {@link PythonParser#importing}.
	 * @param ctx the parse tree
	 */
	void enterImport(PythonParser.ImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import}
	 * labeled alternative in {@link PythonParser#importing}.
	 * @param ctx the parse tree
	 */
	void exitImport(PythonParser.ImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Library}
	 * labeled alternative in {@link PythonParser#libraries}.
	 * @param ctx the parse tree
	 */
	void enterLibrary(PythonParser.LibraryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Library}
	 * labeled alternative in {@link PythonParser#libraries}.
	 * @param ctx the parse tree
	 */
	void exitLibrary(PythonParser.LibraryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link PythonParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDecl(PythonParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link PythonParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDecl(PythonParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString_Value(PythonParser.String_ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString_Value(PythonParser.String_ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInt_Value(PythonParser.Int_ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInt_Value(PythonParser.Int_ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AppValue}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAppValue(PythonParser.AppValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AppValue}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAppValue(PythonParser.AppValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Routes}
	 * labeled alternative in {@link PythonParser#route}.
	 * @param ctx the parse tree
	 */
	void enterRoutes(PythonParser.RoutesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Routes}
	 * labeled alternative in {@link PythonParser#route}.
	 * @param ctx the parse tree
	 */
	void exitRoutes(PythonParser.RoutesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Functions}
	 * labeled alternative in {@link PythonParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(PythonParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Functions}
	 * labeled alternative in {@link PythonParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(PythonParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Params}
	 * labeled alternative in {@link PythonParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParams(PythonParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Params}
	 * labeled alternative in {@link PythonParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParams(PythonParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RunServer}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 */
	void enterRunServer(PythonParser.RunServerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RunServer}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 */
	void exitRunServer(PythonParser.RunServerContext ctx);
}