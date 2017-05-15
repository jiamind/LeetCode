import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by udingji on 5/15/17.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    public int findKthLargestII(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

}
