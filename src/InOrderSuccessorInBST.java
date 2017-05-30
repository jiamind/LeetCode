/**
 * Created by udingji on 5/13/17.
 */
public class InOrderSuccessorInBST {

    // Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

    // Note: If the given node has no in-order successor in the tree, return null.

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Iterative
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null){
            if (p.val < root.val){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }


    // Recursive
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (p.val >= root.val){
            return inorderSuccessorII(root.right,p);
        } else {
            TreeNode left = inorderSuccessorII(root.left,p);
            return left == null ? root : left;
        }
    }
}
