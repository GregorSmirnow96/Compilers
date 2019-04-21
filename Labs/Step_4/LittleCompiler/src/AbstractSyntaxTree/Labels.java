package AbstractSyntaxTree;

import java.lang.String;
/**
 * Singleton for keeping track of labels for If and While nodes.
 */
public class Labels {
    private static Labels instance;
    private int a = 0;

    static {
        instance = new Labels();
    }

    public String getLabel() {
        a++;
        return "label".concat(Integer.toString(a));
    }

    public static Labels getInstance() {
        return instance;
    }
}
