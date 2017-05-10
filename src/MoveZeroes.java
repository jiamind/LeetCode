/**
 * Created by udingji on 5/10/17.
 */
public class MoveZeroes {

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
