import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 3/9/17.
 */
public class BinaryTreeLevelOrderTraversal {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        // Create the result variable
        List<List<Integer>> result = new ArrayList<>();

        // If the root is null, return empty result
        if (root == null) return result;

        // Create a linkedlist (queue) to store tree nodes at each level
        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);

        // While there is tree node in the queue
        while (list.size() > 0){
            // Get the number of tree nodes at this level
            int size = list.size();
            // Create a list to hold values of tree nodes at this level
            List<Integer> levelList = new ArrayList<>();
            // Iterate through each tree node on this level
            for (int i = 0; i < size; i ++) {
                // Pop the tree node from the queue
                TreeNode node = list.remove();
                // Add the value of the tree node to the list
                levelList.add(node.val);
                // If the left node of the current node is not null, psuh it in the queue
                if (node.left != null)
                    list.add(node.left);
                // If the right node of the current node is not null, push it in the queue
                if (node.right != null)
                    list.add(node.right);
            }
            // Add the values of this level to the result list
            result.add(levelList);
        }
        return result;
    }

}
