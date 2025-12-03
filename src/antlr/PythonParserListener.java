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
	 * Enter a parse tree produced by the {@code App_Initialize}
	 * labeled alternative in {@link PythonParser#app_initialization}.
	 * @param ctx the parse tree
	 */
	void enterApp_Initialize(PythonParser.App_InitializeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code App_Initialize}
	 * labeled alternative in {@link PythonParser#app_initialization}.
	 * @param ctx the parse tree
	 */
	void exitApp_Initialize(PythonParser.App_InitializeContext ctx);
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
	 * Enter a parse tree produced by the {@code Run_Server}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 */
	void enterRun_Server(PythonParser.Run_ServerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Run_Server}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 */
	void exitRun_Server(PythonParser.Run_ServerContext ctx);
}