/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltables;

import symboltables.enums.ESymbolAttribute;
import symboltables.enums.ESymbolType;

/**
 *
 * @author im5no
 */
public class SymbolTables
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SymbolTable globalSymbolTable = new SymbolTable("Global");
        
        globalSymbolTable.addSymbol(
            new Symbol(
                "anInt",
                ESymbolType.VAR,
                ESymbolAttribute.INT));
        globalSymbolTable.addSymbol(
            new Symbol(
                "ProcedureX",
                ESymbolType.PROCEDURE,
                ESymbolAttribute.INT));
        
        SymbolTableVisualizer tableVisualizer = new SymbolTableVisualizer();
        tableVisualizer.printSymbolTable(globalSymbolTable);
    }
}