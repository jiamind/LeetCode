/**
 * Created by jmding on 2/12/17.
 */
public class ImplementStrStr {

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
