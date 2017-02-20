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
            int mid = (left + right) / 2;
            // If the target is greater than the number at mid, bring up the left pointer to mid + 1
            if (target > nums[mid]){
                left = mid + 1;
            }else {
                // The target os less than or equal to the number at mid, bring down the right pointer to mids
                right = mid;
            }
        }

        return left;
    }


//    public static int[] searchRange2(int[] A, int target) {
//        int start = firstGreaterEqual(A, target);
//        if (start == A.length || A[start] != target) {
//            return new int[]{-1, -1};
//        }
//        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
//    }
//
//    //find the first number that is greater than or equal to target.
//    //could return A.length if target is greater than A[A.length-1].
//    //actually this is the same as lower_bound in C++ STL.
//    private static int firstGreaterEqual(int[] A, int target) {
//        int low = 0, high = A.length;
//        while (low < high) {
//            int mid = low + ((high - low) >> 1);
//            //low <= mid < high
//            if (A[mid] < target) {
//                low = mid + 1;
//            } else {
//                //should not be mid-1 when A[mid]==target.
//                //could be mid even if A[mid]>target because mid<high.
//                high = mid;
//            }
//        }
//        return low;
//    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;
        int[] result = searchRange(nums, target);
        for (int i : result){
            System.out.print(i + ", ");
        }
    }
}
