import java.util.HashMap;

/**
 * Created by udingji on 5/11/17.
 */
public class MaximumSizeSubarraySumEqualsK {

    // Problem: Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

    //Example: Given nums = [1, -1, 5, -2, 3], k = 3,
    // return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

    // Idea: Iterate through the array of numbers. Save the sum so far at each index in a hashmap
    // If we find a sum equals to k at index i, set the max length to i + 1
    // If we find the difference between the sum and the target is in the hashmap at index j,
    // it means the sum from j+1 to i is equal to k, update the max
    public int maxSubArrayLen(int[] nums, int k) {

        int sum = 0, max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i : nums){
            sum += nums[i];
            // Since we are iterating to the end of the array, the length of the sub array so far is growing
            // If the sum at the current index is k, then the maximum length of sub array must be it
            if (sum == k) {
                max = i + 1;
            }else if (hashMap.containsKey(sum - k)){
                max = Math.max(max,i - hashMap.get(sum - k));
            }
            // Do not update the <sum,i> if it is already in the hashmap, since the existing one in the hashmap has smaller i
            if (!hashMap.containsKey(sum))
                hashMap.put(sum,i);
        }
        return max;
    }

}
