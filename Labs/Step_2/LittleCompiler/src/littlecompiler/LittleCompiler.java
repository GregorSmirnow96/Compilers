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
        String compiledFilePath = arguments[0];
        
        CompilerFactory compilerFactory = new CompilerFactory();
        Compiler littleCompiler = compilerFactory
            .createCompiler(compiledFilePath);

        /* Call consecutive compilation steps: */
        // Step 1
        String[] filePathParts = compiledFilePath
            .replace("\\\\", "/")
            .split("/");
        String fileName = filePathParts[filePathParts.length - 1];
        String fileNameWithoutExtension = fileName.split("\\.")[0];
        
        littleCompiler.generateAndParseTokens();
    }
}