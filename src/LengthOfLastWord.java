/**
 * Created by udingji on 2/24/17.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        // If s is null or the s is empty, return 0
        if (s == null || s.isEmpty()) return 0;
        // Convert the string to character array
        char[] array = s.toCharArray();
        // Set the index at array length (yes, out of bound) as the last index we see a space
        int lastIndex = array.length;
        // Iterate through the array in reverse order
        for (int i = array.length-1; i >= 0; i--){
            // If we find a ' ' in the current index
            if (array[i] == ' '){
                // If it is the last index, or the next character is still a ' '
                // We update the lastIndex
                if (i == array.length - 1 || array[i+1] == ' '){
                    lastIndex = i;
                }else {
                    // We found the second empty space!
                    // The length of the last word is the length of the word between these two spaces
                    return lastIndex - i - 1;
                }
            }

        }
        // Two scenarios here: either the string are all consecutive empty spaces (contains no word, return 0)
        // or there are no space in the string (one whole word, return the length of the string)
        return array[0] != ' ' ? lastIndex : 0;
    }

    public static void main(String[] args) {
        String s = " asd   dc ";
        System.out.println(lengthOfLastWord(s));
    }
}
