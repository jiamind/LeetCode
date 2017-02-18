package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 2/16/17.
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start){
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++){
                if (i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                backtrack(result,tempList,candidates,remain-candidates[i],i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates,target);
        System.out.println("done");
    }
}
