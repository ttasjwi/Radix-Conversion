public class Adder {

    public static boolean[] halfAdd(boolean a, boolean b) {
        boolean[] result = new boolean[2];

        boolean carry = LogicGate.and(a,b); // carry (자리올림)
        boolean sum = LogicGate.xor(a,b); // sum (합)

        result[0] = carry;
        result[1] = sum;

        return result;
    }

    public static boolean[] fullAdd(boolean bitA, boolean bitB, boolean carryIn) {
        boolean[] bitAddition = halfAdd(bitA, bitB);
        boolean[] carryInAddition = halfAdd(bitAddition[1], carryIn);

        boolean totalCarryOut = LogicGate.or(bitAddition[0], carryInAddition[0]); // carry(자리 올림)
        boolean totalSum = carryInAddition[1]; // sum (합)

        boolean[] result = new boolean[2];
        result[0] = totalCarryOut;
        result[1] = totalSum;
        return result;
    }
}
