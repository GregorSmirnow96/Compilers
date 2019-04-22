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
public class StatementListNode extends ASTNode
{
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> statements = new ArrayList<>();
        
        children.forEach(child ->
        {
            if (child instanceof ReturnNode)
            {
                statements.addAll(child.generate3AC());
            }
        });
        
        return statements;
    }
}