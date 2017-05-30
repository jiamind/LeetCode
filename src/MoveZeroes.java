/**
 * Created by udingji on 5/10/17.
 */
public class MoveZeroes {

    // Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    // For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

    // Note:
    // You must do this in-place without making a copy of the array.
    // Minimize the total number of operations.

    // Idea: Use two pointers, p1 and p2. p2 skips any 0 in the array, insert the value at p2 to p1.
    // Then mark any number after p1 as 0
    public static void moveZeroes(int[] nums) {

        int p1 = 0, p2 = 0;

        while(p2 < nums.length){
            if (nums[p2] != 0){
                nums[p1] = nums[p2];
                p1++;
                p2++;
            } else {
                p2++;
            }
        }

        while (p1 < nums.length){
            nums[p1] = 0;
            p1++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int n : nums)
            System.out.println(n);
    }
}
