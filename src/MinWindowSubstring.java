import java.util.HashMap;
import java.util.Map;

/**
 * Created by jmding on 1/23/17.
 */
public class MinWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        t.chars().forEach(c -> need.merge((char) c, 1, Integer::sum));
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        String result = "";
        while (j < s.length()) {
            need.merge(s.charAt(j), -1, Integer::sum);
            j++;
            while (isOk(need) && i < j) {
                need.merge(s.charAt(i), 1, Integer::sum);
                if (j - i < min) {
                    min = j - i;
                    result = s.substring(i, j);
                }
                i++;
            }
        }
        return result;
    }

    private static boolean isOk(Map<Character, Integer> need) {
        for (int i : need.values()) {
            if (i > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "AQWERBYUEOCUWYAKNB";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
