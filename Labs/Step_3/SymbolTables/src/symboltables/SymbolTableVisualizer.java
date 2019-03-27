/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltables;

import java.util.Collection;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public class SymbolTableVisualizer
{
    /**
     * <p>
     *  Prints all the symbols in the root symbol table / its children.
     * </p>
     * @param rootTable
     *  The root symbol table in a symbol table tree.
     */
    public void printSymbolTable(SymbolTable rootTable)
    {
        recursivelyPrintSymbolTables(rootTable);
    }
    
    /**
     * <p>
     *  Recursively traverses all of the symbol tables in a tree structure,
     *  printing the table names / their contents along the way.
     * </p>
     * @param currentTable
     *  The current table being iterated over.
     */
    private void recursivelyPrintSymbolTables(SymbolTable currentTable)
    {
        printTableInfo(currentTable);
        
        currentTable.getChildTables().forEach(childTable ->
            recursivelyPrintSymbolTables(childTable));
    }
    
    /**
     * <p>
     *  Prints the currentTable's name and all of its symbols.
     * </p>
     * @param currentTable
     *  The table whose info is being printed.
     */
    private void printTableInfo(SymbolTable currentTable)
    {
        System.out.println("Symbol table ".concat(currentTable.getName()));
        
        Collection<Symbol> tableSymbols = currentTable.getSymbols();
        tableSymbols.forEach(symbol ->
        {
            String name = symbol.getName();
            String type = symbol.getAttribute().toString();
            
            if (type.equals(ESymbolAttribute.STRING.toString()))
            {
                String value = symbol.getValue();
                System.out.println(
                    "name " + name + " type " + type +
                    " value \"" + value + "\"");
            }
            else
            {
                System.out.println("name " + name + " type " + type);
            }
        });
        
        System.out.println();
    }
}