package test;

import java.util.HashSet;

/**
 * Created by udingji on 2/16/17.
 */
public class FindMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int i = 0;
        while (i < nums.length){
            if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) i++;
            else if (nums[nums[i]-1] != nums[i]) swap(nums,i,nums[i]-1);
            else i++;
        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i+1;

    }


    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
