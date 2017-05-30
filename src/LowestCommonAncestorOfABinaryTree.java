import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by udingji on 5/14/17.
 */
public class LowestCommonAncestorOfABinaryTree {

    // Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    // According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

    //         _______3______
    //        /              \
    //    ___5__          ___1__
    //   /      \        /      \
    //  6      _2       0       8
    //        /  \
    //       7   4
    // For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If we reach the null node, or we find p or q, return it
        if (root == null || root == p || root == q)
            return root;
        // Check if we find p,q in the left and right sub tree
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // If one of them is in the left subtree and one is in the right sub tree, return the current node (Lowest common ancestor)
        if (left != null && right != null)
            return root;
        // Both of p,q are in left or right sub tree.
        return left != null ? left : right;
    }

    // Iterative
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parents.put(root,null);
        while (queue.size() > 0 && (!parents.containsKey(p) || !parents.containsKey(q))){
            TreeNode node = queue.poll();
            if (node.left != null){
                parents.put(node.left,node);
                queue.offer(node.left);
            }
            if (node.right != null){
                parents.put(node.right,node);
                queue.offer(node.right);
            }
        }

        HashSet<TreeNode> pParents = new HashSet<>();
        while (p != null){
            pParents.add(p);
            p = parents.get(p);

        }

        while (q != null){
            if (pParents.contains(q))
                return q;
            q = parents.get(q);
        }
        return null;
    }
}
