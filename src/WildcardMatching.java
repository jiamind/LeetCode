
/**
 * Created by udingji on 2/17/17.
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        int p1 = 0, p2 = 0, lastStarIndex = -1, matchedWithStar = -1;

        while (p1 < s.length()){
            // If the current character at s and p are the same, or p is '?', move both pointers forward
            // If p is '*', mark the index of '*', mark the character index in s which covered by the '*', move p forward
            // If s and p doesn't match, move p to the next character of the last '*', try cover one more character in s with this '*'
            if (p2 < p.length() && (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '?')){
                p1++;
                p2++;
            }else if (p2 < p.length() && p.charAt(p2) == '*'){
                lastStarIndex = p2;
                matchedWithStar = p1;
                p2++;
            }else if (lastStarIndex != -1){
                p2 = lastStarIndex + 1;
                matchedWithStar ++;
                p1 = matchedWithStar;
            }else {
                return false;
            }
        }

        // Since p1 already ends, the rest of p2 should all be '*'
        while (p2 < p.length() && p.charAt(p2) == '*') p2++;
        return p2 == p.length();
    }


    public static void main(String[] args) {
        String s = "abcdefgh";
        String p = "a*?d?f***h";
        System.out.println(isMatch(s,p));
    }
}
