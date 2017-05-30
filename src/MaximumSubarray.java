/**
 * Created by udingji on 2/23/17.
 */
public class MaximumSubarray {

    // Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    // For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    // the contiguous subarray [4,-1,2,1] has the largest sum = 6.

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // Create max to save the max so far,
        int max = nums[0], runningMax = nums[0];
        // Iterate through the array
        for (int i = 1; i < nums.length; i++){
            // Would the runningMax make this number smaller? If so, we'd rather set this number as the new runningMax
            runningMax = Math.max(runningMax + nums[i], nums[i]);
            //
            max = Math.max(max,runningMax);
        }
        return max;
    }

}
