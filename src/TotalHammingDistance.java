/**
 * Created by udingji on 5/18/17.
 */
public class TotalHammingDistance {

    // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    // Now your job is to find the total Hamming distance between all pairs of the given numbers.

    // Example:
    // Input: 4, 14, 2
    // Output: 6

    // Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
    // showing the four bits relevant in this case). So the answer will be:
    // HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.


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
