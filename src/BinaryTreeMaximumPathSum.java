/**
 * Created by udingji on 3/28/17.
 */
public class BinaryTreeMaximumPathSum {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Use DFS to traverse the tree. Treat each node as the highest node in the path.
    // Find the maximum sum of node values in the left and right sub tree. Update the maxSum value we found so far

    // Initialize the maxSum so far as the min integer value
    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        // If root is null, return 0
        if (root == null)
            return 0;
        // Call the recursive method on root
        recurMaxPathSum(root);
        return maxSum;
    }

    private static int recurMaxPathSum(TreeNode node){
        // If we reach the child of leaf, return 0 (the value of null node is 0)
        if (node == null)
            return 0;
        // Recursively find the max path sum of the left sub tree
        // If the sum is a negative number, we don't go through that path
        int leftSum = Math.max(0,recurMaxPathSum(node.left));
        // Recursively find the max path sum of the right sub tree
        // If the sum is a negative number, we don't go through that path
        int rightSum = Math.max(0,recurMaxPathSum(node.right));
        // Update the maxSum we found so far
        maxSum = Math.max(maxSum,leftSum+rightSum+node.val);
        // Now this path becomes a sub tree of the node's parent node.
        // Choose the path which has the maximum sum value and return that maximum sum value
        return Math.max(leftSum,rightSum) + node.val;
    }
}
