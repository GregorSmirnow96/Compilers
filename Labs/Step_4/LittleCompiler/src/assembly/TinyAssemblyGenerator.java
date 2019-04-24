package AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.Hashtable;

public class TinyAssemblyGenerator {
    private int registerCounter;
    private Hashtable<String, String> variableTable;
    private ArrayList<String> variableDeclarations;
    private ArrayList<String> assemblyCode;
    private boolean jumpGenerated;
    private boolean newlineUsed;
    private ArrayList<String> freeRegisters;

    public TinyAssemblyGenerator() {
        registerCounter = 0;
        variableTable = new Hashtable<>();
        assemblyCode = new ArrayList<>();
        variableDeclarations = new ArrayList<>();
        jumpGenerated = false;
        newlineUsed = false;
        freeRegisters = new ArrayList<>();
    }

    /**
     *  must be called before generating new Tiny code from a new Basic Block
     */
    public void reset() {
        registerCounter = 0;
        variableTable = new Hashtable<>();
        assemblyCode = new ArrayList<>();
        variableDeclarations = new ArrayList<>();
        jumpGenerated = false;
        newlineUsed = false;
        freeRegisters = new ArrayList<>();
    }

    /**
     *  generate Tiny code from the TAC
     * @param tacList the TAC from which to generate Tiny code
     * @return the ArrayList of Strings representing the generated Tiny code
     */
    public ArrayList<String> assemble(ArrayList<TACLine> tacList) {
        for (TACLine tacLine: tacList) {
            ArrayList<String> newCode;

            // switch based on the TAC instruction type
            switch (tacLine.getElements().get(0)) {
                case "STOREI":
                case "STOREF":
                    newCode = generateSTORE(tacLine);
                    break;

                case "MULTI":
                case "MULTF":
                case "ADDI":
                case "ADDF":
                case "SUBI":
                case "SUBF":
                case "DIVI":
                case "DIVF":
                    newCode = generateAddSubMultDiv(tacLine);
                    break;

                case "WRITEI":
                case "WRITEF":
                case "WRITES":
                    newCode = generateWRITE(tacLine);
                    break;

                case "RET":
                    newCode = generateRET(tacLine);
                    break;

                case "LABEL":
                    newCode = generateLABEL(tacLine);
                    break;

                case "LEI":
                case "LEF":
                case "EQI":
                case "EQF":
                case "NEI":
                case "NEF":
                case "LTI":
                case "LTF":
                case "GTI":
                case "GTF":
                case "GEI":
                case "GEF":
                    newCode = generateConditionalBranch(tacLine);
                    break;

                case "READI":
                case "READF":
                    newCode = generateREAD(tacLine);
                    break;

                case "JUMP":
                    newCode = generateJUMP(tacLine);
                    break;

                // this should only be entered if an invalid TAC instruction is encountered
                // in the case of an invalid TAC instruction, do not produce any Tiny code
                // ###
                // Note: maybe this should be changed? Maybe we should throw an error?
                // ##

                default:
                    newCode = new ArrayList<>();
            }

            assemblyCode.addAll(newCode);
        }

        // handles the way that the given test code only declares 'str newline' when the newline is actually used
        if (newlineUsed) {
            assemblyCode.add(0, "str newline \"\\n\"");
        }

        // handles the stipulation that all variable declarations must appear at the beginning of the tiny code,
        // as opposed to when they are first needed
        for (int i = variableDeclarations.size() - 1; i >= 0; i--) {
            assemblyCode.add(0, variableDeclarations.get(i));
        }

        // handles the way that the given test code only generates 'label' statements if the Tiny code contains a jump
        // statement
        if (!jumpGenerated) {
            ArrayList<String> toRemove = new ArrayList<>();
            for (String s: assemblyCode) {
                if (s.startsWith("label ")) {
                    toRemove.add(s);
                }
            }

            // remove label statements if there isn't a jump statement in the tiny code
            for (String s: toRemove) {
                assemblyCode.remove(s);
            }
        }

        return assemblyCode;
    }

    /**
     *  gets the next free register
     *
     *  note: in accordance to the given test code, a register is only considered free if it has not been assigned yet,
     *  or if it has only been assigned temporarily in a Store instruction in which both arguments are variables
     *  (neither argument is already in a register)
     *
     *  this seems like a random arbitrary rule, but I implemented it this way to match the test code
     *
     * @return the string representation of the next available register
     */
    private String getNextFreeRegister() {
        if (!freeRegisters.isEmpty()) {
            return freeRegisters.remove(0);
        }

        String r = "r" + registerCounter++;
        freeRegisters.add(r);
        return r;
    }

    /**
     * @return the lowest unassigned register number
     */
    private String getNextRegister() {
        return "r" + registerCounter++;
    }

    /**
     * @param tacName   the TAC variable name
     * @return the tiny variable name or register name associated with tacName
     */
    private String getVarNameFromVariableTable(String tacName) {
        if (!variableTable.containsKey(tacName))
        {
            // assign register
            if (tacName.startsWith("$")) {
                variableTable.put(tacName, "r" + registerCounter++);
            }

            // the var name is not a register, and not 'newLine'
            else if (!tacName.equals("newline"))
            {
                variableTable.put(tacName, tacName);
                String varInitialization = "var " + variableTable.get(tacName);
                variableDeclarations.add(varInitialization);
            }

            // the var name is specifically 'newLine'
            else
            {
                newlineUsed = true;
                return "newline";
            }
        }

        return variableTable.get(tacName);
    }

    /**
     * STORE I/F
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateSTORE(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        ArrayList<String> tac = tacLine.getElements();

        String arg1 = tac.get(1);
        String arg2 = tac.get(2);

        // we need to address the special scenario in which we declare this temporary register 'free'
        if (!arg1.startsWith("$") && !arg2.startsWith("$"))
        {
            String arg3 = getNextFreeRegister();

            String line = "move " + arg1 + " " + arg3;
            code.add(line);
            line = "move " + arg3 + " " + arg2;
            code.add(line);

            return code;
        }

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
     * WRITE S/F/I
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateWRITE(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        ArrayList<String> tac = tacLine.getElements();

        String arg0 = tac.get(0);
        String arg1 = tac.get(1);

        arg1 = getVarNameFromVariableTable(arg1);

        String operator = "";

        switch (arg0) {
            case "WRITES":
                operator = "writes ";
                break;

            case "WRITEF":
                operator = "writer ";
                break;

            case "WRITEI":
                operator = "writei ";
                break;
        }

        String line = "sys " + operator + arg1;
        code.add(line);

        return code;
    }

    /**
     * RET
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateRET(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        String line = "sys halt";
        code.add(line);

        return code;
    }

    /**
     * LABEL
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateLABEL(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        String arg1 = tacLine.getElements().get(1);

        String line = "label " + arg1;
        code.add(line);

        return code;
    }

    /**
     * JUMP
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateJUMP(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        jumpGenerated = true;

        String arg1 = tacLine.getElements().get(1);

        String line = "jmp " + arg1;
        code.add(line);

        return code;
    }

    /**
     * Conditional Branch: LE EQ GT NE GE LT
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateConditionalBranch(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        jumpGenerated = true;

        ArrayList<String> tac = tacLine.getElements();

        String arg0 = tac.get(0);
        String arg1 = tac.get(1);
        String arg2 = tac.get(2);
        String arg3 = tac.get(3);

        if (!arg1.startsWith("$") && !arg2.startsWith("$"))
        {
            String temp = getNextRegister();
            String line = "move " + arg2 + " " + temp;
            arg2 = temp;
            code.add(line);

            arg1 = getVarNameFromVariableTable(arg1);
        }

        else
        {
            arg1 = getVarNameFromVariableTable(arg1);
            arg2 = getVarNameFromVariableTable(arg2);
        }

        String operator = "";

        switch (arg0.charAt(2)) {
            case 'I':
                operator = "cmpi ";
                break;

            case 'F':
                operator = "cmpr ";
                break;
        }

        String line = operator + arg1 + " " + arg2;
        code.add(line);

        String operator2 = "";

        switch (arg0.substring(0,2)) {
            case "LE":
                operator2 = "jle ";
                break;

            case "EQ":
                operator2 = "jeq ";
                break;

            case "NE":
                operator2 = "jne ";
                break;

            case "GT":
                operator2 = "jgt ";
                break;

            case "GE":
                operator2 = "jge ";
                break;

            case "LT":
                operator2 = "jlt ";
                break;
        }

        String line2 = operator2 + arg3;
        code.add(line2);

        return code;
    }

    /**
     * READ
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateREAD(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        ArrayList<String> tac = tacLine.getElements();

        String arg0 = tac.get(0);
        String arg1 = tac.get(1);

        arg1 = getVarNameFromVariableTable(arg1);

        String operator = "";

        switch (arg0) {
            case "READI":
                operator = "readi ";
                break;

            case "READF":
                operator = "readr ";
                break;

            case "READS":
                operator = "reads ";
                break;
        }
        String line = "sys " + operator + arg1;
        code.add(line);

        return code;
    }

    /**
     * ADD/MUL/DIV/SUB
     *
     * @param tacLine
     * @return
     */
    private ArrayList<String> generateAddSubMultDiv(TACLine tacLine) {
        ArrayList<String> code =  new ArrayList<>();

        ArrayList<String> tac = tacLine.getElements();

        String arg0 = tac.get(0);
        String arg1 = tac.get(1);
        String arg2 = tac.get(2);
        String arg3 = tac.get(3);

        arg1 = getVarNameFromVariableTable(arg1);
        arg2 = getVarNameFromVariableTable(arg2);
        arg3 = getVarNameFromVariableTable(arg3);

        String line = "move " + arg1 + " " + arg3;
        code.add(line);

        String operator = "";

        switch (arg0) {
            case "MULTI":
                operator = "muli ";
                break;

            case "MULTF":
                operator = "mulr ";
                break;

            case "ADDI":
                operator = "addi ";
                break;

            case "ADDF":
                operator = "addr ";
                break;

            case "SUBI":
                operator = "subi ";
                break;

            case "SUBF":
                operator = "subr ";
                break;

            case "DIVI":
                operator = "divi ";
                break;

            case "DIVF":
                operator = "divr ";
                break;
        }

        String line2 = operator + arg2 + " " + arg3;
        code.add(line2);

        return code;
    }
}


