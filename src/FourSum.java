package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 2/6/17.
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int left, right;
        Integer sum;
        for (int i = 0;i < nums.length - 3;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1;j < nums.length - 2; j++){
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                left = j + 1;
                right = nums.length-1;
                while (left < right){
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                    }else if (sum < target){
                        while (left < right && nums[left] == nums[left+1]) left++;
                        left++;
                    }else {
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
