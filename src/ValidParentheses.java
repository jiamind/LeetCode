package test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by udingji on 2/7/17.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0){
            return false;
        }

        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        List<Character> str1 = Arrays.asList('(','[','{');
        List<Character> str2 = Arrays.asList(')',']','}');
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (str1.indexOf(c) >= 0){
                stack.push(c);
            }else {
                if (stack.empty()) return false;
                char d = stack.pop();
                if (str1.indexOf(d) != str2.indexOf(c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
