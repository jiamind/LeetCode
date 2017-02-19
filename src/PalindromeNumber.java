/**
 * Created by udingji on 2/2/17.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // Return false if x is negative or x is greater than 10 and can be fully divided by 10
        if (x < 0 || (x >= 10 && x % 10 == 0)){
            return false;
        }
        // If x is less than 10 (but greater than or equal to 0), return true
        if (x < 10){
            return true;
        }
        // y should be the half reverse of x
        int y = 0;
        // As long as x is greater than y
        while (x > y) {
            // y times 10, plus the last digit of x
            y = y * 10 + x % 10;
            // x divided by 10
            x /= 10;
        }
        // Return base on length of x is odd, or even
        return (x * 10 + y % 10) == y || x == y;
    }

    public static void main(String[] args) {
        int x = 1234321;
        System.out.println(isPalindrome(x));
    }
}
