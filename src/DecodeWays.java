/**
 * Created by udingji on 5/11/17.
 */
public class DecodeWays {

    // Idea: Use dynamic programming.
    // Create a dp array. dp[0] means number of ways to decode when there is no string. dp[n] means number of ways to decode at n-1 index in the string
    // Iterate through each character in the array, we evaluate the number of ways to decode at this index by treating this character as a single digit,
    // as well as combining the previous character to treat it as a two-digit number. Update the dp accordingly
    public static int numDecodings(String s) {

        if (s == null || s.isEmpty())
            return 0;

        char[] array = s.toCharArray();

        int[] dp = new int[array.length+1];
        dp[0] = 1;
        dp[1] = array[0] == '0' ? 0 : 1;

        for (int i = 2; i < array.length + 1; i++){
            int oneDigit = Integer.valueOf(new String(array,i-1,1));
            int twoDigits = Integer.valueOf(new String(array,i-2,2));
            if (oneDigit >= 1 && oneDigit <= 9){
                dp[i] += dp[i-1];
            }
            if (twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[array.length];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }
}
