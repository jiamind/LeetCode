/**
 * Created by jmding on 2/23/17.
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        // The Farthest index we can reach
        int farthest = nums[0];
        // Iterate through the nums
        for (int i = 1; i < nums.length; i++){
            // If we reach the num which exceeds the farthest we can reach, return false
            if(i>farthest) return false;
            // Update the farthest index we can reach
            farthest = Math.max(farthest,i+nums[i]);
        }
        // We reached the end of the nums, return true
        return true;
    }
}
