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
public class AssignNode extends ASTNode
{
    protected final static int VARIABLE_INDEX = 0;
    protected final static int EXPRESSION_INDEX = 1;

    @Override
    public void addChild(ASTNode childNode)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TACLine> generate3AC()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}