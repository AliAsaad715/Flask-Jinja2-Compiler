// Generated from src/antlr/TemplateParser.g4 by ANTLR 4.13.2
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
		PIPE=9, PERCENT=10, GE=11, LE=12, EQEQ=13, NE=14, GT=15, LT=16, PLUS=17, 
		MINUS=18, STAR=19, SLASH=20, AND=21, OR=22, NOT=23, IS=24, TRUE=25, FALSE=26, 
		NONE=27, INT=28, FLOAT=29, STRING=30, ID=31, JINJA_EXPR_OPEN=32, JINJA_STMT_OPEN=33, 
		TAG_OPEN=34, TEXT=35, TAG_SELF_CLOSE=36, TAG_CLOSE=37, TAG_SLASH=38, EQ=39, 
		DQUOTE=40, SQUOTE=41, VOID_TAG_NAME=42, TAG_NAME=43, TAG_WS=44, JINJA_EXPR_CLOSE=45, 
		JINJA_WS_E=46, JINJA_STMT_CLOSE=47, JINJA_WS_S=48, EXTENDS=49, BLOCK=50, 
		ENDBLOCK=51, FOR=52, IN=53, ENDFOR=54, IF=55, ELIF=56, ELSE=57, ENDIF=58, 
		SET=59, WITH=60, ENDWITH=61, LPAREN_E=62, RPAREN_E=63, LBRACK_E=64, RBRACK_E=65, 
		COMMA_E=66, DOT_E=67, COLON_E=68, PIPE_E=69, GE_E=70, LE_E=71, EQEQ_E=72, 
		NE_E=73, PLUS_E=74, MINUS_E=75, STAR_E=76, PERCENT_E=77, AND_E=78, OR_E=79, 
		NOT_E=80, IS_E=81, IN_E=82, IF_E=83, ELSE_E=84;
	public static final int
		RULE_template = 0, RULE_item = 1, RULE_htmlText = 2, RULE_htmlElement = 3, 
		RULE_normalElement = 4, RULE_openTag = 5, RULE_selfClosingElement = 6, 
		RULE_closeTag = 7, RULE_voidElement = 8, RULE_attribute = 9, RULE_attrValue = 10, 
		RULE_attrValuePart = 11, RULE_jinjaExtends = 12, RULE_jinjaBlock = 13, 
		RULE_blockBodyItem = 14, RULE_jinjaFor = 15, RULE_forBodyItem = 16, RULE_jinjaIf = 17, 
		RULE_ifThenBodyItem = 18, RULE_jinjaElif = 19, RULE_elifBodyItem = 20, 
		RULE_jinjaElse = 21, RULE_jinjaWith = 22, RULE_withBodyItem = 23, RULE_elseBodyItem = 24, 
		RULE_jinjaPrint = 25, RULE_expr = 26, RULE_condExpr = 27, RULE_orExpr = 28, 
		RULE_andExpr = 29, RULE_notExpr = 30, RULE_comparison = 31, RULE_compOp = 32, 
		RULE_filterExpr = 33, RULE_filterCall = 34, RULE_additive = 35, RULE_multiplicative = 36, 
		RULE_unary = 37, RULE_postfix = 38, RULE_trailer = 39, RULE_subscript = 40, 
		RULE_argList = 41, RULE_argument = 42, RULE_primary = 43, RULE_exprList = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "item", "htmlText", "htmlElement", "normalElement", "openTag", 
			"selfClosingElement", "closeTag", "voidElement", "attribute", "attrValue", 
			"attrValuePart", "jinjaExtends", "jinjaBlock", "blockBodyItem", "jinjaFor", 
			"forBodyItem", "jinjaIf", "ifThenBodyItem", "jinjaElif", "elifBodyItem", 
			"jinjaElse", "jinjaWith", "withBodyItem", "elseBodyItem", "jinjaPrint", 
			"expr", "condExpr", "orExpr", "andExpr", "notExpr", "comparison", "compOp", 
			"filterExpr", "filterCall", "additive", "multiplicative", "unary", "postfix", 
			"trailer", "subscript", "argList", "argument", "primary", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'{{'", "'{%'", null, 
			null, "'/>'", null, null, null, null, null, null, null, null, "'}}'", 
			null, "'%}'", null, "'extends'", "'block'", "'endblock'", "'for'", null, 
			"'endfor'", null, "'elif'", null, "'endif'", "'set'", "'with'", "'endwith'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ATTR_TEXT", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", 
			"COLON", "PIPE", "PERCENT", "GE", "LE", "EQEQ", "NE", "GT", "LT", "PLUS", 
			"MINUS", "STAR", "SLASH", "AND", "OR", "NOT", "IS", "TRUE", "FALSE", 
			"NONE", "INT", "FLOAT", "STRING", "ID", "JINJA_EXPR_OPEN", "JINJA_STMT_OPEN", 
			"TAG_OPEN", "TEXT", "TAG_SELF_CLOSE", "TAG_CLOSE", "TAG_SLASH", "EQ", 
			"DQUOTE", "SQUOTE", "VOID_TAG_NAME", "TAG_NAME", "TAG_WS", "JINJA_EXPR_CLOSE", 
			"JINJA_WS_E", "JINJA_STMT_CLOSE", "JINJA_WS_S", "EXTENDS", "BLOCK", "ENDBLOCK", 
			"FOR", "IN", "ENDFOR", "IF", "ELIF", "ELSE", "ENDIF", "SET", "WITH", 
			"ENDWITH", "LPAREN_E", "RPAREN_E", "LBRACK_E", "RBRACK_E", "COMMA_E", 
			"DOT_E", "COLON_E", "PIPE_E", "GE_E", "LE_E", "EQEQ_E", "NE_E", "PLUS_E", 
			"MINUS_E", "STAR_E", "PERCENT_E", "AND_E", "OR_E", "NOT_E", "IS_E", "IN_E", 
			"IF_E", "ELSE_E"
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
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) {
				{
				{
				setState(90);
				item();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				htmlElement();
				}
				break;
			case 2:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				jinjaBlock();
				}
				break;
			case 3:
				_localctx = new JinjaForItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				jinjaFor();
				}
				break;
			case 4:
				_localctx = new JinjaIfItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				jinjaIf();
				}
				break;
			case 5:
				_localctx = new JinjaWithItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				jinjaWith();
				}
				break;
			case 6:
				_localctx = new JinjaExtendsItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				jinjaExtends();
				}
				break;
			case 7:
				_localctx = new JinjaPrintItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				jinjaPrint();
				}
				break;
			case 8:
				_localctx = new HtmlTextItemContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
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
			setState(108);
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
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlVoidElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				voidElement();
				}
				break;
			case 2:
				_localctx = new HtmlNormalElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				normalElement();
				}
				break;
			case 3:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
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
			setState(115);
			openTag();
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116);
					item();
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(122);
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
			setState(124);
			match(TAG_OPEN);
			setState(125);
			match(TAG_NAME);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(126);
				attribute();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
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
			setState(134);
			match(TAG_OPEN);
			setState(135);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(136);
				attribute();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
			setState(144);
			match(TAG_OPEN);
			setState(145);
			match(TAG_SLASH);
			setState(146);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(147);
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
			setState(149);
			match(TAG_OPEN);
			setState(150);
			match(VOID_TAG_NAME);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(151);
				attribute();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
			setState(159);
			match(TAG_NAME);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(160);
				match(EQ);
				setState(161);
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
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(DQUOTE);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(165);
					attrValuePart();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(SQUOTE);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_TEXT || _la==JINJA_EXPR_OPEN) {
					{
					{
					setState(173);
					attrValuePart();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
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
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttrTextValuePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(ATTR_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaPrintValuePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
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
			setState(186);
			match(JINJA_STMT_OPEN);
			setState(187);
			match(EXTENDS);
			setState(188);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
			setState(191);
			match(JINJA_STMT_OPEN);
			setState(192);
			match(BLOCK);
			setState(193);
			match(ID);
			setState(194);
			match(JINJA_STMT_CLOSE);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					blockBodyItem();
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(201);
			match(JINJA_STMT_OPEN);
			setState(202);
			match(ENDBLOCK);
			setState(203);
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
			setState(205);
			if (!( !nextIsEndBlock() )) throw new FailedPredicateException(this, " !nextIsEndBlock() ");
			setState(206);
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
		public List<TerminalNode> ID() { return getTokens(TemplateParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TemplateParser.ID, i);
		}
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDFOR() { return getToken(TemplateParser.ENDFOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TemplateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TemplateParser.COMMA, i);
		}
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(JINJA_STMT_OPEN);
			setState(209);
			match(FOR);
			setState(210);
			match(ID);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(211);
				match(COMMA);
				setState(212);
				match(ID);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			match(IN);
			setState(219);
			expr();
			setState(220);
			match(JINJA_STMT_CLOSE);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					forBodyItem();
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(227);
			match(JINJA_STMT_OPEN);
			setState(228);
			match(ENDFOR);
			setState(229);
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
			setState(231);
			if (!( !nextIsEndFor() )) throw new FailedPredicateException(this, " !nextIsEndFor() ");
			setState(232);
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
			setState(234);
			match(JINJA_STMT_OPEN);
			setState(235);
			match(IF);
			setState(236);
			expr();
			setState(237);
			match(JINJA_STMT_CLOSE);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(238);
					ifThenBodyItem();
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(244);
					jinjaElif();
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(250);
				jinjaElse();
				}
				break;
			}
			setState(253);
			match(JINJA_STMT_OPEN);
			setState(254);
			match(ENDIF);
			setState(255);
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
			setState(257);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(258);
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
			setState(260);
			match(JINJA_STMT_OPEN);
			setState(261);
			match(ELIF);
			setState(262);
			expr();
			setState(263);
			match(JINJA_STMT_CLOSE);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					elifBodyItem();
					}
					} 
				}
				setState(269);
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
			setState(270);
			if (!( !nextIsIfBranchOrEnd() )) throw new FailedPredicateException(this, " !nextIsIfBranchOrEnd() ");
			setState(271);
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
			setState(273);
			match(JINJA_STMT_OPEN);
			setState(274);
			match(ELSE);
			setState(275);
			match(JINJA_STMT_CLOSE);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(276);
					elseBodyItem();
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public Token name;
		public ExprContext value;
		public List<TerminalNode> JINJA_STMT_OPEN() { return getTokens(TemplateParser.JINJA_STMT_OPEN); }
		public TerminalNode JINJA_STMT_OPEN(int i) {
			return getToken(TemplateParser.JINJA_STMT_OPEN, i);
		}
		public TerminalNode WITH() { return getToken(TemplateParser.WITH, 0); }
		public List<TerminalNode> JINJA_STMT_CLOSE() { return getTokens(TemplateParser.JINJA_STMT_CLOSE); }
		public TerminalNode JINJA_STMT_CLOSE(int i) {
			return getToken(TemplateParser.JINJA_STMT_CLOSE, i);
		}
		public TerminalNode ENDWITH() { return getToken(TemplateParser.ENDWITH, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public List<WithBodyItemContext> withBodyItem() {
			return getRuleContexts(WithBodyItemContext.class);
		}
		public WithBodyItemContext withBodyItem(int i) {
			return getRuleContext(WithBodyItemContext.class,i);
		}
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(JINJA_STMT_OPEN);
			setState(283);
			match(WITH);
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(284);
				((JinjaWithContext)_localctx).name = match(ID);
				setState(285);
				match(EQ);
				}
				break;
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
				{
				setState(288);
				((JinjaWithContext)_localctx).value = expr();
				}
			}

			setState(291);
			match(JINJA_STMT_CLOSE);
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(292);
					withBodyItem();
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(298);
			match(JINJA_STMT_OPEN);
			setState(299);
			match(ENDWITH);
			setState(300);
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
			setState(302);
			if (!( !nextIsEndWith() )) throw new FailedPredicateException(this, " !nextIsEndWith() ");
			setState(303);
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
			setState(305);
			if (!( !nextIsEndIf() )) throw new FailedPredicateException(this, " !nextIsEndIf() ");
			setState(306);
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
			setState(308);
			match(JINJA_EXPR_OPEN);
			setState(309);
			expr();
			setState(310);
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
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			condExpr();
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
	public static class CondExprContext extends ParserRuleContext {
		public List<OrExprContext> orExpr() {
			return getRuleContexts(OrExprContext.class);
		}
		public OrExprContext orExpr(int i) {
			return getRuleContext(OrExprContext.class,i);
		}
		public TerminalNode IF() { return getToken(TemplateParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(TemplateParser.ELSE, 0); }
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCondExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCondExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		CondExprContext _localctx = new CondExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_condExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			orExpr();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(315);
				match(IF);
				setState(316);
				orExpr();
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(317);
					match(ELSE);
					setState(318);
					condExpr();
					}
				}

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
	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TemplateParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TemplateParser.OR, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			andExpr();
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(324);
				match(OR);
				setState(325);
				andExpr();
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class AndExprContext extends ParserRuleContext {
		public List<NotExprContext> notExpr() {
			return getRuleContexts(NotExprContext.class);
		}
		public NotExprContext notExpr(int i) {
			return getRuleContext(NotExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TemplateParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TemplateParser.AND, i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			notExpr();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(332);
				match(AND);
				setState(333);
				notExpr();
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class NotExprContext extends ParserRuleContext {
		public NotExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpr; }
	 
		public NotExprContext() { }
		public void copyFrom(NotExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotPassthroughContext extends NotExprContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public NotPassthroughContext(NotExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterNotPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitNotPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitNotPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotUnaryContext extends NotExprContext {
		public TerminalNode NOT() { return getToken(TemplateParser.NOT, 0); }
		public NotExprContext notExpr() {
			return getRuleContext(NotExprContext.class,0);
		}
		public NotUnaryContext(NotExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterNotUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitNotUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitNotUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExprContext notExpr() throws RecognitionException {
		NotExprContext _localctx = new NotExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_notExpr);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new NotUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(NOT);
				setState(340);
				notExpr();
				}
				break;
			case LPAREN:
			case LBRACK:
			case MINUS:
			case TRUE:
			case FALSE:
			case NONE:
			case INT:
			case FLOAT:
			case STRING:
			case ID:
				_localctx = new NotPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				comparison();
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
	public static class ComparisonContext extends ParserRuleContext {
		public List<FilterExprContext> filterExpr() {
			return getRuleContexts(FilterExprContext.class);
		}
		public FilterExprContext filterExpr(int i) {
			return getRuleContext(FilterExprContext.class,i);
		}
		public List<CompOpContext> compOp() {
			return getRuleContexts(CompOpContext.class);
		}
		public CompOpContext compOp(int i) {
			return getRuleContext(CompOpContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			filterExpr();
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199280035840L) != 0)) {
				{
				{
				setState(345);
				compOp();
				setState(346);
				filterExpr();
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
	 
		public CompOpContext() { }
		public void copyFrom(CompOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompNotEqContext extends CompOpContext {
		public TerminalNode NE() { return getToken(TemplateParser.NE, 0); }
		public CompNotEqContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompNotEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompNotEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompNotEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompInContext extends CompOpContext {
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public CompInContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompIn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompIsNotContext extends CompOpContext {
		public TerminalNode IS() { return getToken(TemplateParser.IS, 0); }
		public TerminalNode NOT() { return getToken(TemplateParser.NOT, 0); }
		public CompIsNotContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompIsNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompIsNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompIsNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompLtContext extends CompOpContext {
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public CompLtContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompLt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompGtContext extends CompOpContext {
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public CompGtContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompGt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompGeContext extends CompOpContext {
		public TerminalNode GE() { return getToken(TemplateParser.GE, 0); }
		public CompGeContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompGe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompGe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompGe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompNotInContext extends CompOpContext {
		public TerminalNode NOT() { return getToken(TemplateParser.NOT, 0); }
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public CompNotInContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompNotIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompNotIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompNotIn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompLeContext extends CompOpContext {
		public TerminalNode LE() { return getToken(TemplateParser.LE, 0); }
		public CompLeContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompLe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompLe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompLe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompIsContext extends CompOpContext {
		public TerminalNode IS() { return getToken(TemplateParser.IS, 0); }
		public CompIsContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompIs(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompEqContext extends CompOpContext {
		public TerminalNode EQEQ() { return getToken(TemplateParser.EQEQ, 0); }
		public CompEqContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCompEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCompEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCompEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_compOp);
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new CompEqContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				match(EQEQ);
				}
				break;
			case 2:
				_localctx = new CompNotEqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				match(NE);
				}
				break;
			case 3:
				_localctx = new CompLeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				match(LE);
				}
				break;
			case 4:
				_localctx = new CompGeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				match(GE);
				}
				break;
			case 5:
				_localctx = new CompLtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(357);
				match(LT);
				}
				break;
			case 6:
				_localctx = new CompGtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(358);
				match(GT);
				}
				break;
			case 7:
				_localctx = new CompNotInContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(359);
				match(NOT);
				setState(360);
				match(IN);
				}
				break;
			case 8:
				_localctx = new CompInContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(361);
				match(IN);
				}
				break;
			case 9:
				_localctx = new CompIsNotContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(362);
				match(IS);
				setState(363);
				match(NOT);
				}
				break;
			case 10:
				_localctx = new CompIsContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(364);
				match(IS);
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
	public static class FilterExprContext extends ParserRuleContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public List<TerminalNode> PIPE() { return getTokens(TemplateParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(TemplateParser.PIPE, i);
		}
		public List<FilterCallContext> filterCall() {
			return getRuleContexts(FilterCallContext.class);
		}
		public FilterCallContext filterCall(int i) {
			return getRuleContext(FilterCallContext.class,i);
		}
		public FilterExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterExprContext filterExpr() throws RecognitionException {
		FilterExprContext _localctx = new FilterExprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_filterExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			additive();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(368);
				match(PIPE);
				setState(369);
				filterCall();
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class FilterCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(TemplateParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TemplateParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FilterCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterFilterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitFilterCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitFilterCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterCallContext filterCall() throws RecognitionException {
		FilterCallContext _localctx = new FilterCallContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_filterCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(ID);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(376);
				match(LPAREN);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
					{
					setState(377);
					argList();
					}
				}

				setState(380);
				match(RPAREN);
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
	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(TemplateParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(TemplateParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TemplateParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TemplateParser.MINUS, i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAdditive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAdditive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			multiplicative();
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(384);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(385);
				multiplicative();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class MultiplicativeContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(TemplateParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(TemplateParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(TemplateParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(TemplateParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(TemplateParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(TemplateParser.PERCENT, i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitMultiplicative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitMultiplicative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			unary();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1573888L) != 0)) {
				{
				{
				setState(392);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1573888L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(393);
				unary();
				}
				}
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPassthroughContext extends UnaryContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public UnaryPassthroughContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterUnaryPassthrough(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitUnaryPassthrough(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitUnaryPassthrough(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusContext extends UnaryContext {
		public TerminalNode MINUS() { return getToken(TemplateParser.MINUS, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public UnaryMinusContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unary);
		try {
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new UnaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(MINUS);
				setState(400);
				unary();
				}
				break;
			case LPAREN:
			case LBRACK:
			case TRUE:
			case FALSE:
			case NONE:
			case INT:
			case FLOAT:
			case STRING:
			case ID:
				_localctx = new UnaryPassthroughContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				postfix();
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
	public static class PostfixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TrailerContext> trailer() {
			return getRuleContexts(TrailerContext.class);
		}
		public TrailerContext trailer(int i) {
			return getRuleContext(TrailerContext.class,i);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPostfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			primary();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 148L) != 0)) {
				{
				{
				setState(405);
				trailer();
				}
				}
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class TrailerContext extends ParserRuleContext {
		public TrailerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailer; }
	 
		public TrailerContext() { }
		public void copyFrom(TrailerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrailerIndexContext extends TrailerContext {
		public TerminalNode LBRACK() { return getToken(TemplateParser.LBRACK, 0); }
		public SubscriptContext subscript() {
			return getRuleContext(SubscriptContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(TemplateParser.RBRACK, 0); }
		public TrailerIndexContext(TrailerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterTrailerIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitTrailerIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitTrailerIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrailerCallContext extends TrailerContext {
		public TerminalNode LPAREN() { return getToken(TemplateParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TemplateParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TrailerCallContext(TrailerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterTrailerCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitTrailerCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitTrailerCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrailerAttrContext extends TrailerContext {
		public TerminalNode DOT() { return getToken(TemplateParser.DOT, 0); }
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public TrailerAttrContext(TrailerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterTrailerAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitTrailerAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitTrailerAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailerContext trailer() throws RecognitionException {
		TrailerContext _localctx = new TrailerContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_trailer);
		int _la;
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new TrailerAttrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(DOT);
				setState(412);
				match(ID);
				}
				break;
			case LBRACK:
				_localctx = new TrailerIndexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				match(LBRACK);
				setState(414);
				subscript();
				setState(415);
				match(RBRACK);
				}
				break;
			case LPAREN:
				_localctx = new TrailerCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(417);
				match(LPAREN);
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
					{
					setState(418);
					argList();
					}
				}

				setState(421);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubscriptContext extends ParserRuleContext {
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
	 
		public SubscriptContext() { }
		public void copyFrom(SubscriptContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubscriptIndexContext extends SubscriptContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubscriptIndexContext(SubscriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSubscriptIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSubscriptIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSubscriptIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubscriptSliceContext extends SubscriptContext {
		public ExprContext start;
		public ExprContext stop;
		public TerminalNode COLON() { return getToken(TemplateParser.COLON, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubscriptSliceContext(SubscriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSubscriptSlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSubscriptSlice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSubscriptSlice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_subscript);
		int _la;
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new SubscriptIndexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				expr();
				}
				break;
			case 2:
				_localctx = new SubscriptSliceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
					{
					setState(425);
					((SubscriptSliceContext)_localctx).start = expr();
					}
				}

				setState(428);
				match(COLON);
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
					{
					setState(429);
					((SubscriptSliceContext)_localctx).stop = expr();
					}
				}

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
	public static class ArgListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TemplateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TemplateParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_argList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			argument();
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(435);
					match(COMMA);
					setState(436);
					argument();
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(442);
				match(COMMA);
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
	public static class ArgumentContext extends ParserRuleContext {
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	 
		public ArgumentContext() { }
		public void copyFrom(ArgumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgKeywordContext extends ArgumentContext {
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgKeywordContext(ArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterArgKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitArgKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitArgKeyword(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgPositionalContext extends ArgumentContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgPositionalContext(ArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterArgPositional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitArgPositional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitArgPositional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_argument);
		try {
			setState(449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ArgKeywordContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				match(ID);
				setState(446);
				match(EQ);
				setState(447);
				expr();
				}
				break;
			case 2:
				_localctx = new ArgPositionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				expr();
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
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryListContext extends PrimaryContext {
		public TerminalNode LBRACK() { return getToken(TemplateParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(TemplateParser.RBRACK, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public PrimaryListContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryStringContext extends PrimaryContext {
		public TerminalNode STRING() { return getToken(TemplateParser.STRING, 0); }
		public PrimaryStringContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryTrueContext extends PrimaryContext {
		public TerminalNode TRUE() { return getToken(TemplateParser.TRUE, 0); }
		public PrimaryTrueContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryFloatContext extends PrimaryContext {
		public TerminalNode FLOAT() { return getToken(TemplateParser.FLOAT, 0); }
		public PrimaryFloatContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryIntContext extends PrimaryContext {
		public TerminalNode INT() { return getToken(TemplateParser.INT, 0); }
		public PrimaryIntContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryFalseContext extends PrimaryContext {
		public TerminalNode FALSE() { return getToken(TemplateParser.FALSE, 0); }
		public PrimaryFalseContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoneContext extends PrimaryContext {
		public TerminalNode NONE() { return getToken(TemplateParser.NONE, 0); }
		public PrimaryNoneContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryNone(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryParenContext extends PrimaryContext {
		public TerminalNode LPAREN() { return getToken(TemplateParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TemplateParser.RPAREN, 0); }
		public PrimaryParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryIdContext extends PrimaryContext {
		public TerminalNode ID() { return getToken(TemplateParser.ID, 0); }
		public PrimaryIdContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterPrimaryId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitPrimaryId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitPrimaryId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_primary);
		int _la;
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new PrimaryIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				match(ID);
				}
				break;
			case INT:
				_localctx = new PrimaryIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new PrimaryFloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(453);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new PrimaryStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(454);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new PrimaryTrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(455);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new PrimaryFalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(456);
				match(FALSE);
				}
				break;
			case NONE:
				_localctx = new PrimaryNoneContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(457);
				match(NONE);
				}
				break;
			case LPAREN:
				_localctx = new PrimaryParenContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(458);
				match(LPAREN);
				setState(459);
				expr();
				setState(460);
				match(RPAREN);
				}
				break;
			case LBRACK:
				_localctx = new PrimaryListContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(462);
				match(LBRACK);
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4270063636L) != 0)) {
					{
					setState(463);
					exprList();
					}
				}

				setState(466);
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
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TemplateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TemplateParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_exprList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			expr();
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(470);
					match(COMMA);
					setState(471);
					expr();
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(477);
				match(COMMA);
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
		"\u0004\u0001T\u01e1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0005\u0000\\\b\u0000\n\u0000\f\u0000_\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001k\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003r\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0005\u0004v\b\u0004\n\u0004\f\u0004y\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0080"+
		"\b\u0005\n\u0005\f\u0005\u0083\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u008a\b\u0006\n\u0006\f\u0006\u008d"+
		"\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c"+
		"\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u00a3\b\t\u0001\n"+
		"\u0001\n\u0005\n\u00a7\b\n\n\n\f\n\u00aa\t\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00af\b\n\n\n\f\n\u00b2\t\n\u0001\n\u0003\n\u00b5\b\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00b9\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c5\b\r\n\r\f\r\u00c8"+
		"\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00d6\b\u000f\n\u000f\f\u000f\u00d9\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00df\b\u000f\n\u000f\f\u000f\u00e2\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u00f0\b\u0011\n\u0011\f\u0011\u00f3\t\u0011\u0001\u0011\u0005"+
		"\u0011\u00f6\b\u0011\n\u0011\f\u0011\u00f9\t\u0011\u0001\u0011\u0003\u0011"+
		"\u00fc\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u010a\b\u0013\n\u0013\f\u0013\u010d\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0116\b\u0015\n\u0015\f\u0015\u0119\t\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u011f\b\u0016\u0001\u0016"+
		"\u0003\u0016\u0122\b\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0126\b"+
		"\u0016\n\u0016\f\u0016\u0129\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u0140\b\u001b\u0003\u001b\u0142\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u0147\b\u001c\n\u001c\f\u001c\u014a\t\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u014f\b\u001d\n\u001d"+
		"\f\u001d\u0152\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0157\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u015d\b\u001f\n\u001f\f\u001f\u0160\t\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u016e"+
		"\b \u0001!\u0001!\u0001!\u0005!\u0173\b!\n!\f!\u0176\t!\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u017b\b\"\u0001\"\u0003\"\u017e\b\"\u0001#\u0001#\u0001"+
		"#\u0005#\u0183\b#\n#\f#\u0186\t#\u0001$\u0001$\u0001$\u0005$\u018b\b$"+
		"\n$\f$\u018e\t$\u0001%\u0001%\u0001%\u0003%\u0193\b%\u0001&\u0001&\u0005"+
		"&\u0197\b&\n&\f&\u019a\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u01a4\b\'\u0001\'\u0003\'\u01a7\b\'\u0001("+
		"\u0001(\u0003(\u01ab\b(\u0001(\u0001(\u0003(\u01af\b(\u0003(\u01b1\b("+
		"\u0001)\u0001)\u0001)\u0005)\u01b6\b)\n)\f)\u01b9\t)\u0001)\u0003)\u01bc"+
		"\b)\u0001*\u0001*\u0001*\u0001*\u0003*\u01c2\b*\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003"+
		"+\u01d1\b+\u0001+\u0003+\u01d4\b+\u0001,\u0001,\u0001,\u0005,\u01d9\b"+
		",\n,\f,\u01dc\t,\u0001,\u0003,\u01df\b,\u0001,\u0000\u0000-\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVX\u0000\u0004\u0001\u0000*+\u0001\u0000\u001e"+
		"\u001f\u0001\u0000\u0011\u0012\u0002\u0000\n\n\u0013\u0014\u01fb\u0000"+
		"]\u0001\u0000\u0000\u0000\u0002j\u0001\u0000\u0000\u0000\u0004l\u0001"+
		"\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000\bs\u0001\u0000\u0000"+
		"\u0000\n|\u0001\u0000\u0000\u0000\f\u0086\u0001\u0000\u0000\u0000\u000e"+
		"\u0090\u0001\u0000\u0000\u0000\u0010\u0095\u0001\u0000\u0000\u0000\u0012"+
		"\u009f\u0001\u0000\u0000\u0000\u0014\u00b4\u0001\u0000\u0000\u0000\u0016"+
		"\u00b8\u0001\u0000\u0000\u0000\u0018\u00ba\u0001\u0000\u0000\u0000\u001a"+
		"\u00bf\u0001\u0000\u0000\u0000\u001c\u00cd\u0001\u0000\u0000\u0000\u001e"+
		"\u00d0\u0001\u0000\u0000\u0000 \u00e7\u0001\u0000\u0000\u0000\"\u00ea"+
		"\u0001\u0000\u0000\u0000$\u0101\u0001\u0000\u0000\u0000&\u0104\u0001\u0000"+
		"\u0000\u0000(\u010e\u0001\u0000\u0000\u0000*\u0111\u0001\u0000\u0000\u0000"+
		",\u011a\u0001\u0000\u0000\u0000.\u012e\u0001\u0000\u0000\u00000\u0131"+
		"\u0001\u0000\u0000\u00002\u0134\u0001\u0000\u0000\u00004\u0138\u0001\u0000"+
		"\u0000\u00006\u013a\u0001\u0000\u0000\u00008\u0143\u0001\u0000\u0000\u0000"+
		":\u014b\u0001\u0000\u0000\u0000<\u0156\u0001\u0000\u0000\u0000>\u0158"+
		"\u0001\u0000\u0000\u0000@\u016d\u0001\u0000\u0000\u0000B\u016f\u0001\u0000"+
		"\u0000\u0000D\u0177\u0001\u0000\u0000\u0000F\u017f\u0001\u0000\u0000\u0000"+
		"H\u0187\u0001\u0000\u0000\u0000J\u0192\u0001\u0000\u0000\u0000L\u0194"+
		"\u0001\u0000\u0000\u0000N\u01a6\u0001\u0000\u0000\u0000P\u01b0\u0001\u0000"+
		"\u0000\u0000R\u01b2\u0001\u0000\u0000\u0000T\u01c1\u0001\u0000\u0000\u0000"+
		"V\u01d3\u0001\u0000\u0000\u0000X\u01d5\u0001\u0000\u0000\u0000Z\\\u0003"+
		"\u0002\u0001\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`a\u0005\u0000\u0000\u0001a\u0001\u0001"+
		"\u0000\u0000\u0000bk\u0003\u0006\u0003\u0000ck\u0003\u001a\r\u0000dk\u0003"+
		"\u001e\u000f\u0000ek\u0003\"\u0011\u0000fk\u0003,\u0016\u0000gk\u0003"+
		"\u0018\f\u0000hk\u00032\u0019\u0000ik\u0003\u0004\u0002\u0000jb\u0001"+
		"\u0000\u0000\u0000jc\u0001\u0000\u0000\u0000jd\u0001\u0000\u0000\u0000"+
		"je\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000jg\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0003\u0001"+
		"\u0000\u0000\u0000lm\u0005#\u0000\u0000m\u0005\u0001\u0000\u0000\u0000"+
		"nr\u0003\u0010\b\u0000or\u0003\b\u0004\u0000pr\u0003\f\u0006\u0000qn\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"r\u0007\u0001\u0000\u0000\u0000sw\u0003\n\u0005\u0000tv\u0003\u0002\u0001"+
		"\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000z{\u0003\u000e\u0007\u0000{\t\u0001\u0000\u0000\u0000"+
		"|}\u0005\"\u0000\u0000}\u0081\u0005+\u0000\u0000~\u0080\u0003\u0012\t"+
		"\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005%\u0000\u0000\u0085\u000b\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005\"\u0000\u0000\u0087\u008b\u0007\u0000\u0000\u0000\u0088\u008a"+
		"\u0003\u0012\t\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008d\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005$\u0000\u0000\u008f\r\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005\"\u0000\u0000\u0091\u0092\u0005&\u0000"+
		"\u0000\u0092\u0093\u0007\u0000\u0000\u0000\u0093\u0094\u0005%\u0000\u0000"+
		"\u0094\u000f\u0001\u0000\u0000\u0000\u0095\u0096\u0005\"\u0000\u0000\u0096"+
		"\u009a\u0005*\u0000\u0000\u0097\u0099\u0003\u0012\t\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005%\u0000\u0000\u009e\u0011\u0001\u0000\u0000\u0000\u009f\u00a2\u0005"+
		"+\u0000\u0000\u00a0\u00a1\u0005\'\u0000\u0000\u00a1\u00a3\u0003\u0014"+
		"\n\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a3\u0013\u0001\u0000\u0000\u0000\u00a4\u00a8\u0005(\u0000\u0000"+
		"\u00a5\u00a7\u0003\u0016\u000b\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00b5\u0005(\u0000\u0000\u00ac"+
		"\u00b0\u0005)\u0000\u0000\u00ad\u00af\u0003\u0016\u000b\u0000\u00ae\u00ad"+
		"\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b5"+
		"\u0005)\u0000\u0000\u00b4\u00a4\u0001\u0000\u0000\u0000\u00b4\u00ac\u0001"+
		"\u0000\u0000\u0000\u00b5\u0015\u0001\u0000\u0000\u0000\u00b6\u00b9\u0005"+
		"\u0001\u0000\u0000\u00b7\u00b9\u00032\u0019\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u0017\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005!\u0000\u0000\u00bb\u00bc\u00051\u0000\u0000"+
		"\u00bc\u00bd\u0007\u0001\u0000\u0000\u00bd\u00be\u0005/\u0000\u0000\u00be"+
		"\u0019\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005!\u0000\u0000\u00c0\u00c1"+
		"\u00052\u0000\u0000\u00c1\u00c2\u0005\u001f\u0000\u0000\u00c2\u00c6\u0005"+
		"/\u0000\u0000\u00c3\u00c5\u0003\u001c\u000e\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005!\u0000"+
		"\u0000\u00ca\u00cb\u00053\u0000\u0000\u00cb\u00cc\u0005/\u0000\u0000\u00cc"+
		"\u001b\u0001\u0000\u0000\u0000\u00cd\u00ce\u0004\u000e\u0000\u0000\u00ce"+
		"\u00cf\u0003\u0002\u0001\u0000\u00cf\u001d\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005!\u0000\u0000\u00d1\u00d2\u00054\u0000\u0000\u00d2\u00d7\u0005"+
		"\u001f\u0000\u0000\u00d3\u00d4\u0005\u0006\u0000\u0000\u00d4\u00d6\u0005"+
		"\u001f\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u00055\u0000\u0000\u00db\u00dc\u00034\u001a"+
		"\u0000\u00dc\u00e0\u0005/\u0000\u0000\u00dd\u00df\u0003 \u0010\u0000\u00de"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005!\u0000\u0000\u00e4\u00e5\u00056\u0000\u0000\u00e5\u00e6\u0005"+
		"/\u0000\u0000\u00e6\u001f\u0001\u0000\u0000\u0000\u00e7\u00e8\u0004\u0010"+
		"\u0001\u0000\u00e8\u00e9\u0003\u0002\u0001\u0000\u00e9!\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0005!\u0000\u0000\u00eb\u00ec\u00057\u0000\u0000\u00ec"+
		"\u00ed\u00034\u001a\u0000\u00ed\u00f1\u0005/\u0000\u0000\u00ee\u00f0\u0003"+
		"$\u0012\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f7\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f6\u0003&\u0013\u0000\u00f5\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000"+
		"\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fc\u0003*\u0015\u0000"+
		"\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005!\u0000\u0000\u00fe"+
		"\u00ff\u0005:\u0000\u0000\u00ff\u0100\u0005/\u0000\u0000\u0100#\u0001"+
		"\u0000\u0000\u0000\u0101\u0102\u0004\u0012\u0002\u0000\u0102\u0103\u0003"+
		"\u0002\u0001\u0000\u0103%\u0001\u0000\u0000\u0000\u0104\u0105\u0005!\u0000"+
		"\u0000\u0105\u0106\u00058\u0000\u0000\u0106\u0107\u00034\u001a\u0000\u0107"+
		"\u010b\u0005/\u0000\u0000\u0108\u010a\u0003(\u0014\u0000\u0109\u0108\u0001"+
		"\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\'\u0001\u0000"+
		"\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0004\u0014"+
		"\u0003\u0000\u010f\u0110\u0003\u0002\u0001\u0000\u0110)\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0005!\u0000\u0000\u0112\u0113\u00059\u0000\u0000\u0113"+
		"\u0117\u0005/\u0000\u0000\u0114\u0116\u00030\u0018\u0000\u0115\u0114\u0001"+
		"\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118+\u0001\u0000"+
		"\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0005!\u0000"+
		"\u0000\u011b\u011e\u0005<\u0000\u0000\u011c\u011d\u0005\u001f\u0000\u0000"+
		"\u011d\u011f\u0005\'\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u00034\u001a\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0127"+
		"\u0005/\u0000\u0000\u0124\u0126\u0003.\u0017\u0000\u0125\u0124\u0001\u0000"+
		"\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u012a\u0001\u0000"+
		"\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012b\u0005!\u0000"+
		"\u0000\u012b\u012c\u0005=\u0000\u0000\u012c\u012d\u0005/\u0000\u0000\u012d"+
		"-\u0001\u0000\u0000\u0000\u012e\u012f\u0004\u0017\u0004\u0000\u012f\u0130"+
		"\u0003\u0002\u0001\u0000\u0130/\u0001\u0000\u0000\u0000\u0131\u0132\u0004"+
		"\u0018\u0005\u0000\u0132\u0133\u0003\u0002\u0001\u0000\u01331\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0005 \u0000\u0000\u0135\u0136\u00034\u001a\u0000"+
		"\u0136\u0137\u0005-\u0000\u0000\u01373\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u00036\u001b\u0000\u01395\u0001\u0000\u0000\u0000\u013a\u0141\u00038"+
		"\u001c\u0000\u013b\u013c\u00057\u0000\u0000\u013c\u013f\u00038\u001c\u0000"+
		"\u013d\u013e\u00059\u0000\u0000\u013e\u0140\u00036\u001b\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0142"+
		"\u0001\u0000\u0000\u0000\u0141\u013b\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0001\u0000\u0000\u0000\u01427\u0001\u0000\u0000\u0000\u0143\u0148\u0003"+
		":\u001d\u0000\u0144\u0145\u0005\u0016\u0000\u0000\u0145\u0147\u0003:\u001d"+
		"\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000"+
		"\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000"+
		"\u0000\u01499\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000"+
		"\u014b\u0150\u0003<\u001e\u0000\u014c\u014d\u0005\u0015\u0000\u0000\u014d"+
		"\u014f\u0003<\u001e\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u0152"+
		"\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0001\u0000\u0000\u0000\u0151;\u0001\u0000\u0000\u0000\u0152\u0150\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0005\u0017\u0000\u0000\u0154\u0157\u0003"+
		"<\u001e\u0000\u0155\u0157\u0003>\u001f\u0000\u0156\u0153\u0001\u0000\u0000"+
		"\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157=\u0001\u0000\u0000\u0000"+
		"\u0158\u015e\u0003B!\u0000\u0159\u015a\u0003@ \u0000\u015a\u015b\u0003"+
		"B!\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u0159\u0001\u0000\u0000"+
		"\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000"+
		"\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f?\u0001\u0000\u0000\u0000"+
		"\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u016e\u0005\r\u0000\u0000\u0162"+
		"\u016e\u0005\u000e\u0000\u0000\u0163\u016e\u0005\f\u0000\u0000\u0164\u016e"+
		"\u0005\u000b\u0000\u0000\u0165\u016e\u0005\u0010\u0000\u0000\u0166\u016e"+
		"\u0005\u000f\u0000\u0000\u0167\u0168\u0005\u0017\u0000\u0000\u0168\u016e"+
		"\u00055\u0000\u0000\u0169\u016e\u00055\u0000\u0000\u016a\u016b\u0005\u0018"+
		"\u0000\u0000\u016b\u016e\u0005\u0017\u0000\u0000\u016c\u016e\u0005\u0018"+
		"\u0000\u0000\u016d\u0161\u0001\u0000\u0000\u0000\u016d\u0162\u0001\u0000"+
		"\u0000\u0000\u016d\u0163\u0001\u0000\u0000\u0000\u016d\u0164\u0001\u0000"+
		"\u0000\u0000\u016d\u0165\u0001\u0000\u0000\u0000\u016d\u0166\u0001\u0000"+
		"\u0000\u0000\u016d\u0167\u0001\u0000\u0000\u0000\u016d\u0169\u0001\u0000"+
		"\u0000\u0000\u016d\u016a\u0001\u0000\u0000\u0000\u016d\u016c\u0001\u0000"+
		"\u0000\u0000\u016eA\u0001\u0000\u0000\u0000\u016f\u0174\u0003F#\u0000"+
		"\u0170\u0171\u0005\t\u0000\u0000\u0171\u0173\u0003D\"\u0000\u0172\u0170"+
		"\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0172"+
		"\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175C\u0001"+
		"\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177\u017d\u0005"+
		"\u001f\u0000\u0000\u0178\u017a\u0005\u0002\u0000\u0000\u0179\u017b\u0003"+
		"R)\u0000\u017a\u0179\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017e\u0005\u0003\u0000"+
		"\u0000\u017d\u0178\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017eE\u0001\u0000\u0000\u0000\u017f\u0184\u0003H$\u0000\u0180"+
		"\u0181\u0007\u0002\u0000\u0000\u0181\u0183\u0003H$\u0000\u0182\u0180\u0001"+
		"\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184\u0182\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185G\u0001\u0000"+
		"\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u018c\u0003J%\u0000"+
		"\u0188\u0189\u0007\u0003\u0000\u0000\u0189\u018b\u0003J%\u0000\u018a\u0188"+
		"\u0001\u0000\u0000\u0000\u018b\u018e\u0001\u0000\u0000\u0000\u018c\u018a"+
		"\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018dI\u0001"+
		"\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018f\u0190\u0005"+
		"\u0012\u0000\u0000\u0190\u0193\u0003J%\u0000\u0191\u0193\u0003L&\u0000"+
		"\u0192\u018f\u0001\u0000\u0000\u0000\u0192\u0191\u0001\u0000\u0000\u0000"+
		"\u0193K\u0001\u0000\u0000\u0000\u0194\u0198\u0003V+\u0000\u0195\u0197"+
		"\u0003N\'\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197\u019a\u0001"+
		"\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199M\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0005\u0007\u0000\u0000\u019c\u01a7\u0005\u001f"+
		"\u0000\u0000\u019d\u019e\u0005\u0004\u0000\u0000\u019e\u019f\u0003P(\u0000"+
		"\u019f\u01a0\u0005\u0005\u0000\u0000\u01a0\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a3\u0005\u0002\u0000\u0000\u01a2\u01a4\u0003R)\u0000\u01a3\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a7\u0005\u0003\u0000\u0000\u01a6\u019b"+
		"\u0001\u0000\u0000\u0000\u01a6\u019d\u0001\u0000\u0000\u0000\u01a6\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a7O\u0001\u0000\u0000\u0000\u01a8\u01b1\u0003"+
		"4\u001a\u0000\u01a9\u01ab\u00034\u001a\u0000\u01aa\u01a9\u0001\u0000\u0000"+
		"\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000"+
		"\u0000\u01ac\u01ae\u0005\b\u0000\u0000\u01ad\u01af\u00034\u001a\u0000"+
		"\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000"+
		"\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01a8\u0001\u0000\u0000\u0000"+
		"\u01b0\u01aa\u0001\u0000\u0000\u0000\u01b1Q\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b7\u0003T*\u0000\u01b3\u01b4\u0005\u0006\u0000\u0000\u01b4\u01b6\u0003"+
		"T*\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6\u01b9\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000"+
		"\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000"+
		"\u0000\u01ba\u01bc\u0005\u0006\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000"+
		"\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bcS\u0001\u0000\u0000\u0000"+
		"\u01bd\u01be\u0005\u001f\u0000\u0000\u01be\u01bf\u0005\'\u0000\u0000\u01bf"+
		"\u01c2\u00034\u001a\u0000\u01c0\u01c2\u00034\u001a\u0000\u01c1\u01bd\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c2U\u0001\u0000"+
		"\u0000\u0000\u01c3\u01d4\u0005\u001f\u0000\u0000\u01c4\u01d4\u0005\u001c"+
		"\u0000\u0000\u01c5\u01d4\u0005\u001d\u0000\u0000\u01c6\u01d4\u0005\u001e"+
		"\u0000\u0000\u01c7\u01d4\u0005\u0019\u0000\u0000\u01c8\u01d4\u0005\u001a"+
		"\u0000\u0000\u01c9\u01d4\u0005\u001b\u0000\u0000\u01ca\u01cb\u0005\u0002"+
		"\u0000\u0000\u01cb\u01cc\u00034\u001a\u0000\u01cc\u01cd\u0005\u0003\u0000"+
		"\u0000\u01cd\u01d4\u0001\u0000\u0000\u0000\u01ce\u01d0\u0005\u0004\u0000"+
		"\u0000\u01cf\u01d1\u0003X,\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d4\u0005\u0005\u0000\u0000\u01d3\u01c3\u0001\u0000\u0000\u0000\u01d3"+
		"\u01c4\u0001\u0000\u0000\u0000\u01d3\u01c5\u0001\u0000\u0000\u0000\u01d3"+
		"\u01c6\u0001\u0000\u0000\u0000\u01d3\u01c7\u0001\u0000\u0000\u0000\u01d3"+
		"\u01c8\u0001\u0000\u0000\u0000\u01d3\u01c9\u0001\u0000\u0000\u0000\u01d3"+
		"\u01ca\u0001\u0000\u0000\u0000\u01d3\u01ce\u0001\u0000\u0000\u0000\u01d4"+
		"W\u0001\u0000\u0000\u0000\u01d5\u01da\u00034\u001a\u0000\u01d6\u01d7\u0005"+
		"\u0006\u0000\u0000\u01d7\u01d9\u00034\u001a\u0000\u01d8\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01de\u0001\u0000"+
		"\u0000\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01df\u0005\u0006"+
		"\u0000\u0000\u01de\u01dd\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000"+
		"\u0000\u0000\u01dfY\u0001\u0000\u0000\u00001]jqw\u0081\u008b\u009a\u00a2"+
		"\u00a8\u00b0\u00b4\u00b8\u00c6\u00d7\u00e0\u00f1\u00f7\u00fb\u010b\u0117"+
		"\u011e\u0121\u0127\u013f\u0141\u0148\u0150\u0156\u015e\u016d\u0174\u017a"+
		"\u017d\u0184\u018c\u0192\u0198\u01a3\u01a6\u01aa\u01ae\u01b0\u01b7\u01bb"+
		"\u01c1\u01d0\u01d3\u01da\u01de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}