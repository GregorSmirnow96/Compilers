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
public class IfNode extends ASTNode
{
    protected final static int CONDITION_INDEX = 0;
    protected final static int STATEMENT_LIST_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeIfTAC = new ArrayList<>();
        var tac = new TACLine();
        tac.addElement("GEI");  //Seems to me the same as Greater and Greater or Equal
        tac.addElement(this.children.get(CONDITION_INDEX).toString());
        tac.addElement(this.children.get(STATEMENT_LIST_INDEX).toString());
        tac.addElement("label#");   //Need to check on labels and numbering
        completeIfTAC.add(tac);
        return completeIfTAC;
    }
}