/**
 * Created by udingji on 5/15/17.
 */
public class IncreasingTripletSubsequence {

    // Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

    // Formally the function should:
    // Return true if there exists i, j, k
    // such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    // Your algorithm should run in O(n) time complexity and O(1) space complexity.

    // Examples:
    // Given [1, 2, 3, 4, 5],
    // return true.

    // Given [5, 4, 3, 2, 1],
    // return false.

    // Create two integers to hold the i and j

    public boolean increasingTriplet(int[] nums) {

        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;

        // If we find a number which is smaller than i, update i
        // If we find a number which is greater than i but smaller than j, update j
        // Otherwise, the number is greater than both i and j, we found the three increasing numbers
        for (int num : nums){
            if (num < i){
                i = num;
            } else if (num < j){
                j = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
