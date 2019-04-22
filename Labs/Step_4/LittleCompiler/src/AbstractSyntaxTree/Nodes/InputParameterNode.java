/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.ParameterRegisterHandler;
import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class InputParameterNode extends ASTNode
{
    private final String parameterName;
    
    public InputParameterNode(String parameterName)
    {
        this.parameterName = parameterName;
    }
    
    public String getParameterName()
    {
        return parameterName;
    }
    
    @Override
    public List<TACLine> generate3AC()
    {
        // Use singleton class to load in variables.
        List<TACLine> variableLoadingCode = new ArrayList<>();
        
        TACLine newLine = new TACLine();
        newLine.addElement("LOAD");
        newLine.addElement(
            ParameterRegisterHandler.getInstance().getNextRegister());
        newLine.addElement(this.parameterName);
        
        variableLoadingCode.add(newLine);
        
        return variableLoadingCode;
    }
}