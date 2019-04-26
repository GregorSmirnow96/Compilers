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
    protected final static int CONDITION_INDEX = 0;
    protected final static int STATEMENT_LIST_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeWhileTAC = new ArrayList<>();
        
        Labels label = Labels.getInstance();
        String whileLabel = label.getLabel();
        String exitLabel = label.getLabel();
        
        TACLine whileLabelLine = new TACLine();
        whileLabelLine.addElement("LABEL");
        whileLabelLine.addElement(whileLabel);
        completeWhileTAC.add(whileLabelLine);
        
        List<TACLine> conditionCode = this.children
            .get(CONDITION_INDEX)
            .generate3AC();
        conditionCode.get(conditionCode.size() - 1).addElement(exitLabel);
        completeWhileTAC.addAll(conditionCode);
        
        /* Statement list */
        completeWhileTAC.addAll(
            this.children
                .get(STATEMENT_LIST_INDEX)
                .generate3AC());
        
        TACLine jumpUpLine = new TACLine();
        jumpUpLine.addElement("JUMP");
        jumpUpLine.addElement(whileLabel);
        completeWhileTAC.add(jumpUpLine);
        
        TACLine jumpOutLabel = new TACLine();
        jumpOutLabel.addElement("LABEL");
        jumpOutLabel.addElement(exitLabel);
        completeWhileTAC.add(jumpOutLabel);
        
        return completeWhileTAC;
    }
}