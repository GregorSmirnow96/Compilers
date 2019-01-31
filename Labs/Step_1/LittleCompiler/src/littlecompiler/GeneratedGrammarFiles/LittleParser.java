package littlecompiler.GeneratedGrammarFiles;

// Generated from Little.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, ALPHANUMERIC=2, LETTER=3, IDENTIFIER=4, INT_LITERAL=5, FLOAT_LITERAL=6, 
		STRING_LITERAL=7, COMMENT=8, WS=9, PROGRAM=10, BEGIN=11, END=12, FUNCTION=13, 
		READ=14, WRITE=15, IF=16, ELSE=17, ENDIF=18, WHILE=19, ENDWHILE=20, CONTINUE=21, 
		BREAK=22, RETURN=23, INT=24, VOID=25, STRING=26, FLOAT=27, SET_TO=28, 
		PLUS=29, MINUS=30, MULTIPLY=31, DIVIDE=32, EQUALS=33, NOT_EQUALS=34, LESS_THAN=35, 
		GREATER_THAN=36, OPEN_PARENTHESES=37, CLOSE_PARENTHESES=38, END_STATEMENT=39, 
		COMMA=40, LESS_THAN_OR_EQUAL_TO=41, GREATER_THAN_OR_EQUAL_TO=42;
	public static final int
		RULE_string_literal = 0;
	public static final String[] ruleNames = {
		"string_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'PROGRAM'", 
		"'BEGIN'", "'END'", "'FUNCTION'", "'READ'", "'WRITE'", "'IF'", "'ELSE'", 
		"'ENDIF'", "'WHILE'", "'ENDWHILE'", "'CONTINUE'", "'BREAK'", "'RETURN'", 
		"'INT'", "'VOID'", "'STRING'", "'FLOAT'", "':='", "'+'", "'-'", "'*'", 
		"'/'", "'='", "'!='", "'<'", "'>'", "'('", "')'", "';'", "','", "'<='", 
		"'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DIGIT", "ALPHANUMERIC", "LETTER", "IDENTIFIER", "INT_LITERAL", 
		"FLOAT_LITERAL", "STRING_LITERAL", "COMMENT", "WS", "PROGRAM", "BEGIN", 
		"END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", "ENDIF", "WHILE", "ENDWHILE", 
		"CONTINUE", "BREAK", "RETURN", "INT", "VOID", "STRING", "FLOAT", "SET_TO", 
		"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "EQUALS", "NOT_EQUALS", "LESS_THAN", 
		"GREATER_THAN", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", "END_STATEMENT", 
		"COMMA", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN_OR_EQUAL_TO"
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

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LittleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(LittleParser.STRING_LITERAL, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(STRING_LITERAL);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\7\4\2\t\2\3\2\3"+
		"\2\3\2\2\2\3\2\2\2\2\5\2\4\3\2\2\2\4\5\7\t\2\2\5\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}