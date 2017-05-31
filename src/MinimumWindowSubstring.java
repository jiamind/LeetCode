/**
 * Created by udingji on 5/12/17.
 */
public class MinimumWindowSubstring {

    // Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    // For example,
    //        S = "ADOBECODEBANC"
    ///T = "ABC"
    // Minimum window is "BANC".

    // Note:
    // If there is no such window in S that covers all characters in T, return the empty string "".
    // If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


    // Idea: create an integer array, map each character in t to the array, with the number of times it appears as its value
    // Use two pointers marking the head and end of the sliding window, both initially point to the head
    // Move the end pointer first, for each scanned character, reduce its value in the map.
    // If it has a positive value in the map, it means it's in t, reduce the counter (number of characters in t remaining to find)
    // When counter is 0, it means all characters in t are found, we begin to move the start pointer. As it moves, update the min length substring.
    // For each character it scanned, increment its value in the map. If it results in a positive value, it means this character is in t, increment the counter
    // Obviously it will stop moving the start pointer and continue moving the end pointer, until the counter reaches 0 again
    public String minWindow(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] map = new int[128];
        for (char c : tArray)
            map[c]++;

        int start = 0, end = 0, counter = tArray.length, minLength = Integer.MAX_VALUE;
        String result = "";

        while (end < sArray.length){
            if (map[sArray[end]]-- > 0)
                counter--;

            while (counter == 0){

                if (end-start+1 < minLength){
                    minLength = end-start+1;
                    result = new String(sArray,start,end-start+1);

                }

                if (++map[sArray[start]] > 0)
                    counter++;
                start++;
            }
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";

    }
}
