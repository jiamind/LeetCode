import java.util.Arrays;

/**
 * Created by udingji on 5/15/17.
 */
public class CombinationSumIV {

    // Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

    // Example:

    // nums = [1, 2, 3]
    // target = 4

    // The possible combination ways are:
    //        (1, 1, 1, 1)
    //        (1, 1, 2)
    //        (1, 2, 1)
    //        (1, 3)
    //        (2, 1, 1)
    //        (2, 2)
    //        (3, 1)

    // Note that different sequences are counted as different combinations.

    // Therefore the output is 7.
    // Follow up:
    // What if negative numbers are allowed in the given array?
    // How does it change the problem?
    // What limitation we need to add to the question to allow negative numbers?

    // Idea: NumberOfCombination(Target) = Sum of(NumberOfCombination(Target - each number))
    // Base: NumberOfCombination(0) = 1
    public int combinationSum4(int[] nums, int target) {
        // Create a int array to store number of combination for each index(target)
        int[] dp = new int[target];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return helper(nums,target,dp);
    }

    private int helper(int[] nums, int target, int[] dp){
        if (dp[target] != -1)
            return dp[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (target >= nums[i])
                res += helper(nums,target-nums[i],dp);
        }
        dp[target] = res;
        return res;
    }
}
