import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 2/16/17.
 */
public class CombinationSum {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start){
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<Integer>(temp));
        else {
            for (int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                backtrack(result,temp,candidates,remain-candidates[i],i);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        // If the distance to the target is less than 0, we exceeds the target. Return.
        if(remain < 0) return;
        // If the distance to the target is 0, means we reach the target. Add the temp list to the result list.
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        // If there is still distance to the target
        else{
            // Iterate through the numbers starting from the current position to the end
            for(int i = start; i < nums.length; i++){
                // Add the number to the temp list
                tempList.add(nums[i]);
                // Call backtrack method. Update the remain distance
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                // Remove the number we just added
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum2(candidates,target);
        System.out.println("done");
    }
}
