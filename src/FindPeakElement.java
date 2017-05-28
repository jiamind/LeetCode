/**
 * Created by jmding on 5/27/17.
 */
public class FindPeakElement {

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
