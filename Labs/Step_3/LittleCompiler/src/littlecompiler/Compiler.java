/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import littlecompiler.GeneratedGrammarFiles.LittleBaseListener;
import littlecompiler.GeneratedGrammarFiles.LittleLexer;
import org.antlr.v4.runtime.Token;
import littlecompiler.GeneratedGrammarFiles.LittleParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
    
    /**
     * <p>
     *  STEP 0:
     *   This step isn't required for generating a parse tree. It is simply for
     *   demonstration purposes. Once lexer.getAllTokens() has been called there
     *   are no more Tokens in the parser's CommonTokenStream to be read, so
     *   lexer.reset() is called to put the Tokens back into the parser's
     *   CommonTokenStream. These Tokens are used in step 1 / 2.
     * </p>
     */
    public void printTokens()
    {
        List<Token> tokens = (List<Token>) lexer.getAllTokens();
        TokenVisualizer tokenVisualizer = new TokenVisualizer(tokens);
        System.out.println(tokenVisualizer.getTokenInfoString());
        
        lexer.reset();
    }

    /**
     * <p>
     *  STEP 0:
     *   This step isn't required for generating a parse tree. It is simply for
     *   demonstration purposes. Once lexer.getAllTokens() has been called there
     *   are no more Tokens in the parser's CommonTokenStream to be read, so
     *   lexer.reset() is called to put the Tokens back into the parser's
     *   CommonTokenStream. These Tokens are used in step 1 / 2.
     * </p>
     * @param fileName
     *  The name of the file whose tokens were generated.
     * @throws java.io.IOException
     */
    public void writeTokensToFile(String fileName) throws IOException
    {
        List<Token> tokens = (List<Token>) lexer.getAllTokens();
        TokenVisualizer tokenVisualizer = new TokenVisualizer(tokens);

        String outputFilePath = "./step_1_output";
        File outputFile = new File(outputFilePath);
        System.out.println(outputFile.getCanonicalPath());
        if (!outputFile.exists())
            outputFile.mkdir();
        try (BufferedWriter fileWriter = new BufferedWriter(
            new FileWriter(outputFilePath + "/" + fileName + ".out")))
        {
            fileWriter.write(tokenVisualizer.getTokenInfoString());
        }

        lexer.reset();
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
            System.out.println("Accepted");
            
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(
                listener,
                parseTree);
        }
        catch (Exception e)
        {
            System.out.println("Not accepted");
        }
    }
}