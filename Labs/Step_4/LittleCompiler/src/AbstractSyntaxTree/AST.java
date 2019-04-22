/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import AbstractSyntaxTree.Nodes.ASTNode;
import java.util.List;
import java.util.Stack;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public class AST
{
    private final ASTNode root;
    private final Stack<ASTNode> currentAstBranch;
    
    public AST(ASTNode root)
    {
        this.root = root;
        this.currentAstBranch = new Stack<>();
        this.currentAstBranch.push(root);
    }
    
    public ASTNode getCurrentNode()
    {
        return this.currentAstBranch.peek();
    }
    
    public void push(ASTNode newCurrentNode)
    {
        this.currentAstBranch.peek().addChild(newCurrentNode);
        this.currentAstBranch.push(newCurrentNode);
    }
    
    public ASTNode pop()
    {
        return this.currentAstBranch.pop();
    }
    
    public List<TACLine> generate3AC()
    {
        return root.generate3AC();
    }
}