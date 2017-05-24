import java.util.Stack;

/**
 * Created by udingji on 3/7/17.
 */
public class ValidateBinarySearchTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Use in order traversal. For a BST, the value of the current node must be greater than the value of previous node
    // Create a global variable to store the previous tree node
    public static TreeNode pre = null;

    public static boolean isValidBST(TreeNode root) {
        return validate(root);
    }

    // Recursive
    private static boolean validate(TreeNode treeNode){
        // If the current tree node is null, it is valid
        if (treeNode == null) return true;
        // Call validate on the left sub tree. If it is not valid, return false
        if (!validate(treeNode.left)) return false;
        // If the value of previous tree node is greater than the current node, return false
        if (pre != null && pre.val >= treeNode.val) return false;
        // Set the pre node to the current node
        pre = treeNode;
        // Validate the right sub tree.
        return validate(treeNode.right);
    }

    // Iterative
    public static boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (prev != null && prev.val >= root.val)
                return false;

            prev = root;

            root = root.right;

        }

        return true;
    }


    // Idea: Use max and min long value to restrict the range of each node value
    public static boolean isValidBST3(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode treeNode, long min, long max){
        // If the current tree node is null, it's valid
        if (treeNode == null) return true;
        // The value of the current tree node should fall in the range
        if (treeNode.val <= min || treeNode.val >= max) return false;
        // Check the left and right node to see if they fall in the range
        // For the left node, the max is now the value of the current node
        // For the right node, the min is now the value of the current node
        return validate(treeNode.left,min,treeNode.val) && validate(treeNode.right,treeNode.val,max);
    }
}
