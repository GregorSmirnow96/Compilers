package littlecompiler.GeneratedGrammarFiles;

// Generated from Little.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LittleParser}.
 */
public interface LittleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LittleParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(LittleParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(LittleParser.String_literalContext ctx);
}