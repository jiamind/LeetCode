/**
 * Created by jmding on 1/30/17.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int result = 0;
        boolean xIsNegative = false;
        if (x < 0) {
            x = 0 - x;
            xIsNegative = true;
        }
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < result){
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
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
