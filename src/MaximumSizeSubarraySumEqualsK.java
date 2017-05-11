import java.util.HashMap;

/**
 * Created by udingji on 5/11/17.
 */
public class MaximumSizeSubarraySumEqualsK {


    // Idea: Iterate through the array of numbers. Save the sum so far at each index in a hashmap
    // If we find a sum equals to k at index i, set the max length to i + 1
    // If we find the difference between the sum and the target is in the hashmap at index j,
    // it means the sum from j+1 to i is equal to k, update the max
    public int maxSubArrayLen(int[] nums, int k) {

        int sum = 0, max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i : nums){
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            }else if (hashMap.containsKey(sum - k)){
                max = Math.max(max,i - hashMap.get(sum - k));
            }
            if (!hashMap.containsKey(sum))
                hashMap.put(sum,i);
        }
        return max;
    }

}
