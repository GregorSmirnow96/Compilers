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
public class WriteNode extends ASTNode
{
    private final SymbolTable scopeTable;
    
    public WriteNode(SymbolTable table)
    {
        this.scopeTable = table;
    }
    
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeWriteTAC = new ArrayList<>();
        
        this.children.forEach(child ->
        {
            VariableNode node = (VariableNode) child;
            String variableName = node.getVariableName();
            ESymbolAttribute type = this.scopeTable
                .getSymbolByName(variableName)
                .getAttribute();
            String variableType = type == ESymbolAttribute.INT
                ? "I"
                : "F";
            TACLine tac = new TACLine();
            tac.addElement("WRITE".concat(variableType));
            tac.addElement(variableName);
            completeWriteTAC.add(tac);
        });
        
        return completeWriteTAC;
    }
}