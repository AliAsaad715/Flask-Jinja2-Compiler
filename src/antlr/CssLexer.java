// Generated from src/antlr/CssLexer.g4 by ANTLR 4.13.2
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
public class CssLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WS=2, LBRACE=3, RBRACE=4, COLON=5, SEMI=6, COMMA=7, LPAREN=8, 
		RPAREN=9, PERCENT=10, PLUS=11, MINUS=12, STAR=13, SLASH=14, DOT=15, HASH=16, 
		COLOR=17, NUMBER=18, STRING=19, IDENT=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "WS", "LBRACE", "RBRACE", "COLON", "SEMI", "COMMA", "LPAREN", 
			"RPAREN", "PERCENT", "PLUS", "MINUS", "STAR", "SLASH", "DOT", "HASH", 
			"COLOR", "NUMBER", "STRING", "IDENT", "HEX", "DIGIT", "ESC"
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


	public CssLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CssLexer.g4"; }

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

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u0099\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0004\u0001?\b\u0001\u000b\u0001\f\u0001@\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010i\b\u0010\u0001\u0011\u0004\u0011"+
		"l\b\u0011\u000b\u0011\f\u0011m\u0001\u0011\u0001\u0011\u0004\u0011r\b"+
		"\u0011\u000b\u0011\f\u0011s\u0003\u0011v\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012{\b\u0012\n\u0012\f\u0012~\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0084\b\u0012\n\u0012"+
		"\f\u0012\u0087\t\u0012\u0001\u0012\u0003\u0012\u008a\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u008e\b\u0013\n\u0013\f\u0013\u0091\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u00015\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0000+\u0000-\u0000\u0001\u0000\u0007\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0004\u0000--AZ__az\u0005\u0000--0"+
		"9AZ__az\u0003\u000009AFaf\u0001\u000009\u00a1\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u0003>\u0001\u0000\u0000"+
		"\u0000\u0005D\u0001\u0000\u0000\u0000\u0007F\u0001\u0000\u0000\u0000\t"+
		"H\u0001\u0000\u0000\u0000\u000bJ\u0001\u0000\u0000\u0000\rL\u0001\u0000"+
		"\u0000\u0000\u000fN\u0001\u0000\u0000\u0000\u0011P\u0001\u0000\u0000\u0000"+
		"\u0013R\u0001\u0000\u0000\u0000\u0015T\u0001\u0000\u0000\u0000\u0017V"+
		"\u0001\u0000\u0000\u0000\u0019X\u0001\u0000\u0000\u0000\u001bZ\u0001\u0000"+
		"\u0000\u0000\u001d\\\u0001\u0000\u0000\u0000\u001f^\u0001\u0000\u0000"+
		"\u0000!`\u0001\u0000\u0000\u0000#k\u0001\u0000\u0000\u0000%\u0089\u0001"+
		"\u0000\u0000\u0000\'\u008b\u0001\u0000\u0000\u0000)\u0092\u0001\u0000"+
		"\u0000\u0000+\u0094\u0001\u0000\u0000\u0000-\u0096\u0001\u0000\u0000\u0000"+
		"/0\u0005/\u0000\u000001\u0005*\u0000\u000015\u0001\u0000\u0000\u00002"+
		"4\t\u0000\u0000\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000068\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000089\u0005*\u0000\u00009:\u0005/\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;<\u0006\u0000\u0000\u0000<\u0002\u0001\u0000"+
		"\u0000\u0000=?\u0007\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AB\u0001\u0000\u0000\u0000BC\u0006\u0001\u0000\u0000C\u0004\u0001\u0000"+
		"\u0000\u0000DE\u0005{\u0000\u0000E\u0006\u0001\u0000\u0000\u0000FG\u0005"+
		"}\u0000\u0000G\b\u0001\u0000\u0000\u0000HI\u0005:\u0000\u0000I\n\u0001"+
		"\u0000\u0000\u0000JK\u0005;\u0000\u0000K\f\u0001\u0000\u0000\u0000LM\u0005"+
		",\u0000\u0000M\u000e\u0001\u0000\u0000\u0000NO\u0005(\u0000\u0000O\u0010"+
		"\u0001\u0000\u0000\u0000PQ\u0005)\u0000\u0000Q\u0012\u0001\u0000\u0000"+
		"\u0000RS\u0005%\u0000\u0000S\u0014\u0001\u0000\u0000\u0000TU\u0005+\u0000"+
		"\u0000U\u0016\u0001\u0000\u0000\u0000VW\u0005-\u0000\u0000W\u0018\u0001"+
		"\u0000\u0000\u0000XY\u0005*\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000"+
		"Z[\u0005/\u0000\u0000[\u001c\u0001\u0000\u0000\u0000\\]\u0005.\u0000\u0000"+
		"]\u001e\u0001\u0000\u0000\u0000^_\u0005#\u0000\u0000_ \u0001\u0000\u0000"+
		"\u0000`a\u0003\u001f\u000f\u0000ab\u0003)\u0014\u0000bc\u0003)\u0014\u0000"+
		"ch\u0003)\u0014\u0000de\u0003)\u0014\u0000ef\u0003)\u0014\u0000fg\u0003"+
		")\u0014\u0000gi\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000i\"\u0001\u0000\u0000\u0000jl\u0003+\u0015\u0000kj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000nu\u0001\u0000\u0000\u0000oq\u0003\u001d\u000e"+
		"\u0000pr\u0003+\u0015\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000"+
		"\u0000\u0000uo\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v$\u0001"+
		"\u0000\u0000\u0000w|\u0005\"\u0000\u0000x{\u0003-\u0016\u0000y{\b\u0001"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u007f\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u008a"+
		"\u0005\"\u0000\u0000\u0080\u0085\u0005\'\u0000\u0000\u0081\u0084\u0003"+
		"-\u0016\u0000\u0082\u0084\b\u0002\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000"+
		"\u0000\u0000\u0088\u008a\u0005\'\u0000\u0000\u0089w\u0001\u0000\u0000"+
		"\u0000\u0089\u0080\u0001\u0000\u0000\u0000\u008a&\u0001\u0000\u0000\u0000"+
		"\u008b\u008f\u0007\u0003\u0000\u0000\u008c\u008e\u0007\u0004\u0000\u0000"+
		"\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090(\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0007\u0005\u0000\u0000\u0093*\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0007\u0006\u0000\u0000\u0095,\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\\\u0000\u0000\u0097\u0098\t\u0000\u0000\u0000\u0098.\u0001\u0000\u0000"+
		"\u0000\r\u00005@hmsuz|\u0083\u0085\u0089\u008f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}