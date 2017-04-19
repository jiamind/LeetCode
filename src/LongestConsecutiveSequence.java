import java.util.HashMap;

/**
 * Created by jmding on 4/19/17.
 */
public class LongestConsecutiveSequence {


    public static int longestConsecutive(int[] nums) {
        int res = 0;
        // Create a hashmap to store each num in the array, as well as the length of consecutive sequence at that number
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Iterate through each num in the array
        for (int n : nums) {
            // If the number is not in the hashmap, add it
            if (!map.containsKey(n)) {
                // Check if there are numbers adjacent to its left and right. If so, get their length of consecutive sequence
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // The length of consecutive sequence at this number is left plus right plus 1
                int sum = left + right + 1;
                // Put this number and its length into the hashmap
                map.put(n, sum);

                // Update the max length of consecutive sequence
                res = Math.max(res, sum);

                // Update the length of consecutive sequence at both edges of the current sequence
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // Otherwise it's a duplicate number, skip it
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,6,7,8,5};
        System.out.println(longestConsecutive(nums));
    }
}
