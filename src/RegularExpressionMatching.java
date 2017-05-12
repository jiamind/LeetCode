/**
 * Created by udingji on 2/2/17.
 */
public class RegularExpressionMatching {


    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        // Create 2D dynamic programming array
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        // Starting position is true, since there is no character and no pattern
        dp[0][0] = true;
        // Initialize the p column when s is empty
        // Consider '*' as 0 occurrence
        for (int i = 0; i < pArray.length; i++){
            dp[0][i+1] = pArray[i] == '*' && dp[0][i-1];
        }
        for (int i = 0; i < sArray.length; i++){
            for (int j = 0; j < pArray.length; j++){
                // If the pattern is '.' or the character matches the pattern
                if (pArray[j] == '.' || pArray[j] == s.charAt(i)) {
                    // Mark it the same as the previous position
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pArray[j] == '*') {
                    // If the previous pattern is not '.' and the character before '*' does not match with the character
                    if (pArray[j-1] != sArray[i] && pArray[j-1] != '.') {
                        // We consider this '*' means 0 occurrence. Then dp[i+1][j+1] is determined by two characters before '*'
                        // Whether the character matches with the previous pattern
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        // We can either think character at j-1 is equal to character at i
                        // Or the character at j-1 is '.' (could be any character, ignore current i)
                        // Or this '*' means 0 occurrence
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[sArray.length][pArray.length];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s,p));

    }
}
