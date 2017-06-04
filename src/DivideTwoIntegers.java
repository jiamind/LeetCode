/**
 * Created by jmding on 2/12/17.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        // If the divisor is 1, return the dividend itself
        if (divisor == 1) return dividend;
        // If the divisor is -1, and the dividend is min integer, the result will overflow. Return the max integer
        // Otherwise, return the negative of dividend
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        // Make dividend and divisor both negative since negative has broader range
        boolean negative = dividend < 0 != divisor < 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        return negative ? -recurDiv(dividend,divisor) : recurDiv(dividend,divisor);
    }

    public static int recurDiv(int dividend, int divisor){
        // If the dividend is the same as divisor, return 1
        if (dividend == divisor) return 1;
        // If the dividend (negative value) is greater than the divisor (negative value), the int result is 0 (actual result between 0 and 1)
        if (dividend > divisor) return 0;

        int shift = 1;
        // Shift the divisor to the left, until it is less than the dividend (note: the devisor and dividend should all be negative value)
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
