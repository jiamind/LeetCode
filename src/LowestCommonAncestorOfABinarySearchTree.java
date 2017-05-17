/**
 * Created by udingji on 5/16/17.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Starting from the root, determine whether p and q are on the same side of root by comparing their values
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = root.val > p.val ? root.left : root.right;
        return root;
    }
}
