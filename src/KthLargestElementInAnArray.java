import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by udingji on 5/15/17.
 */
public class KthLargestElementInAnArray {

    // Slowest: use quick sort
    // Time complexity: O(NlogN)
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    // Use priority queue
    // Time complexity: O(NlogK), space complexity O(K)
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

    // Use quick select algorithm
    // Time complexity (Average) O(N)
    //                  (Worst: find the largest element, always select the first element as the pivot in a sorted array) O(N^2)
    public static int findKthLargestIII(int[] nums, int k){

        // We are finding the kth largest, convert it to the kth smallest
        k = nums.length - k;

        int left = 0, right = nums.length - 1;

        while (left < right){
            // Partition the array
            int pivot = partition(nums,left,right);

            // If the pivot is k, k is in the right position
            // If k is greater than the pivot, k is on the right side of the pivot, raise the left bar
            // If k is less than the pivot, k is on the left side of the pivot, lower the right bar
            if (pivot == k){
                break;
            } else if (pivot < k){
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return nums[k];
    }

    private static int partition(int[] nums, int left, int right){
        // Choose a pivot at random
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        // swap the pivot to the end of the array
        swap(nums,pivot,right);
        // i points to the position to be swapped to if we found a number which is smaller than the pivot
        int i = left;
        // Iterate through the array until the number before the pivot (last element)
        for (int j = left ; j < right; j++){
            // If we find any number which is less than the pivot, swap it to the i position, then increment i
            if (nums[j] < nums[right]){
                swap(nums,i,j);
                i++;
            }
        }
        // Swap the pivot back to i.
        // Numbers before i are all smaller than the pivot, numbers since i are all greater than the pivot. Therefore, i is the position where the pivot belongs to.
        swap(nums,i,right);
        return i;
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        System.out.println(findKthLargestIII(nums,2));
    }
}
