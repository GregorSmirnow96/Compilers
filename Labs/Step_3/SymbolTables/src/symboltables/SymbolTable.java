/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltables;

import java.util.ArrayList;
import java.util.List;
import symboltables.enums.ESymbolType;

/**
 * <p>
 *  This class represents a symbol table for a single scope.
 * </p>
 * @author im5no
 */
public class SymbolTable
{
    /* Attributes of a SymbolTable. */
    private final String name;
    private final List<Symbol> symbols;
    private final List<SymbolTable> childTables;
    
    public SymbolTable(String name)
    {
        this.name = name;
        this.symbols = new ArrayList<>();
        this.childTables = new ArrayList<>();
    }
    
    
    /* Getters */
    
    public String getName()
    {
        return name;
    }
    
    public List<Symbol> getSymbols()
    {
        return symbols;
    }
    
    public Symbol getSymbolByName(String symbolName)
    {
        for (Symbol symbol : symbols)
            if (symbol.getName().equals(symbolName))
                return symbol;
        
        return null;
    }
    
    public List<SymbolTable> getChildTables()
    {
        return childTables;
    }
    
    public SymbolTable getChildTableByName(String tableName)
    {
        for (SymbolTable table : childTables)
            if (table.getName().equals(tableName))
                return table;
        
        return null;
    }
    
    
    /* Mutators */
    
    public void addSymbol(Symbol newSymbol)
    {
        ESymbolType symbolType = newSymbol.getType();
        if (symbolType == ESymbolType.PROCEDURE)
            addChildProcedureTable(newSymbol);
        else
            symbols.add(newSymbol);
    }
    
    private void addChildProcedureTable(Symbol procedureSymbol)
    {
        SymbolTable procedureTable = new SymbolTable(procedureSymbol.getName());
        childTables.add(procedureTable);
    }
    
    public void addChildTable(SymbolTable newTable)
    {
        childTables.add(newTable);
    }
}