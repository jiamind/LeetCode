import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by udingji on 3/30/17.
 */
public class WordLadderII {

    static int minDistance;

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        minDistance = wordList.size();
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord))
            return result;

        backtrack(result, new ArrayList<>(), beginWord, endWord, wordList);

        Iterator<List<String>> iterator = result.iterator();
        while (iterator.hasNext()){
            List<String> list = iterator.next();
            if (list.size() > minDistance)
                iterator.remove();
            list.add(0, beginWord);
        }

        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> list, String word, String endWord,
            List<String> wordList) {

        if (word.equals(endWord)) {
            minDistance = Math.min(minDistance,list.size());
            result.add(new ArrayList<>(list));
        } else if (isDifferByOne(word,endWord)) {
            list.add(endWord);
            minDistance = Math.min(minDistance,list.size());
            result.add(new ArrayList<>(list));
            list.remove(endWord);
        } else {
            for (String str : wordList) {
                if (isDifferByOne(str, word)) {
                    list.add(str);
                    List<String> newWordList = new ArrayList<>(wordList);
                    newWordList.remove(str);
                    backtrack(result, list, str, endWord, newWordList);
                    list.remove(str);
                }
            }
        }
    }

    private static boolean isDifferByOne(String str1, String str2) {
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        int diff = 0;
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                diff++;
        }

        return diff == 1;
    }

    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        String[] array = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList = Arrays.asList(array);

        Long startTime = System.currentTimeMillis();
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        Long endTime = System.currentTimeMillis();
        System.out.println("Time spent: " + (endTime - startTime));
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

}
