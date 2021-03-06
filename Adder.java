import java.util.Arrays;

public class Adder {

    private static boolean getBitSum(boolean bitA, boolean bitB) {
        return LogicGate.xor(bitA, bitB);
    }

    private static boolean getBitCarryOut(boolean bitA, boolean bitB) {
        return LogicGate.and(bitA, bitB);
    }

    public static boolean[] halfAdd(boolean bitA, boolean bitB) {
        boolean carryOut = getBitCarryOut(bitA, bitB); // 자리 올림
        boolean sum = getBitSum(bitA,bitB);

        return new boolean[] {carryOut, sum};
    }

    public static boolean[] fullAdd(boolean bitA, boolean bitB, boolean carryIn) {
        boolean[] firstAddition = halfAdd(bitA, bitB); // 비트끼리의 연산
        boolean firstCarryOut = firstAddition[0];
        boolean firstSum = firstAddition[1];

        boolean[] secondAddition = halfAdd(firstSum, carryIn); // carryIn까지 연산
        boolean secondCarryOut = secondAddition[0];
        boolean secondSum = secondAddition[1];

        boolean totalCarryOut = LogicGate.or(firstCarryOut, secondCarryOut); // 최종 carryOut (자리올림)
        boolean totalSum = secondSum; // 최종 sum (합)
        return new boolean[] {totalCarryOut, totalSum};
    }

    public static boolean[] byteAdd(boolean[] byteA, boolean[] byteB) {
        if (byteA.length != byteB.length) { // 자릿수 통일
            int maxLength = Math.max(byteA.length, byteB.length);
            byteA = extendArray(byteA, maxLength);
            byteB = extendArray(byteA, maxLength);
        }
        boolean[] result = new boolean[byteA.length+1];
        boolean carry = false;
        for (int i=0; i<result.length-1; i++) {
            boolean[] fullAddition = fullAdd(byteA[i], byteB[i], carry);
            result[i] = fullAddition[1];
            carry = fullAddition[0];
        }
        result[result.length-1] = carry;
        return result;
    }

    public static boolean[] extendArray(boolean[] booleans, int length) {
        return (booleans.length == length) ? booleans : Arrays.copyOf(booleans, length);
    }
}
