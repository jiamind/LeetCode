import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 2/8/17.
 */
public class GenerateParentheses {

// Idea: Use recursive to insert '()' at the begining of string and after each '('
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

        // If the length of the result is equal to twice the number of parentheses. Generate process is finished.
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        // If the number of left bracket is less than max, increment the left counter and recursive call
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        // Each time after we add a '(',  we add another ')' and increment the right counter
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
