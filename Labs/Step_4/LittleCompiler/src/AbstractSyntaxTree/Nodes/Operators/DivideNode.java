/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import AbstractSyntaxTree.TACLine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class DivideNode extends ASTNode
{
    protected final static int LEFT_OPERATOR_INDEX = 0;
    protected final static int RIGHT_OPERATOR_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeDivideTAC = new ArrayList<>();
        TACLine tac =  new TACLine();
        ASTNode left = this.children.get(LEFT_OPERATOR_INDEX);
        ASTNode right = this.children.get(RIGHT_OPERATOR_INDEX);
        if (left instanceof IntLiteralNode || right instanceof IntLiteralNode) {
            tac.addElement("DIVI");
        }
        else {
            tac.addElement("DIVF");
        }

        tac.addElement(left.toString());
        tac.addElement(right.toString());
        completeDivideTAC.add(tac);
        return completeDivideTAC;
    }
}