// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Project/src/antlr/PythonParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link PythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(PythonParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Import}
	 * labeled alternative in {@link PythonParser#importing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport(PythonParser.ImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Library}
	 * labeled alternative in {@link PythonParser#libraries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibrary(PythonParser.LibraryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code App_Initialize}
	 * labeled alternative in {@link PythonParser#app_initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp_Initialize(PythonParser.App_InitializeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Routes}
	 * labeled alternative in {@link PythonParser#route}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutes(PythonParser.RoutesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Functions}
	 * labeled alternative in {@link PythonParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(PythonParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Run_Server}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun_Server(PythonParser.Run_ServerContext ctx);
}