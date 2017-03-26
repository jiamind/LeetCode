/**
 * Created by udingji on 3/16/17.
 */
public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {

        // If t is an empty string, it is a subsequence of s, but only 1 way
        if (t.length() == 0)
            return 1;

        // Convert two strings into character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Create a dynamic programing 2D array to store the result (number of distinct subsequence so far at each index comparision)
        // 0 in the dp means empty string, so we need array length + 1 for the array size
        int[][] dp = new int[sArray.length+1][tArray.length+1];

        // S 0123....j
        // T +----------+
        //   |1111111111|
        // 0 |0         |
        // 1 |0         |
        // 2 |0         |
        // . |0         |
        // . |0         |
        // i |0         |
        // When t is an empty string, it is a subsequence of s, but only 1 way
        // Therefore, mark all s positions to 1 when t is at 0
        for (int i = 0; i <= sArray.length; i++){
            dp[i][0] = 1;
        }

        // When s is an empty string, there is no way t is a subsequence of s
        // Except both s and t are empty string, so dp[0][0] remains 1
        // Mark all t positions to 0 (except the 0 position)
        for (int i = 1; i <= tArray.length; i++){
            dp[0][i] = 0;
        }

        // Iterate through each s position inside each t position
        for (int j = 1; j <= tArray.length; j++){
            for (int i = 1; i <= sArray.length; i++){
                // If the current character at s and t are not the same
                // (Note: i and j are indexes in the dp, the corresponding index in the character array is i-1 and j-1)
                // The number of subsequence remains the same as comparing the same t with previous s
                //
                // If the current character at s and t are the same
                // The number of subsequence is the number when comparing the same t with previous s
                // Plus, without the current t, the number of subsequence comparing the previous s
                // (Means we combining this t with all previous possibilities with previous t and previous s)
                if (sArray[i-1] != tArray[j-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }

        return dp[sArray.length][tArray.length];
    }
}
