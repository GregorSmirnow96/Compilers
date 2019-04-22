/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree.Nodes;

import AbstractSyntaxTree.ParameterRegisterHandler;
import AbstractSyntaxTree.TACLine;
import java.util.ArrayList;
import java.util.List;
import littlecompiler.SymbolTableContainer;
import symboltables.enums.ESymbolAttribute;

/**
 *
 * @author im5no
 */
public class ReturnNode extends ASTNode
{
    protected final static int RETURN_EXPRESSION_INDEX = 0;
    
    private final String methodName;
    
    public ReturnNode(String methodName)
    {
        this.methodName = methodName;
    }

    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> lines = new ArrayList<>();
        
        TACLine returnRegisterStoreLine = new TACLine();
        lines.add(returnRegisterStoreLine);
        
        ASTNode node = this.children.get(RETURN_EXPRESSION_INDEX);
        if (node instanceof VariableNode)
        {
            
        }
        else
        {
            List<TACLine> tac = node.generate3AC();
            
            ESymbolAttribute type = this.getChildResultType(tac);
            if (type == ESymbolAttribute.INT)
                returnRegisterStoreLine.addElement("STOREI");
            else
                returnRegisterStoreLine.addElement("STOREF");
            
            String registerToReturn = this.getChildResultRegister(tac);
            returnRegisterStoreLine.addElement(registerToReturn);
        }
        
        returnRegisterStoreLine
            .addElement(
                ParameterRegisterHandler
                    .getInstance()
                    .getReturnRegister());
        
        return lines;
    }
}