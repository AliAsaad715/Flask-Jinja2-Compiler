// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/TemplateParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
 import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ATTR_TEXT=1, LPAREN=2, RPAREN=3, LBRACK=4, RBRACK=5, COMMA=6, DOT=7, COLON=8, 
		PIPE=9, GE=10, LE=11, EQEQ=12, NE=13, GT=14, LT=15, PLUS=16, MINUS=17, 
		STAR=18, SLASH=19, INT=20, STRING=21, ID=22, JINJA_EXPR_OPEN=23, JINJA_STMT_OPEN=24, 
		TAG_OPEN=25, TEXT=26, TAG_SELF_CLOSE=27, TAG_CLOSE=28, TAG_SLASH=29, EQ=30, 
		DQUOTE=31, SQUOTE=32, TAG_NAME=33, TAG_WS=34, JINJA_EXPR_CLOSE=35, JINJA_WS_E=36, 
		JINJA_STMT_CLOSE=37, JINJA_WS_S=38, EXTENDS=39, BLOCK=40, ENDBLOCK=41, 
		FOR=42, IN=43, ENDFOR=44, IF=45, ELIF=46, ELSE=47, ENDIF=48, SET=49, LPAREN_E=50, 
		RPAREN_E=51, LBRACK_E=52, RBRACK_E=53, COMMA_E=54, DOT_E=55, COLON_E=56, 
		PIPE_E=57, GE_E=58, LE_E=59, EQEQ_E=60, NE_E=61, PLUS_E=62, MINUS_E=63, 
		STAR_E=64;
	public static final int
		RULE_template = 0, RULE_item = 1, RULE_htmlText = 2, RULE_htmlElement = 3, 
		RULE_normalElement = 4, RULE_openTag = 5, RULE_closeTag = 6, RULE_selfClosingElement = 7, 
		RULE_attribute = 8, RULE_attrValue = 9, RULE_attrValuePart = 10, RULE_jinjaExtends = 11, 
		RULE_jinjaBlock = 12, RULE_jinjaFor = 13, RULE_jinjaIf = 14, RULE_jinjaElif = 15, 
		RULE_jinjaElse = 16, RULE_jinjaPrint = 17, RULE_expr = 18, RULE_exprUnit = 19, 
		RULE_atom = 20, RULE_op = 21, RULE_punct = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "item", "htmlText", "htmlElement", "normalElement", "openTag", 
			"closeTag", "selfClosingElement", "attribute", "attrValue", "attrValuePart", 
			"jinjaExtends", "jinjaBlock", "jinjaFor", "jinjaIf", "jinjaElif", "jinjaElse", 
			"jinjaPrint", "expr", "exprUnit", "atom", "op", "punct"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'{{'", 
			"'{%'", null, null, "'/>'", null, null, null, null, null, null, null, 
			"'}}'", null, "'%}'", null, "'extends'", "'block'", "'endblock'", "'for'", 
			"'in'", "'endfor'", "'if'", "'elif'", "'else'", "'endif'", "'set'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ATTR_TEXT", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", 
			"COLON", "PIPE", "GE", "LE", "EQEQ", "NE", "GT", "LT", "PLUS", "MINUS", 
			"STAR", "SLASH", "INT", "STRING", "ID", "JINJA_EXPR_OPEN", "JINJA_STMT_OPEN", 
			"TAG_OPEN", "TEXT", "TAG_SELF_CLOSE", "TAG_CLOSE", "TAG_SLASH", "EQ", 
			"DQUOTE", "SQUOTE", "TAG_NAME", "TAG_WS", "JINJA_EXPR_CLOSE", "JINJA_WS_E", 
			"JINJA_STMT_CLOSE", "JINJA_WS_S", "EXTENDS", "BLOCK", "ENDBLOCK", "FOR", 
			"IN", "ENDFOR", "IF", "ELIF", "ELSE", "ENDIF", "SET", "LPAREN_E", "RPAREN_E", 
			"LBRACK_E", "RBRACK_E", "COMMA_E", "DOT_E", "COLON_E", "PIPE_E", "GE_E", 
			"LE_E", "EQEQ_E", "NE_E", "PLUS_E", "MINUS_E", "STAR_E"
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
	public String getGrammarFileName() { return "TemplateParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TemplateParser.EOF, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				{
				setState(46);
				item();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForItemContext extends ItemContext {
		public JinjaForContext jinjaFor() {
			return getRuleContext(JinjaForContext.class,0);
		}
		public JinjaForItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaForItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaForItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaForItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementItemContext extends ItemContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlElementItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlElementItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlElementItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlElementItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextItemContext extends ItemContext {
		public HtmlTextContext htmlText() {
			return getRuleContext(HtmlTextContext.class,0);
		}
		public HtmlTextItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlTextItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlTextItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlTextItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockItemContext extends ItemContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public JinjaBlockItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfItemContext extends ItemContext {
		public JinjaIfContext jinjaIf() {
			return getRuleContext(JinjaIfContext.class,0);
		}
		public JinjaIfItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaIfItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaIfItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaIfItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaPrintItemContext extends ItemContext {
		public JinjaPrintContext jinjaPrint() {
			return getRuleContext(JinjaPrintContext.class,0);
		}
		public JinjaPrintItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaPrintItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaPrintItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaPrintItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExtendsItemContext extends ItemContext {
		public JinjaExtendsContext jinjaExtends() {
			return getRuleContext(JinjaExtendsContext.class,0);
		}
		public JinjaExtendsItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaExtendsItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaExtendsItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaExtendsItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				htmlElement();
				}
				break;
			case 2:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				jinjaBlock();
				}
				break;
			case 3:
				_localctx = new JinjaForItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				jinjaFor();
				}
				break;
			case 4:
				_localctx = new JinjaIfItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				jinjaIf();
				}
				break;
			case 5:
				_localctx = new JinjaExtendsItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				jinjaExtends();
				}
				break;
			case 6:
				_localctx = new JinjaPrintItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				jinjaPrint();
				}
				break;
			case 7:
				_localctx = new HtmlTextItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(60);
				htmlText();
				}
				break;
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
	public static class HtmlTextContext extends ParserRuleContext {
		public HtmlTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlText; }
	 
		public HtmlTextContext() { }
		public void copyFrom(HtmlTextContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlainTextContext extends HtmlTextContext {
		public TerminalNode TEXT() { return getToken(TemplateParser.TEXT, 0); }
		public PlainTextContext(HtmlTextContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPlainText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPlainText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPlainText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlTextContext htmlText() throws RecognitionException {
		HtmlTextContext _localctx = new HtmlTextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlText);
		try {
			_localctx = new PlainTextContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(TEXT);
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
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSelfClosingElementContext extends HtmlElementContext {
		public SelfClosingElementContext selfClosingElement() {
			return getRuleContext(SelfClosingElementContext.class,0);
		}
		public HtmlSelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlNormalElementContext extends HtmlElementContext {
		public NormalElementContext normalElement() {
			return getRuleContext(NormalElementContext.class,0);
		}
		public HtmlNormalElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlNormalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlNormalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlNormalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlElement);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlNormalElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				normalElement();
				}
				break;
			case 2:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				selfClosingElement();
				}
				break;
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
	public static class NormalElementContext extends ParserRuleContext {
		public OpenTagContext openTag() {
			return getRuleContext(OpenTagContext.class,0);
		}
		public CloseTagContext closeTag() {
			return getRuleContext(CloseTagContext.class,0);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public NormalElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterNormalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitNormalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitNormalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalElementContext normalElement() throws RecognitionException {
		NormalElementContext _localctx = new NormalElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_normalElement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			openTag();
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					item();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(76);
			closeTag();
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
	public static class OpenTagContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplateParser.TAG_OPEN, 0); }
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(TemplateParser.TAG_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public OpenTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterOpenTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitOpenTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitOpenTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpenTagContext openTag() throws RecognitionException {
		OpenTagContext _localctx = new OpenTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_openTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(TAG_OPEN);
			setState(79);
			match(TAG_NAME);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(80);
				attribute();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(TAG_CLOSE);
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
	public static class CloseTagContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplateParser.TAG_OPEN, 0); }
		public TerminalNode TAG_SLASH() { return getToken(TemplateParser.TAG_SLASH, 0); }
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(TemplateParser.TAG_CLOSE, 0); }
		public CloseTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closeTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCloseTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCloseTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CloseTagContext closeTag() throws RecognitionException {
		CloseTagContext _localctx = new CloseTagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_closeTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TAG_OPEN);
			setState(89);
			match(TAG_SLASH);
			setState(90);
			match(TAG_NAME);
			setState(91);
			match(TAG_CLOSE);
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
	public static class SelfClosingElementContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplateParser.TAG_OPEN, 0); }
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode TAG_SELF_CLOSE() { return getToken(TemplateParser.TAG_SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingElementContext selfClosingElement() throws RecognitionException {
		SelfClosingElementContext _localctx = new SelfClosingElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selfClosingElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(TAG_OPEN);
			setState(94);
			match(TAG_NAME);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(95);
				attribute();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(TAG_SELF_CLOSE);
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
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeKVContext extends AttributeContext {
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public AttributeKVContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttributeKV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttributeKV(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttributeKV(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attribute);
		int _la;
		try {
			_localctx = new AttributeKVContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(TAG_NAME);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(104);
				match(EQ);
				setState(105);
				attrValue();
				}
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
	public static class AttrValueContext extends ParserRuleContext {
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
	 
		public AttrValueContext() { }
		public void copyFrom(AttrValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrDoubleQuotedContext extends AttrValueContext {
		public List<TerminalNode> DQUOTE() { return getTokens(TemplateParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(TemplateParser.DQUOTE, i);
		}
		public List<AttrValuePartContext> attrValuePart() {
			return getRuleContexts(AttrValuePartContext.class);
		}
		public AttrValuePartContext attrValuePart(int i) {
			return getRuleContext(AttrValuePartContext.class,i);
		}
		public AttrDoubleQuotedContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttrDoubleQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttrDoubleQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttrDoubleQuoted(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrSingleQuotedContext extends AttrValueContext {
		public List<TerminalNode> SQUOTE() { return getTokens(TemplateParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(TemplateParser.SQUOTE, i);
		}
		public List<AttrValuePartContext> attrValuePart() {
			return getRuleContexts(AttrValuePartContext.class);
		}
		public AttrValuePartContext attrValuePart(int i) {
			return getRuleContext(AttrValuePartContext.class,i);
		}
		public AttrSingleQuotedContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttrSingleQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttrSingleQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttrSingleQuoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attrValue);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(DQUOTE);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(109);
					attrValuePart();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(SQUOTE);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(117);
					attrValuePart();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(SQUOTE);
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
	public static class AttrValuePartContext extends ParserRuleContext {
		public AttrValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValuePart; }
	 
		public AttrValuePartContext() { }
		public void copyFrom(AttrValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrTextValuePartContext extends AttrValuePartContext {
		public TerminalNode ATTR_TEXT() { return getToken(TemplateParser.ATTR_TEXT, 0); }
		public AttrTextValuePartContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttrTextValuePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttrTextValuePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttrTextValuePart(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaPrintValuePartContext extends AttrValuePartContext {
		public JinjaPrintContext jinjaPrint() {
			return getRuleContext(JinjaPrintContext.class,0);
		}
		public AttrJinjaPrintValuePartContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttrJinjaPrintValuePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttrJinjaPrintValuePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttrJinjaPrintValuePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValuePartContext attrValuePart() throws RecognitionException {
		AttrValuePartContext _localctx = new AttrValuePartContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attrValuePart);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttrTextValuePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ATTR_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaPrintValuePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				jinjaPrint();
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
	public static class JinjaExtendsContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode EXTENDS() { return getToken(TemplateParser.EXTENDS, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public TerminalNode STRING() { return getToken(TemplateParser.STRING, 0); }
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public JinjaExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExtends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaExtends(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaExtends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExtendsContext jinjaExtends() throws RecognitionException {
		JinjaExtendsContext _localctx = new JinjaExtendsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jinjaExtends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(JINJA_STMT_OPEN);
			setState(131);
			match(EXTENDS);
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(133);
			match(JINJA_STMT_CLOSE);
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
	public static class JinjaBlockContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_OPEN() { return getTokens(TemplateParser.JINJA_STMT_OPEN); }
		public TerminalNode JINJA_STMT_OPEN(int i) {
			return getToken(TemplateParser.JINJA_STMT_OPEN, i);
		}
		public TerminalNode BLOCK() { return getToken(TemplateParser.BLOCK, 0); }
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDBLOCK() { return getToken(TemplateParser.ENDBLOCK, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public JinjaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContext jinjaBlock() throws RecognitionException {
		JinjaBlockContext _localctx = new JinjaBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jinjaBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(JINJA_STMT_OPEN);
			setState(136);
			match(BLOCK);
			setState(137);
			match(ID);
			setState(138);
			match(JINJA_STMT_CLOSE);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(139);
					item();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(145);
			match(JINJA_STMT_OPEN);
			setState(146);
			match(ENDBLOCK);
			setState(147);
			match(JINJA_STMT_CLOSE);
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
	public static class JinjaForContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_OPEN() { return getTokens(TemplateParser.JINJA_STMT_OPEN); }
		public TerminalNode JINJA_STMT_OPEN(int i) {
			return getToken(TemplateParser.JINJA_STMT_OPEN, i);
		}
		public TerminalNode FOR() { return getToken(TemplateParser.FOR, 0); }
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDFOR() { return getToken(TemplateParser.ENDFOR, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public JinjaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForContext jinjaFor() throws RecognitionException {
		JinjaForContext _localctx = new JinjaForContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jinjaFor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(JINJA_STMT_OPEN);
			setState(150);
			match(FOR);
			setState(151);
			match(ID);
			setState(152);
			match(IN);
			setState(153);
			expr();
			setState(154);
			match(JINJA_STMT_CLOSE);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					item();
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(161);
			match(JINJA_STMT_OPEN);
			setState(162);
			match(ENDFOR);
			setState(163);
			match(JINJA_STMT_CLOSE);
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
	public static class JinjaIfContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_OPEN() { return getTokens(TemplateParser.JINJA_STMT_OPEN); }
		public TerminalNode JINJA_STMT_OPEN(int i) {
			return getToken(TemplateParser.JINJA_STMT_OPEN, i);
		}
		public TerminalNode IF() { return getToken(TemplateParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDIF() { return getToken(TemplateParser.ENDIF, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<JinjaElifContext> jinjaElif() {
			return getRuleContexts(JinjaElifContext.class);
		}
		public JinjaElifContext jinjaElif(int i) {
			return getRuleContext(JinjaElifContext.class,i);
		}
		public JinjaElseContext jinjaElse() {
			return getRuleContext(JinjaElseContext.class,0);
		}
		public JinjaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfContext jinjaIf() throws RecognitionException {
		JinjaIfContext _localctx = new JinjaIfContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jinjaIf);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(JINJA_STMT_OPEN);
			setState(166);
			match(IF);
			setState(167);
			expr();
			setState(168);
			match(JINJA_STMT_CLOSE);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					item();
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					jinjaElif();
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(181);
				jinjaElse();
				}
				break;
			}
			setState(184);
			match(JINJA_STMT_OPEN);
			setState(185);
			match(ENDIF);
			setState(186);
			match(JINJA_STMT_CLOSE);
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
	public static class JinjaElifContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode ELIF() { return getToken(TemplateParser.ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public JinjaElifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaElif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaElif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaElif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElifContext jinjaElif() throws RecognitionException {
		JinjaElifContext _localctx = new JinjaElifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jinjaElif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(JINJA_STMT_OPEN);
			setState(189);
			match(ELIF);
			setState(190);
			expr();
			setState(191);
			match(JINJA_STMT_CLOSE);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					item();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class JinjaElseContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode ELSE() { return getToken(TemplateParser.ELSE, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public JinjaElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElseContext jinjaElse() throws RecognitionException {
		JinjaElseContext _localctx = new JinjaElseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jinjaElse);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(JINJA_STMT_OPEN);
			setState(199);
			match(ELSE);
			setState(200);
			match(JINJA_STMT_CLOSE);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					item();
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	public static class JinjaPrintContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR_OPEN() { return getToken(TemplateParser.JINJA_EXPR_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA_EXPR_CLOSE() { return getToken(TemplateParser.JINJA_EXPR_CLOSE, 0); }
		public JinjaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaPrintContext jinjaPrint() throws RecognitionException {
		JinjaPrintContext _localctx = new JinjaPrintContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jinjaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(JINJA_EXPR_OPEN);
			setState(208);
			expr();
			setState(209);
			match(JINJA_EXPR_CLOSE);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSequenceContext extends ExprContext {
		public List<ExprUnitContext> exprUnit() {
			return getRuleContexts(ExprUnitContext.class);
		}
		public ExprUnitContext exprUnit(int i) {
			return getRuleContext(ExprUnitContext.class,i);
		}
		public ExprSequenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr);
		int _la;
		try {
			_localctx = new ExprSequenceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(211);
				exprUnit();
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1082130388L) != 0) );
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
	public static class ExprUnitContext extends ParserRuleContext {
		public ExprUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprUnit; }
	 
		public ExprUnitContext() { }
		public void copyFrom(ExprUnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOpUnitContext extends ExprUnitContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ExprOpUnitContext(ExprUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprOpUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprOpUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprOpUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPunctUnitContext extends ExprUnitContext {
		public PunctContext punct() {
			return getRuleContext(PunctContext.class,0);
		}
		public ExprPunctUnitContext(ExprUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprPunctUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprPunctUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprPunctUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAtomUnitContext extends ExprUnitContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ExprAtomUnitContext(ExprUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprAtomUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprAtomUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprAtomUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprUnitContext exprUnit() throws RecognitionException {
		ExprUnitContext _localctx = new ExprUnitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprUnit);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case LBRACK:
			case INT:
			case STRING:
			case ID:
				_localctx = new ExprAtomUnitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				atom();
				}
				break;
			case PIPE:
			case GE:
			case LE:
			case EQEQ:
			case NE:
			case GT:
			case LT:
			case PLUS:
			case MINUS:
			case STAR:
			case SLASH:
			case EQ:
				_localctx = new ExprOpUnitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				op();
				}
				break;
			case COMMA:
			case DOT:
			case COLON:
				_localctx = new ExprPunctUnitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				punct();
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
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomIntContext extends AtomContext {
		public TerminalNode INT() { return getToken(TemplateParser.INT, 0); }
		public AtomIntContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAtomInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAtomInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAtomInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomParenContext extends AtomContext {
		public TerminalNode LPAREN() { return getToken(TemplateParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TemplateParser.RPAREN, 0); }
		public AtomParenContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAtomParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAtomParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAtomParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomBracketContext extends AtomContext {
		public TerminalNode LBRACK() { return getToken(TemplateParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(TemplateParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomBracketContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAtomBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAtomBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAtomBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomIdContext extends AtomContext {
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public AtomIdContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAtomId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAtomId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAtomId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomStringContext extends AtomContext {
		public TerminalNode STRING() { return getToken(TemplateParser.STRING, 0); }
		public AtomStringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAtomString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAtomString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAtomString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atom);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AtomIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(ID);
				}
				break;
			case INT:
				_localctx = new AtomIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new AtomStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				match(STRING);
				}
				break;
			case LPAREN:
				_localctx = new AtomParenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(LPAREN);
				setState(225);
				expr();
				setState(226);
				match(RPAREN);
				}
				break;
			case LBRACK:
				_localctx = new AtomBracketContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(LBRACK);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082130388L) != 0)) {
					{
					setState(229);
					expr();
					}
				}

				setState(232);
				match(RBRACK);
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
	public static class OpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TemplateParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TemplateParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(TemplateParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(TemplateParser.SLASH, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode GE() { return getToken(TemplateParser.GE, 0); }
		public TerminalNode LE() { return getToken(TemplateParser.LE, 0); }
		public TerminalNode EQEQ() { return getToken(TemplateParser.EQEQ, 0); }
		public TerminalNode NE() { return getToken(TemplateParser.NE, 0); }
		public TerminalNode PIPE() { return getToken(TemplateParser.PIPE, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1074789888L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class PunctContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(TemplateParser.DOT, 0); }
		public TerminalNode COMMA() { return getToken(TemplateParser.COMMA, 0); }
		public TerminalNode COLON() { return getToken(TemplateParser.COLON, 0); }
		public PunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_punct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PunctContext punct() throws RecognitionException {
		PunctContext _localctx = new PunctContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_punct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001@\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003D\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004\f\u0004K\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"R\b\u0005\n\u0005\f\u0005U\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007a\b\u0007\n\u0007\f\u0007d\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\bk\b\b\u0001\t\u0001\t\u0005"+
		"\to\b\t\n\t\f\tr\t\t\u0001\t\u0001\t\u0001\t\u0005\tw\b\t\n\t\f\tz\t\t"+
		"\u0001\t\u0003\t}\b\t\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u008d\b\f\n\f\f\f\u0090\t\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u009d\b\r\n\r\f\r\u00a0\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00ab\b\u000e"+
		"\n\u000e\f\u000e\u00ae\t\u000e\u0001\u000e\u0005\u000e\u00b1\b\u000e\n"+
		"\u000e\f\u000e\u00b4\t\u000e\u0001\u000e\u0003\u000e\u00b7\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00c2\b\u000f\n\u000f\f\u000f"+
		"\u00c5\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00cb\b\u0010\n\u0010\f\u0010\u00ce\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u00d5\b\u0012\u000b\u0012\f"+
		"\u0012\u00d6\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00dc\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00e7\b\u0014\u0001\u0014"+
		"\u0003\u0014\u00ea\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0003\u0001\u0000"+
		"\u0015\u0016\u0002\u0000\t\u0013\u001e\u001e\u0001\u0000\u0006\b\u00f7"+
		"\u00001\u0001\u0000\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004?"+
		"\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bE\u0001\u0000"+
		"\u0000\u0000\nN\u0001\u0000\u0000\u0000\fX\u0001\u0000\u0000\u0000\u000e"+
		"]\u0001\u0000\u0000\u0000\u0010g\u0001\u0000\u0000\u0000\u0012|\u0001"+
		"\u0000\u0000\u0000\u0014\u0080\u0001\u0000\u0000\u0000\u0016\u0082\u0001"+
		"\u0000\u0000\u0000\u0018\u0087\u0001\u0000\u0000\u0000\u001a\u0095\u0001"+
		"\u0000\u0000\u0000\u001c\u00a5\u0001\u0000\u0000\u0000\u001e\u00bc\u0001"+
		"\u0000\u0000\u0000 \u00c6\u0001\u0000\u0000\u0000\"\u00cf\u0001\u0000"+
		"\u0000\u0000$\u00d4\u0001\u0000\u0000\u0000&\u00db\u0001\u0000\u0000\u0000"+
		"(\u00e9\u0001\u0000\u0000\u0000*\u00eb\u0001\u0000\u0000\u0000,\u00ed"+
		"\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000"+
		"\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005"+
		"\u0000\u0000\u00015\u0001\u0001\u0000\u0000\u00006>\u0003\u0006\u0003"+
		"\u00007>\u0003\u0018\f\u00008>\u0003\u001a\r\u00009>\u0003\u001c\u000e"+
		"\u0000:>\u0003\u0016\u000b\u0000;>\u0003\"\u0011\u0000<>\u0003\u0004\u0002"+
		"\u0000=6\u0001\u0000\u0000\u0000=7\u0001\u0000\u0000\u0000=8\u0001\u0000"+
		"\u0000\u0000=9\u0001\u0000\u0000\u0000=:\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>\u0003\u0001\u0000\u0000"+
		"\u0000?@\u0005\u001a\u0000\u0000@\u0005\u0001\u0000\u0000\u0000AD\u0003"+
		"\b\u0004\u0000BD\u0003\u000e\u0007\u0000CA\u0001\u0000\u0000\u0000CB\u0001"+
		"\u0000\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EI\u0003\n\u0005\u0000"+
		"FH\u0003\u0002\u0001\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0003\f\u0006\u0000M\t\u0001"+
		"\u0000\u0000\u0000NO\u0005\u0019\u0000\u0000OS\u0005!\u0000\u0000PR\u0003"+
		"\u0010\b\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000VW\u0005\u001c\u0000\u0000W\u000b\u0001\u0000"+
		"\u0000\u0000XY\u0005\u0019\u0000\u0000YZ\u0005\u001d\u0000\u0000Z[\u0005"+
		"!\u0000\u0000[\\\u0005\u001c\u0000\u0000\\\r\u0001\u0000\u0000\u0000]"+
		"^\u0005\u0019\u0000\u0000^b\u0005!\u0000\u0000_a\u0003\u0010\b\u0000`"+
		"_\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000ef\u0005\u001b\u0000\u0000f\u000f\u0001\u0000\u0000\u0000"+
		"gj\u0005!\u0000\u0000hi\u0005\u001e\u0000\u0000ik\u0003\u0012\t\u0000"+
		"jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u0011\u0001\u0000"+
		"\u0000\u0000lp\u0005\u001f\u0000\u0000mo\u0003\u0014\n\u0000nm\u0001\u0000"+
		"\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"s}\u0005\u001f\u0000\u0000tx\u0005 \u0000\u0000uw\u0003\u0014\n\u0000"+
		"vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000{}\u0005 \u0000\u0000|l\u0001\u0000\u0000\u0000|t\u0001\u0000"+
		"\u0000\u0000}\u0013\u0001\u0000\u0000\u0000~\u0081\u0005\u0001\u0000\u0000"+
		"\u007f\u0081\u0003\"\u0011\u0000\u0080~\u0001\u0000\u0000\u0000\u0080"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0018\u0000\u0000\u0083\u0084\u0005\'\u0000\u0000\u0084\u0085"+
		"\u0007\u0000\u0000\u0000\u0085\u0086\u0005%\u0000\u0000\u0086\u0017\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088\u0089\u0005"+
		"(\u0000\u0000\u0089\u008a\u0005\u0016\u0000\u0000\u008a\u008e\u0005%\u0000"+
		"\u0000\u008b\u008d\u0003\u0002\u0001\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000"+
		"\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0018\u0000"+
		"\u0000\u0092\u0093\u0005)\u0000\u0000\u0093\u0094\u0005%\u0000\u0000\u0094"+
		"\u0019\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0018\u0000\u0000\u0096"+
		"\u0097\u0005*\u0000\u0000\u0097\u0098\u0005\u0016\u0000\u0000\u0098\u0099"+
		"\u0005+\u0000\u0000\u0099\u009a\u0003$\u0012\u0000\u009a\u009e\u0005%"+
		"\u0000\u0000\u009b\u009d\u0003\u0002\u0001\u0000\u009c\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0018"+
		"\u0000\u0000\u00a2\u00a3\u0005,\u0000\u0000\u00a3\u00a4\u0005%\u0000\u0000"+
		"\u00a4\u001b\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0018\u0000\u0000"+
		"\u00a6\u00a7\u0005-\u0000\u0000\u00a7\u00a8\u0003$\u0012\u0000\u00a8\u00ac"+
		"\u0005%\u0000\u0000\u00a9\u00ab\u0003\u0002\u0001\u0000\u00aa\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b2\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b1\u0003"+
		"\u001e\u000f\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b7\u0003 \u0010\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0018\u0000\u0000\u00b9\u00ba\u00050\u0000"+
		"\u0000\u00ba\u00bb\u0005%\u0000\u0000\u00bb\u001d\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00be\u0005.\u0000\u0000\u00be"+
		"\u00bf\u0003$\u0012\u0000\u00bf\u00c3\u0005%\u0000\u0000\u00c0\u00c2\u0003"+
		"\u0002\u0001\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u001f\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005\u0018\u0000\u0000\u00c7\u00c8\u0005"+
		"/\u0000\u0000\u00c8\u00cc\u0005%\u0000\u0000\u00c9\u00cb\u0003\u0002\u0001"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cd!\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0005\u0017\u0000\u0000\u00d0\u00d1\u0003$\u0012\u0000\u00d1"+
		"\u00d2\u0005#\u0000\u0000\u00d2#\u0001\u0000\u0000\u0000\u00d3\u00d5\u0003"+
		"&\u0013\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7%\u0001\u0000\u0000\u0000\u00d8\u00dc\u0003(\u0014\u0000"+
		"\u00d9\u00dc\u0003*\u0015\u0000\u00da\u00dc\u0003,\u0016\u0000\u00db\u00d8"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00da"+
		"\u0001\u0000\u0000\u0000\u00dc\'\u0001\u0000\u0000\u0000\u00dd\u00ea\u0005"+
		"\u0016\u0000\u0000\u00de\u00ea\u0005\u0014\u0000\u0000\u00df\u00ea\u0005"+
		"\u0015\u0000\u0000\u00e0\u00e1\u0005\u0002\u0000\u0000\u00e1\u00e2\u0003"+
		"$\u0012\u0000\u00e2\u00e3\u0005\u0003\u0000\u0000\u00e3\u00ea\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e6\u0005\u0004\u0000\u0000\u00e5\u00e7\u0003$\u0012"+
		"\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00ea\u0005\u0005\u0000"+
		"\u0000\u00e9\u00dd\u0001\u0000\u0000\u0000\u00e9\u00de\u0001\u0000\u0000"+
		"\u0000\u00e9\u00df\u0001\u0000\u0000\u0000\u00e9\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e4\u0001\u0000\u0000\u0000\u00ea)\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0007\u0001\u0000\u0000\u00ec+\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0007\u0002\u0000\u0000\u00ee-\u0001\u0000\u0000\u0000\u00161="+
		"CISbjpx|\u0080\u008e\u009e\u00ac\u00b2\u00b6\u00c3\u00cc\u00d6\u00db\u00e6"+
		"\u00e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}