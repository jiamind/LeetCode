/**
 * Created by jmding on 5/25/17.
 */
public class FindMinimumInRotatedSortedArray {

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
