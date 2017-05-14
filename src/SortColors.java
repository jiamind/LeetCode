/**
 * Created by udingji on 5/14/17.
 */
public class SortColors {


    int RED = 0;
    int WHITE = 1;
    int BLUE = 2;
    public void sortColors(int[] nums) {
        int redPointer = 0;
        int numWhite = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == RED){
                nums[redPointer++] = RED;
            } else if (nums[i] == WHITE){
                numWhite ++;
            }
        }
        for (int i = 0; i < numWhite; i++){
            nums[redPointer++] = WHITE;
        }
        while (redPointer < nums.length){
            nums[redPointer++] = BLUE;
        }
    }

    // Idea: swap red colors to the front, swap blue colors to the end. White colors are left in the middle
    public void sortColorsII(int[] nums) {
        int redPointer = 0, bluePointer = nums.length-1;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] == BLUE && i < bluePointer)
                swap(nums, i, bluePointer--);
            while (nums[i] == RED && i > redPointer++)
                swap(nums, i, redPointer++);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tempA = nums[a];
        nums[a] = nums[b];
        nums[b] = tempA;
    }
}
