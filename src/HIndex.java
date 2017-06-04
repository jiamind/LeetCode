/**
 * Created by udingji on 5/16/17.
 */
public class HIndex {

    // Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

    // According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

    // For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

    // Note: If there are several possible values for h, the maximum one is taken as the h-index.

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
            // If the number of papers which have more than i citations is greater than i, return the index i
            if (total >= i)
                return i;
        }
        return 0;
    }

}
