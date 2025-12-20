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
		SET=50, WITH=51, ENDWITH=52, LPAREN_E=53, RPAREN_E=54, LBRACK_E=55, RBRACK_E=56, 
		COMMA_E=57, DOT_E=58, COLON_E=59, PIPE_E=60, GE_E=61, LE_E=62, EQEQ_E=63, 
		NE_E=64, PLUS_E=65, MINUS_E=66, STAR_E=67;
	public static final int
		RULE_template = 0, RULE_item = 1, RULE_htmlText = 2, RULE_htmlElement = 3, 
		RULE_normalElement = 4, RULE_openTag = 5, RULE_selfClosingElement = 6, 
		RULE_closeTag = 7, RULE_voidElement = 8, RULE_attribute = 9, RULE_attrValue = 10, 
		RULE_attrValuePart = 11, RULE_jinjaExtends = 12, RULE_jinjaBlock = 13, 
		RULE_blockBodyItem = 14, RULE_jinjaFor = 15, RULE_forBodyItem = 16, RULE_jinjaIf = 17, 
		RULE_ifThenBodyItem = 18, RULE_jinjaElif = 19, RULE_elifBodyItem = 20, 
		RULE_jinjaElse = 21, RULE_jinjaWith = 22, RULE_withBodyItem = 23, RULE_elseBodyItem = 24, 
		RULE_jinjaPrint = 25, RULE_expr = 26, RULE_exprUnit = 27, RULE_atom = 28, 
		RULE_op = 29, RULE_punct = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "item", "htmlText", "htmlElement", "normalElement", "openTag", 
			"selfClosingElement", "closeTag", "voidElement", "attribute", "attrValue", 
			"attrValuePart", "jinjaExtends", "jinjaBlock", "blockBodyItem", "jinjaFor", 
			"forBodyItem", "jinjaIf", "ifThenBodyItem", "jinjaElif", "elifBodyItem", 
			"jinjaElse", "jinjaWith", "withBodyItem", "elseBodyItem", "jinjaPrint", 
			"expr", "exprUnit", "atom", "op", "punct"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'{{'", 
			"'{%'", null, null, "'/>'", null, null, null, null, null, null, null, 
			null, "'}}'", null, "'%}'", null, "'extends'", "'block'", "'endblock'", 
			"'for'", "'in'", "'endfor'", "'if'", "'elif'", "'else'", "'endif'", "'set'", 
			"'with'", "'endwith'"
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
			"FOR", "IN", "ENDFOR", "IF", "ELIF", "ELSE", "ENDIF", "SET", "WITH", 
			"ENDWITH", "LPAREN_E", "RPAREN_E", "LBRACK_E", "RBRACK_E", "COMMA_E", 
			"DOT_E", "COLON_E", "PIPE_E", "GE_E", "LE_E", "EQEQ_E", "NE_E", "PLUS_E", 
			"MINUS_E", "STAR_E"
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
	    private boolean nextIsEndWith() {
	        return nextIsStmt(ENDWITH);
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				{
				setState(62);
				item();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
	public static class JinjaWithItemContext extends ItemContext {
		public JinjaWithContext jinjaWith() {
			return getRuleContext(JinjaWithContext.class,0);
		}
		public JinjaWithItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaWithItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaWithItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaWithItem(this);
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
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				htmlElement();
				}
				break;
			case 2:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				jinjaBlock();
				}
				break;
			case 3:
				_localctx = new JinjaForItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				jinjaFor();
				}
				break;
			case 4:
				_localctx = new JinjaIfItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				jinjaIf();
				}
				break;
			case 5:
				_localctx = new JinjaWithItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				jinjaWith();
				}
				break;
			case 6:
				_localctx = new JinjaExtendsItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				jinjaExtends();
				}
				break;
			case 7:
				_localctx = new JinjaPrintItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				jinjaPrint();
				}
				break;
			case 8:
				_localctx = new HtmlTextItemContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
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
			setState(80);
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
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlVoidElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				voidElement();
				}
				break;
			case 2:
				_localctx = new HtmlNormalElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				normalElement();
				}
				break;
			case 3:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
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
			setState(87);
			openTag();
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					item();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(94);
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
			setState(96);
			match(TAG_OPEN);
			setState(97);
			match(TAG_NAME);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(98);
				attribute();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
			setState(106);
			match(TAG_OPEN);
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(108);
				attribute();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
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
			setState(116);
			match(TAG_OPEN);
			setState(117);
			match(TAG_SLASH);
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(119);
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
			setState(121);
			match(TAG_OPEN);
			setState(122);
			match(VOID_TAG_NAME);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(123);
				attribute();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
			setState(131);
			match(TAG_NAME);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(132);
				match(EQ);
				setState(133);
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
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(DQUOTE);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(137);
					attrValuePart();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(SQUOTE);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(145);
					attrValuePart();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
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
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttrTextValuePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(ATTR_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaPrintValuePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
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
			setState(158);
			match(JINJA_STMT_OPEN);
			setState(159);
			match(EXTENDS);
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(161);
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
			setState(163);
			match(JINJA_STMT_OPEN);
			setState(164);
			match(BLOCK);
			setState(165);
			match(ID);
			setState(166);
			match(JINJA_STMT_CLOSE);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					blockBodyItem();
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(173);
			match(JINJA_STMT_OPEN);
			setState(174);
			match(ENDBLOCK);
			setState(175);
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
			setState(177);
			if (!( !nextIsEndBlock() )) throw new FailedPredicateException(this, " !nextIsEndBlock() ");
			setState(178);
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
			setState(180);
			match(JINJA_STMT_OPEN);
			setState(181);
			match(FOR);
			setState(182);
			match(ID);
			setState(183);
			match(IN);
			setState(184);
			expr();
			setState(185);
			match(JINJA_STMT_CLOSE);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					forBodyItem();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(192);
			match(JINJA_STMT_OPEN);
			setState(193);
			match(ENDFOR);
			setState(194);
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
			setState(196);
			if (!( !nextIsEndFor() )) throw new FailedPredicateException(this, " !nextIsEndFor() ");
			setState(197);
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
			setState(199);
			match(JINJA_STMT_OPEN);
			setState(200);
			match(IF);
			setState(201);
			expr();
			setState(202);
			match(JINJA_STMT_CLOSE);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(203);
					ifThenBodyItem();
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(209);
					jinjaElif();
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(215);
				jinjaElse();
				}
				break;
			}
			setState(218);
			match(JINJA_STMT_OPEN);
			setState(219);
			match(ENDIF);
			setState(220);
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
			setState(222);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(223);
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
			setState(225);
			match(JINJA_STMT_OPEN);
			setState(226);
			match(ELIF);
			setState(227);
			expr();
			setState(228);
			match(JINJA_STMT_CLOSE);
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					elifBodyItem();
					}
					} 
				}
				setState(234);
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
			setState(235);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(236);
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
			setState(238);
			match(JINJA_STMT_OPEN);
			setState(239);
			match(ELSE);
			setState(240);
			match(JINJA_STMT_CLOSE);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(241);
					elseBodyItem();
					}
					} 
				}
				setState(246);
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
	public static class JinjaWithContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_OPEN() { return getTokens(TemplateParser.JINJA_STMT_OPEN); }
		public TerminalNode JINJA_STMT_OPEN(int i) {
			return getToken(TemplateParser.JINJA_STMT_OPEN, i);
		}
		public TerminalNode WITH() { return getToken(TemplateParser.WITH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDWITH() { return getToken(TemplateParser.ENDWITH, 0); }
		public List<WithBodyItemContext> withBodyItem() {
			return getRuleContexts(WithBodyItemContext.class);
		}
		public WithBodyItemContext withBodyItem(int i) {
			return getRuleContext(WithBodyItemContext.class,i);
		}
		public JinjaWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaWith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaWithContext jinjaWith() throws RecognitionException {
		JinjaWithContext _localctx = new JinjaWithContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_jinjaWith);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(JINJA_STMT_OPEN);
			setState(248);
			match(WITH);
			setState(249);
			expr();
			setState(250);
			match(JINJA_STMT_CLOSE);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					withBodyItem();
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(257);
			match(JINJA_STMT_OPEN);
			setState(258);
			match(ENDWITH);
			setState(259);
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
	public static class WithBodyItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public WithBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withBodyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterWithBodyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitWithBodyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitWithBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithBodyItemContext withBodyItem() throws RecognitionException {
		WithBodyItemContext _localctx = new WithBodyItemContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_withBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			if (!( !nextIsEndWith() )) throw new FailedPredicateException(this, " !nextIsEndWith() ");
			setState(262);
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
		enterRule(_localctx, 48, RULE_elseBodyItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			if (!( !nextIsEndIf() )) throw new FailedPredicateException(this, " !nextIsEndIf() ");
			setState(265);
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
		enterRule(_localctx, 50, RULE_jinjaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(JINJA_EXPR_OPEN);
			setState(268);
			expr();
			setState(269);
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
		enterRule(_localctx, 52, RULE_expr);
		int _la;
		try {
			_localctx = new ExprSequenceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(272); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(271);
				exprUnit();
				}
				}
				setState(274); 
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
		enterRule(_localctx, 54, RULE_exprUnit);
		try {
			setState(279);
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
				setState(276);
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
				setState(277);
				op();
				}
				break;
			case COMMA:
			case DOT:
			case COLON:
				_localctx = new ExprPunctUnitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
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
		enterRule(_localctx, 56, RULE_atom);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AtomIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(ID);
				}
				break;
			case INT:
				_localctx = new AtomIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new AtomStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(STRING);
				}
				break;
			case LPAREN:
				_localctx = new AtomParenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(284);
				match(LPAREN);
				setState(285);
				expr();
				setState(286);
				match(RPAREN);
				}
				break;
			case LBRACK:
				_localctx = new AtomBracketContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(288);
				match(LBRACK);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082130388L) != 0)) {
					{
					setState(289);
					expr();
					}
				}

				setState(292);
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
		enterRule(_localctx, 58, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
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
		enterRule(_localctx, 60, RULE_punct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		case 23:
			return withBodyItem_sempred((WithBodyItemContext)_localctx, predIndex);
		case 24:
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
	private boolean withBodyItem_sempred(WithBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  !nextIsEndWith() ;
		}
		return true;
	}
	private boolean elseBodyItem_sempred(ElseBodyItemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return  !nextIsEndIf() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001C\u012c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003V\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004Z\b\u0004\n\u0004\f\u0004]\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"d\b\u0005\n\u0005\f\u0005g\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006q\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b}\b\b\n\b\f\b\u0080\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u0087\b\t\u0001\n\u0001\n\u0005"+
		"\n\u008b\b\n\n\n\f\n\u008e\t\n\u0001\n\u0001\n\u0001\n\u0005\n\u0093\b"+
		"\n\n\n\f\n\u0096\t\n\u0001\n\u0003\n\u0099\b\n\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u009d\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00a9\b\r\n\r\f\r\u00ac\t\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00bc\b\u000f\n\u000f\f\u000f\u00bf\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00cd\b\u0011\n\u0011\f\u0011\u00d0\t\u0011\u0001\u0011\u0005\u0011\u00d3"+
		"\b\u0011\n\u0011\f\u0011\u00d6\t\u0011\u0001\u0011\u0003\u0011\u00d9\b"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00e7\b\u0013\n\u0013\f\u0013\u00ea\t\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00f3\b\u0015\n\u0015\f\u0015\u00f6\t\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00fd\b\u0016\n"+
		"\u0016\f\u0016\u0100\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0004"+
		"\u001a\u0111\b\u001a\u000b\u001a\f\u001a\u0112\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0118\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0123\b\u001c\u0001\u001c\u0003\u001c\u0126\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0000\u0000\u001f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<\u0000\u0004\u0001\u0000!\"\u0001\u0000\u0015"+
		"\u0016\u0002\u0000\t\u0013\u001e\u001e\u0001\u0000\u0006\b\u012f\u0000"+
		"A\u0001\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000\u0004P\u0001"+
		"\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\bW\u0001\u0000\u0000"+
		"\u0000\n`\u0001\u0000\u0000\u0000\fj\u0001\u0000\u0000\u0000\u000et\u0001"+
		"\u0000\u0000\u0000\u0010y\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000"+
		"\u0000\u0000\u0014\u0098\u0001\u0000\u0000\u0000\u0016\u009c\u0001\u0000"+
		"\u0000\u0000\u0018\u009e\u0001\u0000\u0000\u0000\u001a\u00a3\u0001\u0000"+
		"\u0000\u0000\u001c\u00b1\u0001\u0000\u0000\u0000\u001e\u00b4\u0001\u0000"+
		"\u0000\u0000 \u00c4\u0001\u0000\u0000\u0000\"\u00c7\u0001\u0000\u0000"+
		"\u0000$\u00de\u0001\u0000\u0000\u0000&\u00e1\u0001\u0000\u0000\u0000("+
		"\u00eb\u0001\u0000\u0000\u0000*\u00ee\u0001\u0000\u0000\u0000,\u00f7\u0001"+
		"\u0000\u0000\u0000.\u0105\u0001\u0000\u0000\u00000\u0108\u0001\u0000\u0000"+
		"\u00002\u010b\u0001\u0000\u0000\u00004\u0110\u0001\u0000\u0000\u00006"+
		"\u0117\u0001\u0000\u0000\u00008\u0125\u0001\u0000\u0000\u0000:\u0127\u0001"+
		"\u0000\u0000\u0000<\u0129\u0001\u0000\u0000\u0000>@\u0003\u0002\u0001"+
		"\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000DE\u0005\u0000\u0000\u0001E\u0001\u0001\u0000\u0000"+
		"\u0000FO\u0003\u0006\u0003\u0000GO\u0003\u001a\r\u0000HO\u0003\u001e\u000f"+
		"\u0000IO\u0003\"\u0011\u0000JO\u0003,\u0016\u0000KO\u0003\u0018\f\u0000"+
		"LO\u00032\u0019\u0000MO\u0003\u0004\u0002\u0000NF\u0001\u0000\u0000\u0000"+
		"NG\u0001\u0000\u0000\u0000NH\u0001\u0000\u0000\u0000NI\u0001\u0000\u0000"+
		"\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0003\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u001a\u0000\u0000Q\u0005\u0001\u0000\u0000\u0000RV\u0003\u0010"+
		"\b\u0000SV\u0003\b\u0004\u0000TV\u0003\f\u0006\u0000UR\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0007\u0001"+
		"\u0000\u0000\u0000W[\u0003\n\u0005\u0000XZ\u0003\u0002\u0001\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^_\u0003\u000e\u0007\u0000_\t\u0001\u0000\u0000\u0000`a\u0005\u0019"+
		"\u0000\u0000ae\u0005\"\u0000\u0000bd\u0003\u0012\t\u0000cb\u0001\u0000"+
		"\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"hi\u0005\u001c\u0000\u0000i\u000b\u0001\u0000\u0000\u0000jk\u0005\u0019"+
		"\u0000\u0000ko\u0007\u0000\u0000\u0000ln\u0003\u0012\t\u0000ml\u0001\u0000"+
		"\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"rs\u0005\u001b\u0000\u0000s\r\u0001\u0000\u0000\u0000tu\u0005\u0019\u0000"+
		"\u0000uv\u0005\u001d\u0000\u0000vw\u0007\u0000\u0000\u0000wx\u0005\u001c"+
		"\u0000\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0005\u0019\u0000\u0000"+
		"z~\u0005!\u0000\u0000{}\u0003\u0012\t\u0000|{\u0001\u0000\u0000\u0000"+
		"}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\u001c\u0000\u0000\u0082\u0011\u0001\u0000"+
		"\u0000\u0000\u0083\u0086\u0005\"\u0000\u0000\u0084\u0085\u0005\u001e\u0000"+
		"\u0000\u0085\u0087\u0003\u0014\n\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0013\u0001\u0000\u0000\u0000"+
		"\u0088\u008c\u0005\u001f\u0000\u0000\u0089\u008b\u0003\u0016\u000b\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008f\u0099\u0005\u001f\u0000\u0000\u0090\u0094\u0005 \u0000\u0000\u0091"+
		"\u0093\u0003\u0016\u000b\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096"+
		"\u0094\u0001\u0000\u0000\u0000\u0097\u0099\u0005 \u0000\u0000\u0098\u0088"+
		"\u0001\u0000\u0000\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0099\u0015"+
		"\u0001\u0000\u0000\u0000\u009a\u009d\u0005\u0001\u0000\u0000\u009b\u009d"+
		"\u00032\u0019\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u0017\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\u0018\u0000\u0000\u009f\u00a0\u0005(\u0000\u0000\u00a0\u00a1\u0007\u0001"+
		"\u0000\u0000\u00a1\u00a2\u0005&\u0000\u0000\u00a2\u0019\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u00a5\u0005)\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0016\u0000\u0000\u00a6\u00aa\u0005&\u0000\u0000\u00a7"+
		"\u00a9\u0003\u001c\u000e\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0018\u0000\u0000\u00ae"+
		"\u00af\u0005*\u0000\u0000\u00af\u00b0\u0005&\u0000\u0000\u00b0\u001b\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0004\u000e\u0000\u0000\u00b2\u00b3\u0003"+
		"\u0002\u0001\u0000\u00b3\u001d\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0018\u0000\u0000\u00b5\u00b6\u0005+\u0000\u0000\u00b6\u00b7\u0005\u0016"+
		"\u0000\u0000\u00b7\u00b8\u0005,\u0000\u0000\u00b8\u00b9\u00034\u001a\u0000"+
		"\u00b9\u00bd\u0005&\u0000\u0000\u00ba\u00bc\u0003 \u0010\u0000\u00bb\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0005\u0018\u0000\u0000\u00c1\u00c2\u0005-\u0000\u0000\u00c2\u00c3\u0005"+
		"&\u0000\u0000\u00c3\u001f\u0001\u0000\u0000\u0000\u00c4\u00c5\u0004\u0010"+
		"\u0001\u0000\u00c5\u00c6\u0003\u0002\u0001\u0000\u00c6!\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0018\u0000\u0000\u00c8\u00c9\u0005.\u0000\u0000"+
		"\u00c9\u00ca\u00034\u001a\u0000\u00ca\u00ce\u0005&\u0000\u0000\u00cb\u00cd"+
		"\u0003$\u0012\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d4\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d3\u0003&\u0013\u0000\u00d2\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d9\u0003*\u0015"+
		"\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0018\u0000"+
		"\u0000\u00db\u00dc\u00051\u0000\u0000\u00dc\u00dd\u0005&\u0000\u0000\u00dd"+
		"#\u0001\u0000\u0000\u0000\u00de\u00df\u0004\u0012\u0002\u0000\u00df\u00e0"+
		"\u0003\u0002\u0001\u0000\u00e0%\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005"+
		"\u0018\u0000\u0000\u00e2\u00e3\u0005/\u0000\u0000\u00e3\u00e4\u00034\u001a"+
		"\u0000\u00e4\u00e8\u0005&\u0000\u0000\u00e5\u00e7\u0003(\u0014\u0000\u00e6"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9"+
		"\'\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0004\u0014\u0003\u0000\u00ec\u00ed\u0003\u0002\u0001\u0000\u00ed)\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0005\u0018\u0000\u0000\u00ef\u00f0\u0005"+
		"0\u0000\u0000\u00f0\u00f4\u0005&\u0000\u0000\u00f1\u00f3\u00030\u0018"+
		"\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5+\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005\u0018\u0000\u0000\u00f8\u00f9\u00053\u0000\u0000\u00f9"+
		"\u00fa\u00034\u001a\u0000\u00fa\u00fe\u0005&\u0000\u0000\u00fb\u00fd\u0003"+
		".\u0017\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000"+
		"\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000"+
		"\u0000\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000"+
		"\u0000\u0000\u0101\u0102\u0005\u0018\u0000\u0000\u0102\u0103\u00054\u0000"+
		"\u0000\u0103\u0104\u0005&\u0000\u0000\u0104-\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0004\u0017\u0004\u0000\u0106\u0107\u0003\u0002\u0001\u0000\u0107"+
		"/\u0001\u0000\u0000\u0000\u0108\u0109\u0004\u0018\u0005\u0000\u0109\u010a"+
		"\u0003\u0002\u0001\u0000\u010a1\u0001\u0000\u0000\u0000\u010b\u010c\u0005"+
		"\u0017\u0000\u0000\u010c\u010d\u00034\u001a\u0000\u010d\u010e\u0005$\u0000"+
		"\u0000\u010e3\u0001\u0000\u0000\u0000\u010f\u0111\u00036\u001b\u0000\u0110"+
		"\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113"+
		"5\u0001\u0000\u0000\u0000\u0114\u0118\u00038\u001c\u0000\u0115\u0118\u0003"+
		":\u001d\u0000\u0116\u0118\u0003<\u001e\u0000\u0117\u0114\u0001\u0000\u0000"+
		"\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0116\u0001\u0000\u0000"+
		"\u0000\u01187\u0001\u0000\u0000\u0000\u0119\u0126\u0005\u0016\u0000\u0000"+
		"\u011a\u0126\u0005\u0014\u0000\u0000\u011b\u0126\u0005\u0015\u0000\u0000"+
		"\u011c\u011d\u0005\u0002\u0000\u0000\u011d\u011e\u00034\u001a\u0000\u011e"+
		"\u011f\u0005\u0003\u0000\u0000\u011f\u0126\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u0005\u0004\u0000\u0000\u0121\u0123\u00034\u001a\u0000\u0122\u0121"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0001\u0000\u0000\u0000\u0124\u0126\u0005\u0005\u0000\u0000\u0125\u0119"+
		"\u0001\u0000\u0000\u0000\u0125\u011a\u0001\u0000\u0000\u0000\u0125\u011b"+
		"\u0001\u0000\u0000\u0000\u0125\u011c\u0001\u0000\u0000\u0000\u0125\u0120"+
		"\u0001\u0000\u0000\u0000\u01269\u0001\u0000\u0000\u0000\u0127\u0128\u0007"+
		"\u0002\u0000\u0000\u0128;\u0001\u0000\u0000\u0000\u0129\u012a\u0007\u0003"+
		"\u0000\u0000\u012a=\u0001\u0000\u0000\u0000\u0018ANU[eo~\u0086\u008c\u0094"+
		"\u0098\u009c\u00aa\u00bd\u00ce\u00d4\u00d8\u00e8\u00f4\u00fe\u0112\u0117"+
		"\u0122\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}