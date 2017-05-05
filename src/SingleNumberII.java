/**
 * Created by jmding on 5/3/17.
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, reset = 0;

        for (int num : nums){
            x1 ^= x2 & num;
            x2 ^= num;
            reset = ~(x1 & x2);
            x1 &= reset;
            x2 &= reset;
        }

        return x2;
    }
}
