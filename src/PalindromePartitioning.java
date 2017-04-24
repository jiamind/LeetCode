import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 4/20/17.
 */
public class PalindromePartitioning {

    // Idea: use backtrack
    public static List<List<String>> partition(String s) {

        // Create a list to store result
        List<List<String>> result = new ArrayList<>();

        // If the string is null or is empty, return the empty result list
        if (s == null || s.isEmpty())
            return result;

        // Create a list to store each possible partition of s
        List<String> list = new ArrayList<>();
        // Convert the string to character array
        char[] array = s.toCharArray();

        backtrack(result,list,array,0);

        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> list, char[] s, int start){
        // If we reach the end of the string, add the current partition to the result list
        if (start >= s.length){
            result.add(new ArrayList<>(list));
        } else {
            // For the next substring, we could take length starting from 1 to the whole rest of the string
            for (int i = 1; i <= s.length - start; i++){
                String str = new String(s,start,i);
                // If the substring is a valid palindrome string, add it to the list, move the starting point forward to the head of the next substring
                // then recursively call the backtrack method
                if (isValidPalindrome(str)){
                    list.add(str);
                    backtrack(result,list,s,start+i);
                    // Remove the last string added
                    // Note: you could use list.remove(str). Since same str value could appear multiple times in a possible partition
                    // The order of the result string may not retain
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private static boolean isValidPalindrome(String str){
        // Convert the string into character array
        char[] array = str.toCharArray();
        // If the length of the array is less than or equal to 1, it is a palindrome string
        if (array.length <= 1)
            return true;
        // Create two pointers point to the head and end of the array
        int left = 0, right = str.length()-1;
        // Move the left and right pointers towards each other.
        // The two characters pointed by the pointers should be identical
        // Otherwise, it is not a palindrome string
        while (left < right){
            if (array[left] != array[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbbbcc";
        List<List<String>> result = partition(str);

        for (List<String> list : result){
            for (String s : list){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
