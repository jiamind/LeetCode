/**
 * Created by jmding on 5/28/17.
 */
public class LargestBSTSubtree {

    // Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

    // Note:
    // A subtree must include all of its descendants.
    // Here's an example:
    //            10
    //           / \
    //          5  15
    //         / \   \
    //        1   8   7
    // The Largest BST Subtree in this case is the highlighted one.
    // The return value is the subtree's size, which is 3.
    // Follow up:
    // Can you figure out ways to solve it with O(n) time complexity?

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class StaticNode {
        int num;
        Integer lower, upper;

        StaticNode(int num, Integer lower, Integer upper) {
            this.num = num;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {

        traverse(root);
        return max;
    }

    private StaticNode traverse(TreeNode node) {
        if (node == null)
            return new StaticNode(0, null, null);

        StaticNode left = traverse(node.left);
        StaticNode right = traverse(node.right);

        if (left.num == -1 || right.num == -1 || (left.upper != null && node.val <= left.upper) || (right.lower != null && node.val >= right.lower))
            return new StaticNode(-1, 0, 0);

        int num = left.num + right.num + 1;
        max = Math.max(max, num);

        return new StaticNode(num, left.lower == null ? node.val : left.lower, right.upper == null ? node.val : right.upper);
    }
}
