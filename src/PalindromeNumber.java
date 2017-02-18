package test;

/**
 * Created by udingji on 2/2/17.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)){
            return false;
        }
        if (x < 10){
            return true;
        }
        int y = 0;
        while (x > y){
            y = y * 10 + x % 10;
            x /= 10;
        }
        return (x * 10 + y % 10) == y || x == y;
    }

    public static void main(String[] args) {
        int x = 1234321;
        System.out.println(isPalindrome(x));
    }
}
