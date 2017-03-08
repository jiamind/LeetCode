import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 3/1/17.
 */
public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        // TODO: needs comments
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        int wordLength = 0;
        int numOfWords = 0;
        while (end < words.length){

            if (words[end].length() + wordLength + numOfWords >= maxWidth || end == words.length - 1){
                if (words[end].length() + wordLength + numOfWords > maxWidth) {
                    end--;
                }else {
                    wordLength += words[end].length();
                    numOfWords++;
                }
                int spaceLeft = maxWidth;
                for (int i = start; i <= end; i++){
                    sb.append(words[i]);
                    if (end == words.length - 1 && start != end){
                      sb.append(" ");
                      spaceLeft--;
                    } else if (numOfWords != 1) {
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
                if (spaceLeft > 0){
                    for (int i = 0; i < spaceLeft; i++){
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                start = end+1;
                wordLength = 0;
                numOfWords = 0;
            } else {
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
