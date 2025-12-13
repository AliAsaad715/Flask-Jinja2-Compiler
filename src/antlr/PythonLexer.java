// Generated from C:/Users/EVO.store/IdeaProjects/Flask_Jinja2_Project/src/antlr/PythonLexer.g4 by ANTLR 4.13.2
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
		FROM=1, IMPORT=2, FLASK=3, FLASK_LIBRARY=4, DEFINETION=5, COLON=6, RETURN=7, 
		RUN=8, EQUAL=9, OPEN_B=10, CLOSE_B=11, APP_NAME=12, DECORATOR=13, DOT=14, 
		ROUTE=15, SINGLE_QUOTES=16, ID=17, INT_VALUE=18, WS=19, NEWLINE=20, SLASH=21, 
		STRING_VALUE=22, STRING_ESCAPE=23, STRING_END=24;
	public static final int
		STRING_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "STRING_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FROM", "IMPORT", "FLASK", "FLASK_LIBRARY", "DEFINETION", "COLON", "RETURN", 
			"RUN", "EQUAL", "OPEN_B", "CLOSE_B", "APP_NAME", "DECORATOR", "DOT", 
			"ROUTE", "SINGLE_QUOTES", "ID", "INT_VALUE", "WS", "NEWLINE", "SLASH", 
			"STRING_VALUE", "STRING_ESCAPE", "STRING_END"
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

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u00a5\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"+
		"\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"+
		"\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"+
		"\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"+
		"\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002"+
		"\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002"+
		"\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002"+
		"\u0017\u0007\u0017\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010{\b\u0010"+
		"\n\u0010\f\u0010~\t\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u0082\b"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0086\b\u0011\n\u0011\f\u0011"+
		"\u0089\t\u0011\u0003\u0011\u008b\b\u0011\u0001\u0012\u0004\u0012\u008e"+
		"\b\u0012\u000b\u0012\f\u0012\u008f\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0004\u0015\u009b\b\u0015\u000b\u0015\f\u0015\u009c\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0000"+
		"\u0000\u0018\u0002\u0001\u0004\u0002\u0006\u0003\b\u0004\n\u0005\f\u0006"+
		"\u000e\u0007\u0010\b\u0012\t\u0014\n\u0016\u000b\u0018\f\u001a\r\u001c"+
		"\u000e\u001e\u000f \u0010\"\u0011$\u0012&\u0013(\u0014*\u0015,\u0016."+
		"\u00170\u0018\u0002\u0000\u0001\u0007\u0003\u0000AZ__az\u0004\u000009"+
		"AZ__az\u0001\u000019\u0001\u000009\u0002\u0000\t\t  \u0002\u0000\n\n\r"+
		"\r\u0005\u0000\t\n\r\r\'\'//\\\\\u00a9\u0000\u0002\u0001\u0000\u0000\u0000"+
		"\u0000\u0004\u0001\u0000\u0000\u0000\u0000\u0006\u0001\u0000\u0000\u0000"+
		"\u0000\b\u0001\u0000\u0000\u0000\u0000\n\u0001\u0000\u0000\u0000\u0000"+
		"\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001\u0000\u0000\u0000\u0000\u0010"+
		"\u0001\u0000\u0000\u0000\u0000\u0012\u0001\u0000\u0000\u0000\u0000\u0014"+
		"\u0001\u0000\u0000\u0000\u0000\u0016\u0001\u0000\u0000\u0000\u0000\u0018"+
		"\u0001\u0000\u0000\u0000\u0000\u001a\u0001\u0000\u0000\u0000\u0000\u001c"+
		"\u0001\u0000\u0000\u0000\u0000\u001e\u0001\u0000\u0000\u0000\u0000 \u0001"+
		"\u0000\u0000\u0000\u0000\"\u0001\u0000\u0000\u0000\u0000$\u0001\u0000"+
		"\u0000\u0000\u0000&\u0001\u0000\u0000\u0000\u0000(\u0001\u0000\u0000\u0000"+
		"\u0001*\u0001\u0000\u0000\u0000\u0001,\u0001\u0000\u0000\u0000\u0001."+
		"\u0001\u0000\u0000\u0000\u00010\u0001\u0000\u0000\u0000\u00022\u0001\u0000"+
		"\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000"+
		"\bD\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fN\u0001\u0000"+
		"\u0000\u0000\u000eP\u0001\u0000\u0000\u0000\u0010W\u0001\u0000\u0000\u0000"+
		"\u0012[\u0001\u0000\u0000\u0000\u0014]\u0001\u0000\u0000\u0000\u0016_"+
		"\u0001\u0000\u0000\u0000\u0018a\u0001\u0000\u0000\u0000\u001aj\u0001\u0000"+
		"\u0000\u0000\u001cl\u0001\u0000\u0000\u0000\u001en\u0001\u0000\u0000\u0000"+
		" t\u0001\u0000\u0000\u0000\"x\u0001\u0000\u0000\u0000$\u008a\u0001\u0000"+
		"\u0000\u0000&\u008d\u0001\u0000\u0000\u0000(\u0093\u0001\u0000\u0000\u0000"+
		"*\u0097\u0001\u0000\u0000\u0000,\u009a\u0001\u0000\u0000\u0000.\u009e"+
		"\u0001\u0000\u0000\u00000\u00a1\u0001\u0000\u0000\u000023\u0005f\u0000"+
		"\u000034\u0005r\u0000\u000045\u0005o\u0000\u000056\u0005m\u0000\u0000"+
		"6\u0003\u0001\u0000\u0000\u000078\u0005i\u0000\u000089\u0005m\u0000\u0000"+
		"9:\u0005p\u0000\u0000:;\u0005o\u0000\u0000;<\u0005r\u0000\u0000<=\u0005"+
		"t\u0000\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0005f\u0000\u0000?@\u0005"+
		"l\u0000\u0000@A\u0005a\u0000\u0000AB\u0005s\u0000\u0000BC\u0005k\u0000"+
		"\u0000C\u0007\u0001\u0000\u0000\u0000DE\u0005F\u0000\u0000EF\u0005l\u0000"+
		"\u0000FG\u0005a\u0000\u0000GH\u0005s\u0000\u0000HI\u0005k\u0000\u0000"+
		"I\t\u0001\u0000\u0000\u0000JK\u0005d\u0000\u0000KL\u0005e\u0000\u0000"+
		"LM\u0005f\u0000\u0000M\u000b\u0001\u0000\u0000\u0000NO\u0005:\u0000\u0000"+
		"O\r\u0001\u0000\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005e\u0000\u0000"+
		"RS\u0005t\u0000\u0000ST\u0005u\u0000\u0000TU\u0005r\u0000\u0000UV\u0005"+
		"n\u0000\u0000V\u000f\u0001\u0000\u0000\u0000WX\u0005r\u0000\u0000XY\u0005"+
		"u\u0000\u0000YZ\u0005n\u0000\u0000Z\u0011\u0001\u0000\u0000\u0000[\\\u0005"+
		"=\u0000\u0000\\\u0013\u0001\u0000\u0000\u0000]^\u0005(\u0000\u0000^\u0015"+
		"\u0001\u0000\u0000\u0000_`\u0005)\u0000\u0000`\u0017\u0001\u0000\u0000"+
		"\u0000ab\u0005_\u0000\u0000bc\u0005_\u0000\u0000cd\u0005n\u0000\u0000"+
		"de\u0005a\u0000\u0000ef\u0005m\u0000\u0000fg\u0005e\u0000\u0000gh\u0005"+
		"_\u0000\u0000hi\u0005_\u0000\u0000i\u0019\u0001\u0000\u0000\u0000jk\u0005"+
		"@\u0000\u0000k\u001b\u0001\u0000\u0000\u0000lm\u0005.\u0000\u0000m\u001d"+
		"\u0001\u0000\u0000\u0000no\u0005r\u0000\u0000op\u0005o\u0000\u0000pq\u0005"+
		"u\u0000\u0000qr\u0005t\u0000\u0000rs\u0005e\u0000\u0000s\u001f\u0001\u0000"+
		"\u0000\u0000tu\u0005\'\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0006\u000f"+
		"\u0000\u0000w!\u0001\u0000\u0000\u0000x|\u0007\u0000\u0000\u0000y{\u0007"+
		"\u0001\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}#\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000\u007f\u008b\u00050\u0000\u0000\u0080"+
		"\u0082\u0005-\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0087"+
		"\u0007\u0002\u0000\u0000\u0084\u0086\u0007\u0003\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008b"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u007f"+
		"\u0001\u0000\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000\u008b%\u0001"+
		"\u0000\u0000\u0000\u008c\u008e\u0007\u0004\u0000\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0006\u0012\u0001\u0000\u0092\'\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0007\u0005\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0006\u0013\u0002\u0000\u0096)\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005/\u0000\u0000\u0098+\u0001\u0000\u0000\u0000\u0099"+
		"\u009b\b\u0006\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d-\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\\\u0000\u0000\u009f\u00a0\t\u0000\u0000\u0000\u00a0/\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005\'\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0006\u0017\u0003\u0000\u00a41\u0001\u0000\u0000\u0000\b"+
		"\u0000\u0001|\u0081\u0087\u008a\u008f\u009c\u0004\u0005\u0001\u0000\u0000"+
		"\u0001\u0000\u0006\u0000\u0000\u0004\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}