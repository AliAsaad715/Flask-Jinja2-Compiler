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
		STRING_VALUE=22, STRING_ESCAPE=23, STRING_END=24;
	public static final int
		RULE_program = 0, RULE_importing = 1, RULE_libraries = 2, RULE_declaration = 3, 
		RULE_value = 4, RULE_route = 5, RULE_function = 6, RULE_parameter = 7, 
		RULE_server_startup = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importing", "libraries", "declaration", "value", "route", 
			"function", "parameter", "server_startup"
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
			"SLASH", "STRING_VALUE", "STRING_ESCAPE", "STRING_END"
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
		public Server_startupContext server_startup() {
			return getRuleContext(Server_startupContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<ImportingContext> importing() {
			return getRuleContexts(ImportingContext.class);
		}
		public ImportingContext importing(int i) {
			return getRuleContext(ImportingContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
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
			int _alt;
			_localctx = new ProgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				importing();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FROM );
			setState(24); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(23);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(26); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DECORATOR) {
				{
				{
				setState(28);
				route();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			server_startup();
			setState(35);
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
			setState(37);
			match(FROM);
			setState(38);
			match(FLASK);
			setState(39);
			match(IMPORT);
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				libraries();
				}
				}
				setState(43); 
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
			setState(45);
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
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DeclContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			_localctx = new DeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(ID);
			setState(48);
			match(EQUAL);
			setState(49);
			value();
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
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class String_ValueContext extends ValueContext {
		public TerminalNode SINGLE_QUOTES() { return getToken(PythonParser.SINGLE_QUOTES, 0); }
		public TerminalNode STRING_END() { return getToken(PythonParser.STRING_END, 0); }
		public TerminalNode STRING_VALUE() { return getToken(PythonParser.STRING_VALUE, 0); }
		public String_ValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterString_Value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitString_Value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitString_Value(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Int_ValueContext extends ValueContext {
		public TerminalNode INT_VALUE() { return getToken(PythonParser.INT_VALUE, 0); }
		public Int_ValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInt_Value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInt_Value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitInt_Value(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppValueContext extends ValueContext {
		public TerminalNode FLASK_LIBRARY() { return getToken(PythonParser.FLASK_LIBRARY, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode APP_NAME() { return getToken(PythonParser.APP_NAME, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public AppValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAppValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAppValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAppValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTES:
				_localctx = new String_ValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(SINGLE_QUOTES);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_VALUE) {
					{
					setState(52);
					match(STRING_VALUE);
					}
				}

				setState(55);
				match(STRING_END);
				}
				break;
			case INT_VALUE:
				_localctx = new Int_ValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(INT_VALUE);
				}
				break;
			case FLASK_LIBRARY:
				_localctx = new AppValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(FLASK_LIBRARY);
				setState(58);
				match(OPEN_B);
				setState(59);
				match(APP_NAME);
				setState(60);
				match(CLOSE_B);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TerminalNode STRING_VALUE() { return getToken(PythonParser.STRING_VALUE, 0); }
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
		enterRule(_localctx, 10, RULE_route);
		int _la;
		try {
			_localctx = new RoutesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(DECORATOR);
			setState(64);
			match(ID);
			setState(65);
			match(DOT);
			setState(66);
			match(ROUTE);
			setState(67);
			match(OPEN_B);
			setState(68);
			match(SINGLE_QUOTES);
			setState(69);
			match(SLASH);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING_VALUE) {
				{
				setState(70);
				match(STRING_VALUE);
				}
			}

			setState(73);
			match(STRING_END);
			setState(74);
			match(CLOSE_B);
			setState(75);
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
		public List<TerminalNode> ID() { return getTokens(PythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PythonParser.ID, i);
		}
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TerminalNode RETURN() { return getToken(PythonParser.RETURN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
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
		enterRule(_localctx, 12, RULE_function);
		int _la;
		try {
			_localctx = new FunctionsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(DEFINETION);
			setState(78);
			match(ID);
			setState(79);
			match(OPEN_B);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(80);
				parameter();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(CLOSE_B);
			setState(87);
			match(COLON);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(88);
				declaration();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(RETURN);
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(95);
				match(ID);
				}
				break;
			case FLASK_LIBRARY:
			case SINGLE_QUOTES:
			case INT_VALUE:
				{
				setState(96);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParameterContext {
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public ParamsContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			_localctx = new ParamsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
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
	public static class RunServerContext extends Server_startupContext {
		public TerminalNode ID() { return getToken(PythonParser.ID, 0); }
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public TerminalNode RUN() { return getToken(PythonParser.RUN, 0); }
		public TerminalNode OPEN_B() { return getToken(PythonParser.OPEN_B, 0); }
		public TerminalNode CLOSE_B() { return getToken(PythonParser.CLOSE_B, 0); }
		public RunServerContext(Server_startupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRunServer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRunServer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitRunServer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Server_startupContext server_startup() throws RecognitionException {
		Server_startupContext _localctx = new Server_startupContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_server_startup);
		try {
			_localctx = new RunServerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(ID);
			setState(102);
			match(DOT);
			setState(103);
			match(RUN);
			setState(104);
			match(OPEN_B);
			setState(105);
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
		"\u0004\u0001\u0018l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015"+
		"\u0001\u0000\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001"+
		"\u0000\u0005\u0000\u001e\b\u0000\n\u0000\f\u0000!\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001*\b\u0001\u000b\u0001\f\u0001+\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003"+
		"\u00046\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004>\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005H\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006R\b\u0006\n\u0006"+
		"\f\u0006U\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006Z\b\u0006"+
		"\n\u0006\f\u0006]\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"b\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0000\u0000m\u0000\u0013\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000"+
		"\u0000\u0004-\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b"+
		"=\u0001\u0000\u0000\u0000\n?\u0001\u0000\u0000\u0000\fM\u0001\u0000\u0000"+
		"\u0000\u000ec\u0001\u0000\u0000\u0000\u0010e\u0001\u0000\u0000\u0000\u0012"+
		"\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014"+
		"\u0015\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017"+
		"\u0019\u0003\u0006\u0003\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b\u001f\u0001\u0000\u0000\u0000\u001c"+
		"\u001e\u0003\n\u0005\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!"+
		"\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000\"#\u0003\u0010\b\u0000#$\u0005\u0000\u0000\u0001$\u0001\u0001\u0000"+
		"\u0000\u0000%&\u0005\u0001\u0000\u0000&\'\u0005\u0003\u0000\u0000\')\u0005"+
		"\u0002\u0000\u0000(*\u0003\u0004\u0002\u0000)(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0005\u0004\u0000\u0000.\u0005"+
		"\u0001\u0000\u0000\u0000/0\u0005\u0011\u0000\u000001\u0005\t\u0000\u0000"+
		"12\u0003\b\u0004\u00002\u0007\u0001\u0000\u0000\u000035\u0005\u0010\u0000"+
		"\u000046\u0005\u0016\u0000\u000054\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u00007>\u0005\u0018\u0000\u00008>\u0005"+
		"\u0012\u0000\u00009:\u0005\u0004\u0000\u0000:;\u0005\n\u0000\u0000;<\u0005"+
		"\f\u0000\u0000<>\u0005\u000b\u0000\u0000=3\u0001\u0000\u0000\u0000=8\u0001"+
		"\u0000\u0000\u0000=9\u0001\u0000\u0000\u0000>\t\u0001\u0000\u0000\u0000"+
		"?@\u0005\r\u0000\u0000@A\u0005\u0011\u0000\u0000AB\u0005\u000e\u0000\u0000"+
		"BC\u0005\u000f\u0000\u0000CD\u0005\n\u0000\u0000DE\u0005\u0010\u0000\u0000"+
		"EG\u0005\u0015\u0000\u0000FH\u0005\u0016\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\u0018"+
		"\u0000\u0000JK\u0005\u000b\u0000\u0000KL\u0003\f\u0006\u0000L\u000b\u0001"+
		"\u0000\u0000\u0000MN\u0005\u0005\u0000\u0000NO\u0005\u0011\u0000\u0000"+
		"OS\u0005\n\u0000\u0000PR\u0003\u000e\u0007\u0000QP\u0001\u0000\u0000\u0000"+
		"RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\u000b"+
		"\u0000\u0000W[\u0005\u0006\u0000\u0000XZ\u0003\u0006\u0003\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^a\u0005\u0007\u0000\u0000_b\u0005\u0011\u0000\u0000`b\u0003\b\u0004"+
		"\u0000a_\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000b\r\u0001\u0000"+
		"\u0000\u0000cd\u0005\u0011\u0000\u0000d\u000f\u0001\u0000\u0000\u0000"+
		"ef\u0005\u0011\u0000\u0000fg\u0005\u000e\u0000\u0000gh\u0005\b\u0000\u0000"+
		"hi\u0005\n\u0000\u0000ij\u0005\u000b\u0000\u0000j\u0011\u0001\u0000\u0000"+
		"\u0000\n\u0015\u001a\u001f+5=GS[a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}