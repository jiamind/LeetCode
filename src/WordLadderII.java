import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by udingji on 3/30/17.
 */
public class WordLadderII {


    // Idea: Use bfs to construct neighbors (words which differs from the word by only one character) of each word, as well as the distance from the start word to each word
    // Use dfs to find the min path from the start word to the end word
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list to a hashset for faster word access
        HashSet<String> dictionary = new HashSet<>(wordList);
        // Create the result list
        List<List<String>> result = new ArrayList<>();
        // Create a hashmap to store list of neighbors of each word
        HashMap<String,List<String>> neighbors = new HashMap<>();
        // Create a hashmap to store the distance from the start word to each word
        HashMap<String,Integer> distance = new HashMap<>();
        // Create a list to store each path
        ArrayList<String> path = new ArrayList<>();

        // Add the begin word to the dictionary (if it is not yet in the dictionary)
        dictionary.add(beginWord);
        // Initialize the neighbors of each word with empty neighbor list
        for (String word : dictionary){
            neighbors.put(word,new ArrayList<>());
        }

        // Use bfs to construct neighbors of each word, and the distance from the start word to each word
        bfs(beginWord,endWord,dictionary,neighbors,distance);
        // Use dfs to find the min path from the start word to the end word
        dfs(beginWord,endWord,neighbors,distance,path,result);

        // Return the result list
        return result;
    }

    private static void bfs(String start, String end, HashSet<String> dictionary, HashMap<String,List<String>> neighbors, HashMap<String,Integer> distance){

        // Create a queue (linkedlist) to store the neighbors of each word
        LinkedList<String> queue = new LinkedList<>();
        // Add the start word to the queue
        queue.add(start);
        // The start word has 0 distance to itself
        distance.put(start,0);

        // While the queue is not empty
        while (!queue.isEmpty()){
            // Get the number of neighbors of the current word. Because the size will grow as we're adding more neighbors to the queue
            int size = queue.size();
            // Create a flag to indicate if we reach the end word
            boolean reachEnd = false;
            // For each word in the queue
            for (int i = 0; i < size; i++){
                // Get the current word
                String word = queue.poll();
                // Get the word's distance to the start word
                int currentDistance = distance.get(word);
                // Get all the neighbors of the current word
                List<String> wordNeighbors = findNeighbors(word,dictionary);

                // Iterate through all the neighbors of the current word
                for (String neighborWord : wordNeighbors){
                    // Add the neighbor to the neighbor list of the current word
                    neighbors.get(word).add(neighborWord);
                    // Add the distance of the neighbor word to the distance hashmap, only if it is not present in the hashmap
                    if (!distance.containsKey(neighborWord)){
                        // The distance of the neighbor word is the distance of the current word plus 1
                        // since the distance between the neighbor word and the current word is 1
                        distance.put(neighborWord,currentDistance+1);
                        // If we reach the end word, set the flag
                        // Otherwise, add the neighbor word to the queue (so we will go through its neighbors in the next iteration)
                        if (end.equals(neighborWord))
                            reachEnd = true;
                        else
                            queue.add(neighborWord);
                    }
                }
            }
            // If we already reach the end word, no need to dig deeper.
            if (reachEnd)
                break;
        }
    }

    private static void dfs(String current, String end, HashMap<String,List<String>> neighbors, HashMap<String,Integer> distance, ArrayList<String> path, List<List<String>> result){
        // Add the current word to the path
        path.add(current);
        // If the current word is the end word, we have the complete path, add a copy of it to the result list
        if (current == end){
            result.add(new ArrayList<>(path));
        } else {
            // Otherwise, find all the neighbors of the current word
            List<String> wordNeighbors = neighbors.get(current);
            // Iterate through all the neighbors
            for (String neighbor : wordNeighbors){
                // If the distance of the neighbor is the distance of the current word plus one
                if (distance.get(neighbor) == distance.get(current) + 1){
                    // Recursively call the dfs method on the neighbor word
                    dfs(neighbor,end,neighbors,distance,path,result);
                }
            }
        }
        // Don't forget to remove the current word once we are done with it
        path.remove(current);
    }


    private static List<String> findNeighbors(String word, HashSet<String> dictionary){
        // Create the result list
        List<String> result = new ArrayList<>();
        // Iterate through each word in the dictionary
        for (String dictWord : dictionary){
            // If the word in the dictionary differs from the current word by 1 (which means they are neighbors)
            if (isDifferByOne(word,dictWord))
                // Add the word in the dictionary to the result list
                result.add(dictWord);
        }
        return result;
    }

    private static boolean isDifferByOne(String str1, String str2) {
        // Convert the two words into character array
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        // Use an integer variable to store the difference between the two words
        int diff = 0;
        // If the two words are different in length, they can't be neighbors.
        if (array1.length != array2.length)
            return false;
        // Every time we find a difference between the characters at the same position in the two words, we increment the diff counter
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                diff++;
        }

        // Return whether the difference is 1
        return diff == 1;
    }



    public static void main(String[] args) {
//        String beginWord = "qa";
        String beginWord = "hit";
//        String endWord = "sq";
        String endWord = "cog";
//        String[] array = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String[] array = new String[]{"hot","dot","dog","lot","log","cog"};
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
