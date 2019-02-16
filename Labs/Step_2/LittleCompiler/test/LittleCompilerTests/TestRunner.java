/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LittleCompilerTests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * <p>
 *  The driver-class for this project's JUnit test suite.
 * </p>
 * @author im5no
 */
public class TestRunner
{
    /**
     * <p>
     *  Runs all @Test methods in the specified classes.
     * </p>
     * @param args 
     */
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(TokenVisualizerTest.class);
      
        result.getFailures().forEach(failure ->
            System.out.println(failure.toString()));
		
        System.out.println(result.wasSuccessful());
   }
}