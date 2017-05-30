/**
 * Created by udingji on 5/18/17.
 */
public class DiameterOfBinaryTree {

    // Given a binary tree, you need to compute the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    // Example:
    // Given a binary tree
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    // Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    // Note: The length of path between two nodes is represented by the number of edges between them.

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return maxDepth;
    }

    private int maxDepth(TreeNode root){
        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        maxDepth = Math.max(maxDepth,leftMax + rightMax);

        return Math.max(leftMax,rightMax) + 1;
    }
}
