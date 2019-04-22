/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.Labels;
import AbstractSyntaxTree.TACLine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class ElseNode extends ASTNode
{
    protected final static int CONDITION_INDEX = 0;
    protected final static int STATEMENT_LIST_INDEX = 1;
    
    @Override
    public List<TACLine> generate3AC()
    {
        Labels label = Labels.getInstance();
        String elseLabel = label.getLabel();
        List<TACLine> completeElseTAC = new ArrayList<>();
        TACLine tac = new TACLine();
        tac.addElement("Label " + elseLabel);
        tac.addElement(this.children.get(CONDITION_INDEX).toString());
        tac.addElement(this.children.get(STATEMENT_LIST_INDEX).toString());

        completeElseTAC.add(tac);
        return completeElseTAC;
    }
}