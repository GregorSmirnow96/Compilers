package AbstractSyntaxTree;

import java.util.LinkedHashMap;

/**
 * Singleton for keeping track of temporary register numbers
 */
public class TempararyRegisters {
    private static final TempararyRegisters instance;
    private int a = 0;
    private LinkedHashMap<String, String> lHM = new LinkedHashMap<>();

    static {
        instance = new TempararyRegisters();
    }

    public String getTempReg(String key) {
        a++;
        String value = "$T".concat(Integer.toString(a));
        lHM.put(key, value);
        return value;
    }

    public String getTempReg() {
        a++;
        String value = "$T".concat(Integer.toString(a));
        return value;
    }

    public String checkTempReg(String varName) {
        if (lHM.containsKey(varName)) {
            return lHM.get(varName);
        }
        return getTempReg(varName);
    }
    
    

    public static TempararyRegisters getInstance() { return instance; }
}