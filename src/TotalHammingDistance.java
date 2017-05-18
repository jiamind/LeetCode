/**
 * Created by udingji on 5/18/17.
 */
public class TotalHammingDistance {

    // Idea: For each bit of a integer, find out how many integers (k) in the array (of size n) has 1 on this bit
    // Then, this bit contributes k * (n-k) to the total hamming distance (compare each number which has 1 to each number which has 0)
    public int totalHammingDistance(int[] nums) {

        int total = 0;
        for (int i = 0; i < 32; i++){
            int bitCount = 0;
            for(int j = 0; j < nums.length; j++){
                bitCount += (nums[j] >> i) & 1;
            }
            total += bitCount * (nums.length - bitCount);
        }
        return total;
    }
}
