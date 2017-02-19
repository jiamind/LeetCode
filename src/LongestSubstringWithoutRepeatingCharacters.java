/**
 * Created by jmding on 1/24/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        // If string is null or string length is 0, return 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Create i to store the start index, j to store the end index (also the moving pointer), max to store the max length
        int i = 0, j = 0, max = -1;

        // Create a StringBuilder to store the non-repeating string
        StringBuilder sb = new StringBuilder();
        // While j is less than the length of the string
        while (j < s.length()) {
            // Get the index of the current character at j in the StringBuilder
            int index = sb.indexOf(Character.toString(s.charAt(j)));
            // If this character is in the StringBuilder
            if (index >= 0) {
                // Remove everything before that character, including the character itself
                sb.delete(0, index + 1);
                // Move pointer i to the new start of the non-repeating string
                i += (index + 1);
            }
            // Append this character to the StringBuilder
            sb.append(s.charAt(j));
            // Update the max value if the new length of the string is greater than the current max
            if (j - i + 1 > max) {
                max = j - i + 1;
            }
            // Move j pointer forward
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int r = lengthOfLongestSubstring("pwwkew");
        System.out.println(Integer.toString(r));
    }
}
