package test;

import java.util.Stack;

/**
 * Created by udingji on 2/16/17.
 */
public class LongestValidParentheses {


    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.empty()) {
                    stack.push(i);
                }else {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                        max = Math.max(max,i - (stack.empty()?-1:stack.peek()));
                    }else {
                        stack.push(i);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
}
