/**
 * Created by jmding on 2/20/17.
 */
public class JumpGameII {

    // Given an array of non-negative integers, you are initially positioned at the first index of the array.

    // Each element in the array represents your maximum jump length at that position.

    // Your goal is to reach the last index in the minimum number of jumps.

    // For example:
    // Given array A = [2,3,1,1,4]
    // The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

    public static int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        // The number of minimum steps so far
        int sc = 0;
        // The edge that at current step can reach
        int e = 0;
        // The max edge (the longest jump from current node exceeds max?)
        int max = 0;
        for(int i=0; i<nums.length-1; i++) {
            // Update max if the longest jump from current node exceeds max
            max = Math.max(max, i+nums[i]);
            // If i is at the edge of maximum jump length
            if( i == e ) {
                // We need to increment the step. We have to add another step to reach anywhere further
                sc++;
                // Set the new edge to the max
                e = max;
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump2(nums));
    }
}
