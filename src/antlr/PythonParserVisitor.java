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
	 * Visit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link PythonParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(PythonParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_Value(PythonParser.String_ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int_Value}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_Value(PythonParser.Int_ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AppValue}
	 * labeled alternative in {@link PythonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppValue(PythonParser.AppValueContext ctx);
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
	 * Visit a parse tree produced by the {@code Params}
	 * labeled alternative in {@link PythonParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(PythonParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RunServer}
	 * labeled alternative in {@link PythonParser#server_startup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunServer(PythonParser.RunServerContext ctx);
}