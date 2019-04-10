/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * @summary
 *  This class defined protocols for handling errors that occur during scanning
 *  and parsing.
 * @author im5no
 */
public class LittleErrorStrategy extends DefaultErrorStrategy
{
    @Override
    public Token recoverInline(Parser recognizer)
        throws RecognitionException
    {
        InputMismatchException e = new InputMismatchException(recognizer);
        for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
            context.exception = e;
        }

        throw new ParseCancellationException(e);
    }
    
    @Override
    public void recover(
        Parser recognizer,
        RecognitionException e)
    {
        for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent())
        {
            context.exception = e;
        }

        throw new ParseCancellationException(e);
    }
}