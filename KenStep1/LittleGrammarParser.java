// Generated from /Users/kennethtaylor/MSU/CSCI/CSCIRepositoriedClassWork/CSCIRepositoriedClassWork/CSCI468/Project/Step1/LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleGrammarParser extends Parser {
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
	public static final int
		RULE_r = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"r"
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

	@Override
	public String getGrammarFileName() { return "LittleGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LittleGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RContext extends ParserRuleContext {
		public TerminalNode STRINGLIT() { return getToken(LittleGrammarParser.STRINGLIT, 0); }
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleGrammarListener ) ((LittleGrammarListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleGrammarListener ) ((LittleGrammarListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LittleGrammarVisitor ) return ((LittleGrammarVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(STRINGLIT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\7\4\2\t\2\3\2\3"+
		"\2\3\2\2\2\3\2\2\2\2\5\2\4\3\2\2\2\4\5\7\b\2\2\5\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}