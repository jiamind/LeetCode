import java.util.Arrays;

/**
 * Created by udingji on 5/16/17.
 */
public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for (int num : nums)
            sum += num;
        return (S > sum || (S + sum) % 2 != 0) ? 0 : helper(nums,(S + sum)/2);
    }

    private static int helper(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }
}
