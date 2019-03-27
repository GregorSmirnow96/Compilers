/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltables;

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
        String currentNamespace = rootTable.getName();
        
        System.out.println("---------------");
        recursivelyPrintSymbolTables(
            rootTable,
            currentNamespace);
    }
    
    /**
     * <p>
     *  Recursively traverses all of the symbol tables in a tree structure,
     *  printing the table names / their contents along the way.
     * </p>
     * @param currentTable
     *  The current table being iterated over.
     * @param currentNamespace 
     *  The namespace of the current table.
     */
    private void recursivelyPrintSymbolTables(
        SymbolTable currentTable,
        String currentNamespace)
    {
        printTableInfo(
            currentTable,
            currentNamespace);
        
        currentTable.getChildTables().forEach(childTable ->
        {
            String childNamespace = currentNamespace
                    .concat(".".concat(childTable.getName()));
            recursivelyPrintSymbolTables(
                    childTable,
                    childNamespace);
        });
    }
    
    /**
     * <p>
     *  Prints the currentTable's name and all of its symbols.
     * </p>
     * @param currentTable
     *  The table whose info is being printed.
     * @param currentNamespace
     *  The namespace of this table.
     */
    private void printTableInfo(
        SymbolTable currentTable,
        String currentNamespace)
    {
        System.out.println(currentNamespace);
        currentTable.getSymbols().forEach(symbol ->
        {
            String columnWhitespace = "               ";
            String name = symbol.getName();
            String type = symbol.getType().name();
            String attribute = symbol.getAttribute().name();
            String nameColumn = name
                .concat(columnWhitespace.substring(name.length()));
            String typeColumn = type
                .concat(columnWhitespace.substring(type.length()));
            String attributeColumn = attribute
                .concat(columnWhitespace.substring(attribute.length()));
            System.out.println(
                String.format(
                    "    %s%s%s",
                    nameColumn,
                    typeColumn,
                    attributeColumn));
        });
        System.out.println("---------------");
    }
}