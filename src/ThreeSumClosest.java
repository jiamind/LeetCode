package test;

import java.util.Arrays;

/**
 * Created by udingji on 2/6/17.
 */
public class ThreeSumClosest {


    public static int threeSumClosest(int[] nums, int target) {

        // If the length of the array is less than or equal to 3, just add them up and return the sum.
        if (nums.length <= 3){
            int sum = 0;
            for (int n : nums){
                sum += n;
            }
            return sum;
        }

        // Sort the array
        Arrays.sort(nums);
        // index->    left->               <-right
        //   1          2    3   4   5   6     7
        int index = 0, left = index + 1, right = nums.length-1;
        int sum = 0;
        // The closet sum so far
        Integer closest = null;
        while (index < nums.length-2) {
            while (left < right) {
                // Calculate the sum
                sum = nums[index] + nums[left] + nums[right];
                // If the sum is equal to the target, return the sum since it is the closest
                if (sum == target) {
                    return sum;
                }
                // Set the closest to the sum if closest is not set yet, otherwise check the distance to the target and update the closest
                if (closest == null) {
                    closest = sum;
                } else {
                    if (Math.abs(closest - target) > Math.abs(sum - target)) {
                        closest = sum;
                    }
                }
                // If sum is greater than the target, the right pointer is too large, move it to the left
                // Otherwise, the left pointer is too small, move it to the right
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            // Increment the index. Set left pointer to the right of index, right pointer to the very right of the array
            index++;
            left = index + 1;
            right = nums.length-1;
        }
        // Return the closest sum we found so far
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
