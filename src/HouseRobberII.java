/**
 * Created by jmding on 5/28/17.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }

    private int rob(int[] nums, int start, int end){
        int robPrev = 0, notRobPrev = 0;

        for (int i = start; i <= end; i++){
            int temp = robPrev;
            robPrev = nums[i] + notRobPrev;
            notRobPrev = Math.max(temp,notRobPrev);
        }

        return Math.max(robPrev,notRobPrev);
    }
}
