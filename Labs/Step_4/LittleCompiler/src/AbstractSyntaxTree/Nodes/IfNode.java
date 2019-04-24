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
public class IfNode extends ASTNode
{
    protected final static int CONDITION_INDEX = 0;
    protected final static int STATEMENT_LIST_INDEX = 1;
    protected final static int ELSE_NODE_INDEX = 2;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeIfTAC = new ArrayList<>();
        
        /* Add jump line */
        Labels label = Labels.getInstance();
        String elseLabel = label.getLabel();
        List<TACLine> conditionCode = this.children
            .get(CONDITION_INDEX)
            .generate3AC();
        conditionCode.get(conditionCode.size() - 1).addElement(elseLabel);
        completeIfTAC.addAll(conditionCode);
        
        /* Add statement list */
        ASTNode statementListNode = this.children.get(STATEMENT_LIST_INDEX);
        completeIfTAC.addAll(statementListNode.generate3AC());
        
        /* Add jump-out to end of statement list */
        TACLine jumpOutLine = new TACLine();
        jumpOutLine.addElement("JUMP");
        String outLabel = label.getLabel();
        jumpOutLine.addElement(outLabel);
        completeIfTAC.add(jumpOutLine);
        
        /* Add else block */
        TACLine elseLabelLine = new TACLine();
        elseLabelLine.addElement("LABEL");
        elseLabelLine.addElement(elseLabel);
        completeIfTAC.add(elseLabelLine);
        
        if (this.children.size() > 2)
        {
            ASTNode elseNode = this.children.get(ELSE_NODE_INDEX);
            completeIfTAC.addAll(elseNode.generate3AC());
        }
        
        /* Add jump-out label */
        TACLine jumpOutLabel = new TACLine();
        jumpOutLabel.addElement("LABEL");
        jumpOutLabel.addElement(outLabel);
        completeIfTAC.add(jumpOutLabel);
        
        
        System.out.println("----------------------");
        completeIfTAC.forEach(line -> System.out.println(line.getLineText()));
        return completeIfTAC;
    }
}