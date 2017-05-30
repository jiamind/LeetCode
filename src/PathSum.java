import java.util.Stack;

/**
 * Created by udingji on 3/14/17.
 */
public class PathSum {

    // Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    // For example:
    // Given the below binary tree and sum = 22,
    //        5
    //       / \
    //      4   8
    //     /   / \
    //   11  13  4
    //  /  \      \
    // 7    2      1
    // return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: search from the top (root) to the bottom (leaves). Subtract the current node value from the sum
    // If the current node is a leave and sum - current node value is 0, we found a path
    public static boolean hasPathSum(TreeNode root, int sum) {

        // If the current node is null. return false
        if (root == null)
            return false;

        // If the current node is the leave and sum minus current node value is 0
        // We found a path, return true
        if (root.left == null && root.right == null && sum - root.val == 0)
            return  true;

        // Recursive call on the left and right sub tree
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, node = root;
        int pathSum = 0;

        while (node != null || !stack.empty()){
            // Push left nodes to the stack
            while (node != null){
                stack.push(node);
                pathSum += node.val;
                node = node.left;
            }

            // Peek the top node in the stack
            node = stack.peek();
            // If the current node is leaf and the path sum so far equals the target, return true
            if (node.left == null && node.right == null && pathSum == sum)
                return true;

            // If the current node has a right child, and we did go upwards from the right
            // Set right child as the current node for next iteration
            // Otherwise, set the current node as the previous node,
            // subtract the value of the current node from the path sum,
            // pop the current node from the stack
            // set the current node as null (need to get new node from the stack)
            if (node.right != null && prev != node.right){
                node = node.right;
            } else {
                prev = node;
                pathSum -= node.val;
                stack.pop();
                node = null;
            }
        }

        return false;
    }

}
