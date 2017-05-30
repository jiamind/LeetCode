import java.util.HashMap;

/**
 * Created by udingji on 5/26/17.
 */
public class FirstUniqueCharacterInAString {

    // Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    // Examples:
    // s = "leetcode"
    // return 0.
    // s = "loveleetcode",
    // return 2.

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        char[] array = s.toCharArray();

        for (char c : array){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < array.length; i++){
            if (map.get(array[i]) == 1)
                return i;
        }

        return -1;
    }
}
