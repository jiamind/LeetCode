import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 2/6/17.
 */
public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        // Create a string array. The index of the array maps to the possible letters at that index number
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // Add the first empty string as the starting point
        ans.add("");
        // Iterate through the string
        for(int i =0; i<digits.length();i++){
            // Get the numeric value at index i
            int x = Character.getNumericValue(digits.charAt(i));
            // Only pop the string with length i
            while(ans.peek().length()==i){
                // Remove the first string from the linkedlist
                String t = ans.remove();
                // Append each of the next character to the previous string and add to the queue
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        // Return the queue
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result){
            System.out.print(s + ", ");
        }
    }
}
