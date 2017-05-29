import java.util.HashMap;

/**
 * Created by udingji on 5/18/17.
 */
public class ContiguousArray {

    // Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

    // Example 1:
    // Input: [0,1]
    // Output: 2
    // Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

    // Example 2:
    // Input: [0,1,0]
    // Output: 2
    // Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    // Idea: change all 0s in the array to -1, so that if the sum is 0, it means that we have equal number of 0s and 1s
    public int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0)
                nums[i] = -1;
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);

        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            if (hashMap.containsKey(sum)){
                max = Math.max(max,i - hashMap.get(sum));
            } else {
                hashMap.put(sum,i);
            }
        }

        return max;
    }
}
