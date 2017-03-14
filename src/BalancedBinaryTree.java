/**
 * Created by udingji on 3/14/17.
 */
public class BalancedBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        // If the root is null, this tree is balanced. Return true
        if (root == null)
            return true;

        // Find the height of the left sub tree and right sub tree
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // If the height of the left sub tree and right sub tree differs more than 1,
        // or the left sub tree is not balanced, or the right sub tree is not balanced
        // This tree is not balanced, return false
        if (Math.abs(leftHeight-rightHeight) > 1 || !isBalanced(root.left) || !isBalanced(root.right))
            return false;

        return true;
    }

    private static int height(TreeNode node){
        // Idea: Count from the bottom of a tree
        // If we reach the bottom of a tree, the height is 0
        if (node == null)
            return 0;

        // Add 1 to the max height of left and right sub tree while we count up to the top (root)
        return 1 + Math.max(height(node.left),height(node.right));
    }
}
