/**
 * Created by udingji on 5/16/17.
 */
public class HIndex {

    // Idea: create an array to store how many times the researcher get this number of citations
    // Then scan from the back of that array, and keep track of the total number of citations beyond this point
    // If we see the total is greater than the current index, it means the researcher have more than i papers which receives i citations
    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0)
            return 0;

        int[] numOfCitations = new int[citations.length+1];

        for (int i = 0; i < citations.length; i++){
            if (citations[i] >= citations.length){
                numOfCitations[citations.length]++;
            } else {
                numOfCitations[citations[i]]++;
            }
        }

        int total = 0;

        for (int i = numOfCitations.length - 1; i >= 0; i--){
            total += numOfCitations[i];
            if (total >= i)
                return i;
        }
        return 0;
    }

}
