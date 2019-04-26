/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.Nodes.FloatLiteralNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import AbstractSyntaxTree.Nodes.VariableNode;
import AbstractSyntaxTree.TACLine;
import AbstractSyntaxTree.TempararyRegisters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class PlusNode extends ASTNode
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
            tac.addElement("ADDI");
        }
        else {
            tac.addElement("ADDF");
        }

        String leftValue = null;
        
        if (left instanceof IntLiteralNode)
        {
            leftValue = String.valueOf(
                ((IntLiteralNode) left).getLiteralValue());
            TACLine storeRightValue = new TACLine();
            storeRightValue.addElement("STOREI");
            storeRightValue.addElement(leftValue);
            leftValue = TempararyRegisters.getInstance().getTempReg();
            storeRightValue.addElement(leftValue);
            completeAddTAC.add(storeRightValue);
        }
        else if (left instanceof FloatLiteralNode)
        {
            leftValue = String.valueOf(
                ((FloatLiteralNode) left).getLiteralValue());
            TACLine storeRightValue = new TACLine();
            storeRightValue.addElement("STOREF");
            storeRightValue.addElement(leftValue);
            leftValue = TempararyRegisters.getInstance().getTempReg();
            storeRightValue.addElement(leftValue);
            completeAddTAC.add(storeRightValue);
        }
        else if (left instanceof VariableNode)
        {
            leftValue = ((VariableNode) left).getVariableName();
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
            TACLine storeRightValue = new TACLine();
            storeRightValue.addElement("STOREI");
            storeRightValue.addElement(rightValue);
            rightValue = TempararyRegisters.getInstance().getTempReg();
            storeRightValue.addElement(rightValue);
            completeAddTAC.add(storeRightValue);
        }
        else if (right instanceof FloatLiteralNode)
        {
            rightValue = String.valueOf(
                ((FloatLiteralNode) right).getLiteralValue());
            TACLine storeRightValue = new TACLine();
            storeRightValue.addElement("STOREF");
            storeRightValue.addElement(rightValue);
            rightValue = TempararyRegisters.getInstance().getTempReg();
            storeRightValue.addElement(rightValue);
            completeAddTAC.add(storeRightValue);
        }
        else if (right instanceof VariableNode)
        {
            rightValue = ((VariableNode) right).getVariableName();
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