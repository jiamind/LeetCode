/**
 * Created by udingji on 3/14/17.
 */
public class PathSum {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: search from the top (root) to the bottom (leaves). Subtract the current node value from the sum
    // If the current node is a leave and sum - current node value is 0, we found a path
    public static boolean hasPathSum(TreeNode root, int sum) {

        // If the current node is null. return false
        if (root == null)
            return false;

        // If the current node is the leave and sum minus current node value is 0
        // We found a path, return true
        if (root.left == null && root.right == null && sum - root.val == 0)
            return  true;

        // Recursive call on the left and right sub tree
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
