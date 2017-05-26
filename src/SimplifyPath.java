import java.util.HashSet;
import java.util.Stack;

/**
 * Created by udingji on 3/3/17.
 */
public class SimplifyPath {

//    public static String simplifyPath(String path) {
//        // If the path is empty, return path
//        if (path.isEmpty()) return path;
//        // Create a stack to store path
//        Stack<String> stack = new Stack<>();
//        // Create a string builder to store strings between each two slashes
//        StringBuilder sb = new StringBuilder();
//        // Convert the string to character array
//        char[] array = path.toCharArray();
//        int i = 0;
//        // Iterate through the character array till the end
//        while(i <= array.length){
//            // If we find a slash or we reach the end
//            // Otherwise, append the character in the buffer
//            if (i == array.length || array[i] == '/'){
//                // We take what we have in the buffer
//                String buffer = sb.toString();
//                // If the buffer is "..", pop the stack (go up one level)
//                // If the buffer is ".",  do nothing (stay at the current level)
//                // If the buffer is not empty, push the string in the stack (go down one level)
//                if (buffer.equals("..")){
//                    if (!stack.empty()){
//                        stack.pop();
//                    }
//                }else if (buffer.equals(".")){
//
//                }else if (!buffer.isEmpty()){
//                    stack.push(buffer);
//                }
//                sb = new StringBuilder();
//            }else {
//                sb.append(array[i]);
//            }
//            // Move the pointer to the next character
//            i++;
//        }
//
//        // Construct the path by popping the stack and insert it to the front of the string builder
//        while (!stack.empty()){
//            sb.insert(0,"/" + stack.pop());
//        }
//
//        // Return the string. If the string builder is empty, return "/"
//        return sb.toString().isEmpty() ? "/" : sb.toString();
//    }

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        for (String s : array){
            if (s.equals("..")){
                if (!stack.empty())
                    stack.pop();
            } else if (!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        while (!stack.empty()){
            sb.insert(0,"/" + stack.pop());
        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path = "///a//";
        System.out.println(simplifyPath(path));
    }
}
