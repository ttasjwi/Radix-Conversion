import java.util.Arrays;

public class Adder {

    private static boolean getBitSum(boolean bitA, boolean bitB) {
        return LogicGate.xor(bitA, bitB);
    }

    private static boolean getBitCarryOut(boolean bitA, boolean bitB) {
        return LogicGate.and(bitA, bitB);
    }

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

    public static boolean[] byteAdd(boolean[] byteA, boolean[] byteB) {
        if (byteA.length != byteB.length) { // 바이트 자릿수 통일
            int maxLength = Math.max(byteA.length, byteB.length);
            byteA = Arrays.copyOf(byteA, maxLength);
            byteB = Arrays.copyOf(byteB, maxLength);
        }
        boolean[] result = new boolean[byteA.length];
        boolean carry = false;
        for (int i=0; i<result.length; i++) {
            boolean[] fullAddition = fullAdd(byteA[i], byteB[i], carry);
            result[i] = fullAddition[1];
            carry = fullAddition[0];
        }
        if (carry) { // 마지막 자리수에서 올림이 발생했을 때
            result = Arrays.copyOf(result,result.length+1); // 한 자리 큰 배열 생성
            result[result.length] = true;
        }
        return result;
    }
}
