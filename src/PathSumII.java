import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by udingji on 3/14/17.
 */
public class PathSumII {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        // Create a result list to store the results
        List<List<Integer>> result = new ArrayList<>();
        // Create a list to store each result (path sum)
        LinkedList<Integer> list = new LinkedList<>();

        recurPathSum(result,list,root,sum);
        return result;
    }

    // Backtrack, DFS
    private static void recurPathSum(List<List<Integer>> result, LinkedList<Integer> list, TreeNode node, int sum){
        // If the node itself is null, return
        if (node == null)
            return;

        // Add the value of this node to the list
        list.add(node.val);
        // If the node is leaf (left and right node are both null), and the value of the node equals the sum left
        // We find the path, add a copy of the path to the result list (since we are going to modify the list later to find the next path)
        if (node.left == null && node.right == null && sum == node.val){
            result.add(new ArrayList<>(list));
        }

        // Recursive call on the left and right node
        recurPathSum(result,list,node.left,sum-node.val);
        recurPathSum(result,list,node.right,sum-node.val);
        // Remove the current node value from the list, since we are done finding path for all sub trees under this node
        list.removeLast();
    }
}
