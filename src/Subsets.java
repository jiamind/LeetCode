import java.util.ArrayList;
import java.util.List;

/**
 * Created by udingji on 5/14/17.
 */
public class Subsets {

    // Given a set of distinct integers, nums, return all possible subsets.

    // Note: The solution set must not contain duplicate subsets.

    // For example,
    // If nums = [1,2,3], a solution is:

    //   [
    //    [3],
    //    [1],
    //    [2],
    //    [1,2,3],
    //    [1,3],
    //    [2,3],
    //    [1,2],
    //    []
    //   ]

    // https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start){
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(result,subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
