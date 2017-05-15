/**
 * Created by udingji on 5/14/17.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        // Now, result[i] represents the product of all numbers before 1
        result[0] = 1;

        // Iterate through the array from left and right
        // Update result array with the product of all numbers before each number
        for (int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        // Create a new integer right, represents the product of all numbers after each number
        int right = 1;

        for (int i = nums.length - 1; i >= 0; i--){
            // Update the result by multiply the product of all numbers after it
            result[i] *= right;
            // Update right. Multiply the current number to get ready for the next number
            right *= nums[i];
        }
        return result;
    }
}
