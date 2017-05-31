/**
 * Created by udingji on 5/13/17.
 */
public class OneEditDistance {

    // Given two strings S and T, determine if they are both one edit distance apart.


    // Idea: Iterate through the string (with the minimum characters). If we find different characters at the same index:
    // 1) two strings have the same length. Then we replace this character. Therefore, all other characters have to be the same in these two strings
    // 2) s string is longer than t string. Then we delete this character in s string. Therefore, all other characters have to be the same in these two strings
    // 3) t string is longer than s string. Then we delete this character in t string. Therefore, all ither characters have to be the same in these two strings
    public boolean isOneEditDistance(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < Math.min(sArray.length,tArray.length); i++){
            if (sArray[i] != tArray[i]){
                if (sArray.length == tArray.length){
                    return new String(sArray,i+1,sArray.length-1-i).equals(new String(tArray,i+1,tArray.length-1-i));
                } else if (sArray.length > tArray.length){
                    return new String(sArray,i+1,sArray.length-1-i).equals(new String(tArray,i,tArray.length-i));
                } else {
                    return new String(sArray,i,sArray.length-i).equals(new String(tArray,i+1,tArray.length-1-i));
                }
            }
        }
        return Math.abs(sArray.length-tArray.length) == 1;
    }
}
