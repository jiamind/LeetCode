/**
 * Created by udingji on 2/1/17.
 */
public class StringToInteger {

    // Implement atoi to convert a string to an integer.

    // Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    // Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

    public static int myAtoi(String str) {

        // If the string is empty, return 0
        if (str.trim().isEmpty()) return 0;
        int result = 0;
        boolean isNegative = false;
        char[] array = str.toCharArray();
        // Pointer points to the start position of scanning
        int index = 0;

        // Remove any leading spaces
        while (array[index] == ' ' && index < str.length())
            index++;

        // Handle signs
        if (array[index] == '+' || array[index] == '-'){
            isNegative = array[index] == '-' ? true : false;
            index++;
        }

        // Iterate through the string starting from index
        for (int i = index; i < array.length; i++) {
            // Get the numeric value of the current character
            int value = Character.getNumericValue(array[i]);
            // If the character is not a valid digit
            if (value > 9 || value < 0){
                // Return the result we have
                return result;
            }
            // If adding this value to the result makes the number to be greater than the max integer value
            if ((Integer.MAX_VALUE - value) / 10 < result){
                // Return the max value of integer
                return Integer.MAX_VALUE;
            }
            // If subtracting this value to the result makes the number to be smaller than the min integer value
            if ((Integer.MIN_VALUE + value) / 10 > result){
                // Return the min value of integer
                return Integer.MIN_VALUE;
            }
            // If the number is negative, subtract the value. Otherwise, adding the value
            if (isNegative){
                result = result * 10 - value;
            }else {
                result = result * 10 + value;
            }
        }
        // Return the result
        return result;
    }

    public static void main(String[] args) {
        String str = "  +0 123";
        System.out.println(myAtoi(str));
    }
}
