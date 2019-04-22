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

/**
 *
 * @author im5no
 */
public class ParameterListNode extends ASTNode
{
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> parameterStoringCode = new ArrayList<>();
        
        this.children.forEach(child ->
        {
            TACLine line = new TACLine();
            parameterStoringCode.add(line);
            line.addElement("STORE");
            if (child instanceof IntLiteralNode)
            {
                Integer value = ((IntLiteralNode) child).getLiteralValue();
                line.addElement(value.toString());
            }
            else if (child instanceof FloatLiteralNode)
            {
                Float value = ((FloatLiteralNode) child).getLiteralValue();
                line.addElement(value.toString());
            }
            line.addElement(
                ParameterRegisterHandler
                    .getInstance()
                    .getNextRegister());
        });
        ParameterRegisterHandler.getInstance().resetParameterIndex();
        
        return parameterStoringCode;
    }
}