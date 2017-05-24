/**
 * Created by jmding on 5/23/17.
 */
public class ReverseWordsInAStringII {

    // Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

    // The input string does not contain leading or trailing spaces and the words are always separated by a single space.

    // For example,
    // Given s = "the sky is blue",
    // return "blue is sky the".

    // Could you do it in-place without allocating extra space?


    // Idea: Reverse the whole character array first. Then traverse the array
    // Initiate the start index at 0. When we find a space, reverse the subarray from start to current. Update the start index
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);

        int start = 0;
        for (int i = 0; i <= s.length; i++){
            if (i == s.length || s[i] == ' '){
                reverse(s,start,i-1);
                start = i + 1;
            }
        }
    }

    private void reverse(char[] s, int start, int end){

        while (start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
