/**
 * Created by udingji on 5/17/17.
 */
public class HammingDistance {

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
