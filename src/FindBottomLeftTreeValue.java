import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jmding on 5/28/17.
 */
public class FindBottomLeftTreeValue {

    // Given a binary tree, find the leftmost value in the last row of the tree.

    // Example 1:
    // Input:
    //     2
    //    / \
    //   1   3

    // Output: 1

    // Example 2:
    // Input:
    //        1
    //       / \
    //      2   3
    //     /   / \
    //    4   5   6
    //       /
    //      7

    // Output: 7

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Level order traversal. Add right node to the queue before adding left node, (from right to left)
    // so the last node in the queue is the left most node
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
        }
        return node.val;
    }
}
