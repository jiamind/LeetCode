import java.util.Arrays;

/**
 * Created by jmding on 2/11/17.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
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
        return i+1;
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
