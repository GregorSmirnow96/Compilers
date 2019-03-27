/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import java.io.IOException;

/**
 *
 * @author im5no
 */
public class LittleCompiler
{
    /**
     * @param arguments 
     *  The command line arguments
     * @throws
     *  java.io.IOException
     */
    public static void main(String[] arguments) throws IOException
    {
        for (String compiledFilePath : arguments)
        {
            CompilerFactory compilerFactory = new CompilerFactory();
            Compiler littleCompiler = compilerFactory
                .createCompiler(compiledFilePath);

            littleCompiler.generateAndParseTokens();
        }
    }
}