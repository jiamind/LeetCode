/**
 * Created by jmding on 3/4/17.
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {

        // Get the length of word1
        int len1 = word1.length();
        // Get the length of word2
        int len2 = word2.length();
        // Convert two strings into character arrays
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        // Create a 2-D dynamic programming matrix to store the min edit distance compared at each character in word1 and word2
        int[][] dp = new int[len1+1][len2+1];

        // Initialize the array. When word2 has no characters,
        // all we will do for any length of word2 is deleting that many times of characters in word1
        for (int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        // When word2 has no characters, all we will do for any length of word1 is adding that many times of characters in word2
        for (int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }

        // Iterate through each character in word1 and word2, starting from the first character
        // (Here, i and j represents the position in the dp array.)
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++){
                // If the two characters in word1 and word2 is the same
                if (array1[i-1] == array2[j-1]){
                    // We don't need to edit. The min edit distance is the same as the previous comparison.
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // Otherwise, we could either replace (same as previous one, dp[i-1,j-1]),
                    // delete (move i backward since we are deleting on word1 dp[i-1,j]),
                    // or add (move j forward since we are adding on word2 dp[i,j+1])
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
