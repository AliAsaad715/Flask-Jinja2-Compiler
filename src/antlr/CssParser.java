// Generated from C:/Users/Abdulrahman_kwm/ProjectStudio/Flask-Jinja2-Compiler/src/antlr/CssParser.g4 by ANTLR 4.13.2
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
public class CssParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WS=2, LBRACE=3, RBRACE=4, COLON=5, SEMI=6, COMMA=7, LPAREN=8, 
		RPAREN=9, PERCENT=10, PLUS=11, MINUS=12, STAR=13, SLASH=14, DOT=15, HASH=16, 
		COLOR=17, NUMBER=18, STRING=19, IDENT=20;
	public static final int
		RULE_stylesheet = 0, RULE_cssRule = 1, RULE_selector = 2, RULE_selectorPart = 3, 
		RULE_decl = 4, RULE_value = 5, RULE_valuePart = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"stylesheet", "cssRule", "selector", "selectorPart", "decl", "value", 
			"valuePart"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'{'", "'}'", "':'", "';'", "','", "'('", "')'", "'%'", 
			"'+'", "'-'", "'*'", "'/'", "'.'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "WS", "LBRACE", "RBRACE", "COLON", "SEMI", "COMMA", 
			"LPAREN", "RPAREN", "PERCENT", "PLUS", "MINUS", "STAR", "SLASH", "DOT", 
			"HASH", "COLOR", "NUMBER", "STRING", "IDENT"
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
	public String getGrammarFileName() { return "CssParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CssParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CssParser.EOF, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1147040L) != 0)) {
				{
				{
				setState(14);
				cssRule();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
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
	public static class CssRuleContext extends ParserRuleContext {
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
	 
		public CssRuleContext() { }
		public void copyFrom(CssRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleDefContext extends CssRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(CssParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CssParser.RBRACE, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public CssRuleDefContext(CssRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterCssRuleDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitCssRuleDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitCssRuleDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cssRule);
		int _la;
		try {
			_localctx = new CssRuleDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			selector();
			setState(23);
			match(LBRACE);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(24);
				decl();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(RBRACE);
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
	public static class SelectorContext extends ParserRuleContext {
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
	 
		public SelectorContext() { }
		public void copyFrom(SelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorSeqContext extends SelectorContext {
		public List<SelectorPartContext> selectorPart() {
			return getRuleContexts(SelectorPartContext.class);
		}
		public SelectorPartContext selectorPart(int i) {
			return getRuleContext(SelectorPartContext.class,i);
		}
		public SelectorSeqContext(SelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelectorSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelectorSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelectorSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selector);
		int _la;
		try {
			_localctx = new SelectorSeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				selectorPart();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1147040L) != 0) );
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
	public static class SelectorPartContext extends ParserRuleContext {
		public SelectorPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorPart; }
	 
		public SelectorPartContext() { }
		public void copyFrom(SelectorPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelIdentContext extends SelectorPartContext {
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public SelIdentContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelIdContext extends SelectorPartContext {
		public TerminalNode HASH() { return getToken(CssParser.HASH, 0); }
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public SelIdContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelPseudoContext extends SelectorPartContext {
		public TerminalNode COLON() { return getToken(CssParser.COLON, 0); }
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public SelPseudoContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelPseudo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelPseudo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelPseudo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelClassContext extends SelectorPartContext {
		public TerminalNode DOT() { return getToken(CssParser.DOT, 0); }
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public SelClassContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelClass(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelCommaContext extends SelectorPartContext {
		public TerminalNode COMMA() { return getToken(CssParser.COMMA, 0); }
		public SelCommaContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterSelComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitSelComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitSelComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorPartContext selectorPart() throws RecognitionException {
		SelectorPartContext _localctx = new SelectorPartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectorPart);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				_localctx = new SelIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(IDENT);
				}
				break;
			case DOT:
				_localctx = new SelClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(DOT);
				setState(39);
				match(IDENT);
				}
				break;
			case HASH:
				_localctx = new SelIdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(HASH);
				setState(41);
				match(IDENT);
				}
				break;
			case COMMA:
				_localctx = new SelCommaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				match(COMMA);
				}
				break;
			case COLON:
				_localctx = new SelPseudoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				match(COLON);
				setState(44);
				match(IDENT);
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
	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends DeclContext {
		public Token property;
		public TerminalNode COLON() { return getToken(CssParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CssParser.SEMI, 0); }
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public DeclarationContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		try {
			_localctx = new DeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((DeclarationContext)_localctx).property = match(IDENT);
			setState(48);
			match(COLON);
			setState(49);
			value();
			setState(50);
			match(SEMI);
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
	public static class ValueSeqContext extends ValueContext {
		public List<ValuePartContext> valuePart() {
			return getRuleContexts(ValuePartContext.class);
		}
		public ValuePartContext valuePart(int i) {
			return getRuleContext(ValuePartContext.class,i);
		}
		public ValueSeqContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValueSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValueSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValueSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		int _la;
		try {
			_localctx = new ValueSeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				valuePart();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2097024L) != 0) );
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
	public static class ValuePartContext extends ParserRuleContext {
		public ValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuePart; }
	 
		public ValuePartContext() { }
		public void copyFrom(ValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValDotContext extends ValuePartContext {
		public TerminalNode DOT() { return getToken(CssParser.DOT, 0); }
		public ValDotContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValDot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValNumberContext extends ValuePartContext {
		public TerminalNode NUMBER() { return getToken(CssParser.NUMBER, 0); }
		public ValNumberContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValStarContext extends ValuePartContext {
		public TerminalNode STAR() { return getToken(CssParser.STAR, 0); }
		public ValStarContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValStar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValCommaContext extends ValuePartContext {
		public TerminalNode COMMA() { return getToken(CssParser.COMMA, 0); }
		public ValCommaContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValLParenContext extends ValuePartContext {
		public TerminalNode LPAREN() { return getToken(CssParser.LPAREN, 0); }
		public ValLParenContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValLParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValLParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValLParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValRParenContext extends ValuePartContext {
		public TerminalNode RPAREN() { return getToken(CssParser.RPAREN, 0); }
		public ValRParenContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValRParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValRParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValRParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValSlashContext extends ValuePartContext {
		public TerminalNode SLASH() { return getToken(CssParser.SLASH, 0); }
		public ValSlashContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValPlusContext extends ValuePartContext {
		public TerminalNode PLUS() { return getToken(CssParser.PLUS, 0); }
		public ValPlusContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValIdentContext extends ValuePartContext {
		public TerminalNode IDENT() { return getToken(CssParser.IDENT, 0); }
		public ValIdentContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValColorContext extends ValuePartContext {
		public TerminalNode COLOR() { return getToken(CssParser.COLOR, 0); }
		public ValColorContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValColor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValMinusContext extends ValuePartContext {
		public TerminalNode MINUS() { return getToken(CssParser.MINUS, 0); }
		public ValMinusContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValStringContext extends ValuePartContext {
		public TerminalNode STRING() { return getToken(CssParser.STRING, 0); }
		public ValStringContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValHashContext extends ValuePartContext {
		public TerminalNode HASH() { return getToken(CssParser.HASH, 0); }
		public ValHashContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValHash(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValPercentContext extends ValuePartContext {
		public TerminalNode PERCENT() { return getToken(CssParser.PERCENT, 0); }
		public ValPercentContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).enterValPercent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CssParserListener ) ((CssParserListener)listener).exitValPercent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CssParserVisitor ) return ((CssParserVisitor<? extends T>)visitor).visitValPercent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuePartContext valuePart() throws RecognitionException {
		ValuePartContext _localctx = new ValuePartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_valuePart);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				_localctx = new ValIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(IDENT);
				}
				break;
			case NUMBER:
				_localctx = new ValNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new ValStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(STRING);
				}
				break;
			case COLOR:
				_localctx = new ValColorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(COLOR);
				}
				break;
			case DOT:
				_localctx = new ValDotContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				match(DOT);
				}
				break;
			case HASH:
				_localctx = new ValHashContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				match(HASH);
				}
				break;
			case COMMA:
				_localctx = new ValCommaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(63);
				match(COMMA);
				}
				break;
			case PERCENT:
				_localctx = new ValPercentContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(64);
				match(PERCENT);
				}
				break;
			case PLUS:
				_localctx = new ValPlusContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(65);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new ValMinusContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(66);
				match(MINUS);
				}
				break;
			case STAR:
				_localctx = new ValStarContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(67);
				match(STAR);
				}
				break;
			case SLASH:
				_localctx = new ValSlashContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(68);
				match(SLASH);
				}
				break;
			case LPAREN:
				_localctx = new ValLParenContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(69);
				match(LPAREN);
				}
				break;
			case RPAREN:
				_localctx = new ValRParenContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(70);
				match(RPAREN);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014J\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u001a\b\u0001\n\u0001\f\u0001\u001d"+
		"\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002\"\b\u0002\u000b"+
		"\u0002\f\u0002#\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003.\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004"+
		"\u00056\b\u0005\u000b\u0005\f\u00057\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"H\b\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f"+
		"\u0000\u0000W\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0016\u0001\u0000"+
		"\u0000\u0000\u0004!\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000"+
		"\b/\u0001\u0000\u0000\u0000\n5\u0001\u0000\u0000\u0000\fG\u0001\u0000"+
		"\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u000e\u0001\u0000"+
		"\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000"+
		"\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0000"+
		"\u0000\u0001\u0015\u0001\u0001\u0000\u0000\u0000\u0016\u0017\u0003\u0004"+
		"\u0002\u0000\u0017\u001b\u0005\u0003\u0000\u0000\u0018\u001a\u0003\b\u0004"+
		"\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001d\u0001\u0000\u0000"+
		"\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000"+
		"\u0000\u001c\u001e\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0005\u0004\u0000\u0000\u001f\u0003\u0001\u0000\u0000"+
		"\u0000 \"\u0003\u0006\u0003\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0005"+
		"\u0001\u0000\u0000\u0000%.\u0005\u0014\u0000\u0000&\'\u0005\u000f\u0000"+
		"\u0000\'.\u0005\u0014\u0000\u0000()\u0005\u0010\u0000\u0000).\u0005\u0014"+
		"\u0000\u0000*.\u0005\u0007\u0000\u0000+,\u0005\u0005\u0000\u0000,.\u0005"+
		"\u0014\u0000\u0000-%\u0001\u0000\u0000\u0000-&\u0001\u0000\u0000\u0000"+
		"-(\u0001\u0000\u0000\u0000-*\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000.\u0007\u0001\u0000\u0000\u0000/0\u0005\u0014\u0000\u000001\u0005"+
		"\u0005\u0000\u000012\u0003\n\u0005\u000023\u0005\u0006\u0000\u00003\t"+
		"\u0001\u0000\u0000\u000046\u0003\f\u0006\u000054\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008\u000b\u0001\u0000\u0000\u00009H\u0005\u0014\u0000\u0000:H\u0005"+
		"\u0012\u0000\u0000;H\u0005\u0013\u0000\u0000<H\u0005\u0011\u0000\u0000"+
		"=H\u0005\u000f\u0000\u0000>H\u0005\u0010\u0000\u0000?H\u0005\u0007\u0000"+
		"\u0000@H\u0005\n\u0000\u0000AH\u0005\u000b\u0000\u0000BH\u0005\f\u0000"+
		"\u0000CH\u0005\r\u0000\u0000DH\u0005\u000e\u0000\u0000EH\u0005\b\u0000"+
		"\u0000FH\u0005\t\u0000\u0000G9\u0001\u0000\u0000\u0000G:\u0001\u0000\u0000"+
		"\u0000G;\u0001\u0000\u0000\u0000G<\u0001\u0000\u0000\u0000G=\u0001\u0000"+
		"\u0000\u0000G>\u0001\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000G@\u0001"+
		"\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GB\u0001\u0000\u0000\u0000"+
		"GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GF\u0001\u0000\u0000\u0000H\r\u0001\u0000\u0000\u0000\u0006\u0011"+
		"\u001b#-7G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}