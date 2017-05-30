import java.util.Arrays;

/**
 * Created by udingji on 5/24/17.
 */
public class ReverseWordsInAString {

    // Given an input string, reverse the string word by word.

    // For example,
    // Given s = "the sky is blue",
    // return "blue is sky the".

    public String reverseWords(String s) {

        if (s == null)
            return s;

        // Remove any extra space
        char[] array = removeExtraSpace(s.toCharArray());

        reverse(array,0,array.length - 1);

        int start = 0;
        for (int i = 0; i <= array.length; i++){
            if (i == array.length || array[i] == ' '){
                reverse(array,start,i-1);
                start = i + 1;
            }
        }

        return new String(array);
    }

    private void reverse(char[] array, int start, int end){
        while (start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private char[] removeExtraSpace(char[] array){

        int i = 0;
        for (int j = 0; j < array.length; j++){

            // If the current character is not space, or its previous character is not space (i >0, we allow one space between characters)
            // Copy the character to the new i position
            if (array[j] != ' ' || (j > 0 && array[j - 1] != ' ')){
                array[i++] = array[j];
            }
        }

        // If the array are all spaces, return empty array
        if (i == 0)
            return new char[0];

        // The last character could be a space. If so, remove it
        return Arrays.copyOfRange(array,0,array[i-1] == ' ' ? i-1 : i);
    }

}
