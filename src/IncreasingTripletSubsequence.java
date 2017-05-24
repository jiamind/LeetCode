/**
 * Created by udingji on 5/15/17.
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        // Create two integers to hold the i and j
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;

        // If we find a number which is smaller than i, update i
        // If we find a number which is greater than i but smaller than j, update j
        // Otherwise, the number is greater than both i and j, we found the three increasing numbers
        for (int num : nums){
            if (num < i){
                i = num;
            } else if (num < j){
                j = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
