import java.util.Arrays;

/**
 * Created by jmding on 2/5/17.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();

        // Sort the array of strings
        Arrays.sort(strs);

        // Convert the first string in the array to character array
        char[] head = strs[0].toCharArray();
        // Convert the last string in teh array to character array
        char[] tail = strs[strs.length - 1].toCharArray();

        // Iterate through the head
        for (int i = 0; i < head.length; i++) {
            // Append the character to the StringBuilder if it is in both head and tail
            if (i < tail.length && head[i] == tail[i]) {
                sb.append(head[i]);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
