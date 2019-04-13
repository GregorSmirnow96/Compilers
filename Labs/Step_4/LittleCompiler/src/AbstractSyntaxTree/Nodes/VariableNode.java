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
public class VariableNode extends ASTNode
{
    private final String variableName;
    
    public VariableNode(String variableName)
    {
        this.variableName = variableName;
    }
    
    public String getVariableName()
    {
        return this.variableName;
    }
    
    // This shouldn't require code generation (I don't think).
    @Override
    public List<TACLine> generate3AC()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}