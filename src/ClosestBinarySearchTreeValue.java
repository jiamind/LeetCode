/**
 * Created by udingji on 5/26/17.
 */
public class ClosestBinarySearchTreeValue {

    // Question: Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    // Note:
    // Given target value is a floating point.
    // You are guaranteed to have only one unique value in the BST that is closest to the target.

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {

        int closest = root.val;
        TreeNode node = root;

        while (node != null){
            if (Math.abs(target - node.val) < Math.abs(target - closest))
                closest = node.val;
            node = target < node.val ? node.left : node.right;
        }

        return closest;
    }
}
