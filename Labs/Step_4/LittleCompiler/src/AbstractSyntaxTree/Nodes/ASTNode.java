/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public abstract class ASTNode
{
    protected List<ASTNode> children;
    
    public ASTNode()
    {
        this.children = new ArrayList<>();
    }
    
    public void addChild(ASTNode childNode)
    {
        this.children.add(childNode);
    }
    
    protected String getChildResultRegister(List<TACLine> childCode)
    {
        List<String> lastLineElements = childCode
            .get(childCode.size() - 1)
            .getElements();
        return lastLineElements.get(lastLineElements.size() - 1);
    }
    
    protected ESymbolAttribute getChildResultType(List<TACLine> childCode)
    {
        String finalStatement = childCode
            .get(childCode.size() - 1).getElements().get(0);
        
        return finalStatement.charAt(finalStatement.length() - 1) == 'I'
            ? ESymbolAttribute.INT
            : ESymbolAttribute.FLOAT;
    }
    
    public abstract List<TACLine> generate3AC();
}