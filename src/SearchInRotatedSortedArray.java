/**
 * Created by udingji on 2/16/17.
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;

        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            // If the number at left is less than the number at mid, it means mid is to the left of the pivot, or it's the pivot
            if (nums[left] < nums[mid]){
                if (target == nums[left]) return left;
                if (target == nums[mid]) return mid;
                // If the target is within left and mid, bring the right down to mid - 1
                if (target > nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    // The target is greater than the mid, bring the left up to mid + 1
                    left = mid + 1;
                }
            }else {
                // the mid is to the right of the pivot
                if (target == nums[mid]) return mid;
                if (target == nums[right]) return right;
                // If the target is within left and mid, bring the left up to mid + 1
                if (target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                }else {
                    // The target is less than the mid, bring the right down to mid - 1
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target? left : -1;
    }


}
