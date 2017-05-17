import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 3/1/17.
 */
public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // The index of the start word of this line in words array
        int start = 0;
        // The index of the end word of this line in words array
        int end = 0;
        // The length of words (characters) in this line
        int wordLength = 0;
        // The number of words in this line
        int numOfWords = 0;
        while (end < words.length){
            // If the current word length plus the existing word length, plus the minimum number of space required among words is greater than the maxWidth limit.
            // Or this word is the last word in the array.
            // We are going to finish this line
            if (words[end].length() + wordLength + numOfWords >= maxWidth || end == words.length - 1){
                // If the total length exceeds the limit, remove the last word
                if (words[end].length() + wordLength + numOfWords > maxWidth) {
                    end--;
                }else {
                    wordLength += words[end].length();
                    numOfWords++;
                }
                // Number of space left in this line to be distributed
                int spaceLeft = maxWidth;
                // Iterate through each word in the current line
                for (int i = start; i <= end; i++){
                    // Append the current word into the string buffer
                    sb.append(words[i]);
                    // If the current word is the last word in the array, and it is not the first word in the current line
                    // Just append one space
                    if (end == words.length - 1 && start != end){
                      sb.append(" ");
                      spaceLeft--;
                    } else if (numOfWords != 1) {
                        // Calculate the spaces needed between each two words, append the spaces into ths string buffer (if it is not the last word in this line)
                        int spaceLength = (spaceLeft - wordLength) % (numOfWords - 1) == 0 ? (spaceLeft - wordLength) / (numOfWords - 1) : (spaceLeft - wordLength) / (numOfWords - 1) + 1;
                        for (int j = 0; j < spaceLength; j++) {
                            sb.append(" ");
                            spaceLeft--;
                        }
                    }
                    spaceLeft -= words[i].length();
                    numOfWords--;
                    wordLength -= words[i].length();
                }
                // If there are space left in this line, append them
                if (spaceLeft > 0){
                    for (int i = 0; i < spaceLeft; i++){
                        sb.append(" ");
                    }
                }
                // Add the string buffer to the result.
                // Reset the counters
                result.add(sb.toString());
                sb = new StringBuilder();
                start = end+1;
                wordLength = 0;
                numOfWords = 0;
            } else {
                // There are still spaces in this line to fit this current word
                wordLength += words[end].length();
                numOfWords++;
            }
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
//        String[] words = {"a", "b", "c", "d", "e"};
//        int maxWidth = 3;
//        String[] words = {"what", "must", "be", "shall", "be."};
//        int maxWidth = 12;
//        String[] words = {""};
//        int maxWidth = 0;

        List<String> result = fullJustify(words,maxWidth);

        for (String s : result){
            System.out.println(s);
        }
    }
}
