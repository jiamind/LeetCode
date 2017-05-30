import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 2/20/17.
 */
public class Permutations {

    // Given a collection of distinct numbers, return all possible permutations.

    // For example,
    // [1,2,3] have the following permutations:
    // [
    //   [1,2,3],
    //   [1,3,2],
    //   [2,1,3],
    //   [2,3,1],
    //   [3,1,2],
    //   [3,2,1]
    //  ]

    public static List<List<Integer>> permute(int[] nums) {

        // Create an empty result
        List<List<Integer>> result = new ArrayList<>();
        // If nums is null or the length of nums is 0, return empty result
        if (nums == null || nums.length == 0) return result;

        // Recursively backtrack
        backtrack(nums,result,new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list){

        // If the size of the list equals the length of nums, it means all the numbers are in the list.
        // Add a copy of the list to the result (Since we will remove the last element of list later)
        if (list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // Iterate through each elements
        for (int i = 0; i < nums.length; i++){
            // Skip any duplicate numbers
            if (list.contains(nums[i])) continue;
            // Add the number to the list
            list.add(nums[i]);
            // Call recursive method
            backtrack(nums,result,list);
            // Remove the last added element in the list, be ready to add the next element
            list.remove(list.size()-1);
        }
    }

}
