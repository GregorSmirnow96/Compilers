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
    private static final int STATEMENT_LIST_INDEX = 2;
    
    private final String functionName;
    
    public FunctionNode(String functionName)
    {
        this.functionName = functionName;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> methodLines = new ArrayList<>();
        TACLine methodLabel = new TACLine();
        methodLabel.addElement("LABEL");
        methodLabel.addElement(this.functionName);
        methodLines.add(methodLabel);
        
        this.children.forEach(child -> methodLines.addAll(child.generate3AC()));
        
        return methodLines;
    }
}