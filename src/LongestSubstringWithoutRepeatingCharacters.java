/**
 * Created by jmding on 1/24/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int i = 0, j = 0, max = -1;
        StringBuilder sb = new StringBuilder();
        while (j < s.length()){
            int index = sb.indexOf(Character.toString(s.charAt(j)));
            if (index >= 0){
                sb.delete(0,index + 1);
                i += (index + 1);
            }
            sb.append(s.charAt(j));
            if (j - i + 1 > max){
                max = j - i + 1;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int r = lengthOfLongestSubstring("pwwkew");
        System.out.println(Integer.toString(r));
    }
}
