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
public class WriteNode extends ASTNode
{
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeWriteTAC = new ArrayList<>();
        TACLine tac = new TACLine();
        //tac.addElement(this.getType().toString());  //check on this
        tac.addElement(this.children.get(0).toString());
        completeWriteTAC.add(tac);
        return completeWriteTAC;
    }
}