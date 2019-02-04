// Generated from /Users/kennethtaylor/MSU/CSCI/CSCIRepositoriedClassWork/CSCIRepositoriedClassWork/CSCI468/Project/Step1/LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		D=1, AN=2, ID=3, INTLIT=4, FLOATLIT=5, STRINGLIT=6, COMMENT=7, WS=8, PROGRAM=9, 
		BEGIN=10, END=11, FUNCTION=12, READ=13, WRITE=14, IF=15, ELSE=16, ENDIF=17, 
		WHILE=18, ENDWHILE=19, CONTINUE=20, BREAK=21, RETURN=22, INT=23, VOID=24, 
		STRING=25, FLOAT=26, ASSIGNMENT=27, ADD=28, SUBTRACT=29, MULTIPLY=30, 
		DEVIDE=31, EQUALS=32, NOTEQUAL=33, LESSTHAN=34, GREATERTHAN=35, OPENPAREN=36, 
		CLOSEPAREN=37, SEMICOLON=38, COLON=39, LESSEQUAL=40, GREATEREQUAL=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"D", "AN", "ID", "INTLIT", "FLOATLIT", "STRINGLIT", "COMMENT", "WS", 
			"PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", 
			"ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", 
			"STRING", "FLOAT", "ASSIGNMENT", "ADD", "SUBTRACT", "MULTIPLY", "DEVIDE", 
			"EQUALS", "NOTEQUAL", "LESSTHAN", "GREATERTHAN", "OPENPAREN", "CLOSEPAREN", 
			"SEMICOLON", "COLON", "LESSEQUAL", "GREATEREQUAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'program'", "'begin'", 
			"'end'", "'function'", "'read'", "'write'", "'if'", "'else'", "'endif'", 
			"'while'", "'endwhile'", "'continue'", "'break'", "'return'", "'int'", 
			"'void'", "'string'", "'float'", "':='", "'+'", "'-'", "'*'", "'/'", 
			"'='", "'!='", "'<'", "'>'", "'('", "')'", "';'", "','", "'<='", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "D", "AN", "ID", "INTLIT", "FLOATLIT", "STRINGLIT", "COMMENT", 
			"WS", "PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", 
			"ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", 
			"STRING", "FLOAT", "ASSIGNMENT", "ADD", "SUBTRACT", "MULTIPLY", "DEVIDE", 
			"EQUALS", "NOTEQUAL", "LESSTHAN", "GREATERTHAN", "OPENPAREN", "CLOSEPAREN", 
			"SEMICOLON", "COLON", "LESSEQUAL", "GREATEREQUAL"
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


	public LittleGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LittleGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u011d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\5\6\5b\n\5\r\5\16\5c\3\6\7"+
		"\6g\n\6\f\6\16\6j\13\6\3\6\3\6\6\6n\n\6\r\6\16\6o\3\7\3\7\7\7t\n\7\f\7"+
		"\16\7w\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3"+
		"\b\3\b\3\t\6\t\u0087\n\t\r\t\16\t\u0088\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)"+
		"\3*\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\7\3\2\62;\5\2\62;C\\c|\4"+
		"\2C\\c|\3\2))\5\2\13\f\17\17\"\"\2\u0123\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7Y\3\2\2"+
		"\2\ta\3\2\2\2\13h\3\2\2\2\rq\3\2\2\2\17z\3\2\2\2\21\u0086\3\2\2\2\23\u008c"+
		"\3\2\2\2\25\u0094\3\2\2\2\27\u009a\3\2\2\2\31\u009e\3\2\2\2\33\u00a7\3"+
		"\2\2\2\35\u00ac\3\2\2\2\37\u00b2\3\2\2\2!\u00b5\3\2\2\2#\u00ba\3\2\2\2"+
		"%\u00c0\3\2\2\2\'\u00c6\3\2\2\2)\u00cf\3\2\2\2+\u00d8\3\2\2\2-\u00de\3"+
		"\2\2\2/\u00e5\3\2\2\2\61\u00e9\3\2\2\2\63\u00ee\3\2\2\2\65\u00f5\3\2\2"+
		"\2\67\u00fb\3\2\2\29\u00fe\3\2\2\2;\u0100\3\2\2\2=\u0102\3\2\2\2?\u0104"+
		"\3\2\2\2A\u0106\3\2\2\2C\u0108\3\2\2\2E\u010b\3\2\2\2G\u010d\3\2\2\2I"+
		"\u010f\3\2\2\2K\u0111\3\2\2\2M\u0113\3\2\2\2O\u0115\3\2\2\2Q\u0117\3\2"+
		"\2\2S\u011a\3\2\2\2UV\t\2\2\2V\4\3\2\2\2WX\t\3\2\2X\6\3\2\2\2Y]\t\4\2"+
		"\2Z\\\5\5\3\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\b\3\2\2\2_]\3"+
		"\2\2\2`b\5\3\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\n\3\2\2\2eg"+
		"\5\3\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2k"+
		"m\13\2\2\2ln\5\3\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p\f\3\2\2"+
		"\2qu\7$\2\2rt\n\5\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2"+
		"\2wu\3\2\2\2xy\7$\2\2y\16\3\2\2\2z{\7/\2\2{|\7/\2\2|\u0080\3\2\2\2}\177"+
		"\n\5\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\f\2\2\u0084\20"+
		"\3\2\2\2\u0085\u0087\t\6\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\t"+
		"\2\2\u008b\22\3\2\2\2\u008c\u008d\7r\2\2\u008d\u008e\7t\2\2\u008e\u008f"+
		"\7q\2\2\u008f\u0090\7i\2\2\u0090\u0091\7t\2\2\u0091\u0092\7c\2\2\u0092"+
		"\u0093\7o\2\2\u0093\24\3\2\2\2\u0094\u0095\7d\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7i\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\26\3\2\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u009c\7p\2\2\u009c\u009d\7f\2\2\u009d\30\3\2\2\2\u009e"+
		"\u009f\7h\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7e\2\2"+
		"\u00a2\u00a3\7v\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6"+
		"\7p\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa"+
		"\7c\2\2\u00aa\u00ab\7f\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7y\2\2\u00ad\u00ae"+
		"\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7g\2\2\u00b1"+
		"\36\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7h\2\2\u00b4 \3\2\2\2\u00b5"+
		"\u00b6\7g\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9\"\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f"+
		"\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7h\2\2\u00bf$\3\2\2\2\u00c0\u00c1"+
		"\7y\2\2\u00c1\u00c2\7j\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7g\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\u00c9\7f\2\2\u00c9\u00ca\7y\2\2\u00ca\u00cb\7j\2\2\u00cb\u00cc\7k\2\2"+
		"\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2\u00ce(\3\2\2\2\u00cf\u00d0\7e\2"+
		"\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7w\2\2\u00d6\u00d7\7g\2\2\u00d7"+
		"*\3\2\2\2\u00d8\u00d9\7d\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7g\2\2\u00db"+
		"\u00dc\7c\2\2\u00dc\u00dd\7m\2\2\u00dd,\3\2\2\2\u00de\u00df\7t\2\2\u00df"+
		"\u00e0\7g\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7t\2\2"+
		"\u00e3\u00e4\7p\2\2\u00e4.\3\2\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7p\2"+
		"\2\u00e7\u00e8\7v\2\2\u00e8\60\3\2\2\2\u00e9\u00ea\7x\2\2\u00ea\u00eb"+
		"\7q\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7f\2\2\u00ed\62\3\2\2\2\u00ee\u00ef"+
		"\7u\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7k\2\2\u00f2"+
		"\u00f3\7p\2\2\u00f3\u00f4\7i\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6"+
		"\u00f7\7n\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7v\2\2"+
		"\u00fa\66\3\2\2\2\u00fb\u00fc\7<\2\2\u00fc\u00fd\7?\2\2\u00fd8\3\2\2\2"+
		"\u00fe\u00ff\7-\2\2\u00ff:\3\2\2\2\u0100\u0101\7/\2\2\u0101<\3\2\2\2\u0102"+
		"\u0103\7,\2\2\u0103>\3\2\2\2\u0104\u0105\7\61\2\2\u0105@\3\2\2\2\u0106"+
		"\u0107\7?\2\2\u0107B\3\2\2\2\u0108\u0109\7#\2\2\u0109\u010a\7?\2\2\u010a"+
		"D\3\2\2\2\u010b\u010c\7>\2\2\u010cF\3\2\2\2\u010d\u010e\7@\2\2\u010eH"+
		"\3\2\2\2\u010f\u0110\7*\2\2\u0110J\3\2\2\2\u0111\u0112\7+\2\2\u0112L\3"+
		"\2\2\2\u0113\u0114\7=\2\2\u0114N\3\2\2\2\u0115\u0116\7.\2\2\u0116P\3\2"+
		"\2\2\u0117\u0118\7>\2\2\u0118\u0119\7?\2\2\u0119R\3\2\2\2\u011a\u011b"+
		"\7@\2\2\u011b\u011c\7?\2\2\u011cT\3\2\2\2\n\2]chou\u0080\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}