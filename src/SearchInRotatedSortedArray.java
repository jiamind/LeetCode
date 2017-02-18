package test;

/**
 * Created by udingji on 2/16/17.
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return -1;
//        if (nums.length == 1 && nums[0] == target) return 0;
//
//        int head = nums[0], tail = nums[nums.length-1];
//        if (target < head && target > tail) return -1;
//        if (target >= head){
//            for (int i = 0; i < nums.length; i++)
//                if (nums[i] == target) return i;
//        }else {
//            for (int i = nums.length - 1; i >= 0; i--)
//                if (nums[i] == target) return i;
//        }
//        return -1;


        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;

        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]){
                if (target == nums[left]) return left;
                if (target == nums[mid]) return mid;
                if (target > nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target == nums[mid]) return mid;
                if (target == nums[right]) return right;
                if (target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target? left : -1;
    }


}
