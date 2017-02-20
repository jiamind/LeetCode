/**
 * Created by jmding on 2/19/17.
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        // Iterate through the list
        for(int i = 0; i < nums.length; i++) {
            // Only if the number at index i is different from val, manipulate the list,
            // set the number at result equals to the number at i, increment the result counter
            if (nums[i] != val) nums[result++] = nums[i];
        }
        return result;
    }
}
