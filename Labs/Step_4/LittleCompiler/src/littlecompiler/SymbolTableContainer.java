/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlecompiler;

import symboltables.SymbolTable;

/**
 *
 * @author im5no
 */
public class SymbolTableContainer
{
    private static SymbolTableContainer instance;
    public SymbolTable globalSymbolTable;
    
    public static SymbolTableContainer getInstance()
    {
        return instance == null
            ? instance = new SymbolTableContainer()
            : instance;
    }
    
    private SymbolTableContainer()
    {
    }
    
    public SymbolTable getGlobalTable()
    {
        return globalSymbolTable;
    }
    
    public void setGlobalTable(SymbolTable globalSymbolTable)
    {
        this.globalSymbolTable = globalSymbolTable;
    }
}