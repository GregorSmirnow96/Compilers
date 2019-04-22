/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class FunctionCallNode extends ASTNode
{
    private final String functionName;
    
    public FunctionCallNode(String functionName)
    {
        this.functionName = functionName;
    }
    
    public String getFunctionName()
    {
        return this.functionName;
    }
    
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> linesEndingWithFunctionResultStore = new ArrayList<>();
        
        this.children.forEach(child ->
            linesEndingWithFunctionResultStore
                .addAll(child.generate3AC()));
        
        return linesEndingWithFunctionResultStore;
    }
}