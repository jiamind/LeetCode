/**
 * Created by jmding on 5/23/17.
 */
public class MissingNumber {

    // Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    // For example,
    // Given nums = [0, 1, 3] return 2.

    // Note:
    // Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


    public static int missingNumber(int[] nums) {

        int xor = 0, i = 0;

        for (; i < nums.length; i++){
            xor ^= (i ^ nums[i]);
        }

        // If we are missing exactly one number, there must be a number in the array which equals to the length of the array
        // Therefore, xor that number (the length of the array)
        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3};

        System.out.println(missingNumber(nums));
    }
}
