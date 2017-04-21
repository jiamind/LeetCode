/**
 * Created by udingji on 4/20/17.
 */
public class SumRootToLeafNumbers {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Use recursive to sum the numbers for each left and right path at a node
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }

    private int sum(TreeNode node, int sum){
        // If the current node is null, the sum is 0
        if (node == null)
            return 0;
        // If the node is a leaf, "shift" the sum to the left and add the current node value
        if (node.left == null && node.right == null)
            return sum * 10 + node.val;
        // Otherwise, recursively call sum method on it's left node and right node. Update the sum so far
        return sum(node.left,sum * 10 + node.val) + sum(node.right,sum * 10 + node.val);
    }
}
