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
public class FloatLiteralNode extends ASTNode
{
    private final float literalValue;
    
    public FloatLiteralNode(float value)
    {
        this.literalValue = value;
    }
    
    public float getLiteralValue()
    {
        return literalValue;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}