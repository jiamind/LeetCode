/**
 * Created by udingji on 5/15/17.
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        // Create two integers to hold the min and max bound of the two increasing numbers
        int lower = Integer.MAX_VALUE, upper = Integer.MAX_VALUE;

        // If we find a third number which is smaller than the lower bound, update the lower bound (anything greater than the new lower bound is accepted)
        // If we find a third number which is smaller than the upper bound, update the upeer bound (anything between the old and new upper bound is NOT accepted)
        // Otherwise, the third number is greater than the upper bound, we found the three increasing numbers
        for (int num : nums){
            if (num < lower){
                lower = num;
            } else if (num < upper){
                upper = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
