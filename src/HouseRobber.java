/**
 * Created by jmding on 5/28/17.
 */
public class HouseRobber {

    // You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

    // Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

    // Keep update the total amount if rob or not rob the current house
    // If rob the current house, the previous house can't be robbed
    public int rob(int[] nums) {
        int robPrev = 0, notRobPrev = 0;

        for (int num : nums){
            int temp = robPrev;
            robPrev = num + notRobPrev;
            notRobPrev = Math.max(temp,notRobPrev);
        }

        return Math.max(robPrev,notRobPrev);
    }
}
