/**
 * Created by udingji on 3/2/17.
 */
public class Sqrtx {


    public static int mySqrt(int x) {

        // If x is 0, return 0; If x is 1, return 1
        // Prevent divided by 0 error later
        // (Alternatively without these, we can set right to Integer.Max_value)
        if (x == 0) return 0;
        if (x == 1) return 1;
        // The lower bound is 0, upper bound is x since the square root of x won't exceed x
        int left = 0, right = x;

        // While two pointers don't meet
        while (right > left){
            // Find the mid number. Pay attention to prevent from over-floating
            // Attention: mid can be lower than actual number since it's integer type.
            // We can't set left = mid if we want to bring up the lower bar
            int mid = left + (right - left) / 2;
            // If x is greater than the square of mid, means left is too smaller
            // Otherwise, lower right to mid
            if (mid < x/mid){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // Since left = mid + 1, left can be higher than actual number or equal if x is a perfect square
        return left > x/left ? left - 1 : left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}
