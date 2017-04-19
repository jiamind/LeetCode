
/**
 * Created by udingji on 2/16/17.
 */
public class FirstMissingPositive {

    // Idea: number at index i should store i+1
    // If not, swap it to the right position
    public static int firstMissingPositive(int[] nums) {
        // Return 1 (the first positive integer) if the array is null, or the length of the array is 0
        if (nums == null || nums.length == 0) return 1;

        // Create a pointer i points to the start of the array
        int i = 0;
        // Iterate through the array
        while (i < nums.length){
            // If the number at the current index is less than or equal to 0, or the number is greater than the length of the array,
            // or the number is at the right index (equals index + 1)
            // Move the pointer forward
            if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) i++;
            // If the number - 1 is not equal to i, swap the number to its right position
            else if (nums[nums[i]-1] != nums[i]) swap(nums,i,nums[i]-1);
            // Otherwise, move the pointer forward
            else i++;
        }

        // Reset the pointer
        i = 0;
        // Iterate through the re-arranged array, until we reach the first number which is not equal to its index plus 1
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
