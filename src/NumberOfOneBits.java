/**
 * Created by jmding on 5/25/17.
 */
public class NumberOfOneBits {

    // Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

    // For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

    public int hammingWeight(int n) {
        int count = 0;
        // Treat n as unsigned (therefore cannot use n > 0)
        while (n != 0){
            n &= (n-1);
            count++;
        }
        return count;
    }
}
