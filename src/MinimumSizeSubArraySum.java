/**
 * Created by udingji on 5/15/17.
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        // Store the head and end index of the sub array.
        int head = 0, end = 0, minLength = Integer.MAX_VALUE, sum = 0;

        // Move the end index to the end
        while (end < nums.length){
            // Update the sum
            sum += nums[end++];

            // While the current sum is greater than the target,
            // Update the min length of the sub array. Move head to the end and subtract the head value from the sum
            while (sum >= s){
                minLength = Math.min(minLength,end-head);
                sum -= nums[head++];
            }
        }
        // If the initial min length has not change, it means the sum never meets the target (sum of all numbers is still less than the target)
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
