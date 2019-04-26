/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.TACLine;

import java.util.ArrayList;
import java.util.List;
import symboltables.SymbolTable;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public class ReadNode extends ASTNode
{
    protected final static int READ_INDEX = 0;
    
    private final SymbolTable scopeTable;
    
    public ReadNode(SymbolTable table)
    {
        this.scopeTable = table;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeReadTAC = new ArrayList<>();
        TACLine tac = new TACLine();
        ASTNode read = this.children.get(READ_INDEX);
        
        String variableName = ((VariableNode) read).getVariableName();
        ESymbolAttribute type = this.scopeTable
            .getSymbolByName(variableName)
            .getAttribute();
        String variableType = type == ESymbolAttribute.INT
            ? "I"
            : "F";
        
        tac.addElement("READ".concat(variableType));
        tac.addElement(variableName);
        
        completeReadTAC.add(tac);
        return completeReadTAC;
    }
}