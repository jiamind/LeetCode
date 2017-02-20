/**
 * Created by udingji on 2/15/17.
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2) return;

        // Scan from the right to the left, find the first element that is less than its previous value
        // 4 5 6 7 2 1
        //   p
        int p = 0;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] < nums[i+1]){
                p = i;
                break;
            }
        }

        // Scan from right to left, find the first element that is greater than p
        // 4 5 6 7 2 1
        //     q
        int q = 0;
        for (int i = nums.length - 1; i > p; i--){
            if (nums[i] > nums[p]){
                q = i;
                break;
            }
        }

        // If it's the last permutation, reverse the whole list
        // Otherwsie, swap p and q, reverse from p+1 to the end of the list
        if (p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
        }else {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            reverse(nums,p+1,nums.length - 1);
        }

    }

    private static void reverse(int[] arr, int left, int right){
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i : nums)
            System.out.print(i + ", ");
    }
}
