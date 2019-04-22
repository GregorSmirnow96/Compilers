/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

/**
 *
 * @author im5no
 */
public class ParameterRegisterHandler
{
    private static final int RETURN_VALUE_REGISTER_INDEX = 900;
    private static final int FIRST_PARAMETER_REGISTER_INDEX = 901;
    
    private static ParameterRegisterHandler instance;
    private int nextIndex;
    
    public static ParameterRegisterHandler getInstance()
    {
        return instance == null
            ? instance = new ParameterRegisterHandler()
            : instance;
    }
    
    private ParameterRegisterHandler()
    {
        this.nextIndex = FIRST_PARAMETER_REGISTER_INDEX;
    }
    
    public String getNextRegister()
    {
        return String.format(
            "$T%d",
            nextIndex++);
    }
    
    public void resetParameterIndex()
    {
        this.nextIndex = FIRST_PARAMETER_REGISTER_INDEX;
    }
    
    public String getReturnRegister()
    {
        return "$T" + RETURN_VALUE_REGISTER_INDEX;
    }
}