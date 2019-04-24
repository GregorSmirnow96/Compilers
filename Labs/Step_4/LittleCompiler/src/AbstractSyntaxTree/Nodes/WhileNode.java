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
 * @author Ken
 */
public class WhileNode extends ASTNode
{
    protected final static int WHILE_CONDITION_INDEX = 2;
    protected final static int WHILE_DECL_INDEX = 4;
    protected final static int WHILE_STMTLIST_INDEX = 5;

    @Override
    public List<TACLine> generate3AC()
    {
        Labels label = Labels.getInstance();
        String whileLabel = label.getLabel();
        String endWhileLabel = label.getLabel();
        List<TACLine> completeWhileTAC = new ArrayList<>();
        
        TACLine tac = new TACLine();

        tac.addElement(whileLabel);
        //need a conditional for the JUMP
        tac.addElement("JUMP");
        tac.addElement(whileLabel);
        tac.addElement("LABEL");
        tac.addElement(endWhileLabel);
        completeWhileTAC.add(tac);
        return completeWhileTAC;
    }
}