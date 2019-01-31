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
 *      Tokens:
 *       { TYPE_1 : TEXT_1 }
 *       { TYPE_2 : TEXT_2 }
 *                .
 *                .
 *                .
 *       { TYPE_N : TEXT_N }
 * </p>
 * @author im5no
 */
public class TokenVisualizer
{
    /* A List of generated Tokens */
    private final List<Token> tokens;
    /* The length of the token type in the token-info-display-string */
    private final int lengthOfLeftHandSide;
    
    public TokenVisualizer(List<Token> tokens)
    {
        this.tokens = tokens;
        this.lengthOfLeftHandSide = findLongestTokenTypeNameLength();
    }
    
    /**
     * <p>
     *  Finds the longest length of the Little language's token names.
     * </p>
     * @return
     *  The length of the longest Little-token name.
     */
    private int findLongestTokenTypeNameLength()
    {
        int longestTypeNameLength = 0;
        for (Token token : tokens)
        {
            String tokenType = LittleLexer.ruleNames[token.getType() - 1];
            int tokenTypeNameLength = tokenType.length();
            longestTypeNameLength = longestTypeNameLength < tokenTypeNameLength
                ? tokenTypeNameLength
                : longestTypeNameLength;
        }
        
        return longestTypeNameLength;
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
        
        stringBuilder.append("Tokens:\n");
        tokens.forEach(token ->
        {
            String nextLine = generateTokenDataString(token);
            stringBuilder.append(nextLine);
            stringBuilder.append("\n");
        });
        
        return stringBuilder.toString();
    }
    
    /**
     * <p>
     *  Generates a single line in the token info String.
     * </p>
     * @param token
     *  The token whose info is contained in this line.
     * @return
     *  A generated line of text which contains info on a token.
     */
    private String generateTokenDataString(Token token)
    {
        int tokenTypeID = token.getType();
        String tokenType = LittleLexer.ruleNames[tokenTypeID - 1];
        
        final int lengthOfLeftSide = lengthOfLeftHandSide;
        int leftSideWhiteSpaceSize = lengthOfLeftSide - tokenType.length();
        StringBuilder whiteSpaceBuilder = new StringBuilder();
        for (int i = 0; i < leftSideWhiteSpaceSize; i++)
            whiteSpaceBuilder.append(" ");
        String whiteSpace = whiteSpaceBuilder.toString();
        
        return "\t" + tokenType + whiteSpace + " : " + token.getText();
    }
}