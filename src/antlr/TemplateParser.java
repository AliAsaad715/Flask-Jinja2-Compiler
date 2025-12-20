// Generated from C:/Users/noureddine/IdeaProjects/Flask-Jinja2-Compiler/src/antlr/TemplateParser.g4 by ANTLR 4.13.2
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
		DQUOTE=31, SQUOTE=32, VOID_TAG_NAME=33, TAG_NAME=34, TAG_WS=35, JINJA_EXPR_CLOSE=36, 
		JINJA_WS_E=37, JINJA_STMT_CLOSE=38, JINJA_WS_S=39, EXTENDS=40, BLOCK=41, 
		ENDBLOCK=42, FOR=43, IN=44, ENDFOR=45, IF=46, ELIF=47, ELSE=48, ENDIF=49, 
		SET=50, LPAREN_E=51, RPAREN_E=52, LBRACK_E=53, RBRACK_E=54, COMMA_E=55, 
		DOT_E=56, COLON_E=57, PIPE_E=58, GE_E=59, LE_E=60, EQEQ_E=61, NE_E=62, 
		PLUS_E=63, MINUS_E=64, STAR_E=65;
	public static final int
		RULE_template = 0, RULE_item = 1, RULE_htmlText = 2, RULE_htmlElement = 3, 
		RULE_normalElement = 4, RULE_openTag = 5, RULE_selfClosingElement = 6, 
		RULE_closeTag = 7, RULE_voidElement = 8, RULE_attribute = 9, RULE_attrValue = 10, 
		RULE_attrValuePart = 11, RULE_jinjaExtends = 12, RULE_jinjaBlock = 13, 
		RULE_blockBodyItem = 14, RULE_jinjaFor = 15, RULE_forBodyItem = 16, RULE_jinjaIf = 17, 
		RULE_ifThenBodyItem = 18, RULE_jinjaElif = 19, RULE_elifBodyItem = 20, 
		RULE_jinjaElse = 21, RULE_elseBodyItem = 22, RULE_jinjaPrint = 23, RULE_expr = 24, 
		RULE_exprUnit = 25, RULE_atom = 26, RULE_op = 27, RULE_punct = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "item", "htmlText", "htmlElement", "normalElement", "openTag", 
			"selfClosingElement", "closeTag", "voidElement", "attribute", "attrValue", 
			"attrValuePart", "jinjaExtends", "jinjaBlock", "blockBodyItem", "jinjaFor", 
			"forBodyItem", "jinjaIf", "ifThenBodyItem", "jinjaElif", "elifBodyItem", 
			"jinjaElse", "elseBodyItem", "jinjaPrint", "expr", "exprUnit", "atom", 
			"op", "punct"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'{{'", 
			"'{%'", null, null, "'/>'", null, null, null, null, null, null, null, 
			null, "'}}'", null, "'%}'", null, "'extends'", "'block'", "'endblock'", 
			"'for'", "'in'", "'endfor'", "'if'", "'elif'", "'else'", "'endif'", "'set'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ATTR_TEXT", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", 
			"COLON", "PIPE", "GE", "LE", "EQEQ", "NE", "GT", "LT", "PLUS", "MINUS", 
			"STAR", "SLASH", "INT", "STRING", "ID", "JINJA_EXPR_OPEN", "JINJA_STMT_OPEN", 
			"TAG_OPEN", "TEXT", "TAG_SELF_CLOSE", "TAG_CLOSE", "TAG_SLASH", "EQ", 
			"DQUOTE", "SQUOTE", "VOID_TAG_NAME", "TAG_NAME", "TAG_WS", "JINJA_EXPR_CLOSE", 
			"JINJA_WS_E", "JINJA_STMT_CLOSE", "JINJA_WS_S", "EXTENDS", "BLOCK", "ENDBLOCK", 
			"FOR", "IN", "ENDFOR", "IF", "ELIF", "ELSE", "ENDIF", "SET", "LPAREN_E", 
			"RPAREN_E", "LBRACK_E", "RBRACK_E", "COMMA_E", "DOT_E", "COLON_E", "PIPE_E", 
			"GE_E", "LE_E", "EQEQ_E", "NE_E", "PLUS_E", "MINUS_E", "STAR_E"
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


	    private boolean nextIsStmt(int kw) {
	        return _input.LA(1) == JINJA_STMT_OPEN && _input.LA(2) == kw;
	    }

	    private boolean nextIsEndFor() {
	        return nextIsStmt(ENDFOR);
	    }

	    private boolean nextIsEndBlock() {
	        return nextIsStmt(ENDBLOCK);
	    }

	    private boolean nextIsEndIf() {
	        return nextIsStmt(ENDIF);
	    }

	    private boolean nextIsIfBranchOrEnd() {
	        return _input.LA(1) == JINJA_STMT_OPEN &&
	               (_input.LA(2) == ELIF || _input.LA(2) == ELSE || _input.LA(2) == ENDIF);
	    }

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
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				{
				setState(58);
				item();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				htmlElement();
				}
				break;
			case 2:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				jinjaBlock();
				}
				break;
			case 3:
				_localctx = new JinjaForItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				jinjaFor();
				}
				break;
			case 4:
				_localctx = new JinjaIfItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				jinjaIf();
				}
				break;
			case 5:
				_localctx = new JinjaExtendsItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				jinjaExtends();
				}
				break;
			case 6:
				_localctx = new JinjaPrintItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				jinjaPrint();
				}
				break;
			case 7:
				_localctx = new HtmlTextItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
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
			setState(75);
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
	public static class HtmlVoidElementContext extends HtmlElementContext {
		public VoidElementContext voidElement() {
			return getRuleContext(VoidElementContext.class,0);
		}
		public HtmlVoidElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlVoidElement(this);
			else return visitor.visitChildren(this);
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
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlVoidElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				voidElement();
				}
				break;
			case 2:
				_localctx = new HtmlNormalElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				normalElement();
				}
				break;
			case 3:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
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
			setState(82);
			openTag();
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					item();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(89);
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
			setState(91);
			match(TAG_OPEN);
			setState(92);
			match(TAG_NAME);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(93);
				attribute();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
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
		public TerminalNode TAG_SELF_CLOSE() { return getToken(TemplateParser.TAG_SELF_CLOSE, 0); }
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(TemplateParser.VOID_TAG_NAME, 0); }
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
		enterRule(_localctx, 12, RULE_selfClosingElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(TAG_OPEN);
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(103);
				attribute();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
	public static class CloseTagContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplateParser.TAG_OPEN, 0); }
		public TerminalNode TAG_SLASH() { return getToken(TemplateParser.TAG_SLASH, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(TemplateParser.TAG_CLOSE, 0); }
		public TerminalNode TAG_NAME() { return getToken(TemplateParser.TAG_NAME, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(TemplateParser.VOID_TAG_NAME, 0); }
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
		enterRule(_localctx, 14, RULE_closeTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(TAG_OPEN);
			setState(112);
			match(TAG_SLASH);
			setState(113);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(114);
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
	public static class VoidElementContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplateParser.TAG_OPEN, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(TemplateParser.VOID_TAG_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(TemplateParser.TAG_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidElementContext voidElement() throws RecognitionException {
		VoidElementContext _localctx = new VoidElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_voidElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(TAG_OPEN);
			setState(117);
			match(VOID_TAG_NAME);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(118);
				attribute();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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
		enterRule(_localctx, 18, RULE_attribute);
		int _la;
		try {
			_localctx = new AttributeKVContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(TAG_NAME);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(127);
				match(EQ);
				setState(128);
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
		enterRule(_localctx, 20, RULE_attrValue);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(DQUOTE);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(132);
					attrValuePart();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(SQUOTE);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(140);
					attrValuePart();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
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
		enterRule(_localctx, 22, RULE_attrValuePart);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttrTextValuePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(ATTR_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaPrintValuePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
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
		enterRule(_localctx, 24, RULE_jinjaExtends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(JINJA_STMT_OPEN);
			setState(154);
			match(EXTENDS);
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
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
		public List<BlockBodyItemContext> blockBodyItem() {
			return getRuleContexts(BlockBodyItemContext.class);
		}
		public BlockBodyItemContext blockBodyItem(int i) {
			return getRuleContext(BlockBodyItemContext.class,i);
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
		enterRule(_localctx, 26, RULE_jinjaBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(JINJA_STMT_OPEN);
			setState(159);
			match(BLOCK);
			setState(160);
			match(ID);
			setState(161);
			match(JINJA_STMT_CLOSE);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162);
					blockBodyItem();
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(168);
			match(JINJA_STMT_OPEN);
			setState(169);
			match(ENDBLOCK);
			setState(170);
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
	public static class BlockBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public BlockBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterBlockBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitBlockBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitBlockBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockBodyItemContext blockBodyItem() throws RecognitionException {
		BlockBodyItemContext _localctx = new BlockBodyItemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			if (!( !nextIsEndBlock() )) throw new FailedPredicateException(this, " !nextIsEndBlock() ");
			setState(173);
			item();
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
		public List<ForBodyItemContext> forBodyItem() {
			return getRuleContexts(ForBodyItemContext.class);
		}
		public ForBodyItemContext forBodyItem(int i) {
			return getRuleContext(ForBodyItemContext.class,i);
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
		enterRule(_localctx, 30, RULE_jinjaFor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(JINJA_STMT_OPEN);
			setState(176);
			match(FOR);
			setState(177);
			match(ID);
			setState(178);
			match(IN);
			setState(179);
			expr();
			setState(180);
			match(JINJA_STMT_CLOSE);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					forBodyItem();
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(187);
			match(JINJA_STMT_OPEN);
			setState(188);
			match(ENDFOR);
			setState(189);
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
	public static class ForBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public ForBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterForBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitForBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitForBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBodyItemContext forBodyItem() throws RecognitionException {
		ForBodyItemContext _localctx = new ForBodyItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			if (!( !nextIsEndFor() )) throw new FailedPredicateException(this, " !nextIsEndFor() ");
			setState(192);
			item();
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
		public List<IfThenBodyItemContext> ifThenBodyItem() {
			return getRuleContexts(IfThenBodyItemContext.class);
		}
		public IfThenBodyItemContext ifThenBodyItem(int i) {
			return getRuleContext(IfThenBodyItemContext.class,i);
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
		enterRule(_localctx, 34, RULE_jinjaIf);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(JINJA_STMT_OPEN);
			setState(195);
			match(IF);
			setState(196);
			expr();
			setState(197);
			match(JINJA_STMT_CLOSE);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(198);
					ifThenBodyItem();
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					jinjaElif();
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(210);
				jinjaElse();
				}
				break;
			}
			setState(213);
			match(JINJA_STMT_OPEN);
			setState(214);
			match(ENDIF);
			setState(215);
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
	public static class IfThenBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public IfThenBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterIfThenBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitIfThenBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitIfThenBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenBodyItemContext ifThenBodyItem() throws RecognitionException {
		IfThenBodyItemContext _localctx = new IfThenBodyItemContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifThenBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(218);
			item();
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
		public List<ElifBodyItemContext> elifBodyItem() {
			return getRuleContexts(ElifBodyItemContext.class);
		}
		public ElifBodyItemContext elifBodyItem(int i) {
			return getRuleContext(ElifBodyItemContext.class,i);
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
		enterRule(_localctx, 38, RULE_jinjaElif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(JINJA_STMT_OPEN);
			setState(221);
			match(ELIF);
			setState(222);
			expr();
			setState(223);
			match(JINJA_STMT_CLOSE);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(224);
					elifBodyItem();
					}
					} 
				}
				setState(229);
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
	public static class ElifBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public ElifBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterElifBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitElifBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitElifBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifBodyItemContext elifBodyItem() throws RecognitionException {
		ElifBodyItemContext _localctx = new ElifBodyItemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elifBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(231);
			item();
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
		public List<ElseBodyItemContext> elseBodyItem() {
			return getRuleContexts(ElseBodyItemContext.class);
		}
		public ElseBodyItemContext elseBodyItem(int i) {
			return getRuleContext(ElseBodyItemContext.class,i);
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
		enterRule(_localctx, 42, RULE_jinjaElse);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(JINJA_STMT_OPEN);
			setState(234);
			match(ELSE);
			setState(235);
			match(JINJA_STMT_CLOSE);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(236);
					elseBodyItem();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class ElseBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public ElseBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterElseBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitElseBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitElseBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBodyItemContext elseBodyItem() throws RecognitionException {
		ElseBodyItemContext _localctx = new ElseBodyItemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_elseBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			if (!( !nextIsEndIf() )) throw new FailedPredicateException(this, " !nextIsEndIf() ");
			setState(243);
			item();
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
		enterRule(_localctx, 46, RULE_jinjaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(JINJA_EXPR_OPEN);
			setState(246);
			expr();
			setState(247);
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
		enterRule(_localctx, 48, RULE_expr);
		int _la;
		try {
			_localctx = new ExprSequenceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249);
				exprUnit();
				}
				}
				setState(252); 
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
		enterRule(_localctx, 50, RULE_exprUnit);
		try {
			setState(257);
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
				setState(254);
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
				setState(255);
				op();
				}
				break;
			case COMMA:
			case DOT:
			case COLON:
				_localctx = new ExprPunctUnitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
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
		enterRule(_localctx, 52, RULE_atom);
		int _la;
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AtomIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(ID);
				}
				break;
			case INT:
				_localctx = new AtomIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new AtomStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(STRING);
				}
				break;
			case LPAREN:
				_localctx = new AtomParenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				match(LPAREN);
				setState(263);
				expr();
				setState(264);
				match(RPAREN);
				}
				break;
			case LBRACK:
				_localctx = new AtomBracketContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				match(LBRACK);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082130388L) != 0)) {
					{
					setState(267);
					expr();
					}
				}

				setState(270);
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
		enterRule(_localctx, 54, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
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
		enterRule(_localctx, 56, RULE_punct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return blockBodyItem_sempred((BlockBodyItemContext)_localctx, predIndex);
		case 16:
			return forBodyItem_sempred((ForBodyItemContext)_localctx, predIndex);
		case 18:
			return ifThenBodyItem_sempred((IfThenBodyItemContext)_localctx, predIndex);
		case 20:
			return elifBodyItem_sempred((ElifBodyItemContext)_localctx, predIndex);
		case 22:
			return elseBodyItem_sempred((ElseBodyItemContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean blockBodyItem_sempred(BlockBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  !nextIsEndBlock() ;
		}
		return true;
	}
	private boolean forBodyItem_sempred(ForBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return  !nextIsEndFor() ;
		}
		return true;
	}
	private boolean ifThenBodyItem_sempred(IfThenBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  !nextIsIfBranchOrEnd() ;
		}
		return true;
	}
	private boolean elifBodyItem_sempred(ElifBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return  !nextIsIfBranchOrEnd() ;
		}
		return true;
	}
	private boolean elseBodyItem_sempred(ElseBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  !nextIsEndIf() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001A\u0116\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0005\u0000<\b\u0000\n\u0000\f\u0000"+
		"?\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001J\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"Q\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004U\b\u0004\n\u0004\f\u0004"+
		"X\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005_\b\u0005\n\u0005\f\u0005b\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006i\b\u0006\n\u0006\f\u0006"+
		"l\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bx\b\b\n\b\f\b"+
		"{\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u0082\b\t\u0001"+
		"\n\u0001\n\u0005\n\u0086\b\n\n\n\f\n\u0089\t\n\u0001\n\u0001\n\u0001\n"+
		"\u0005\n\u008e\b\n\n\n\f\n\u0091\t\n\u0001\n\u0003\n\u0094\b\n\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0098\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00a4\b\r\n\r"+
		"\f\r\u00a7\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00b7\b\u000f\n\u000f\f\u000f\u00ba"+
		"\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00c8\b\u0011\n\u0011\f\u0011\u00cb\t\u0011\u0001\u0011"+
		"\u0005\u0011\u00ce\b\u0011\n\u0011\f\u0011\u00d1\t\u0011\u0001\u0011\u0003"+
		"\u0011\u00d4\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00e2\b\u0013\n\u0013\f\u0013\u00e5\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u00ee\b\u0015\n\u0015\f\u0015\u00f1\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0004\u0018\u00fb\b\u0018\u000b\u0018\f\u0018\u00fc"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0102\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u010d\b\u001a\u0001\u001a\u0003\u001a"+
		"\u0110\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0000\u0000\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0004\u0001\u0000!"+
		"\"\u0001\u0000\u0015\u0016\u0002\u0000\t\u0013\u001e\u001e\u0001\u0000"+
		"\u0006\b\u0119\u0000=\u0001\u0000\u0000\u0000\u0002I\u0001\u0000\u0000"+
		"\u0000\u0004K\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000\u0000\b"+
		"R\u0001\u0000\u0000\u0000\n[\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000"+
		"\u0000\u000eo\u0001\u0000\u0000\u0000\u0010t\u0001\u0000\u0000\u0000\u0012"+
		"~\u0001\u0000\u0000\u0000\u0014\u0093\u0001\u0000\u0000\u0000\u0016\u0097"+
		"\u0001\u0000\u0000\u0000\u0018\u0099\u0001\u0000\u0000\u0000\u001a\u009e"+
		"\u0001\u0000\u0000\u0000\u001c\u00ac\u0001\u0000\u0000\u0000\u001e\u00af"+
		"\u0001\u0000\u0000\u0000 \u00bf\u0001\u0000\u0000\u0000\"\u00c2\u0001"+
		"\u0000\u0000\u0000$\u00d9\u0001\u0000\u0000\u0000&\u00dc\u0001\u0000\u0000"+
		"\u0000(\u00e6\u0001\u0000\u0000\u0000*\u00e9\u0001\u0000\u0000\u0000,"+
		"\u00f2\u0001\u0000\u0000\u0000.\u00f5\u0001\u0000\u0000\u00000\u00fa\u0001"+
		"\u0000\u0000\u00002\u0101\u0001\u0000\u0000\u00004\u010f\u0001\u0000\u0000"+
		"\u00006\u0111\u0001\u0000\u0000\u00008\u0113\u0001\u0000\u0000\u0000:"+
		"<\u0003\u0002\u0001\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0000\u0000\u0001A\u0001"+
		"\u0001\u0000\u0000\u0000BJ\u0003\u0006\u0003\u0000CJ\u0003\u001a\r\u0000"+
		"DJ\u0003\u001e\u000f\u0000EJ\u0003\"\u0011\u0000FJ\u0003\u0018\f\u0000"+
		"GJ\u0003.\u0017\u0000HJ\u0003\u0004\u0002\u0000IB\u0001\u0000\u0000\u0000"+
		"IC\u0001\u0000\u0000\u0000ID\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000"+
		"\u0000IF\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000"+
		"\u0000\u0000J\u0003\u0001\u0000\u0000\u0000KL\u0005\u001a\u0000\u0000"+
		"L\u0005\u0001\u0000\u0000\u0000MQ\u0003\u0010\b\u0000NQ\u0003\b\u0004"+
		"\u0000OQ\u0003\f\u0006\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RV\u0003"+
		"\n\u0005\u0000SU\u0003\u0002\u0001\u0000TS\u0001\u0000\u0000\u0000UX\u0001"+
		"\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WY\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0003\u000e\u0007"+
		"\u0000Z\t\u0001\u0000\u0000\u0000[\\\u0005\u0019\u0000\u0000\\`\u0005"+
		"\"\u0000\u0000]_\u0003\u0012\t\u0000^]\u0001\u0000\u0000\u0000_b\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005\u001c\u0000"+
		"\u0000d\u000b\u0001\u0000\u0000\u0000ef\u0005\u0019\u0000\u0000fj\u0007"+
		"\u0000\u0000\u0000gi\u0003\u0012\t\u0000hg\u0001\u0000\u0000\u0000il\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u001b\u0000"+
		"\u0000n\r\u0001\u0000\u0000\u0000op\u0005\u0019\u0000\u0000pq\u0005\u001d"+
		"\u0000\u0000qr\u0007\u0000\u0000\u0000rs\u0005\u001c\u0000\u0000s\u000f"+
		"\u0001\u0000\u0000\u0000tu\u0005\u0019\u0000\u0000uy\u0005!\u0000\u0000"+
		"vx\u0003\u0012\t\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|}\u0005\u001c\u0000\u0000}\u0011\u0001"+
		"\u0000\u0000\u0000~\u0081\u0005\"\u0000\u0000\u007f\u0080\u0005\u001e"+
		"\u0000\u0000\u0080\u0082\u0003\u0014\n\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0013\u0001\u0000\u0000"+
		"\u0000\u0083\u0087\u0005\u001f\u0000\u0000\u0084\u0086\u0003\u0016\u000b"+
		"\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u0094\u0005\u001f\u0000\u0000\u008b\u008f\u0005 \u0000\u0000"+
		"\u008c\u008e\u0003\u0016\u000b\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0094\u0005 \u0000\u0000\u0093"+
		"\u0083\u0001\u0000\u0000\u0000\u0093\u008b\u0001\u0000\u0000\u0000\u0094"+
		"\u0015\u0001\u0000\u0000\u0000\u0095\u0098\u0005\u0001\u0000\u0000\u0096"+
		"\u0098\u0003.\u0017\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0017\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0005\u0018\u0000\u0000\u009a\u009b\u0005(\u0000\u0000\u009b\u009c\u0007"+
		"\u0001\u0000\u0000\u009c\u009d\u0005&\u0000\u0000\u009d\u0019\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005\u0018\u0000\u0000\u009f\u00a0\u0005)\u0000"+
		"\u0000\u00a0\u00a1\u0005\u0016\u0000\u0000\u00a1\u00a5\u0005&\u0000\u0000"+
		"\u00a2\u00a4\u0003\u001c\u000e\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0018\u0000\u0000"+
		"\u00a9\u00aa\u0005*\u0000\u0000\u00aa\u00ab\u0005&\u0000\u0000\u00ab\u001b"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0004\u000e\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0002\u0001\u0000\u00ae\u001d\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0005\u0018\u0000\u0000\u00b0\u00b1\u0005+\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0016\u0000\u0000\u00b2\u00b3\u0005,\u0000\u0000\u00b3\u00b4\u00030\u0018"+
		"\u0000\u00b4\u00b8\u0005&\u0000\u0000\u00b5\u00b7\u0003 \u0010\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0005\u0018\u0000\u0000\u00bc\u00bd\u0005-\u0000\u0000\u00bd\u00be"+
		"\u0005&\u0000\u0000\u00be\u001f\u0001\u0000\u0000\u0000\u00bf\u00c0\u0004"+
		"\u0010\u0001\u0000\u00c0\u00c1\u0003\u0002\u0001\u0000\u00c1!\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u00c4\u0005.\u0000"+
		"\u0000\u00c4\u00c5\u00030\u0018\u0000\u00c5\u00c9\u0005&\u0000\u0000\u00c6"+
		"\u00c8\u0003$\u0012\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cf\u0001\u0000\u0000\u0000\u00cb\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003&\u0013\u0000\u00cd\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d4\u0003"+
		"*\u0015\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u0018"+
		"\u0000\u0000\u00d6\u00d7\u00051\u0000\u0000\u00d7\u00d8\u0005&\u0000\u0000"+
		"\u00d8#\u0001\u0000\u0000\u0000\u00d9\u00da\u0004\u0012\u0002\u0000\u00da"+
		"\u00db\u0003\u0002\u0001\u0000\u00db%\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0005\u0018\u0000\u0000\u00dd\u00de\u0005/\u0000\u0000\u00de\u00df\u0003"+
		"0\u0018\u0000\u00df\u00e3\u0005&\u0000\u0000\u00e0\u00e2\u0003(\u0014"+
		"\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e4\'\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0004\u0014\u0003\u0000\u00e7\u00e8\u0003\u0002\u0001\u0000"+
		"\u00e8)\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0018\u0000\u0000\u00ea"+
		"\u00eb\u00050\u0000\u0000\u00eb\u00ef\u0005&\u0000\u0000\u00ec\u00ee\u0003"+
		",\u0016\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f0+\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0004\u0016\u0004\u0000\u00f3\u00f4\u0003\u0002\u0001"+
		"\u0000\u00f4-\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0017\u0000\u0000"+
		"\u00f6\u00f7\u00030\u0018\u0000\u00f7\u00f8\u0005$\u0000\u0000\u00f8/"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fb\u00032\u0019\u0000\u00fa\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd1\u0001\u0000"+
		"\u0000\u0000\u00fe\u0102\u00034\u001a\u0000\u00ff\u0102\u00036\u001b\u0000"+
		"\u0100\u0102\u00038\u001c\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0101"+
		"\u00ff\u0001\u0000\u0000\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102"+
		"3\u0001\u0000\u0000\u0000\u0103\u0110\u0005\u0016\u0000\u0000\u0104\u0110"+
		"\u0005\u0014\u0000\u0000\u0105\u0110\u0005\u0015\u0000\u0000\u0106\u0107"+
		"\u0005\u0002\u0000\u0000\u0107\u0108\u00030\u0018\u0000\u0108\u0109\u0005"+
		"\u0003\u0000\u0000\u0109\u0110\u0001\u0000\u0000\u0000\u010a\u010c\u0005"+
		"\u0004\u0000\u0000\u010b\u010d\u00030\u0018\u0000\u010c\u010b\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u0110\u0005\u0005\u0000\u0000\u010f\u0103\u0001\u0000"+
		"\u0000\u0000\u010f\u0104\u0001\u0000\u0000\u0000\u010f\u0105\u0001\u0000"+
		"\u0000\u0000\u010f\u0106\u0001\u0000\u0000\u0000\u010f\u010a\u0001\u0000"+
		"\u0000\u0000\u01105\u0001\u0000\u0000\u0000\u0111\u0112\u0007\u0002\u0000"+
		"\u0000\u01127\u0001\u0000\u0000\u0000\u0113\u0114\u0007\u0003\u0000\u0000"+
		"\u01149\u0001\u0000\u0000\u0000\u0017=IPV`jy\u0081\u0087\u008f\u0093\u0097"+
		"\u00a5\u00b8\u00c9\u00cf\u00d3\u00e3\u00ef\u00fc\u0101\u010c\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}