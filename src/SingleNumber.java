/**
 * Created by jmding on 5/3/17.
 */
public class SingleNumber {

    // Idea: assume x is an integer. x^x = 0, 0 ^ x = x;
    // XOR each number in the array. The result will be the number which appears only once in the array
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,3,1,5};
        System.out.println(singleNumber(nums));
    }
}
