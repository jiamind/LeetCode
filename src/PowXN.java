/**
 * Created by udingji on 2/21/17.
 */
public class PowXN {

    //    public static double myPow(double x, int n) {
    //
    //        if (n == 0) return 1;
    //        boolean isNegative = n < 0 ? true : false;
    //        n = Math.abs(n);
    //        double result = x;
    //
    //        int count = 1;
    //
    //        while (count * 2 <= n){
    //            count *= 2;
    //            result *= result;
    //        }
    //
    //        while (count < n){
    //            result *= x;
    //            count++;
    //        }
    //
    //        return isNegative ? 1.0 / result : result;
    //    }

    public static double myPow(double x, int n) {
        // Any number to the power of 0 is 1
        if (n == 0){
            return 1;
        }
        // If n is the min integer value, -n will be out of bound
        // Instead, we increment n and treat it as an even number
        if (n == Integer.MIN_VALUE){
            n++;
            x = 1/x;
            n = -n;
            return myPow(x*x, n/2);
        }
        // If n is negative, set x = 1/x and n = -n
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        // If n is even, recursive call (x*x)^(n/2) (This is the same as x^(2* n/2))
        // If n is odd, make it even by taking one x out and multiply it later
        return n % 2 == 0? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        double x = 34.00515;
        int n = -3;
        System.out.println(myPow(x, n));
    }
}
