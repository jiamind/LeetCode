import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 2/6/17.
 */
public class LetterCombinationsOfAPhoneNumber {

    // Given a digit string, return all possible letter combinations that the number could represent.

    // A mapping of digit to letters (just like on the telephone buttons) is given below.

    // Input:Digit string "23"
    // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        // Create a string array. The index of the array maps to the possible letters at that index number
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // Add the first empty string as the starting point
        result.add("");
        // Iterate through the string
        for(int i =0; i<digits.length();i++){
            // Get the numeric value at index i
            int x = Character.getNumericValue(digits.charAt(i));
            // Only pop the string with length i
            while(result.peek().length()==i){
                // Remove the first string from the linkedlist
                String t = result.remove();
                // Append each of the next character to the previous string and add to the queue
                for(char s : mapping[x].toCharArray())
                    result.add(t+s);
            }
        }
        // Return the queue
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result){
            System.out.print(s + ", ");
        }
    }
}
