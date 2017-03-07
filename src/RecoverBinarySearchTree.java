/**
 * Created by udingji on 3/7/17.
 */
public class RecoverBinarySearchTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: Use in order traversal
    // Create three global variables to store the two switched nodes and the previous node
    public static TreeNode node1;
    public static TreeNode node2;
    public static TreeNode pre;

    public static void recoverTree(TreeNode root) {

        findSwitchedElements(root);
        // Switch the value of node1 and node2
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private static void findSwitchedElements(TreeNode treeNode){

        // If the current tree node is null, return.
        if (treeNode == null) return;
        // Find if any node is switched in the left sub tree
        findSwitchedElements(treeNode.left);
        // If previous node is not null, and the value of the previous node is greater than or equal to the current node
        // Means either the previous node and the current node is switched if the first switched node (node1) is not found
        // Or node1 is switched with the current node
        if (pre != null && pre.val >= treeNode.val){
            // If the first switched node hasn't found, assign the previous node to node1
            if (node1 == null) {
                node1 = pre;
            }
            // The current tree node is the second switched node
            node2 = treeNode;
        }
        // Set the current node as the previous node
        pre = treeNode;
        // Find if any node is switched in the right sub tree
        findSwitchedElements(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node = new TreeNode(1);
        root.left = node;
        recoverTree(root);
        System.out.println("done");
    }
}
