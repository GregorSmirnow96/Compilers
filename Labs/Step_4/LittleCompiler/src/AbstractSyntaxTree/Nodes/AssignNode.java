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
public class AssignNode extends ASTNode
{
    protected final static int VARIABLE_INDEX = 0;
    protected final static int EXPRESSION_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAssignTAC = new ArrayList<>();
        TACLine tac = new TACLine();
        //tac.addElement(this.getType().toString());  //Check on this
        tac.addElement(this.children.get(VARIABLE_INDEX).toString());
        //probably need to send the expression index value to and expressionNode
        tac.addElement(this.children.get(EXPRESSION_INDEX).toString());
        completeAssignTAC.add(tac);
        return completeAssignTAC;
    }
}