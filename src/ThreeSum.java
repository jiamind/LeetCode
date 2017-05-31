import java.util.*;

/**
 * Created by jmding on 2/5/17.
 */
public class ThreeSum {

    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    // Note: The solution set must not contain duplicate triplets.

    //For example, given array S = [-1, 0, 1, 2, -1, -4],

    //A solution set is:
    // [
    //   [-1, 0, 1],
    //   [-1, -1, 2]
    // ]

    // Idea: Use three pointers, index, left and right.
    // The index pointer iterate through the array (till the two elements before the end, since the last two elements are for the left and right pointer)
    // The left pointer starts at the position to the right of index, right pointer starts at the end of the array
    // For each combination of the three pointers, calculate the sum.
    // If sum > 0, move the right pointer to the left while skip any duplicate numbers. If sum < 0, move the left pointer to the right while skip any duplicate numbers.
    // If sum = 0, add the combination to the result list. Move the left and right pointer towards each other while skip any duplicates
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // If the length of nums is less than 3, return empty result
        if (nums.length < 3) return result;
        // If the length of nums is 3, simply add them up to see if the sum equals 0
        if (nums.length == 3){
            if(nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                result.add(list);
                return result;
            }
        }

        // Sort the array
        Arrays.sort(nums);
        // index->    left->               <-right
        //   1          2    3   4   5   6     7
        int index = 0, left = 1, right = nums.length - 1;
        while (index < nums.length - 2){
            while (left<right){
                // Calculate the sum
                int sum = nums[left] + nums[index] + nums[right];
                // If the sum is less than 0, left is too small, increment left
                if (sum < 0){
                    left++;
                    // If the sum is greater than 0, right is too big, decrement right
                }else if (sum > 0){
                    right--;
                }else{
                    // If the sum is 0, add numbers to the result list
                    result.add(Arrays.asList(nums[index],nums[left],nums[right]));
                    // Skip any duplicate if the next number is the same as the previous one
                    while (left < right && nums[left] == nums[left+1]) left++;
                    // Move left pointer to the next number which is different from the previous number
                    left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    // Move the right pointer to the next number which is different from the previous number
                    right--;
                }
            }
            // Skip any duplicate if the next index is the same as the previous one
            while (index < nums.length - 1 && nums[index] == nums[index+1]) index++;
            // Move the index pointer to the next one which is different from the previous number
            index++;
            // Set left to be the right of index
            left = index+1;
            // Set right to be all the way right
            right = nums.length -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,-1,-1,0,1,1,2,2,2};
        List<List<Integer>> result = threeSum(nums);
        if (result != null){
            System.out.println("[");
            for (List<Integer> list: result){
                System.out.print("[");
                for (int n : list){
                    System.out.print(n + ", ");
                }
                System.out.println("],");
            }
            System.out.println("]");
        }
    }
}
