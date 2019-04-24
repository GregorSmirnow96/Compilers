package AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.Hashtable;

public class TinyAssemblyGenerator {
    private int registerCounter;
    private Hashtable<String, String> variableTable;
    private ArrayList<String> assemblyCode;

    public TinyAssemblyGenerator() {
        registerCounter = 0;
        variableTable = new Hashtable<>();
        assemblyCode = new ArrayList<>();
    }

    public ArrayList<String> assemble(ArrayList<TACLine> tacList) {
        for (TACLine tacLine: tacList) {
            ArrayList<String> newCode;
            switch (tacLine.getElements().get(0)) {
                case "STOREI":
                    newCode = generateSTOREI(tacLine);
                    break;

                default:
                    newCode = new ArrayList<>();
            }

            assemblyCode.addAll(newCode);
        }

        return assemblyCode;
    }

    private String getVarNameFromVariableTable(String tacName) {
        if (!variableTable.containsKey(tacName))
        {
            if (tacName.startsWith("$")) {
                variableTable.put(tacName, "r" + registerCounter++);
            }

            else
            {
                variableTable.put(tacName, tacName);
                String varInitialization = "var " + variableTable.get(tacName);
                assemblyCode.add(0, varInitialization);
            }
        }

        return variableTable.get(tacName);
    }


    /**
     * STOREI
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateSTOREI(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        ArrayList<String> tac = tacLine.getElements();

        String arg1 = tac.get(1);
        String arg2 = tac.get(2);

        if (!Character.isDigit(arg1.toCharArray()[0])) {
            arg1 = getVarNameFromVariableTable(arg1);
        }

        if (!Character.isDigit(arg2.toCharArray()[0])) {
            arg2 = getVarNameFromVariableTable(arg2);
        }

        String line = "move " + arg1 + " " + arg2;
        code.add(line);

        return code;
    }

    /**
     * MULTI
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateMULTI(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();



        return code;
    }

    /**
     * ADDI
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateADDI(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();



        return code;
    }

    /**
     * DIVI
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateDIVI(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();



        return code;
    }

    /**
     * WRITEI
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateWRITEI(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();



        return code;
    }
}


