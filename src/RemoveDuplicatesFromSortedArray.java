import java.util.Arrays;

/**
 * Created by jmding on 2/11/17.
 */
public class RemoveDuplicatesFromSortedArray {

    // Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    // Do not allocate extra space for another array, you must do this in place with constant memory.

    // For example,
    // Given input array nums = [1,1,2],
    // Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

    public static int removeDuplicates(int[] nums) {
        // If the list is null, return size 0
        if (nums == null) return 0;

        int i = 0;

        for (int num : nums){
            // Copy the number to the next available slot if
            // 1) this is the first number (index < 1);
            // 2) its value is greater than the number before the next available slot
            if (i < 1 || num > nums[i-1])
                nums[i++] = num;
        }

        return i;
    }

    public static int[] removeDuplicates2(int[] nums) {
        if (nums == null) return null;
        if (nums.length < 2) return nums;
        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums,0,i+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,5,5,6,6,7,8,8,8,9};
//        System.out.println(removeDuplicates(nums));
        int[] result = removeDuplicates2(nums);
        for (int i : result){
            System.out.print(i + ", ");
        }
    }
}
