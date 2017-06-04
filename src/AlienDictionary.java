import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by udingji on 5/16/17.
 */
public class AlienDictionary {

    // There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

    // Example 1:
    // Given the following words in dictionary,

    // [
    //    "wrt",
    //    "wrf",
    //    "er",
    //    "ett",
    //    "rftt"
    //    ]
    // The correct order is: "wertf".

    // Example 2:
    // Given the following words in dictionary,

    // [
    //    "z",
    //    "x"
    //    ]
    // The correct order is: "zx".

    // Example 3:
    // Given the following words in dictionary,

    // [
    //     "z",
    //     "x",
    //     "z"
    //     ]
    // The order is invalid, so return "".

    // Note:
    // You may assume all letters are in lowercase.
    // You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
    // If the order is invalid, return an empty string.
    // There may be multiple valid order of letters, return any one of them is fine.

    public String alienOrder(String[] words) {

        Hashtable<Character,Set<Character>> charactersComesAfter = new Hashtable<>();
        Hashtable<Character,Integer> numCharactersBefore = new Hashtable<>();

        for (String word : words){
            char[] array = word.toCharArray();
            for (char c : array) {
                charactersComesAfter.put(c, new HashSet<>());
                numCharactersBefore.put(c,0);
            }
        }

        for (int i = 0; i < words.length - 1; i++){
            char[] current = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();
            int minLength = Math.min(current.length,next.length);
            for (int j = 0; j < minLength; j++){
                if (current[j] != next[j]){
                    if(charactersComesAfter.get(current[j]).add(next[j]))
                        numCharactersBefore.put(next[j],numCharactersBefore.get(next[j]) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Character c : numCharactersBefore.keySet()){
            if (numCharactersBefore.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Character c = queue.poll();
            sb.append(c);
            Set<Character> set = charactersComesAfter.get(c);
            for (Character character : set){
                numCharactersBefore.put(character,numCharactersBefore.get(character) - 1);
                if (numCharactersBefore.get(character) == 0){
                    queue.offer(character);
                }
            }
        }

        String result = sb.toString();
        return result.length() == numCharactersBefore.size() ? result : "";

    }
}
