/**
 * Created by jmding on 5/28/17.
 */
public class PermutationInString {

    // Idea: sliding window of size s1.length() from left to the right of s2
    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() > s2.length())
            return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] count = new int[26];

        for (int i = 0; i < c1.length; i++){
            count[c1[i] - 'a'] ++;
            count[c2[i] - 'a'] --;
        }

        if (allZeros(count))
            return true;

        for (int i = c1.length; i < c2.length; i++){
            count[c2[i] - 'a'] --;
            count[c2[i - c1.length] - 'a'] ++;
            if (allZeros(count))
                return true;
        }

        return false;
    }

    private boolean allZeros(int[] nums){
        for (int num : nums)
            if (num != 0)
                return false;
        return true;
    }
}
