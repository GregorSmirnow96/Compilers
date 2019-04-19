/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.TACLine;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}