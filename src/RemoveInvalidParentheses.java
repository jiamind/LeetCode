import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by udingji on 5/11/17.
 */
public class RemoveInvalidParentheses {

    // Idea: remove one left or right parentheses at a time, add it into a queue and repeat the process, until we found valid parentheses string
    // Then we stop removing parentheses (adding string to the queue) since we need to remove minimum number of parentheses
    public static List<String> removeInvalidParentheses(String s) {

        // Create the result list
        List<String> result = new ArrayList<>();

        // If the string is null, return the empty result
        if (s == null)
            return result;

        // Create a queue to store strings at each level (after remove a parentheses)
        Queue<String> queue = new LinkedList<String>();
        // Create a hash set to store each string we processed to aviod duplicate result
        HashSet<String> visited = new HashSet<>();

        // Add the original string to the queue and add it to the visited hash set
        queue.offer(s);
        visited.add(s);

        // Create a flag which indicates whether we have found the result (with minimum removal of parentheses)
        boolean found = false;

        while (!queue.isEmpty()) {
            // Get the first string in the queue
            String str = queue.poll();

            // If the string contains valid parentheses, add it to the result list,
            // and set the flag since we found the result with minimum removal of parentheses
            if (isValid(str)) {
                result.add(str);
                found = true;
            }

            // If we found any result, we don't want to continue remove parentheses any further, since we found the minimum
            if (found)
                continue;

            char[] array = str.toCharArray();
            // For each character in the string, if it is a parentheses, remove it, mark it as visited, and add it to the queue
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '(' || array[i] == ')') {
                    String newStr = new String(array, 0, i)
                            .concat(new String(array, i + 1 >= array.length ? array.length - 1 : i + 1,
                                    array.length - i - 1));
                    if (!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(')');
            } else if (array[i] == ')') {
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> result = removeInvalidParentheses(s);

        for (String str : result)
            System.out.println(str);
    }
}
