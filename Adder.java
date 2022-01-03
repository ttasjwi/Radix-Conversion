public class Adder {

    public static boolean[] halfAdd(boolean a, boolean b) {
        boolean[] result = new boolean[2];

        boolean carry = LogicGate.and(a,b); // carry (자리올림)
        boolean sum = LogicGate.xor(a,b); // sum (합)

        result[0] = carry;
        result[1] = sum;

        return result;
    }
}
