import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by udingji on 2/7/17.
 */
public class ValidParentheses {

    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    // The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

    public static boolean isValid(String s) {
        // If the string is null or the length of the string cannot be divided by 2, return false.
        if (s == null || s.length() % 2 != 0){
            return false;
        }

        // If the string is empty, return true
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        List<Character> str1 = Arrays.asList('(','[','{');
        List<Character> str2 = Arrays.asList(')',']','}');
        // Iterate through the string
        for (int i = 0; i < s.length(); i++){
            // Get the character at index i
            char c = s.charAt(i);
            // If the character is a left bracket
            if (str1.indexOf(c) >= 0){
                // Push it to the stack
                stack.push(c);
            }else {
                // If the character is a right bracket
                // If the stack is already empty, return false
                if (stack.empty()) return false;
                // Otherwise, pop the stack
                char d = stack.pop();
                // If the bracket poped and the current character is not a pair, return false
                if (str1.indexOf(d) != str2.indexOf(c)){
                    return false;
                }
            }
        }
        // If the stack is empty at the end, return true
        return stack.empty();
    }

    // Idea: Push the corresponding right parentheses to the stack if we find a left parentheses.
    // Otherwise, if stack is empty or the current parentheses does not match with the one popped from the stack, this is an invalid parentheses string
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
