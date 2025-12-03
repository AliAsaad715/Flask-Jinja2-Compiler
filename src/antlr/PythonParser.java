// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Project/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FROM=1, IMPORT=2, FLASK=3, FLASK_LIBRARY=4, DEFINETION=5, COLON=6, RETURN=7, 
		RUN=8, EQUAL=9, OPEN_B=10, CLOSE_B=11, APP_NAME=12, DECORATOR=13, DOT=14, 
		ROUTE=15, SINGLE_QUOTES=16, ID=17, INT_VALUE=18, WS=19, NEWLINE=20, SLASH=21, 
		STRING_TEXT=22, STRING_ESCAPE=23, STRING_END=24;
	public static final int
		RULE_program = 0, RULE_importing = 1, RULE_libraries = 2, RULE_app_initialization = 3, 
		RULE_route = 4, RULE_function = 5, RULE_server_startup = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importing", "libraries", "app_initialization", "route", "function", 
			"server_startup"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'from'", "'import'", "'flask'", "'Flask'", "'def'", "':'", "'return'", 
			"'run'", "'='", "'('", "')'", "'__name__'", "'@'", "'.'", "'route'", 
			null, null, null, null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FROM", "IMPORT", "FLASK", "FLASK_LIBRARY", "DEFINETION", "COLON", 
			"RETURN", "RUN", "EQUAL", "OPEN_B", "CLOSE_B", "APP_NAME", "DECORATOR", 
			"DOT", "ROUTE", "SINGLE_QUOTES", "ID", "INT_VALUE", "WS", "NEWLINE", 
			"SLASH", "STRING_TEXT", "STRING_ESCAPE", "STRING_END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PythonParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ProgramContext {
		public ImportingContext importing() {
			return getRuleContext(ImportingContext.class,0);
		}
		public App_initializationContext app_initialization() {
			return getRuleContext(App_initializationContext.class,0);
		}
		public Server_startupContext server_startup() {
			return getRuleContext(Server_startupContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<RouteContext> route() {
			return getRuleContexts(RouteContext.class);
		}
		public RouteContext route(int i) {
			return getRuleContext(RouteContext.class,i);
		}
		public ProgContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			importing();
			setState(15);
			app_initialization();
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DECORATOR) {
				{
				{
				setState(16);
				route();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			server_startup();
			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportingContext extends ParserRuleContext {
		public ImportingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importing; }
	 
		public ImportingContext() { }
		public void copyFrom(ImportingContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportContext extends ImportingContext {
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public TerminalNode FLASK() { return getToken(PythonParser.FLASK, 0); }
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public List<LibrariesContext> libraries() {
			return getRuleContexts(LibrariesContext.class);
		}
		public LibrariesContext libraries(int i) {
			return getRuleContext(LibrariesContext.class,i);
		}
		public ImportContext(ImportingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportingContext importing() throws RecognitionException {
		ImportingContext _localctx = new ImportingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importing);
		int _la;
		try {
			_localctx = new ImportContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(FROM);
			setState(26);
			match(FLASK);
			setState(27);
			match(IMPORT);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				libraries();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLASK_LIBRARY );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LibrariesContext extends ParserRuleContext {
		public LibrariesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraries; }
	 
		public LibrariesContext() { }
		public void copyFrom(LibrariesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LibraryContext extends LibrariesContext {
		public TerminalNode FLASK_LIBRARY() { return getToken(PythonParser.FLASK_LIBRARY, 0); }
		public LibraryContext(LibrariesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLibrary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLibrary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLibrary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibrariesContext libraries() throws RecognitionException {
		LibrariesContext _localctx = new LibrariesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_libraries);
		try {
			_localctx = new LibraryContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(FLASK_LIBRARY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class App_initializationContext extends ParserRuleContext {
		public App_initializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_app_initialization; }
	 
		public App_initializationContext() { }
		public void copyFrom(App_initializationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class App_InitializeContext extends App_initializationContext {
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public TerminalNode FLASK_LIBRARY() { return getToken(PythonParser.FLASK_LIBRARY, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode APP_NAME() { return getToken(PythonParser.APP_NAME, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public App_InitializeContext(App_initializationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterApp_Initialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitApp_Initialize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitApp_Initialize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final App_initializationContext app_initialization() throws RecognitionException {
		App_initializationContext _localctx = new App_initializationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_app_initialization);
		try {
			_localctx = new App_InitializeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(ID);
			setState(36);
			match(EQUAL);
			setState(37);
			match(FLASK_LIBRARY);
			setState(38);
			match(OPEN_B);
			setState(39);
			match(APP_NAME);
			setState(40);
			match(CLOSE_B);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteContext extends ParserRuleContext {
		public RouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_route; }
	 
		public RouteContext() { }
		public void copyFrom(RouteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RoutesContext extends RouteContext {
		public TerminalNode DECORATOR() { return getToken(PythonParser.DECORATOR, 0); }
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public TerminalNode ROUTE() { return getToken(PythonParser.ROUTE, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode SINGLE_QUOTES() { return getToken(PythonParser.SINGLE_QUOTES, 0); }
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public TerminalNode STRING_END() { return getToken(PythonParser.STRING_END, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<TerminalNode> STRING_TEXT() { return getTokens(PythonParser.STRING_TEXT); }
		public TerminalNode STRING_TEXT(int i) {
			return getToken(PythonParser.STRING_TEXT, i);
		}
		public List<TerminalNode> INT_VALUE() { return getTokens(PythonParser.INT_VALUE); }
		public TerminalNode INT_VALUE(int i) {
			return getToken(PythonParser.INT_VALUE, i);
		}
		public RoutesContext(RouteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRoutes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRoutes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitRoutes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteContext route() throws RecognitionException {
		RouteContext _localctx = new RouteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_route);
		int _la;
		try {
			_localctx = new RoutesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(DECORATOR);
			setState(43);
			match(ID);
			setState(44);
			match(DOT);
			setState(45);
			match(ROUTE);
			setState(46);
			match(OPEN_B);
			setState(47);
			match(SINGLE_QUOTES);
			setState(48);
			match(SLASH);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING_TEXT) {
				{
				{
				setState(49);
				match(STRING_TEXT);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT_VALUE) {
				{
				{
				setState(55);
				match(INT_VALUE);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(STRING_END);
			setState(62);
			match(CLOSE_B);
			setState(63);
			function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsContext extends FunctionContext {
		public TerminalNode DEFINETION() { return getToken(PythonParser.DEFINETION, 0); }
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TerminalNode RETURN() { return getToken(PythonParser.RETURN, 0); }
		public TerminalNode SINGLE_QUOTES() { return getToken(PythonParser.SINGLE_QUOTES, 0); }
		public TerminalNode STRING_TEXT() { return getToken(PythonParser.STRING_TEXT, 0); }
		public TerminalNode STRING_END() { return getToken(PythonParser.STRING_END, 0); }
		public FunctionsContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		try {
			_localctx = new FunctionsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(DEFINETION);
			setState(66);
			match(ID);
			setState(67);
			match(OPEN_B);
			setState(68);
			match(CLOSE_B);
			setState(69);
			match(COLON);
			setState(70);
			match(RETURN);
			setState(71);
			match(SINGLE_QUOTES);
			setState(72);
			match(STRING_TEXT);
			setState(73);
			match(STRING_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Server_startupContext extends ParserRuleContext {
		public Server_startupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_server_startup; }
	 
		public Server_startupContext() { }
		public void copyFrom(Server_startupContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Run_ServerContext extends Server_startupContext {
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public TerminalNode RUN() { return getToken(PythonParser.RUN, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public Run_ServerContext(Server_startupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRun_Server(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRun_Server(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitRun_Server(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Server_startupContext server_startup() throws RecognitionException {
		Server_startupContext _localctx = new Server_startupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_server_startup);
		try {
			_localctx = new Run_ServerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(ID);
			setState(76);
			match(DOT);
			setState(77);
			match(RUN);
			setState(78);
			match(OPEN_B);
			setState(79);
			match(CLOSE_B);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018R\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u00043\b\u0004\n\u0004"+
		"\f\u00046\t\u0004\u0001\u0004\u0005\u00049\b\u0004\n\u0004\f\u0004<\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002"+
		"\u0004\u0006\b\n\f\u0000\u0000N\u0000\u000e\u0001\u0000\u0000\u0000\u0002"+
		"\u0019\u0001\u0000\u0000\u0000\u0004!\u0001\u0000\u0000\u0000\u0006#\u0001"+
		"\u0000\u0000\u0000\b*\u0001\u0000\u0000\u0000\nA\u0001\u0000\u0000\u0000"+
		"\fK\u0001\u0000\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f"+
		"\u0013\u0003\u0006\u0003\u0000\u0010\u0012\u0003\b\u0004\u0000\u0011\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013\u0011"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0016"+
		"\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0003\f\u0006\u0000\u0017\u0018\u0005\u0000\u0000\u0001\u0018\u0001\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0005\u0001\u0000\u0000\u001a\u001b\u0005"+
		"\u0003\u0000\u0000\u001b\u001d\u0005\u0002\u0000\u0000\u001c\u001e\u0003"+
		"\u0004\u0002\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000"+
		"\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!\"\u0005\u0004\u0000\u0000"+
		"\"\u0005\u0001\u0000\u0000\u0000#$\u0005\u0011\u0000\u0000$%\u0005\t\u0000"+
		"\u0000%&\u0005\u0004\u0000\u0000&\'\u0005\n\u0000\u0000\'(\u0005\f\u0000"+
		"\u0000()\u0005\u000b\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0005"+
		"\r\u0000\u0000+,\u0005\u0011\u0000\u0000,-\u0005\u000e\u0000\u0000-.\u0005"+
		"\u000f\u0000\u0000./\u0005\n\u0000\u0000/0\u0005\u0010\u0000\u000004\u0005"+
		"\u0015\u0000\u000013\u0005\u0016\u0000\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u00005:\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000079\u0005\u0012"+
		"\u0000\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000=>\u0005\u0018\u0000\u0000>?\u0005\u000b\u0000"+
		"\u0000?@\u0003\n\u0005\u0000@\t\u0001\u0000\u0000\u0000AB\u0005\u0005"+
		"\u0000\u0000BC\u0005\u0011\u0000\u0000CD\u0005\n\u0000\u0000DE\u0005\u000b"+
		"\u0000\u0000EF\u0005\u0006\u0000\u0000FG\u0005\u0007\u0000\u0000GH\u0005"+
		"\u0010\u0000\u0000HI\u0005\u0016\u0000\u0000IJ\u0005\u0018\u0000\u0000"+
		"J\u000b\u0001\u0000\u0000\u0000KL\u0005\u0011\u0000\u0000LM\u0005\u000e"+
		"\u0000\u0000MN\u0005\b\u0000\u0000NO\u0005\n\u0000\u0000OP\u0005\u000b"+
		"\u0000\u0000P\r\u0001\u0000\u0000\u0000\u0004\u0013\u001f4:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}