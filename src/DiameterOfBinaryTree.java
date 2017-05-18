/**
 * Created by udingji on 5/18/17.
 */
public class DiameterOfBinaryTree {

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
