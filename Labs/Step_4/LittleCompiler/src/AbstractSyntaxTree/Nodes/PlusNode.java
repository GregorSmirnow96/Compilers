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
public class PlusNode extends ASTNode
{
    protected final static int LEFT_OPERATOR_INDEX = 0;
    protected final static int RIGHT_OPERATOR_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        var tac = new TACLine();
        tac.addElement("T1");
        return tac;
    }
}