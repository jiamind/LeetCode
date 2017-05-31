/**
 * Created by udingji on 2/16/17.
 */
public class SearchForARange {

    // Idea: find the first numbers that greater or equal to target and target + 1
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        if (nums.length == 1 && nums[0] == target) return new int[]{0,0};

        int start = findFirstGreaterOrEqual(nums,target);
        if (start >= nums.length || nums[start] != target) return new int[]{-1,-1};

        return new int[]{start,findFirstGreaterOrEqual(nums,target+1)-1};
    }

    private static int findFirstGreaterOrEqual(int[] nums, int target){
        int left = 0, right = nums.length;

        while (left < right){
            int mid = left + (right - left) / 2;

            if (target > nums[mid]){
                left = mid + 1;
            }else {
                // The target os less than or equal to the number at mid, bring down the right pointer to mid
                right = mid;
            }
        }
        // Left will be equal or greater than the number, since left = mid + 1
        return left;
    }



    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;
        int[] result = searchRange(nums, target);
        for (int i : result){
            System.out.print(i + ", ");
        }
    }
}
