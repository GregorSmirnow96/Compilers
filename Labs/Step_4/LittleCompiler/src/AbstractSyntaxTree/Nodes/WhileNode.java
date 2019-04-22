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
 * @author Ken
 */
public class WhileNode extends ASTNode
{
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeWhileTAC = new ArrayList<>();
        TACLine tac = new TACLine();

        return completeWhileTAC;
    }
}