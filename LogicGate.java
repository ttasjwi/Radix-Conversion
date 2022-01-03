public class LogicGate {

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    public static boolean not(boolean a) {
        return !a;
    }

    public static boolean nand(boolean a, boolean b) {
        return not(and(a,b));
    }

    public static boolean nor(boolean a, boolean b) {
        return not(or(a,b));
    }

    public static boolean xor(boolean a, boolean b) {
        return a != b;
    }

    public static boolean xnor(boolean a, boolean b) {
        return not(xor(a,b));
    }

    public static boolean buffer(boolean a) {
        return a;
    }
}
