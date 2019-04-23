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
public class DeclarationNode extends ASTNode
{
    protected final static int INT_VALUE_INDEX = 0;
    protected final static int VAR_VALUE_INDEX = 1;

    // This shouldn't require code generation (I don't think).
    @Override
    public List<TACLine> generate3AC()
    {
        return new ArrayList<>();
    }
}