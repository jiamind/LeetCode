/**
 * Created by jmding on 5/25/17.
 */
public class FindMinimumInRotatedSortedArray {

    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    // (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    // Find the minimum element.

    // You may assume no duplicate exists in the array.

    public static int findMin(int[] nums) {
        if (nums == null)
            return 0;

        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findMin(nums));
    }
}
