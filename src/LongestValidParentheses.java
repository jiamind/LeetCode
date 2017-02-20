import java.util.Stack;

/**
 * Created by udingji on 2/16/17.
 */
public class LongestValidParentheses {


    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        // Iterate through the string
        for (int i = 0; i < s.length(); i++){

            // If we find a '(', push the index to the stack
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                // If we find a ')'
                // If the stack is empty, there is nothing to pop, this is an invalid bracket. push the index to the stack
                if (stack.empty()) {
                    stack.push(i);
                }else {
                    // If the last character in the stack is '(', pop
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                        // Calculate the max. Now if the stack is empty, use -1 as the starting point.
                        max = Math.max(max,i - (stack.empty()?-1:stack.peek()));
                    }else {
                        // If the last character in the stack is ')', push the ')'
                        stack.push(i);
                    }
                }
            }
        }
        // Return the max
        return max;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
}
