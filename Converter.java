import java.util.Arrays;

public class Converter {

    public static boolean[] dec2bin(int decimal) {
        boolean[] result = new boolean[1];
        int current = decimal;
        int index = 0;

        while (current>0) {
            result = Arrays.copyOf(result, index+1); // 자릿수가 늘어날 때마다 동적으로 한 단계 긴 배열 생성
            result[index] = (current%2 != 0);
            current /= 2;
            index ++;
        }
        return result;
    }

    public static int bin2dec(boolean[] bin) {
        int sum = 0;
        for (int i=0; i<bin.length; i++) {
            sum += (bin[i])
                    ? intExponentiation(2,i) // 현재 자리수가 true이면 2의 i승을 더함.
                    : 0; // 아니면 0을 더함.
        }
        return sum;
    }

    private static int intExponentiation(int base, int exponent) {
        int result = 1;
        for (int i=0; i<exponent; i++) {
            result *= base;
        }
        return result;
    }

}
