/**
 * Created by jmding on 4/23/17.
 */
public class PalindromePartitioningII {

    // Idea: for each character in the string, treat it as the center of a palindrome string (consider both odd and even length)
    // Try expand its length until it reaches either the edge of the string
    // If the substring is a palindrome string, the minimum number of cuts at the end of the substring is the minimum cuts at the beginning of the substring plus 1
    public static int minCut(String s) {

        // Convert the string into character array
        char[] array = s.toCharArray();
        // Create an array to store the min cut at each character (cut point is after each character)
        int[] minCut = new int[array.length + 1];

        // Initialize the array. The min cut at character index i is i - 1
        for (int i = 0; i <= array.length; i++)
            minCut[i] = i - 1;

        // Iterate through each character in the string
        for (int i = 0; i < array.length; i++){
            // Consider that the length of the palindrome substring is odd
            // Use another pointer j to expand the substring in opposite direction. j is moving away to the left of i
            // Update the min cut while j reaches neither the beginning nor the end of the original string
            for (int j = 0; i - j >= 0 && i + j < array.length && array[i-j] == array[i+j]; j++){
                minCut[i+j+1] = Math.min(minCut[i+j+1], minCut[i-j] + 1);
            }

            // Consider that the length of the palindrome substring is even
            for (int j = 1; i - j + 1 >= 0 && i + j < array.length && array[i-j+1] == array[i+j]; j++){
                minCut[i+j+1] = Math.min(minCut[i+j+1], minCut[i-j+1] + 1);
            }
        }

        return minCut[array.length];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
