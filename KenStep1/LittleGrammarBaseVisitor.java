// Generated from /Users/kennethtaylor/MSU/CSCI/CSCIRepositoriedClassWork/CSCIRepositoriedClassWork/CSCI468/Project/Step1/LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link LittleGrammarVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class LittleGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements LittleGrammarVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitR(LittleGrammarParser.RContext ctx) { return visitChildren(ctx); }
}