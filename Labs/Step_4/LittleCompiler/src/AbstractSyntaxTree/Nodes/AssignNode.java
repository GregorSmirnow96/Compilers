/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

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
public class AssignNode extends ASTNode
{
    protected final static int VARIABLE_INDEX = 0;
    protected final static int EXPRESSION_INDEX = 1;

    private final SymbolTable scopeTable;
    
    public AssignNode(SymbolTable table)
    {
        this.scopeTable = table;
    }
    
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAssignTAC = new ArrayList<>();
        TACLine tac1 = new TACLine();
        TACLine tac2 = new TACLine();
        
        ASTNode rhs = this.children.get(EXPRESSION_INDEX);
        String variableName = ((VariableNode)this.children.get(VARIABLE_INDEX))
            .getVariableName();
        
        if (rhs instanceof IntLiteralNode)
        {
            String tempRegister = TempararyRegisters
                .getInstance()
                .checkTempReg(variableName);
            Integer value = ((IntLiteralNode) rhs).getLiteralValue();
            tac1.addElement("STOREI");
            tac1.addElement(value.toString());
            tac1.addElement(tempRegister);
            tac2.addElement("STOREI");
            tac2.addElement(tempRegister);
            tac2.addElement(variableName);
            completeAssignTAC.add(tac1);
            completeAssignTAC.add(tac2);
        }
        else if (rhs instanceof FloatLiteralNode)
        {
            String tempRegister = TempararyRegisters
                .getInstance()
                .checkTempReg(variableName);
            Float value = ((FloatLiteralNode) rhs).getLiteralValue();
            tac1.addElement("STOREF");
            tac1.addElement(value.toString());
            tac1.addElement(tempRegister);
            tac2.addElement("STOREF");
            tac2.addElement(tempRegister);
            tac2.addElement(variableName);
            completeAssignTAC.add(tac1);
            completeAssignTAC.add(tac2);
        }
        else if (rhs instanceof VariableNode)
        {
            VariableNode node = (VariableNode) rhs;
            String variable = node.getVariableName();
            ESymbolAttribute type = this.scopeTable
                .getSymbolByName(variable)
                .getAttribute();
            String variableType = type == ESymbolAttribute.INT
                ? "I"
                : "F";
            TACLine tac = new TACLine();
            tac.addElement("STORE".concat(variableType));
            tac.addElement(variable);
            tac.addElement(variableName);
            completeAssignTAC.add(tac);
        }
        else
        {
            List<TACLine> expressionCode = rhs.generate3AC();
            ESymbolAttribute expressionType = this.getChildResultType(
                expressionCode);
            String expressionResultRegister = this.getChildResultRegister(
                expressionCode);
            
            String storeType = expressionType == ESymbolAttribute.INT
                ? "STOREI"
                : "STOREF";
            
            tac2.addElement(storeType);
            tac2.addElement(expressionResultRegister);
            tac2.addElement(variableName);
            
            completeAssignTAC.addAll(expressionCode);
            completeAssignTAC.add(tac2);
        }
        
        
        return completeAssignTAC;
    }
}