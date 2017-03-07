/**
 * Created by jmding on 3/7/17.
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        // The length of s3 should equal to the sum of length s1 and s2
        // If not, return false;
        if (s3.length() != s1.length() + s2.length()){
            return false;
        }

        // Convert three strings to character arrays
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        char[] array3 = s3.toCharArray();

        // Create a 2D dynamic program array
        // The value of dp[i][j] indicates whether s1 till position i and s2 till position j so far is interleaving.
        // i+j is the position in s3
        boolean[][] dp = new boolean[array1.length+1][array2.length+1];

        // Iterate through each character in s1 and s2.
        // Note: 0 means no character, not the first character. Therefore when we use i, j in array1 and array2, we should -1
        for (int i = 0; i <= array1.length; i++){
            for (int j = 0; j <= array2.length; j++){
                // If there is no character in either s1 or s2, it is interleaving
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                } else if (i == 0){
                    // If there is no character in s1, s3 till the previous character needs to be interleaving
                    // and the current character in s2 needs to be the same as the current character in s3,
                    // in order to say s3 till at the current position is interleaving
                    dp[i][j] = dp[i][j-1] && (array2[j-1] == array3[j-1]);
                } else if (j == 0){
                    // If there is no character in s2, s3 till the previous character needs to be interleaving
                    // and the current character in s1 needs to be the same as the current character in s3
                    // in order to say s3 till the current position is interleaving
                    dp[i][j] = dp[i-1][j] && (array1[i-1] == array3[i-1]);
                } else {
                    // If both s1 and s2 has characters, this position would either come from previous character in s1 or s2
                    // If it comes from previous s1, dp[i-1][j] should be interleaving (true) and the current character in s1 should be the same as s3,
                    // Or, if it comes from previous s2, dp[i][j-1] should be interleaving (true) and the current character in s2 should be the same as s3,
                    // in order to say s3 till the current position is interleaving
                    dp[i][j] = (dp[i-1][j] && array1[i-1] == array3[i+j-1]) || (dp[i][j-1] && array2[j-1] == array3[i+j-1]);
                }
            }
        }

        // Return the result
        return dp[array1.length][array2.length];
    }
}
