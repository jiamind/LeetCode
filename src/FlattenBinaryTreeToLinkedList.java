/**
 * Created by udingji on 3/16/17.
 */
public class FlattenBinaryTreeToLinkedList {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void flatten(TreeNode root) {

        recurFlatten(root);
    }


    private static TreeNode recurFlatten(TreeNode node){

        // If the node is null, return null
        if (node == null)
            return null;
        // If the node is the leaf (both left and right node are null)
        // Return the node
        if (node.left == null && node.right == null)
            return node;
        // Save the current node
        TreeNode temp = node;
        // Save the current right node
        TreeNode tempRight = node.right;
        // Recursive method call to flatten the left sub tree and move it to the right
        node.right = recurFlatten(node.left);
        // Set the left node to null
        node.left = null;
        // Move the current node pointer to the end of current right node
        while (node.right != null)
            node = node.right;
        // Recursive method call to flatten the right sub tree
        node.right = recurFlatten(tempRight);

        return temp;
    }


    private TreeNode prev = null;

    public void flatten2(TreeNode root) {
        // Go to the bottom of the tree (leaf)
        if (root == null)
            return;
        // Flatten the right node, now the prev pointer points to the top right node
        flatten(root.right);
        // Flatten the left node, now the prev pointer points to the top left node
        flatten(root.left);
        // Set the right node of the current node to prev
        // This makes the right of the left node connects to the previous top right node
        // and the right of the righ node connects to the previous top left node
        root.right = prev;
        // Set the left node to null (flatten)
        root.left = null;
        // Now the current node becomes the previous node
        prev = root;
    }
}
