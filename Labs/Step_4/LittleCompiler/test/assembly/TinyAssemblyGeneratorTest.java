package AbstractSyntaxTree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TinyAssemblyGeneratorTest {

    ArrayList<TACLine> TACCode;

    private ArrayList<String> getStringArrayFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();

        Scanner in = null;
        try {
            in = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (in.hasNext())
        {
            list.add(in.nextLine());
        }

        return list;
    }

    private ArrayList<TACLine> convertStringArrayToTACList(ArrayList<String> input) {
        ArrayList<TACLine> list = new ArrayList<>();

        for (String s: input) {
            String[] words = s.split("\\s");

            TACLine t = new TACLine();

            for (String w: words) {
                t.addElement(w);
            }

            list.add(t);
        }

        return list;
    }

    @BeforeEach
    void initialize() {

    }

    @AfterEach
    void deInitialize() {
        System.out.println();
    }

    @Test
    void test_combination() {
        System.out.println("test_combination");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_combination_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_combination_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));
            assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
        }
    }

    @Test
    void testcase() {
        System.out.println("testcase");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("testcase_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("testcase_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void testcase2() {
        System.out.println("testcase2");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("testcase2_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("testcase2_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void test_adv() {
        System.out.println("test_adv");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_adv_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_adv_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void test_expr() {
        System.out.println("test_expr");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_expr_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_expr_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void test_if() {
        System.out.println("test_if");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_if_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_if_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void test_multi() {
        System.out.println("test_multi");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_multi_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_multi_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    @Test
    void test_while() {
        System.out.println("test_while");

        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        ArrayList<String> inputList = getStringArrayFromFile("test_while_input.txt");
        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        ArrayList<String> outputArray = getStringArrayFromFile("test_while_output.txt");

        assertEquals(outputArray.size(), assemblyCode.size());

        for(int i = 0; i < outputArray.size() && i < assemblyCode.size(); i++) {
            System.out.println(assemblyCode.get(i) + " : " + outputArray.get(i));

            if (assemblyCode.get(i).startsWith("var") || outputArray.get(i).startsWith("var")) {
                assertTrue(assemblyCode.get(i).startsWith("var") && outputArray.get(i).startsWith("var"));
            }

            else
            {
                assertTrue(outputArray.get(i).equals(assemblyCode.get(i)));
            }
        }
    }

    void assembleTest1() {
        TACCode = new ArrayList<>();
        TinyAssemblyGenerator gen = new TinyAssemblyGenerator();
        ArrayList<String> assemblyCode;

        String input[] = {
                "STOREI 20 $T1",
                "STOREI $T1 a",
                "STOREI 30 $T2",
                "STOREI $T2 b",
                "STOREI 40 $T3",
                "STOREI $T3 c",
                "MULTI a b $T4",
                "MULTI a b $T5",
                "ADDI $T5 c $T6"
        };

        ArrayList<String> inputList = new ArrayList<>();

        for (String s: input) {
            inputList.add(s);
        }

        ArrayList<TACLine> TACCode = convertStringArrayToTACList(inputList);

        assemblyCode = gen.assemble(TACCode);

        for(String line: assemblyCode) {
            //System.out.println(line);

        }
    }

}