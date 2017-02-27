import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 2/26/17.
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {

        if (n == 0 || k == 0) return "";

        StringBuilder result = new StringBuilder();

        List<Integer> array = new ArrayList<>();
        // The maximum number of times the number will repeat at the current scanning index.
        // For instance, any number will repeat n!/n times at the first index.
        // The position at the array
        int num = 1, pos = 0;
        for (int i = 1; i <= n; i++) {
            num *= i;
            array.add(i);
        }
        // If k is greater than the total possible number of permutations, return empty string since it's invalid
        if (k > num) return "";
        for (int i = n; i > 1 ;i--){
            // Update the number of times the number will repeat at the current index
            num /= i;
            // The position of the number in the array is k / how many times number repeats
            pos = k / num;
            // The remainder becomes the new k at the nex index
            k = k % num;
            // However, if k is 0, which means it's still at the end of the current repeating number, position should be adjusted (-1)
            // and the next k should be the same as the current num
            if (k == 0){
                pos--;
                k = num;
            }
            // Append the number at array pos
            result.append(array.get(pos));
            // Remove that number since it won't appear in the following indexes
            array.remove(pos);
        }
        // Append the last index (the last and the only element in the array)
        result.append(array.get(0));
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 25;
        System.out.println(getPermutation(n,k));
    }
}
