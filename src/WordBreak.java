import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jmding on 4/25/17.
 */
public class WordBreak {

    // Idea: use dynamic programming.
    // Create an array to store whether the substring before each index can be segmented using words in the dictionary
    public static boolean wordBreak(String s, List<String> wordDict) {

        // If the string is null or the string is empty, return true
        if (s == null || s.isEmpty())
            return true;

        // Convert the list into hashset for quick access
        HashSet<String> dictionary = new HashSet<>(wordDict);

        // Convert the string into character array
        char[] array = s.toCharArray();
        // Create the dynamic programming array.
        boolean[] dp = new boolean[array.length + 1];
        // Set dp[0] as true, since there is no character in the substring.
        dp[0] = true;

        // Iterate through each character in the string
        for (int i = 0; i < array.length; i++){
            // Use a second pointer to scan from the current i position to the left (start position of the string)
            for (int j = i; j >= 0; j--){
                // If the substring before the j position can be segmented using the words in the dictionary,
                // and the string between i and j is in the dictionary
                if (dp[j] && dictionary.contains(new String(array,j,i-j+1))){
                    // Then we say that the substring before i position can be segmented using the words in the dictionary
                    // Update the dp array at i+1 position to true
                    dp[i+1] = true;
                    // Break the j loop
                    break;
                }
            }
        }

        return dp[array.length];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet","code"});
        System.out.println(wordBreak(s,wordDict));
    }
}
