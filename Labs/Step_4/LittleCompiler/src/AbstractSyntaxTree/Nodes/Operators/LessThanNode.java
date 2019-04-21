/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.TACLine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class LessThanNode extends ASTNode
{
    protected final static int LEFT_OPERATOR_INDEX = 0;
    protected final static int RIGHT_OPERATOR_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeLessTAC = new ArrayList<>();
        var tac = new TACLine();
        tac.addElement("LEI");
        tac.addElement(this.children.get(LEFT_OPERATOR_INDEX).toString());
        tac.addElement(this.children.get(RIGHT_OPERATOR_INDEX).toString());
        completeLessTAC.add(tac);
        return completeLessTAC;
    }
}