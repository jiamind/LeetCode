
/**
 * Created by udingji on 2/17/17.
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        int p1 = 0, p2 = 0, lastStarIndex = -1, matchedWithStar = -1;

        while (p1 < s.length()){
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

        while (p2 < p.length() && p.charAt(p2) == '*') p2++;
        return p2 == p.length();
    }


    public static boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String p = "a*?d?f***h";
        System.out.println(isMatch(s,p));
//        System.out.println(comparison(s,p));
    }
}
