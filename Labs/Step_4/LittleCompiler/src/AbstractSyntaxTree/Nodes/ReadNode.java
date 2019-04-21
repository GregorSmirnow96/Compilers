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
public class ReadNode extends ASTNode
{
    protected final static int READ_INDEX = 0;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeReadTAC = new ArrayList<>();
        var tac = new TACLine();
        var read = this.children.get(READ_INDEX);
        if (read instanceof IntLiteralNode) {
            tac.addElement("READI");
        }
        else {
            tac.addElement("READF");
        }
        tac.addElement(read.toString());
        completeReadTAC.add(tac);
        return completeReadTAC;
    }
}