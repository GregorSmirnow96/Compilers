/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import java.util.List;
import littlecompiler.GeneratedGrammarFiles.LittleLexer;
import org.antlr.v4.runtime.Token;

/**
 * <p>
 *  A utility class that prints the generated tokens in the format:
 *      Token Type: {type}
 *      Value: {value}
 *             .
 *             .
 *             .
 *      Token Type: {type}
 *      Value: {value}
 * </p>
 * @author im5no
 */
public class TokenVisualizer
{
    /* A List of generated Tokens */
    private final List<Token> tokens;
    
    public TokenVisualizer(List<Token> tokens)
    {
        this.tokens = tokens;
    }
    
    /**
     * <p>
     *  Generates a String which displays info on all the generate tokens.
     * </p>
     * @return
     *  A String with info on all the generated tokens in your compiled program.
     */
    public String getTokenInfoString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        tokens.forEach(token ->
        {
            String nextTokenInfo = generateTokenDataString(token);
            stringBuilder.append(nextTokenInfo);
        });
        
        return stringBuilder.toString();
    }
    
    /**
     * <p>
     *  Generates a String which describes a token.
     * </p>
     * @param token
     *  The token whose info is contained in this String.
     * @return
     *  A String of the format:
     *      Token Type: {type}
     *      Value: {value}
     */
    private String generateTokenDataString(Token token)
    {
        int tokenTypeID = token.getType();
        String tokenType = LittleLexer.ruleNames[tokenTypeID - 1];
        
        return
            "Token Type: " + tokenType + "\nValue: " + token.getText() + "\n";
    }
}