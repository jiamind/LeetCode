/**
 * Created by udingji on 3/14/17.
 */
public class MinimumDepthofBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        return (leftHeight == 0 || rightHeight == 0) ?  1 + leftHeight + rightHeight : 1 + Math.min(leftHeight, rightHeight);
    }

}
