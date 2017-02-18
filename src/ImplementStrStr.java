/**
 * Created by jmding on 2/12/17.
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;

//        if (haystack.isEmpty() && needle.isEmpty()) return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if (haystack.substring(i,i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "ac";
        String needle = "ab";
        System.out.println(strStr(haystack,needle));
    }
}
