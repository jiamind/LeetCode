/**
 * Created by jmding on 5/25/17.
 */
public class NumberOfOneBits {

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
