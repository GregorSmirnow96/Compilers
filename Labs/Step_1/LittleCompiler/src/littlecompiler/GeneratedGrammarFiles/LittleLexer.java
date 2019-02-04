package littlecompiler.GeneratedGrammarFiles;

// Generated from Little.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, OPERATOR=2, IDENTIFIER=3, INTLITERAL=4, FLOATLITERAL=5, STRINGLITERAL=6, 
		COMMENT=7, WS=8, DIGIT=9, ALPHANUMERIC=10, LETTER=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "WS", "DIGIT", "ALPHANUMERIC", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", 
		"STRINGLITERAL", "COMMENT", "WS", "DIGIT", "ALPHANUMERIC", "LETTER"
	};
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


	public LittleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u00bf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2w\n\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\u0083\n\3\3\4\3\4\7\4\u0087\n\4\f\4\16\4\u008a\13"+
		"\4\3\5\6\5\u008d\n\5\r\5\16\5\u008e\3\6\7\6\u0092\n\6\f\6\16\6\u0095\13"+
		"\6\3\6\3\6\6\6\u0099\n\6\r\6\16\6\u009a\3\7\3\7\7\7\u009f\n\7\f\7\16\7"+
		"\u00a2\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00aa\n\b\f\b\16\b\u00ad\13\b"+
		"\3\b\3\b\3\b\3\b\3\t\6\t\u00b4\n\t\r\t\16\t\u00b5\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\3\2\n\6\2,-//\61\61??\6\2*+..=>@@\3\2$$\4\2\f\f))\5\2\13\f\17\17\"\""+
		"\3\2\62;\5\2\62;C\\c|\4\2C\\c|\2\u00db\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3v\3\2\2\2\5\u0082\3\2\2\2\7\u0084"+
		"\3\2\2\2\t\u008c\3\2\2\2\13\u0093\3\2\2\2\r\u009c\3\2\2\2\17\u00a5\3\2"+
		"\2\2\21\u00b3\3\2\2\2\23\u00b9\3\2\2\2\25\u00bb\3\2\2\2\27\u00bd\3\2\2"+
		"\2\31\32\7R\2\2\32\33\7T\2\2\33\34\7Q\2\2\34\35\7I\2\2\35\36\7T\2\2\36"+
		"\37\7C\2\2\37w\7O\2\2 !\7D\2\2!\"\7G\2\2\"#\7I\2\2#$\7K\2\2$w\7P\2\2%"+
		"&\7G\2\2&\'\7P\2\2\'w\7F\2\2()\7H\2\2)*\7W\2\2*+\7P\2\2+,\7E\2\2,-\7V"+
		"\2\2-.\7K\2\2./\7Q\2\2/w\7P\2\2\60\61\7T\2\2\61\62\7G\2\2\62\63\7C\2\2"+
		"\63w\7F\2\2\64\65\7Y\2\2\65\66\7T\2\2\66\67\7K\2\2\678\7V\2\28w\7G\2\2"+
		"9:\7K\2\2:w\7H\2\2;<\7G\2\2<=\7N\2\2=>\7U\2\2>w\7G\2\2?@\7G\2\2@A\7P\2"+
		"\2AB\7F\2\2BC\7K\2\2Cw\7H\2\2DE\7Y\2\2EF\7J\2\2FG\7K\2\2GH\7N\2\2Hw\7"+
		"G\2\2IJ\7G\2\2JK\7P\2\2KL\7F\2\2LM\7Y\2\2MN\7J\2\2NO\7K\2\2OP\7N\2\2P"+
		"w\7G\2\2QR\7E\2\2RS\7Q\2\2ST\7P\2\2TU\7V\2\2UV\7K\2\2VW\7P\2\2WX\7W\2"+
		"\2Xw\7G\2\2YZ\7D\2\2Z[\7T\2\2[\\\7G\2\2\\]\7C\2\2]w\7M\2\2^_\7T\2\2_`"+
		"\7G\2\2`a\7V\2\2ab\7W\2\2bc\7T\2\2cw\7P\2\2de\7K\2\2ef\7P\2\2fw\7V\2\2"+
		"gh\7X\2\2hi\7Q\2\2ij\7K\2\2jw\7F\2\2kl\7U\2\2lm\7V\2\2mn\7T\2\2no\7K\2"+
		"\2op\7P\2\2pw\7I\2\2qr\7H\2\2rs\7N\2\2st\7Q\2\2tu\7C\2\2uw\7V\2\2v\31"+
		"\3\2\2\2v \3\2\2\2v%\3\2\2\2v(\3\2\2\2v\60\3\2\2\2v\64\3\2\2\2v9\3\2\2"+
		"\2v;\3\2\2\2v?\3\2\2\2vD\3\2\2\2vI\3\2\2\2vQ\3\2\2\2vY\3\2\2\2v^\3\2\2"+
		"\2vd\3\2\2\2vg\3\2\2\2vk\3\2\2\2vq\3\2\2\2w\4\3\2\2\2xy\7<\2\2y\u0083"+
		"\7?\2\2z\u0083\t\2\2\2{|\7#\2\2|\u0083\7?\2\2}\u0083\t\3\2\2~\177\7>\2"+
		"\2\177\u0083\7?\2\2\u0080\u0081\7@\2\2\u0081\u0083\7?\2\2\u0082x\3\2\2"+
		"\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082}\3\2\2\2\u0082~\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\6\3\2\2\2\u0084\u0088\5\27\f\2\u0085\u0087\5\25\13\2\u0086"+
		"\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\5\23\n\2\u008c\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\n\3\2\2\2\u0090\u0092\5\23\n\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2"+
		"\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0096\u0098\7\60\2\2\u0097\u0099\5\23\n\2\u0098\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\f\3"+
		"\2\2\2\u009c\u00a0\7$\2\2\u009d\u009f\n\4\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4\16\3\2\2\2\u00a5\u00a6"+
		"\7/\2\2\u00a6\u00a7\7/\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00aa\n\5\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\f\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\b\b\2\2\u00b1\20\3\2\2\2\u00b2\u00b4\t\6\2"+
		"\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\t\2\2\u00b8\22\3\2\2\2\u00b9"+
		"\u00ba\t\7\2\2\u00ba\24\3\2\2\2\u00bb\u00bc\t\b\2\2\u00bc\26\3\2\2\2\u00bd"+
		"\u00be\t\t\2\2\u00be\30\3\2\2\2\f\2v\u0082\u0088\u008e\u0093\u009a\u00a0"+
		"\u00ab\u00b5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}