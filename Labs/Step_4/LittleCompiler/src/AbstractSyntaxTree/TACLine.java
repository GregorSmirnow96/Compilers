/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import java.util.ArrayList;

/**
 *
 * @author im5no
 */
public class TACLine
{
    private final ArrayList<String> elements;
    
    public TACLine()
    {
        this.elements = new ArrayList<>();
    }
    
    public ArrayList<String> getElements()
    {
        return elements;
    }
    
    public void addElement(String element)
    {
        this.elements.add(element);
    }
    
    public String getLineText()
    {
        String lineText = "";
        
        for (String element : elements)
        {
            lineText = lineText.concat(element.concat(" "));
        }
        
        return lineText;
    }
}