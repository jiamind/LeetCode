package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 2/8/17.
 */
public class GenerateParentheses {


//    public static List<String> generateParentheses(int n) {
//        if (n < 1) return new ArrayList<>();
//        return recurGenerateParentheses(n);
//    }
//
//    private static LinkedList<String> recurGenerateParentheses(int n){
//        if (n == 1){
//            LinkedList<String> result = new LinkedList<>();
//            result.add("()");
//            return result;
//        }
//        LinkedList<String> result = recurGenerateParentheses(n-1);
//        String t;
//        while (result.peek().length() == 2 * (n-1)){
//            String str = result.poll();
//            for (int i = 0; i < str.length(); i++){
//                if (str.charAt(i) == '('){
//                    if (!result.contains("()" + str))
//                        result.add("()" + str);
//                    t = new StringBuilder(str).insert(i+1,"()").toString();
//                    if (!result.contains(t))
//                        result.add(t);
//                }
//            }
//        }
//        return result;
//    }

    public static List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        List<String> result = generateParentheses(3);
        for (String str : result){
            System.out.print(str + ", ");
        }

    }
}
