import java.util.Stack;

/**
 * Created by udingji on 5/18/17.
 */
public class SubtreeOfAnotherTree {

    // Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
    // A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

    // Example 1:
    // Given tree s:
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    // Given tree t:
    //        4
    //       / \
    //      1   2
    // Return true, because t has the same structure and node values with a subtree of s.

    // Example 2:
    // Given tree s:

    //        3
    //       / \
    //      4   5
    //     / \
    //   1   2
    //      /
    //     0
    // Given tree t:
    //        4
    //       / \
    //      1   2
    // Return false.

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

    // Idea: Generate the preorder traversal string of both trees. Make sure that node breaks and null nodes are well indicated
    public boolean isSubtree2(TreeNode s, TreeNode t){
        String preorder1 = generatePreOrderTraversal(s);
        String preorder2 = generatePreOrderTraversal(t);

        return preorder1.contains(preorder2);
    }

    private String generatePreOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();
            if (node == null){
                sb.append(",#");
            } else {
                sb.append("," + node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }
}
