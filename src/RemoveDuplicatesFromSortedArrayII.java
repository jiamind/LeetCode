/**
 * Created by udingji on 5/16/17.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        // i: the next index to write to
        int i = 0;

        // Iterate through each number in the array
        for (int num : nums){
            // If we have written less than 2 numbers, just write it
            // or if the number to write is greater than the second number before it's writing index,
            // this number is not a duplicate. Write it to the index
            if (i < 2 || num > nums[i-2])
                nums[i++] = num;
        }

        return i;
    }
}
