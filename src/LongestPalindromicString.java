/**
 * Created by jmding on 1/26/17.
 */
public class LongestPalindromicString {
    public static String longestPalindrome(String s) {
        // If the length of the string is less than 2, return the string itself
        if (s.length() < 2){
            return s;
        }
        // The max length of the palindrome string
        int maxLen = -1;
        // The start index of the palindrome string
        int start = -1;
        // The end index of the palindrome string
        int end = -1;
        // Iterate through the string
        for (int i = 0; i < s.length(); i++){

            // j,k is the start and end of the palindrome string, if the length of the palindrome string is odd
            int j = i;
            int k = i;
            // m,n is the start and end of the palindrome string, if the length of the palindrome string is even
            int m = i;
            int n = i + 1;
            // Assume the length of the palindrome string is odd
            // While two pointers are within the length of the string and two characters at the pointer positions are the same
            // Move the pointers apart from each other
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            // Update the max length if the length of the current palindrome string is greater than the max
            if (k - j - 1 > maxLen){
                maxLen = k - j - 1;
                start = j + 1;
                end = k - 1;
            }
            // Repeat the same for the even case
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
        // Return the substring
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }
}
