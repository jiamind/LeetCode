import java.util.*;

/**
 * Created by jmding on 4/25/17.
 */
public class WordBreakII {

    private static HashMap<Integer, List<String>> dp = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> dictionary = new HashSet<>(wordDict);

        char[] array = s.toCharArray();

        return backtrack(array, 0, dictionary);
    }

    private static List<String> backtrack(char[] array, int start, HashSet<String> dictionary) {
        List<String> list = new ArrayList<>();
        if (start >= array.length) {
            list.add("");
            return list;
        }

        for (int i = 1; i <= array.length - start; i++) {
            String s = new String(array, start, i);
            if (dictionary.contains(s)) {
                List<String> r;
                if (dp.containsKey(start + i))
                    r = dp.get(start + i);
                else
                    r = backtrack(array, start + i, dictionary);

                for (String str : r)
                    list.add(s + (str.isEmpty() ? "" : " ") + str);
            }
        }
        dp.put(start, list);
        return list;

    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});

        List<String> result = wordBreak(s, wordDict);

        for (String str : result) {
            System.out.println(str);
        }
    }
}
