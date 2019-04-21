/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.Labels;
import AbstractSyntaxTree.Nodes.Operators.GreaterThanNode;
import AbstractSyntaxTree.Nodes.Operators.GreaterThanOrEqualToNode;
import AbstractSyntaxTree.Nodes.Operators.LessThanNode;
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
    public List<TACLine> generate3AC() {
        Labels label = Labels.getInstance();
        var ifLabel = label.getLabel();
        var elseLabel = label.getLabel();
        List<TACLine> completeIfTAC = new ArrayList<>();
        var tac = new TACLine();
        var stmtList = this.children.get(STATEMENT_LIST_INDEX);
        if (stmtList instanceof GreaterThanNode) {
            tac.addElement(GreaterThanNode.generate3AC() + " " + ifLabel);
        } else if (stmtList instanceof GreaterThanOrEqualToNode) {

        } else if (stmtList instanceof LessThanNode) {

        } else {

        }
        //tac.addElement("GEI");  //need type of operator in IfNode
        tac.addElement(this.children.get(CONDITION_INDEX).toString());
        // maybe this next line should call StatementListNode
        tac.addElement(this.children.get(STATEMENT_LIST_INDEX).toString());
        tac.addElement(label.getLabel());
        // how do we check if there's an else block
        if (else block){
            tac.addElement(ElseNode.generate3AC() + " " + elseLabel);
        }
        else{
            tac.addElement();  //needs logic work
        }
        completeIfTAC.add(tac);
        return completeIfTAC;
    }
}