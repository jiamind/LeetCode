

/**
 * Created by udingji on 2/16/17.
 */
public class CountAndSay {

    // The count-and-say sequence is the sequence of integers beginning as follows:
    // 1, 11, 21, 1211, 111221, ...

    // 1 is read off as "one 1" or 11.
    // 11 is read off as "two 1s" or 21.
    // 21 is read off as "one 2, then one 1" or 1211.
    // Given an integer n, generate the nth sequence.

    // Note: The sequence of integers will be represented as a string.

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n-1);
        return sayNum(str);
    }

    private static String sayNum(String n){
        StringBuilder sb = new StringBuilder();
        // The new character
        Character current = null;
        // The starting index of the new character
        int count = 0;
        for (int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            if (current == null || current != c){
                if (current != null){
                    sb.append(count);
                    sb.append(current);
                }
                current = c;
                count = 1;
            }else {
                count ++;
            }
        }
        sb.append(count);
        sb.append(current);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
