import java.util.Stack;

/**
 * Created by udingji on 3/8/17.
 */
public class SymmetricTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recursive method
    public static boolean isSymmetric(TreeNode root) {

        // If root is null, the tree is symmetric
        return root == null || recurSymmetric(root.left, root.right);
    }

    private static boolean recurSymmetric(TreeNode left, TreeNode right){
        // If either of left node or right node is null, if they are both null, return true, else, return false
        if (left == null || right == null)
            return left == right;

        // If the left value is not equal to the right value, return false
        if (left.val != right.val)
            return false;

        // According to the definition of symmetric
        // The left node of the left node should be the same as the right node of the right node
        // The right node of the left node should be the same as the left node of the right node
        return recurSymmetric(left.left,right.right) && recurSymmetric(left.right,right.left);
    }


    //Iterative method
    public static boolean isSymmetric2(TreeNode root) {

        // If the root is null, the tree is symmetric
        if (root == null) return true;
        // If either of the left or right node is null, if they are both null, the tree is symmetric, otherwise is not
        if (root.left == null || root.right == null)
            return root.left == root.right;

        // The left and right node are both not null.
        // If the value of left node does not equal to the value of the right node, the tree is not symmetric
        if (root.left.val != root.right.val)
            return false;

        // Create a stack to store left and right nodes at each level
        Stack<TreeNode> stack = new Stack<>();
        // Push the left and the right node to the stack
        stack.push(root.left);
        stack.push(root.right);
        // While stack is not empty
        while (!stack.empty()){

            // Pop the right and left node we stored
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            // If either of the left node of the left or the right node of the right is null
            if (left.left == null || right.right == null){
                // If they are not both null, the tree is not symmetric
                // Otherwise they are both null, do nothing
                if (left.left != right.right)
                    return false;
            } else {
                // Both nodes are not null
                // If the left node value of the left does not equal to the right node value of the right, the tree is not symmetric
                if (left.left.val != right.right.val)
                    return false;
                // Otherwise, push the left and right nodes to the stack
                stack.push(left.left);
                stack.push(right.right);
            }

            // If either of the right node of the left or the left node of the right is null
            if (left.right == null || right.left == null){
                // If they are not both null, the tree is not symmetric
                // Otherwise they are both null, do nothing
                if (left.right != right.left)
                    return false;
            } else {
                // Both nodes are not null
                // If the right node value of the left does not equal to the left node value of the right, the tree is not symmetric
                if (left.right.val != right.left.val)
                    return false;
                // Otherwise, push the left and the right node to the stack
                stack.push(left.right);
                stack.push(right.left);

            }
        }
        // If we finish comparison and did not return false, the tree is symmetric
        return true;
    }

}
