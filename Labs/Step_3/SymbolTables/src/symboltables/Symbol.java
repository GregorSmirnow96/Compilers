/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltables;

import symboltables.enums.ESymbolAttribute;
import symboltables.enums.ESymbolType;

/**
 * <p>
 *  This class represents a symbol held in a symbol table.
 * </p>
 * @author im5no
 */
public class Symbol
{
    /* Attributes of a Symbol. */
    private final String name;
    private final ESymbolType type;
    private final ESymbolAttribute attribute;
    
    public Symbol(
        String name,
        ESymbolType type,
        ESymbolAttribute attribute)
    {
        this.name = name;
        this.type = type;
        this.attribute = attribute;
    }
    
    
    /* Getters */
    
    public String getName()
    {
        return name;
    }
    
    public ESymbolType getType()
    {
        return type;
    }
    
    public ESymbolAttribute getAttribute()
    {
        return attribute;
    }
}