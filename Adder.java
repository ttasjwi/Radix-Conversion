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
