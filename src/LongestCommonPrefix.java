import java.util.Arrays;

/**
 * Created by jmding on 2/5/17.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        char[] head = strs[0].toCharArray();
        char[] tail = strs[strs.length-1].toCharArray();

       for (int i = 0; i < head.length; i++){
            if (i < tail.length && head[i] == tail[i]){
                sb.append(head[i]);
            }else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
