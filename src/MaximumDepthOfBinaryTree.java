import java.util.Stack;

/**
 * Created by udingji on 3/9/17.
 */
public class MaximumDepthOfBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Use depth first search
    public static int maxDepth(TreeNode root) {

        int maxDepth = 0;
        // If the root is null, the depth is 0
        if (root == null) return maxDepth;
        // Create a stack for DFS
        Stack<TreeNode> stack = new Stack<>();
        // Create a stack to store depth for each node in the stack
        Stack<Integer> depth = new Stack<>();
        // Push the root node and the depth (1)
        stack.push(root);
        depth.push(1);

        // While stack is not empty
        while (!stack.empty()){
            // Pop the node and depth in the stacks
            TreeNode node = stack.pop();
            int d = depth.pop();
            // If we reach the end of tree, update the maximum depth
            if (node.left == null && node.right == null){
                maxDepth = Math.max(maxDepth,d);
            } else {
                // Otherwise, push any non-null left and right node and their depth
                if (node.left != null) {
                    stack.push(node.left);
                    depth.push(d+1);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    depth.push(d+1);
                }
            }

        }
        return maxDepth;
    }

    // Use recursive
    // Count from the every bottom of the tree (0), for each level up, add 1 to the maxmium count (left or right branch)
    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(maxDepth2(root.left),maxDepth2(root.left));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        System.out.println(maxDepth(a));
    }
}
