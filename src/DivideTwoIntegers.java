/**
 * Created by jmding on 2/12/17.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        if (dividend == divisor) return 1;

        // Make dividend and divisor both negative since negative has broader range
        boolean negative = dividend < 0 != divisor < 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        if (dividend > divisor) return 0;

        return negative ? -recurDiv(dividend,divisor) : recurDiv(dividend,divisor);
    }

    public static int recurDiv(int dividend, int divisor){
        if (dividend == divisor) return 1;
        if (dividend > divisor) return 0;

        int shift = 1;
        while ((divisor << shift) >= dividend && (divisor << shift) < 0 && shift < 31){
            shift++;
        }
        // The quotient is how many time we shifted, recursive divide the reminder
        return (1 << (shift - 1)) + recurDiv(dividend-(divisor<<shift-1), divisor);
    }

    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = 2;

        Long start = System.currentTimeMillis();
        System.out.println("Actual: " + divide(dividend,divisor));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("Expected: " + dividend/divisor);
//        System.out.printf(String.valueOf(1 << 30));
    }
}
