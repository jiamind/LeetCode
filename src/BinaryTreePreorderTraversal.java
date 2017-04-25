import java.util.*;

/**
 * Created by jmding on 4/24/17.
 */
public class BinaryTreePreorderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: push node to a stack
    public List<Integer> preorderTraversal(TreeNode root) {

        // Create a list to store preordered result
        List<Integer> result = new ArrayList<>();

        // If the root is null, return the empty result list
        if (root == null)
            return result;

        // Create a stack to store untraversed node
        Stack<TreeNode> stack  = new Stack<>();

        // Push the root to the stack
        stack.push(root);

        // While the stack is not empty
        while (!stack.empty()){

            // Pop the top node in the stack
            TreeNode node = stack.pop();
            // Add the node value to the result list
            result.add(node.val);

            // If there is a right child, push the right child to the stack
            // Note: we push right child first, then the left child to make sure that left child is always processed first
            // Therefore, queue won't work here
            if (node.right != null){
                stack.push(node.right);
            }

            // If there is a left child, push the left child to the stack
            if (node.left != null){
                stack.push(node.left);
            }
        }

        // Return the result list
        return result;
    }
}
