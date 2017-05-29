/**
 * Created by jmding on 5/28/17.
 */
public class HouseRobber {

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
