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
import symboltables.SymbolTable;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public class GreaterThanNode extends ASTNode
{
    protected final static int LEFT_OPERAND_INDEX = 0;
    protected final static int RIGHT_OPERAND_INDEX = 1;
    
    private final SymbolTable scopeTable;
    
    public GreaterThanNode(SymbolTable table)
    {
        this.scopeTable = table;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAddTAC = new ArrayList<>();
        ASTNode left = this.children.get(LEFT_OPERAND_INDEX);
        ASTNode right = this.children.get(RIGHT_OPERAND_INDEX);

        String variableType = "F";
        String leftValue = null;
        
        if (left instanceof IntLiteralNode)
        {
            String literal = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREI");
            storeLiteralLine.addElement(literal);
            leftValue = TempararyRegisters
                .getInstance()
                .getTempReg();
            storeLiteralLine.addElement(leftValue);
            completeAddTAC.add(storeLiteralLine);
        }
        else if (left instanceof FloatLiteralNode)
        {
            String literal = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREF");
            storeLiteralLine.addElement(literal);
            leftValue = TempararyRegisters
                .getInstance()
                .getTempReg();
            storeLiteralLine.addElement(leftValue);
            completeAddTAC.add(storeLiteralLine);
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
            rightValue = TempararyRegisters
                .getInstance()
                .getTempReg();
            storeLiteralLine.addElement(rightValue);
            completeAddTAC.add(storeLiteralLine);
            variableType = "I";
        }
        else if (right instanceof FloatLiteralNode)
        {
            String rightLiteral = String.valueOf(
                ((IntLiteralNode) right).getLiteralValue());
            TACLine storeLiteralLine = new TACLine();
            storeLiteralLine.addElement("STOREF");
            storeLiteralLine.addElement(rightLiteral);
            rightValue = TempararyRegisters
                .getInstance()
                .getTempReg();
            storeLiteralLine.addElement(rightValue);
            completeAddTAC.add(storeLiteralLine);
        }
        else if (right instanceof VariableNode)
        {
            rightValue = ((VariableNode) right).getVariableName();
            ESymbolAttribute type = this.scopeTable
                .getSymbolByName(rightValue)
                .getAttribute();
            variableType = type == ESymbolAttribute.INT
                ? "I"
                : "F";
        }
        else
        {
            List<TACLine> rightExpressionCode = right.generate3AC();
            rightValue = this.getChildResultRegister(rightExpressionCode);
            completeAddTAC.addAll(rightExpressionCode);
            ESymbolAttribute expressionType = this.getChildResultType(
                rightExpressionCode);
            variableType = expressionType == ESymbolAttribute.INT
                ? "I"
                : "F";
        }
        
        TACLine jumpLine = new TACLine();
        jumpLine.addElement("LE".concat(variableType));
        jumpLine.addElement(leftValue);
        jumpLine.addElement(rightValue);
        completeAddTAC.add(jumpLine);
        /* Add label in caller */
        
        return completeAddTAC;
    }
}