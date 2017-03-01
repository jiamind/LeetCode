/**
 * Created by udingji on 3/1/17.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {

        if (digits.length == 0) return digits;

        boolean incrementOne = true;
        for (int i = digits.length-1; i >= 0; i--){
            if (incrementOne){
                digits[i] += 1;
                incrementOne = false;
            }
            if (digits[i] == 10){
                digits[i] = 0;
                incrementOne = true;
            } else {
                break;
            }
        }

        if (incrementOne){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }

    public static int[] plusOne2(int[] digits) {

        // Get the length of the digits
        int n = digits.length;
        // Iterate through the digits starting from the end
        for(int i=n-1; i>=0; i--) {
            // If the digit at the current position is less than 9, increment that digit by 1.
            // We can return digits here, since it's not greater than 10 and we don't need to add 1 to the next digit
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // The current digit is 9, adding 1 makes it to 10.
            // The digit becomes 0, adding 1 to the next digit
            digits[i] = 0;
        }

        // We still need to add 1 to the next digit but we've already reached the start of the digits (e.g. 999 + 1)
        // Create a new array with one extra in length, set the first digit to 1, and the result will automatically initialized to 0
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,6,9,9};
        int[] result = plusOne(digits);
        for (int i : result){
            System.out.print(i);
        }
    }
}
