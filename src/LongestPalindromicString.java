/**
 * Created by jmding on 1/26/17.
 */
public class LongestPalindromicString {
    public static String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int maxLen = -1;
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length(); i++){

            int j = i;
            int k = i;
            int m = i;
            int n = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            if (k - j - 1 > maxLen){
                maxLen = k - j - 1;
                start = j + 1;
                end = k - 1;
            }
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)){
                m--;
                n++;
            }
            if (n - m - 1 > maxLen){
                maxLen = n - m - 1;
                start = m + 1;
                end = n - 1;
            }
        }
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }
}
