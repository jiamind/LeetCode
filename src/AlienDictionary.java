import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by udingji on 5/16/17.
 */
public class AlienDictionary {

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
