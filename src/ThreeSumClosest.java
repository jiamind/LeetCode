package test;

import java.util.Arrays;

/**
 * Created by udingji on 2/6/17.
 */
public class ThreeSumClosest {


    public static int threeSumClosest(int[] nums, int target) {

        if (nums.length <= 3){
            int sum = 0;
            for (int n : nums){
                sum += n;
            }
            return sum;
        }

        Arrays.sort(nums);
        int index = 0, left = index + 1, right = nums.length-1;
        int sum = 0;
        Integer closest = null;
        while (index < nums.length-2) {
            while (left < right) {
                sum = nums[index] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (closest == null) {
                    closest = sum;
                } else {
                    if (Math.abs(closest - target) > Math.abs(sum - target)) {
                        closest = sum;
                    }
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            index++;
            left = index + 1;
            right = nums.length-1;
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
