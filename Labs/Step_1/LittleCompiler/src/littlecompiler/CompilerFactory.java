/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import java.io.IOException;
import littlecompiler.GeneratedGrammarFiles.LittleBaseListener;
import littlecompiler.GeneratedGrammarFiles.LittleLexer;
import littlecompiler.GeneratedGrammarFiles.LittleParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * <p>
 *  A factory class that handles creating Compilers and injecting their
 *  dependencies. The dependencies are created here to allow for unit testing
 *  of the Compiler class.
 * </p>
 * @author im5no
 */
public class CompilerFactory
{
    /**
     * @param compiledFilePath
     *  The file path of the file being compiled.
     * @return
     *  A Compiler to compile the provided file.
     * @throws IOException
     */
    public Compiler createCompiler(String compiledFilePath) throws IOException
    {
        return createCompiler(
            generateCharStreamFromFilePath(
                compiledFilePath));
    }
    
    /**
     * @param compiledFilePath
     *  The file path of the file being compiled.
     * @return
     *  A CharStream of all the characters in the compiled file.
     * @throws IOException
     */
    private CharStream generateCharStreamFromFilePath(
        String compiledFilePath) throws IOException
    {
        return CharStreams.fromFileName(compiledFilePath);
    }
    
    /**
     * @param compiledFileCharStream
     *  A CharStream of all the characters in the compiled file.
     * @return
     *  A Compiler for compiling the provided CharStream.
     */
    private Compiler createCompiler(CharStream compiledFileCharStream)
    {
        LittleBaseListener littleListener = new LittleBaseListener();
        
        LittleLexer littleLexer =
            new LittleLexer(compiledFileCharStream);
        
        LittleParser littleParser = new LittleParser(
            new CommonTokenStream(littleLexer));
        
        return new Compiler(
            littleListener,
            littleLexer,
            littleParser);
    }
}