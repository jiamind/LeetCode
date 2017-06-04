/**
 * Created by udingji on 5/17/17.
 */
public class SplitArrayLargestSum {

    // Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

    // Note:
    // If n is the length of array, assume the following constraints are satisfied:

    //       1 ≤ n ≤ 1000
    //       1 ≤ m ≤ min(50, n)

    //Examples:
    // Input:
    // nums = [7,2,5,10,8]
    // m = 2
    // Output:
    //        18

    //Explanation:
    //There are four ways to split nums into two subarrays.
    //The best way is to split it into [7,2,5] and [10,8],
    //where the largest sum among the two subarrays is only 18.

    public static int splitArray(int[] nums, int m) {

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
    private static boolean targetTooBig(int[] nums, int m, long target){
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

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums,2));
    }
}
