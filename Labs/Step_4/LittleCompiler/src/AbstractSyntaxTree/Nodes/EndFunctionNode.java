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
public class EndFunctionNode extends ASTNode
{
    @Override
    public List<TACLine> generate3AC()
    {
        List<TACLine> code = new ArrayList<>();
        
        TACLine linkLine = new TACLine();
        linkLine.addElement("RET");
        code.add(linkLine);
        
        return code;
    }
}