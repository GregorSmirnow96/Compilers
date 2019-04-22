/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.FunctionCodeContainer;
import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class FunctionNode extends ASTNode
{
    private static final int INPUT_NODE_INDEX = 0;
    private static final int STATEMENT_LIST_INDEX = 1;
    
    private final String functionName;
    
    public FunctionNode(String functionName)
    {
        this.functionName = functionName;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> methodLines = new ArrayList<>();
        List<TACLine> parameterLoadingCode = this.children
            .get(INPUT_NODE_INDEX)
            .generate3AC();
        
        methodLines.addAll(parameterLoadingCode);
        methodLines.addAll(
            this.children.get(STATEMENT_LIST_INDEX).generate3AC());
        
        methodLines.forEach(line -> System.out.println(line.getLineText()));
        
        FunctionCodeContainer.getInstance().addFunctionCode(
            functionName,
            methodLines);
        return methodLines;
    }
}