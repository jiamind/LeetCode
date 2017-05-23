/**
 * Created by jmding on 5/23/17.
 */
public class RearrangeAnArrayInMaximumMinimumForm {

    public static void rearrange(int[] nums){
        int maxIndex = nums.length - 1, minIndex = 0;
        int maxElement = nums[nums.length-1] + 1;

        for (int i = 0; i < nums.length; i++){
            // We put max number at even index
            // any number % maxElement will be its original number
            // any number / maxElement will be its new number
            if (i % 2 == 0){
                nums[i] += (nums[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                nums[i] += (nums[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] /= maxElement;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};

        rearrange(nums);

        for (int n : nums)
            System.out.print(n + " ");
    }
}
