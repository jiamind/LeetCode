/**
 * Created by udingji on 5/17/17.
 */
public class HammingDistance {

    // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    //Given two integers x and y, calculate the Hamming distance.

    // Example: Input: x = 1, y = 4
    // Output: 2

    // Explanation:
    //         1   (0 0 0 1)
    //         4   (0 1 0 0)
    //                ↑   ↑

    //The above arrows point to positions where the corresponding bits are different.

    public static int hammingDistance(int x, int y) {
        int result = 0;
        int xor = x ^ y;

        while (xor > 0){
//            int rightShift = xor >> 1;
//            if (xor > rightShift << 1 )
//                result++;
//            xor >>= 1;

            // Toggle the right most bit which is 1 and everything after it
            // And (&) will clear all these bits, which means clear the right most '1' bit
            // Count how many times we clear the '1' bit before reaching 0
            xor &= (xor - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
