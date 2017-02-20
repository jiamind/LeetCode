import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 2/6/17.
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Return an empty list if nums is null or the length of the nums is less than 4
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);
        int left, right;
        Integer sum;
        for (int i = 0;i < nums.length - 3;i++){
            // Skip if the number at this i is the same as the previous one
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1;j < nums.length - 2; j++){
                // Skip if the number at this j is the same as the previous one
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                // Set left to be the right of j
                left = j + 1;
                // Set right to be all the way to the right
                right = nums.length-1;
                while (left < right){
                    // Calculate the sum of the four numbers
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    // If sum is equal to the target
                    if (sum == target){
                        // Add the four numbers to the result list
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        // Skip the next left if it is the same as the previous one
                        while (left < right && nums[left] == nums[left+1]) left++;
                        // Move left pointer to the left one more time, so the number is different from the previous one
                        left++;
                        // Skip the next right if it is the same as the previous one
                        while (left < right && nums[right] == nums[right-1]) right--;
                        // Move the right pointer to the right one more time, so the number is different from the previous one
                        right--;
                    }else if (sum < target){
                        // If the sum is smaller than the target, the left pointer is too small, move it to the right
                        // Skip any duplicate
                        while (left < right && nums[left] == nums[left+1]) left++;
                        left++;
                    }else {
                        // If the sum is greater than the target, the right pointer is too large, move it to the left
                        // Skip any duplicate
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> result = fourSum(nums,target);
        System.out.println("[");
        for (List<Integer> list : result){
            System.out.print("[");
            for (Integer i : list){
                System.out.print(i + ", ");
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}
