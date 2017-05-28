import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by udingji on 5/17/17.
 */
public class SumOfLeftLeaves {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Find the sum of all left leaves in a given binary tree.

    // Example:
    //          3
    //         / \
    //        9  20
    //          /  \
    //        15   7

    // There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


    // Recursive
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        // If left node is not null
        if (root.left != null){
            // If the left node is a leaf, add the value of the left node to the sum
            // Otherwise, recursively call the method on the left node
            if (root.left.left == null && root.left.right == null){
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        // Recursively call the method on the right node
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    // Iterative
    public int sumOfLeftLeavesII(TreeNode root) {
        int sum = 0;

        if (root == null)
            return sum;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}
