
/**
 * Created by udingji on 2/16/17.
 */
public class SearchInsertPosition {


    // Idea: Search for the number that is greater or equal to the target
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1){
            if (nums[0] == target || nums[0] > target) return 0;
            else return 1;
        }

        int left = 0, right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,8};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
}
