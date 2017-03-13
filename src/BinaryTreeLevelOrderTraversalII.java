import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 3/13/17.
 */
public class BinaryTreeLevelOrderTraversalII {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        // If the root is null, return the empty result list
        if (root == null)
            return result;

        // Create a queue (linked list) to store nodes at each level
        LinkedList<TreeNode> list = new LinkedList<>();
        // Add root to the queue
        list.add(root);

        // Iterate while we have a node in the queue (this level)
        while (list.size() > 0){
            // Get the size of nodes in the current level
            int size = list.size();
            // Create a list to store node values in the current level
            List<Integer> level = new ArrayList<>();
            // Iterate through the nodes in the current level
            for (int i = 0; i < size; i++){
                // Get and remove the first node from the queue
                TreeNode node = list.remove();
                // If the left node of the current node is not null, add it to the end of node list
                if (node.left != null)
                    list.add(node.left);
                // If the right node of the current node is not null, add it to the end of node list
                if (node.right != null)
                    list.add(node.right);
                level.add(node.val);
            }
            // Add the level list to the front of the result list
            result.add(0,level);
        }
        return result;
    }

    // DFS
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        // If the root is null, return the empty result list
        if (root == null)
            return result;

        buildLevels(result,root,0);
        return result;
    }

    private static void buildLevels(List<List<Integer>> result, TreeNode treeNode, int level){

        // If the current node is null, return
        if (treeNode == null)
            return;
        // If the current level is equal or greater than the size of the result list,
        // Add one level to the front of the result list (since we need reversed level order)
        if (level >= result.size())
            result.add(0,new ArrayList<>());

        // Recursive call on the left node. Increment level
        buildLevels(result,treeNode.left,level+1);
        // Recursive call on the right node. Increment level
        buildLevels(result,treeNode.right,level+1);
        // Get the level in the result list (Note: level order is reversed)
        // Add the tree node value to that level list
        result.get(result.size()-1-level).add(treeNode.val);
    }
}
