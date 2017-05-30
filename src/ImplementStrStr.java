/**
 * Created by jmding on 2/12/17.
 */
public class ImplementStrStr {

    // Implement strStr().
    // Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    // Idea: use two pointers i and j, i is the offset in haystack string, j is the index in needle string.
    // i + j is the index in haystack string
    // While incrementing i (offset), compare character at each j index in the needle string with i + j index in the haystack string
    // If we find a mismatch, break the current j loop and continue with the next i offset
    public static int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for (int i = 0; ; i++){
            for (int j = 0; ; j++){
                if (j == n.length)
                    return i;
                if (i + j >= h.length)
                    return -1;
                if (h[i+j] != n[j])
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String haystack = "ac";
        String needle = "ab";
        System.out.println(strStr(haystack,needle));
    }
}
