import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 3/9/17.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    // Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    // For example:
    // Given binary tree [3,9,20,null,null,15,7],
    //         3
    //        / \
    //       9  20
    //         /  \
    //        15   7
    // return its zigzag level order traversal as:
    // [
    //  [3],
    //  [20,9],
    //  [15,7]
    // ]

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Create the result variable
        List<List<Integer>> result = new ArrayList<>();

        // If the root is null, return empty result
        if (root == null) return result;

        // Create a linkedlist (queue) to store tree nodes at each level
        LinkedList<TreeNode> list = new LinkedList<>();

        // Add the root to the queue
        list.add(root);

        // Create a integer flag to indicate whether we are at an odd level
        int oddLevel = 0;

        while (list.size() > 0){
            int size = list.size();
            oddLevel ^= 1;
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = list.remove();
                levelList.add(node.val);
                if (node.left != null)
                    list.add(node.left);
                if (node.right != null)
                    list.add(node.right);
            }
            if (oddLevel == 0) {
                Collections.reverse(levelList);
            }
            result.add(levelList);
        }
        return result;
    }
}
