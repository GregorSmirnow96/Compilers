/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;

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
    
    public abstract List<TACLine> generate3AC();
}