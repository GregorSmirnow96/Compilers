/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LittleCompilerTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import littlecompilerv1.GeneratedGrammarFiles.LittleLexer;
import littlecompilerv1.TokenVisualizer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 *  Tests the token printing class (TokenVisualizer.java).
 * </p>
 * @author im5no
 */
public class TokenVisualizerTest
{
    /* The directories containing the input and output Little files. */
    private final String inputsDirectory = "LittlePrograms\\inputs\\";
    private final String outputsDirectory = "LittlePrograms\\outputs\\";
    /* The file extensions for the input and output Little files. */
    private final String inputFileExtension = ".micro";
    private final String outputFileExtension = ".out";
    
    
    /* Unit tests for each of the provided Little programs. */
    
    @Test
    public void testScanningFibonacciProgram()
    {
        String programName = "fibonacci";
        testProgramInputVsOutput(programName);
    }
    
    @Test
    public void testScanningLoopProgram()
    {
        String programName = "loop";
        testProgramInputVsOutput(programName);
    }
    
    @Test
    public void testScanningNestedProgram()
    {
        String programName = "nested";
        testProgramInputVsOutput(programName);
    }
    
    @Test
    public void testScanningSqrtProgram()
    {
        String programName = "sqrt";
        testProgramInputVsOutput(programName);
    }
    
    /**
     * <p>
     *  Scans a program to generate a List of tokens, then compares the output
     *  of the scanner to the expected tokens provided by the professor.
     * </p>
     * @param programName 
     */
    private void testProgramInputVsOutput(String programName)
    {
        String inputFilePath = inputsDirectory
            .concat(programName)
            .concat(inputFileExtension);
        String outputFilePath = outputsDirectory
            .concat(programName)
            .concat(outputFileExtension);
        
        LittleLexer lexer = createLexer(inputFilePath);
        List<Token> tokens = (List<Token>) lexer.getAllTokens();
        
        TokenVisualizer tokenVisualizer = new TokenVisualizer(tokens);
        
        String scannedTokensString = tokenVisualizer.getTokenInfoString();
        String expectedTokensString = getFileText(outputFilePath);
        
        Assert.assertEquals(
            "Scanned String = Expected String",
            scannedTokensString,
            expectedTokensString);
    }
    
    /**
     * @param compiledFilePath
     *  The file path used to create the LittleLexer.
     * @return
     *  Returns a LittleLexer used for unit testing.
     */
    private LittleLexer createLexer(String compiledFilePath)
    {
        LittleLexer lexerToReturn = null;
        
        try
        {
            CharStream compiledFileCharStream = CharStreams
                .fromFileName(compiledFilePath);
            lexerToReturn = new LittleLexer(compiledFileCharStream);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        return lexerToReturn;
    }
    
    /**
     * @param filePath
     *  The file path of the file whose text is bring extracted.
     * @return
     *  Returns the contents of the file as a String.
     */
    private String getFileText(String filePath)
    {
        String fileText = null;
        
        try
        {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            fileText = "";
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null)
                fileText = fileText.concat(nextLine).concat("\n");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        return fileText;
    }
}