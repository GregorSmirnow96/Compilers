/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.Nodes.FloatLiteralNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import AbstractSyntaxTree.TACLine;
import AbstractSyntaxTree.TempararyRegisters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class MinusNode extends ASTNode
{
    protected final static int LEFT_OPERAND_INDEX = 0;
    protected final static int RIGHT_OPERAND_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAddTAC = new ArrayList<>();
        TACLine tac = new TACLine();
        ASTNode left = this.children.get(LEFT_OPERAND_INDEX);
        ASTNode right = this.children.get(RIGHT_OPERAND_INDEX);
        if (left instanceof IntLiteralNode || right instanceof IntLiteralNode){
            tac.addElement("SUBI");
        }
        else {
            tac.addElement("SUBF");
        }

        String leftValue = null;
        
        if (left instanceof IntLiteralNode)
        {
            leftValue = String.valueOf(
                ((IntLiteralNode) left).getLiteralValue());
        }
        else if (left instanceof FloatLiteralNode)
        {
            leftValue = String.valueOf(
                ((FloatLiteralNode) left).getLiteralValue());
        }
        else
        {
            List<TACLine> leftExpressionCode = left.generate3AC();
            leftValue = this.getChildResultRegister(leftExpressionCode);
            completeAddTAC.addAll(leftExpressionCode);
        }

        String rightValue = null;
        
        if (right instanceof IntLiteralNode)
        {
            rightValue = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
        }
        else if (right instanceof FloatLiteralNode)
        {
            rightValue = String.valueOf(
                ((FloatLiteralNode) right).getLiteralValue());
        }
        else
        {
            List<TACLine> rightExpressionCode = right.generate3AC();
            rightValue = this.getChildResultRegister(rightExpressionCode);
            completeAddTAC.addAll(rightExpressionCode);
        }
        
        tac.addElement(leftValue);
        tac.addElement(rightValue);
        tac.addElement(TempararyRegisters.getInstance().getTempReg());
        
        completeAddTAC.add(tac);
        return completeAddTAC;
    }
}