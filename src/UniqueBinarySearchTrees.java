/**
 * Created by jmding on 3/6/17.
 */
public class UniqueBinarySearchTrees {

    // idea: The total number of ways to construct a tree using numbers from 1 to i is the sum of all the combinations of left tree and right tree for all roots
    public static int numTrees(int n) {

        // Create a dynamic program array of length n+1. It is used to store the num of trees that store value 1 to i
        int dp[] = new int[n+1];

        // If there is nothing or just one number, there is only one way to construct a tree
        dp[0] = 1;
        dp[1] = 1;

        // Starting with 2 numbers (1,2)
        for (int i = 2; i <= n; i++){
            // Pick any number as the root
            for (int j = 1; j <= i; j++){
                // The total number of ways to construct a tree using numbers from 1 to i is the sum of all the combinations of left tree and right tree for all roots
                // (dp[num of numbers in the left tree] * dp[num of numbers in the right tree])
                // The actual numbers doesn't matter here. (The number of ways to construct a tree using (1,2,3) is the same as using (4,5,6). They are all dp[3);
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
