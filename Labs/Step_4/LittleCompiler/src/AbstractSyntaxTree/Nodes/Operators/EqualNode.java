/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.Nodes.FloatLiteralNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import static AbstractSyntaxTree.Nodes.Operators.PlusNode.LEFT_OPERAND_INDEX;
import AbstractSyntaxTree.Nodes.VariableNode;
import AbstractSyntaxTree.ParameterRegisterHandler;
import AbstractSyntaxTree.TACLine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class EqualNode extends ASTNode
{
    protected final static int LEFT_OPERAND_INDEX = 0;
    protected final static int RIGHT_OPERAND_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAddTAC = new ArrayList<>();
        ASTNode left = this.children.get(LEFT_OPERAND_INDEX);
        ASTNode right = this.children.get(RIGHT_OPERAND_INDEX);

        String leftValue = null;
        
        if (left instanceof IntLiteralNode)
        {
            String literal = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREI");
            storeLiteralLine.addElement(literal);
            leftValue = ParameterRegisterHandler
                .getInstance()
                .getNextRegister();
            storeLiteralLine.addElement(leftValue);
        }
        else if (left instanceof FloatLiteralNode)
        {
            String literal = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREF");
            storeLiteralLine.addElement(literal);
            leftValue = ParameterRegisterHandler
                .getInstance()
                .getNextRegister();
            storeLiteralLine.addElement(leftValue);
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
            String literal = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREI");
            storeLiteralLine.addElement(literal);
            rightValue = ParameterRegisterHandler
                .getInstance()
                .getNextRegister();
            storeLiteralLine.addElement(rightValue);
        }
        else if (right instanceof FloatLiteralNode)
        {
            String rightLiteral = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREF");
            storeLiteralLine.addElement(rightLiteral);
            rightValue = ParameterRegisterHandler
                .getInstance()
                .getNextRegister();
            storeLiteralLine.addElement(rightValue);
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
        
        TACLine jumpLine = new TACLine();
        jumpLine.addElement(leftValue);
        jumpLine.addElement(rightValue);
        /* Add label in caller */
        
        return completeAddTAC;
    }
}