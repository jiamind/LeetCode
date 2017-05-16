import java.util.Arrays;

/**
 * Created by udingji on 5/15/17.
 */
public class CombinationSumIV {

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
