/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author im5no
 */
public class FunctionCodeContainer
{
    private static FunctionCodeContainer instance;
    private HashMap<String, List<TACLine>> functionCodes;
    
    public static FunctionCodeContainer getInstance()
    {
        return instance == null
            ? instance = new FunctionCodeContainer()
            : instance;
    }
    
    private FunctionCodeContainer()
    {
    }
    
    public void addFunctionCode(
        String functionName,
        List<TACLine> linesOfCode)
    {
        this.functionCodes.put(
            functionName,
            linesOfCode);
    }
    
    public List<TACLine> getFunctionCode(String functionName)
    {
        return this.functionCodes.get(functionName);
    }
}