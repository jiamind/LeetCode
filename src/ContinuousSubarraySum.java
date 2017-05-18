import java.util.Hashtable;

/**
 * Created by udingji on 5/17/17.
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        // Create a hash table to store the sum so far at each index <sum,index>
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (hashtable.containsKey(sum)) {
                if ( i - hashtable.get(sum) > 1)
                    return true;
            } else {
                hashtable.put(sum, i);
            }
        }

        return false;
    }
}
