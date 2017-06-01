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

    // Idea: use rolling hash
    public static int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        if (needle.length() == 0)
            return 0;

        if (haystack.length() < needle.length())
            return -1;

        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();

        int currentHHash = 0, nHash = 0;
        for (int i = 0; i < nArray.length; i++){
            currentHHash += new Character(hArray[i]).hashCode();
        }
        for (int i = 0; i < nArray.length; i++){
            nHash += new Character(nArray[i]).hashCode();
        }

        if (currentHHash == nHash){
            if (containsSubstring(hArray,nArray,0))
                return 0;
        }

        for (int i = 0; i < hArray.length - nArray.length; i++){
            currentHHash -= new Character(hArray[i]).hashCode();
            currentHHash += new Character(hArray[i + nArray.length]).hashCode();

            if (currentHHash == nHash){
                if (containsSubstring(hArray,nArray,i+1)){
                    return i + 1;
                }
            }
        }

        return -1;
    }


    private static boolean containsSubstring(char[] haystack, char[] needle, int index) {
        int i = index, j = 0;
        while (i < haystack.length && j < needle.length){
            if (haystack[i] != needle[j])
                return false;
            i++;
            j++;
        }
        return j == needle.length;
    }

    public static void main(String[] args) {
        String haystack = "aceabd";
        String needle = "ab";
        System.out.println(strStr2(haystack,needle));
    }
}
