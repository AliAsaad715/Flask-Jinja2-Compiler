// Generated from src/antlr/PythonLexer.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, FROM=3, IMPORT=4, AS=5, DEFINETION=6, RETURN=7, IF=8, 
		ELIF=9, ELSE=10, FOR=11, IN=12, IS=13, AND=14, OR=15, NOT=16, NONE=17, 
		TRUE=18, FALSE=19, DECORATOR=20, DOT=21, COMMA=22, COLON=23, EQEQ=24, 
		NOTEQ=25, LE=26, GE=27, LT=28, GT=29, EQUAL=30, PLUS=31, MINUS=32, STAR=33, 
		SLASH=34, PERCENT=35, OPEN_B=36, CLOSE_B=37, LBRACK=38, RBRACK=39, LBRACE=40, 
		RBRACE=41, FLOAT_VALUE=42, INT_VALUE=43, STRING=44, ID=45, LINE_JOINING=46, 
		COMMENT=47, NEWLINE=48, WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FROM", "IMPORT", "AS", "DEFINETION", "RETURN", "IF", "ELIF", "ELSE", 
			"FOR", "IN", "IS", "AND", "OR", "NOT", "NONE", "TRUE", "FALSE", "DECORATOR", 
			"DOT", "COMMA", "COLON", "EQEQ", "NOTEQ", "LE", "GE", "LT", "GT", "EQUAL", 
			"PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "OPEN_B", "CLOSE_B", "LBRACK", 
			"RBRACK", "LBRACE", "RBRACE", "FLOAT_VALUE", "INT_VALUE", "STRING", "ID", 
			"LINE_JOINING", "COMMENT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'from'", "'import'", "'as'", "'def'", "'return'", 
			"'if'", "'elif'", "'else'", "'for'", "'in'", "'is'", "'and'", "'or'", 
			"'not'", "'None'", "'True'", "'False'", "'@'", "'.'", "','", "':'", "'=='", 
			"'!='", "'<='", "'>='", "'<'", "'>'", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "FROM", "IMPORT", "AS", "DEFINETION", "RETURN", 
			"IF", "ELIF", "ELSE", "FOR", "IN", "IS", "AND", "OR", "NOT", "NONE", 
			"TRUE", "FALSE", "DECORATOR", "DOT", "COMMA", "COLON", "EQEQ", "NOTEQ", 
			"LE", "GE", "LT", "GT", "EQUAL", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", 
			"OPEN_B", "CLOSE_B", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "FLOAT_VALUE", 
			"INT_VALUE", "STRING", "ID", "LINE_JOINING", "COMMENT", "NEWLINE", "WS"
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


	    private java.util.LinkedList<Token> pendingTokens = new java.util.LinkedList<>();
	        private java.util.Stack<Integer> indents = new java.util.Stack<>();
	        private int opened = 0;

	        private boolean initialized = false;
	        private org.antlr.v4.runtime.Token lastToken = null;

	        @Override
	        public org.antlr.v4.runtime.Token nextToken() {

	            if (!initialized) {
	                indents.push(0);
	                initialized = true;
	            }

	            if (!pendingTokens.isEmpty()) {
	                org.antlr.v4.runtime.Token t = pendingTokens.poll();

	                if (t.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
	                    lastToken = t;
	                }
	                return t;
	            }

	            org.antlr.v4.runtime.Token next = super.nextToken();

	            if (next.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL
	                    && indents.size() == 1
	                    && (lastToken == null || lastToken.getType() == NEWLINE)
	                    && next.getCharPositionInLine() > 0
	                    && next.getType() != NEWLINE
	                    && next.getType() != EOF) {
	                throw new RuntimeException("IndentationError: unexpected indent at line " + next.getLine());
	            }

	            if (next.getType() == EOF) {

	                if (lastToken != null && lastToken.getType() != NEWLINE) {
	                    pendingTokens.add(commonToken(NEWLINE, "\n"));
	                }

	                while (indents.size() > 1) {
	                    indents.pop();
	                    pendingTokens.add(commonToken(DEDENT, ""));
	                }

	                pendingTokens.add(next);
	                org.antlr.v4.runtime.Token t = pendingTokens.poll();

	                if (t.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
	                    lastToken = t;
	                }
	                return t;
	            }

	            if (next.getChannel() == org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
	                lastToken = next;
	            }

	            return next;
	        }


	    private org.antlr.v4.runtime.CommonToken commonToken(int type, String text) {
	        org.antlr.v4.runtime.CommonToken t =
	                new org.antlr.v4.runtime.CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, -1, -1);
	        t.setText(text);
	        t.setLine(getLine());
	        t.setCharPositionInLine(getCharPositionInLine());
	        return t;
	    }

	    private int getIndentationCount(String spaces) {
	        int count = 0;
	        for (int i = 0; i < spaces.length(); i++) {
	            if (spaces.charAt(i) == '\t') {
	                count += 8 - (count % 8);
	            } else {
	                count++;
	            }
	        }
	        return count;
	    }


	public PythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 33:
			OPEN_B_action((RuleContext)_localctx, actionIndex);
			break;
		case 34:
			CLOSE_B_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			LBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 36:
			RBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			LBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void OPEN_B_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			opened++;
			break;
		}
	}
	private void CLOSE_B_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 if (opened > 0) opened--; 
			break;
		}
	}
	private void LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened++;
			break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 if (opened > 0) opened--; 
			break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened++;
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 if (opened > 0) opened--; 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

			        String newLine = getText().replaceAll("[^\r\n]+", "");
			        String spaces  = getText().replaceAll("[\r\n]+", "");

			        int next = _input.LA(1);

			        if (opened > 0 || next == '\r' || next == '\n' || next == '#' || next == EOF) {
			            skip();
			        } else {
			            setText(newLine);

			            int indent = getIndentationCount(spaces);
			            int prev = indents.peek();

			            if (lastToken != null && lastToken.getType() == COLON && indent <= prev) {
			                throw new RuntimeException(
			                    "IndentationError: expected an indented block at line " + getLine()
			                );
			            }

			            if (indent > prev) {

			                if (lastToken == null || lastToken.getType() != COLON) {
			                    throw new RuntimeException(
			                        "IndentationError: unexpected indent at line " + getLine()
			                    );
			                }
			                indents.push(indent);
			                pendingTokens.add(commonToken(INDENT, ""));

			            } else if (indent < prev) {
			                while (indents.size() > 1 && indent < indents.peek()) {
			                    indents.pop();
			                    pendingTokens.add(commonToken(DEDENT, ""));
			                }
			                if (indent != indents.peek()) {
			                    throw new RuntimeException(
			                        "IndentationError: unindent does not match any outer indentation level at line " + getLine()
			                    );
			                }
			            }

			        }
			      
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u00001\u0144\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001\'\u0004\'\u00e3\b\'\u000b\'\f\'\u00e4\u0001\'\u0001\'\u0004\'"+
		"\u00e9\b\'\u000b\'\f\'\u00ea\u0001(\u0001(\u0001(\u0005(\u00f0\b(\n(\f"+
		"(\u00f3\t(\u0003(\u00f5\b(\u0001)\u0001)\u0001)\u0001)\u0005)\u00fb\b"+
		")\n)\f)\u00fe\t)\u0001)\u0001)\u0001)\u0001)\u0001)\u0005)\u0105\b)\n"+
		")\f)\u0108\t)\u0001)\u0003)\u010b\b)\u0001*\u0001*\u0005*\u010f\b*\n*"+
		"\f*\u0112\t*\u0001+\u0001+\u0005+\u0116\b+\n+\f+\u0119\t+\u0001+\u0003"+
		"+\u011c\b+\u0001+\u0004+\u011f\b+\u000b+\f+\u0120\u0001+\u0001+\u0001"+
		",\u0001,\u0005,\u0127\b,\n,\f,\u012a\t,\u0001,\u0001,\u0001-\u0003-\u012f"+
		"\b-\u0001-\u0004-\u0132\b-\u000b-\f-\u0133\u0001-\u0005-\u0137\b-\n-\f"+
		"-\u013a\t-\u0001-\u0001-\u0001.\u0004.\u013f\b.\u000b.\f.\u0140\u0001"+
		".\u0001.\u0000\u0000/\u0001\u0003\u0003\u0004\u0005\u0005\u0007\u0006"+
		"\t\u0007\u000b\b\r\t\u000f\n\u0011\u000b\u0013\f\u0015\r\u0017\u000e\u0019"+
		"\u000f\u001b\u0010\u001d\u0011\u001f\u0012!\u0013#\u0014%\u0015\'\u0016"+
		")\u0017+\u0018-\u0019/\u001a1\u001b3\u001c5\u001d7\u001e9\u001f; =!?\""+
		"A#C$E%G&I\'K(M)O*Q+S,U-W.Y/[0]1\u0001\u0000\b\u0001\u000009\u0001\u0000"+
		"19\u0004\u0000\n\n\r\r\'\'\\\\\u0004\u0000\n\n\r\r\"\"\\\\\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u0155"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"+
		"\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000"+
		"\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000"+
		"\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y"+
		"\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000"+
		"\u0000\u0000\u0001_\u0001\u0000\u0000\u0000\u0003d\u0001\u0000\u0000\u0000"+
		"\u0005k\u0001\u0000\u0000\u0000\u0007n\u0001\u0000\u0000\u0000\tr\u0001"+
		"\u0000\u0000\u0000\u000by\u0001\u0000\u0000\u0000\r|\u0001\u0000\u0000"+
		"\u0000\u000f\u0081\u0001\u0000\u0000\u0000\u0011\u0086\u0001\u0000\u0000"+
		"\u0000\u0013\u008a\u0001\u0000\u0000\u0000\u0015\u008d\u0001\u0000\u0000"+
		"\u0000\u0017\u0090\u0001\u0000\u0000\u0000\u0019\u0094\u0001\u0000\u0000"+
		"\u0000\u001b\u0097\u0001\u0000\u0000\u0000\u001d\u009b\u0001\u0000\u0000"+
		"\u0000\u001f\u00a0\u0001\u0000\u0000\u0000!\u00a5\u0001\u0000\u0000\u0000"+
		"#\u00ab\u0001\u0000\u0000\u0000%\u00ad\u0001\u0000\u0000\u0000\'\u00af"+
		"\u0001\u0000\u0000\u0000)\u00b1\u0001\u0000\u0000\u0000+\u00b3\u0001\u0000"+
		"\u0000\u0000-\u00b6\u0001\u0000\u0000\u0000/\u00b9\u0001\u0000\u0000\u0000"+
		"1\u00bc\u0001\u0000\u0000\u00003\u00bf\u0001\u0000\u0000\u00005\u00c1"+
		"\u0001\u0000\u0000\u00007\u00c3\u0001\u0000\u0000\u00009\u00c5\u0001\u0000"+
		"\u0000\u0000;\u00c7\u0001\u0000\u0000\u0000=\u00c9\u0001\u0000\u0000\u0000"+
		"?\u00cb\u0001\u0000\u0000\u0000A\u00cd\u0001\u0000\u0000\u0000C\u00cf"+
		"\u0001\u0000\u0000\u0000E\u00d2\u0001\u0000\u0000\u0000G\u00d5\u0001\u0000"+
		"\u0000\u0000I\u00d8\u0001\u0000\u0000\u0000K\u00db\u0001\u0000\u0000\u0000"+
		"M\u00de\u0001\u0000\u0000\u0000O\u00e2\u0001\u0000\u0000\u0000Q\u00f4"+
		"\u0001\u0000\u0000\u0000S\u010a\u0001\u0000\u0000\u0000U\u010c\u0001\u0000"+
		"\u0000\u0000W\u0113\u0001\u0000\u0000\u0000Y\u0124\u0001\u0000\u0000\u0000"+
		"[\u0131\u0001\u0000\u0000\u0000]\u013e\u0001\u0000\u0000\u0000_`\u0005"+
		"f\u0000\u0000`a\u0005r\u0000\u0000ab\u0005o\u0000\u0000bc\u0005m\u0000"+
		"\u0000c\u0002\u0001\u0000\u0000\u0000de\u0005i\u0000\u0000ef\u0005m\u0000"+
		"\u0000fg\u0005p\u0000\u0000gh\u0005o\u0000\u0000hi\u0005r\u0000\u0000"+
		"ij\u0005t\u0000\u0000j\u0004\u0001\u0000\u0000\u0000kl\u0005a\u0000\u0000"+
		"lm\u0005s\u0000\u0000m\u0006\u0001\u0000\u0000\u0000no\u0005d\u0000\u0000"+
		"op\u0005e\u0000\u0000pq\u0005f\u0000\u0000q\b\u0001\u0000\u0000\u0000"+
		"rs\u0005r\u0000\u0000st\u0005e\u0000\u0000tu\u0005t\u0000\u0000uv\u0005"+
		"u\u0000\u0000vw\u0005r\u0000\u0000wx\u0005n\u0000\u0000x\n\u0001\u0000"+
		"\u0000\u0000yz\u0005i\u0000\u0000z{\u0005f\u0000\u0000{\f\u0001\u0000"+
		"\u0000\u0000|}\u0005e\u0000\u0000}~\u0005l\u0000\u0000~\u007f\u0005i\u0000"+
		"\u0000\u007f\u0080\u0005f\u0000\u0000\u0080\u000e\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005l\u0000\u0000\u0083\u0084"+
		"\u0005s\u0000\u0000\u0084\u0085\u0005e\u0000\u0000\u0085\u0010\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005f\u0000\u0000\u0087\u0088\u0005o\u0000\u0000"+
		"\u0088\u0089\u0005r\u0000\u0000\u0089\u0012\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005i\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u0014\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005i\u0000\u0000\u008e\u008f\u0005s\u0000"+
		"\u0000\u008f\u0016\u0001\u0000\u0000\u0000\u0090\u0091\u0005a\u0000\u0000"+
		"\u0091\u0092\u0005n\u0000\u0000\u0092\u0093\u0005d\u0000\u0000\u0093\u0018"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005o\u0000\u0000\u0095\u0096\u0005"+
		"r\u0000\u0000\u0096\u001a\u0001\u0000\u0000\u0000\u0097\u0098\u0005n\u0000"+
		"\u0000\u0098\u0099\u0005o\u0000\u0000\u0099\u009a\u0005t\u0000\u0000\u009a"+
		"\u001c\u0001\u0000\u0000\u0000\u009b\u009c\u0005N\u0000\u0000\u009c\u009d"+
		"\u0005o\u0000\u0000\u009d\u009e\u0005n\u0000\u0000\u009e\u009f\u0005e"+
		"\u0000\u0000\u009f\u001e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005T\u0000"+
		"\u0000\u00a1\u00a2\u0005r\u0000\u0000\u00a2\u00a3\u0005u\u0000\u0000\u00a3"+
		"\u00a4\u0005e\u0000\u0000\u00a4 \u0001\u0000\u0000\u0000\u00a5\u00a6\u0005"+
		"F\u0000\u0000\u00a6\u00a7\u0005a\u0000\u0000\u00a7\u00a8\u0005l\u0000"+
		"\u0000\u00a8\u00a9\u0005s\u0000\u0000\u00a9\u00aa\u0005e\u0000\u0000\u00aa"+
		"\"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005@\u0000\u0000\u00ac$\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0005.\u0000\u0000\u00ae&\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005,\u0000\u0000\u00b0(\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005:\u0000\u0000\u00b2*\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005"+
		"=\u0000\u0000\u00b4\u00b5\u0005=\u0000\u0000\u00b5,\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0005!\u0000\u0000\u00b7\u00b8\u0005=\u0000\u0000\u00b8"+
		".\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005<\u0000\u0000\u00ba\u00bb\u0005"+
		"=\u0000\u0000\u00bb0\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005>\u0000"+
		"\u0000\u00bd\u00be\u0005=\u0000\u0000\u00be2\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0005<\u0000\u0000\u00c04\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005"+
		">\u0000\u0000\u00c26\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005=\u0000"+
		"\u0000\u00c48\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005+\u0000\u0000\u00c6"+
		":\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005-\u0000\u0000\u00c8<\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005*\u0000\u0000\u00ca>\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0005/\u0000\u0000\u00cc@\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0005%\u0000\u0000\u00ceB\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"(\u0000\u0000\u00d0\u00d1\u0006!\u0000\u0000\u00d1D\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0005)\u0000\u0000\u00d3\u00d4\u0006\"\u0001\u0000"+
		"\u00d4F\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005[\u0000\u0000\u00d6\u00d7"+
		"\u0006#\u0002\u0000\u00d7H\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005]"+
		"\u0000\u0000\u00d9\u00da\u0006$\u0003\u0000\u00daJ\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005{\u0000\u0000\u00dc\u00dd\u0006%\u0004\u0000\u00ddL"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0005}\u0000\u0000\u00df\u00e0\u0006"+
		"&\u0005\u0000\u00e0N\u0001\u0000\u0000\u0000\u00e1\u00e3\u0007\u0000\u0000"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0005.\u0000\u0000"+
		"\u00e7\u00e9\u0007\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00ebP\u0001\u0000\u0000\u0000\u00ec"+
		"\u00f5\u00050\u0000\u0000\u00ed\u00f1\u0007\u0001\u0000\u0000\u00ee\u00f0"+
		"\u0007\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f4\u00ec\u0001\u0000\u0000\u0000\u00f4\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f5R\u0001\u0000\u0000\u0000\u00f6\u00fc\u0005"+
		"\'\u0000\u0000\u00f7\u00f8\u0005\\\u0000\u0000\u00f8\u00fb\t\u0000\u0000"+
		"\u0000\u00f9\u00fb\b\u0002\u0000\u0000\u00fa\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00ff\u010b\u0005\'\u0000\u0000\u0100\u0106\u0005\"\u0000\u0000\u0101"+
		"\u0102\u0005\\\u0000\u0000\u0102\u0105\t\u0000\u0000\u0000\u0103\u0105"+
		"\b\u0003\u0000\u0000\u0104\u0101\u0001\u0000\u0000\u0000\u0104\u0103\u0001"+
		"\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0001"+
		"\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010b\u0005"+
		"\"\u0000\u0000\u010a\u00f6\u0001\u0000\u0000\u0000\u010a\u0100\u0001\u0000"+
		"\u0000\u0000\u010bT\u0001\u0000\u0000\u0000\u010c\u0110\u0007\u0004\u0000"+
		"\u0000\u010d\u010f\u0007\u0005\u0000\u0000\u010e\u010d\u0001\u0000\u0000"+
		"\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000"+
		"\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111V\u0001\u0000\u0000\u0000"+
		"\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0117\u0005\\\u0000\u0000\u0114"+
		"\u0116\u0007\u0006\u0000\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0116"+
		"\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117"+
		"\u0118\u0001\u0000\u0000\u0000\u0118\u011e\u0001\u0000\u0000\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u011a\u011c\u0005\r\u0000\u0000\u011b\u011a"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0001\u0000\u0000\u0000\u011d\u011f\u0005\n\u0000\u0000\u011e\u011b\u0001"+
		"\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u011e\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0006+\u0006\u0000\u0123X\u0001\u0000\u0000"+
		"\u0000\u0124\u0128\u0005#\u0000\u0000\u0125\u0127\b\u0007\u0000\u0000"+
		"\u0126\u0125\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000"+
		"\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0006,\u0006\u0000\u012cZ\u0001\u0000\u0000\u0000\u012d\u012f"+
		"\u0005\r\u0000\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0132\u0005"+
		"\n\u0000\u0000\u0131\u012e\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"+
		"\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000"+
		"\u0000\u0000\u0134\u0138\u0001\u0000\u0000\u0000\u0135\u0137\u0007\u0006"+
		"\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000"+
		"\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0006-\u0007\u0000\u013c\\\u0001\u0000\u0000"+
		"\u0000\u013d\u013f\u0007\u0006\u0000\u0000\u013e\u013d\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0006.\b\u0000\u0143^\u0001\u0000\u0000\u0000\u0013"+
		"\u0000\u00e4\u00ea\u00f1\u00f4\u00fa\u00fc\u0104\u0106\u010a\u0110\u0117"+
		"\u011b\u0120\u0128\u012e\u0133\u0138\u0140\t\u0001!\u0000\u0001\"\u0001"+
		"\u0001#\u0002\u0001$\u0003\u0001%\u0004\u0001&\u0005\u0006\u0000\u0000"+
		"\u0001-\u0006\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}