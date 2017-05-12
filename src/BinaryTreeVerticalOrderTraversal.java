import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by udingji on 5/11/17.
 */
public class BinaryTreeVerticalOrderTraversal {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Level order traverse the tree starting from the root. root will have column number 0
    // Any left node will have 1 less value in column, any right node will have 1 more value in column
    // Keep track of the min and max column value as we traverse the tree
    // Save the column and node values combination in the hash table
    // Add hashtable values from min to max to the result list
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Hashtable<Integer,List<Integer>> hashtable = new Hashtable<>();
        int min = 0, max = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();

        nodeQueue.offer(root);
        columnQueue.offer(0);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int column = columnQueue.poll();

            if (!hashtable.contains(column))
                hashtable.put(column,new ArrayList<>());

            hashtable.get(column).add(node.val);

            if (node.left != null){
                nodeQueue.offer(node.left);
                columnQueue.offer(column-1);
                min = Math.min(min,column-1);
            }

            if (node.right != null){
                nodeQueue.offer(node.right);
                columnQueue.offer(column+1);
                max = Math.max(max,column+1);
            }
        }

        for (int i = min; i <= max; i++){
            result.add(hashtable.get(i));
        }

        return result;
    }
}
