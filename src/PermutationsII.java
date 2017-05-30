import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jmding on 2/20/17.
 */
public class PermutationsII {

    // Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    // For example,
    // [1,1,2] have the following unique permutations:
    //   [
    //    [1,1,2],
    //    [1,2,1],
    //    [2,1,1]
    //   ]

    public static List<List<Integer>> permuteUnique(int[] nums) {

        // Create an empty result
        List<List<Integer>> result = new ArrayList<>();
        // If nums is null or the length of nums is 0, return the empty result
        if (nums == null || nums.length == 0) return result;
        // Need to sort the array, since we will need to skip adjacent duplicate numbers
        Arrays.sort(nums);
        // Call recursive backtrack
        backtrack(nums,result,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }


    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used){
        // If the list size equals the length of nums, it means we have all the numbers in the list
        // Add a copy of the list to the result list (Since we will remove the last element from the list later)
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        // Iterate through the nums
        for (int i = 0; i < nums.length; i++){
            // If the number is already used, or the number is not used but it's same as the previous number, skip it
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            // Add the number to the list
            list.add(nums[i]);
            // Mark the number as used
            used[i] = true;
            // Call recursive backtrack
            backtrack(nums,result,list,used);
            // Remove the last element (we just added) from the list
            list.remove(list.size() - 1);
            // Mark that number as not used
            used[i] = false;
        }
    }
}
