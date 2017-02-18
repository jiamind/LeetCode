package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by udingji on 2/15/17.
 */
public class SubstringWithConcatOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int windowSize = wordLen * words.length;

        if (s.length() < windowSize) return result;

        Map<String, Integer> map = new HashMap<>();
        for (String word: words) map.put(word, map.getOrDefault(word,0) + 1);

        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            String window = s.substring(i, i + windowSize);
            Map<String, Integer> tmp = new HashMap<>(map);
            for (int j = 0; j < window.length() - wordLen + 1; j += wordLen) {
                String subStr = window.substring(j, j + wordLen);
                if (tmp.containsKey(subStr)) {
                    if (tmp.get(subStr) - 1 == 0) {
                        tmp.remove(subStr);
                    } else {
                        tmp.put(subStr, tmp.get(subStr) - 1);
                    }
                } else {
                    break;
                }
            }
            if (tmp.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababaab";
        String[] words = {"ab", "ba","ba"};

        List<Integer> result = findSubstring(s,words);

        for (Integer i : result)
            System.out.print(i + ", ");
    }

}
