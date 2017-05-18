/**
 * Created by udingji on 5/17/17.
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        if (nums == null || nums.length == 0 || m < 1)
            return 0;

        // Get the sum of all numbers in the array, and the maximum number in the array
        long sum = 0;
        int max = 0;

        for (int num : nums){
            sum += num;
            max = Math.max(max,num);
        }

        // If only one sub array is need, return the whole array
        if (m == 1)
            return (int) sum;

        // The minimized maximum sub array sum would fall in the range of maximum number in the array and the sum of all numbers in the array
        long left = max, right = sum;

        while (left <= right){
            long mid = left + (right - left) / 2;
            if (targetTooBig(nums,m,mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    // Try to cut the array into sub arrays that, the sum of each sub array won't exceed the target
    // We're trying to evenly distributed the sum of sub array as much as possible, so that we are minimizing the maximum sum of sub arrays
    private boolean targetTooBig(int[] nums, int m, long target){
        int count = 1, sum = 0;
        for (int num : nums){
            sum += num;
            if (sum > target){
                sum = num;
                count ++;
            }
            if (count > m){
                return false;
            }
        }
        return true;
    }
}
