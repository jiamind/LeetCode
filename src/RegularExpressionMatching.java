/**
 * Created by udingji on 2/2/17.
 */
public class RegularExpressionMatching {


    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        // Create 2D dynamic programming array
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        // Starting position is true, since there is no character and no pattern
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++){
            dp[0][i+1] = p.charAt(i) == '*' && dp[0][i-1];
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                // If the pattern is '.' or the character matches the pattern
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    // Mark it the same as the previous position
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    // If the previous pattern is not '.' and the character before '*' does not match with the character
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        // Whether the character matches with the previous pattern
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s,p));

    }
}
