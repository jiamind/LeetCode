import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 5/15/17.
 */
public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        backtrack(result,new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int index){
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1])
                continue;
            subset.add(nums[i]);
            backtrack(result,subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
