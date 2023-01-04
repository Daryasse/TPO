package listeners;
import java.util.*;
import java.util.logging.Logger;

public abstract class ListenerBase {
    protected static Logger logger;
    private static List list = new ArrayList();

    static {
        logger=Logger.getLogger(RequestListener.class.getName());
    }
    public static void add(String s) {
        list.add(s);
    }

    public static List get() { return list; }
}