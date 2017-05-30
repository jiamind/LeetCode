/**
 * Created by jmding on 5/27/17.
 */
public class FindPeakElement {

    // A peak element is an element that is greater than its neighbors.

    // Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

    // The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    // You may imagine that num[-1] = num[n] = -∞.

    // For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // Recursive
    private int helper(int[] nums, int left, int right){
        if (left == right)
            return left;

        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid+1]){
            return helper(nums,left, mid);
        } else {
            return helper(nums, mid+1, right);
        }
    }

    // Iterative
    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
