/**
 * Created by jmding on 1/30/17.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        // If x is the min value of integer, we know the reverse of it is 0 because it is out of bound
        if (x == Integer.MIN_VALUE) return 0;
        // Initiate the result as 0
        int result = 0;
        // Check if x is a negative value
        boolean xIsNegative = false;
        if (x < 0) {
            x = 0 - x;
            xIsNegative = true;
        }
        // While x is greater than 0
        while (x > 0) {
            // Be careful that the reversed integer could be greater than the max integer
            // If the max value of integer minus the last digit of x, then divided by 10 is still less than the result so far,
            // return 0 since it is out of bound
            if ((Integer.MAX_VALUE - x % 10) / 10 < result){
                return 0;
            }
            // 10 times the existing result value, plus the last digit of x
            // x divided by 10
            result = result * 10 + x % 10;
            x /= 10;
        }
        // If x is negative, the result should also be negative
        if (xIsNegative) result = 0 - result;
        return result;
    }

    public static void main(String[] args) {
        int x = -2147483647;
        int r = reverse(x);
        System.out.println(r);
//        x = 0 - x;
//        System.out.println(x);
    }
}
