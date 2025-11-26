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
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link PythonParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PythonParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link PythonParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PythonParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PythonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PythonParser.ValueContext ctx);
}