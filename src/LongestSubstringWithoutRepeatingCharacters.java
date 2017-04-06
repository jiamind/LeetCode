import java.util.HashMap;

/**
 * Created by jmding on 1/24/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // Idea: Use a hashmap to store each character and its index. Use two pointers point to the start and end of the longest substring
    // Iterate through each character in the string. If we find a character which already in the hashmap, we update the start pointer to the right of the current character
    // Update the max length using the distance between the start and end pointer
    public static int lengthOfLongestSubstring(String s) {
        // If string is null or string length is 0, return 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Create i to store the start index, j to store the end index (also the moving pointer), max to store the max length
        int i = 0, j = 0, max = -1;
        // Convert the string to character array
        char[] array = s.toCharArray();

        // Create a hashmap to store each character and its index
        HashMap<Character,Integer> hashMap = new HashMap<>();
        // Iterate through each character in the string
        for (;j < array.length; j++) {
            // If the current character is already in the hashmap, update the start pointer points to the right of the current character
            if (hashMap.containsKey(array[j])){
                // Note: i cannot go backward (smaller).
                i = Math.max(i,hashMap.get(array[j])+1);
            }
            // Put the current character and its index in the hashmap
            hashMap.put(array[j],j);
            // Update the max substring length
            max = Math.max(max,j-i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int r = lengthOfLongestSubstring("pwwkew");
        System.out.println(Integer.toString(r));
    }
}
