/**
 * Created by udingji on 5/13/17.
 */
public class InOrderSuccessorInBST {

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
