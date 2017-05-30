/**
 * Created by udingji on 5/14/17.
 */
public class SortColors {


    int RED = 0;
    int WHITE = 1;
    int BLUE = 2;

    // Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    // Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    // Note:
    // You are not suppose to use the library's sort function for this problem.


    // Idea: swap red colors to the front, swap blue colors to the end. White colors are left in the middle
    public void sortColors(int[] nums) {
        int redPointer = 0, bluePointer = nums.length-1;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] == BLUE && i < bluePointer)
                swap(nums, i, bluePointer--);
            while (nums[i] == RED && i > redPointer)
                swap(nums, i, redPointer++);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tempA = nums[a];
        nums[a] = nums[b];
        nums[b] = tempA;
    }
}
