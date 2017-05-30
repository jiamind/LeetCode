import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by jmding on 1/22/17.
 */
public class TwoSum {

    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    // You may assume that each input would have exactly one solution, and you may not use the same element twice.

    // Idea: Store the complement (target - number) and the index of each number in a hashmap
    // For each later numbers, if the number is in the hashmap as a complement,
    // we found the pair of numbers that sum up to the target
    public static int[] twoSum(int[] nums, int target) {
        // Create the hashmap to store the complement and the index of each number
        HashMap hashMap = new HashMap();
        // Iterate through each number in the list
        for (int i = 0; i < nums.length; i++) {
            // Get the number at index i
            int num = nums[i];
            // If any previous number needs this number as a complement
            // We found the pair
            if (hashMap.containsKey(num)) {
                // Sort base on index and then return
                return (Integer) hashMap.get(num) > i ? new int[]{i, (Integer) hashMap.get(num)} : new int[]{(Integer) hashMap.get(num), i};
            }
            // Otherwise, put the complement of this number and its index into the hashmap
            if (!hashMap.containsKey(target - num)) {
                hashMap.put(target - num, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int[] r = twoSum(nums, -8);
        if (r != null && r.length > 1) {
            System.out.println("[" + r[0] + "," + r[1] + "]");
        } else {
            System.out.println("not found");
        }
    }
}
