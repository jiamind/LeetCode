/**
 * Created by udingji on 3/29/17.
 */
public class ValidPalindrome {

    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    // For example,
    // "A man, a plan, a canal: Panama" is a palindrome.
    // "race a car" is not a palindrome.

    // Note:
    // Have you consider that the string might be empty? This is a good question to ask during an interview.
    // For the purpose of this problem, we define empty string as valid palindrome.


    // Beat 97.39% of java submissions! GJ!
    // Idea: use two pointers, one at the front, another one at the end, scan towards each other
    // Move pointer forward/backward if the current character is not alphanumeric.
    public static boolean isPalindrome(String s) {

        // If the string is null or the string is empty, return true
        if (s == null || s.isEmpty()){
            return true;
        }

        // Convert the string to character array
        char[] array = s.toCharArray();

        // Create two pointers point to the front and end of the array
        // Define the difference between a uppercase letter and a lower case letter (assuming we don't know)
        int i = 0, j = array.length-1, diff = 'a' - 'A';

        // While i,j don't go beyond each other
        // They could be equal if the palindrome length is odd
        while (i <= j){
            // Move i pointer forward if the character at i is not alphanumeric
            if (!isAlphanumeric(array[i])){
                i++;
                continue;
            }
            // Move j pointer backward if the character at j is not alphanumeric
            if (!isAlphanumeric(array[j])){
                j--;
                continue;
            }
            // If both of the two characters at i and j are alphabetic
            if (isAlphabetic(array[i]) && isAlphabetic(array[j])){
                // If they are neither equal to each other, nor one of them is uppercase and another one is lowercase of the same character
                // The string is not a palindrome. Return false
                if ((array[i] != array[j]) && (Math.abs(array[i] - array[j]) != Math.abs(diff))){
                    return false;
                }
            } else {
                // One character is numeric, another one is alphabetic
                // Or both of them are numeric
                // Anyway, if they are not equal, the string is not a palindrome. Return false
                if (array[i] != array[j]){
                    return false;
                }
            }

            // Move i and j to the next position
            i++;
            j--;
        }

        return true;
    }

    private static boolean isAlphanumeric(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private static boolean isAlphabetic(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        String s = "0P0";
        System.out.println(isPalindrome(s));
    }
}
