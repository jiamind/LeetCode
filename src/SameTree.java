/**
 * Created by udingji on 3/7/17.
 */
public class SameTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // If both tree nodes are null, they are the same
        if (p == null && q == null) return true;
        // If either of the tree nodes is null while the other is not, they are not the same
        if (p == null || q == null) return false;
        // Both tree nodes are not null. If their values are not equal, they are not the same
        if (p.val != q.val) return false;
        // Check if their left node and right node are the same
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
