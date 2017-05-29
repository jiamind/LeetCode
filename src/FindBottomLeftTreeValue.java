import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jmding on 5/28/17.
 */
public class FindBottomLeftTreeValue {

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
