/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes.Operators;

import AbstractSyntaxTree.Nodes.ASTNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import AbstractSyntaxTree.TACLine;
import org.antlr.v4.tool.LeftRecursionCyclesMessage;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author im5no
 */
public class PlusNode extends ASTNode
{
    protected final static int LEFT_OPERAND_INDEX = 0;
    protected final static int RIGHT_OPERAND_INDEX = 1;

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> completeAddTAC = new ArrayList<>();
        var tac = new TACLine();
        var left = this.children.get(LEFT_OPERAND_INDEX);
        var right = this.children.get(RIGHT_OPERAND_INDEX);
        if (left instanceof IntLiteralNode || right instanceof IntLiteralNode){
            tac.addElement("ADDI");
        }
        else {
            tac.addElement("ADDF");
        }

        tac.addElement(left.toString());
        tac.addElement(right.toString());
        completeAddTAC.add(tac);
        return completeAddTAC;
    }
}