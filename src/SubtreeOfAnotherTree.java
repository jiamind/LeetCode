/**
 * Created by udingji on 5/18/17.
 */
public class SubtreeOfAnotherTree {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: for each node in s, compare if the sub tree rooted at that node is exactly the same as t
    // Alternative way(non-recursive): if t is a sub tree of s, the traversal string of t should also be a sub string of the traversal string of s
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s,t))
            return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);

    }

    private boolean isSame(TreeNode s, TreeNode t){
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
