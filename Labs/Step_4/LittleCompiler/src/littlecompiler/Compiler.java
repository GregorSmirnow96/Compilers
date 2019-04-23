/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import littlecompiler.GeneratedGrammarFiles.LittleBaseListener;
import littlecompiler.GeneratedGrammarFiles.LittleLexer;
import littlecompiler.GeneratedGrammarFiles.LittleParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import symboltables.SymbolTableVisualizer;

/**
 * <p>
 *  The entity that performs scanning / parsing / code generation.
 * </p>
 * @author im5no
 */
public class Compiler
{
    /* The dependencies of the Compiler */
    private final LittleBaseListener listener;
    private final LittleLexer lexer;
    private final LittleParser parser;
    private ParseTree parseTree;
    
    public Compiler(
        LittleBaseListener listener,
        LittleLexer lexer,
        LittleParser parser)
    {
        this.listener = listener;
        this.lexer = lexer;
        this.parser = parser;
    }
    
    public void printSymbolTable()
    {
        new SymbolTableVisualizer().printSymbolTable(
            listener.symbolTables.peek());
    }

    /**
     * <p>
     *  STEP 1 + 2:
     *   Parsing the generated tokens into a parse tree.
     * </p>
     */
    public void generateAndParseTokens()
    {
        try
        {
            parseTree = parser.program();
            
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(
                listener,
                parseTree);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}