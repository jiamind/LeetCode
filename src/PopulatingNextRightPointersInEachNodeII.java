/**
 * Created by udingji on 3/17/17.
 */
public class PopulatingNextRightPointersInEachNodeII {

    // Follow up for problem "Populating Next Right Pointers in Each Node".

    // What if the given tree could be any binary tree? Would your previous solution still work?

    // Note:

    // You may only use constant extra space.
    // For example,
    // Given the following binary tree,
    //          1
    //        /  \
    //       2    3
    //      / \    \
    //     4   5    7
    // After calling your function, the tree should look like:
    //        1 -> NULL
    //      /  \
    //     2 -> 3 -> NULL
    //    / \    \
    //  4-> 5 -> 7 -> NULL


    private static class TreeLinkNode {

        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {

        // If the root is null, return
        if (root == null)
            return;

        // Create a levelStart pointer which points to the starting node of the current level
        // Initiate it with root (since root is the starting node of the first level)
        TreeLinkNode levelStart = root;
        // While we find a level
        while (levelStart != null){
            // Create a pointer which will be used to point to each node on the current level
            // Initiate it with the staring node of the current level
            TreeLinkNode node = levelStart;
            // Set the starting node of the level to null, since we are going to use it to store the starting node of the next level
            levelStart = null;
            // Create a prev pointer which points to the previously linked node
            // Initiate it with null (since we haven't touch any node yet)
            TreeLinkNode prev = null;
            // While there is a node on the current level
            while (node != null){
                // If the current node has both left and right node
                if (node.left != null && node.right != null){
                    // If the starting node of the next level hasn't set, set it to the left node
                    if (levelStart == null)
                        levelStart = node.left;
                    // If we previously linked a node (this is not the first node on the current level)
                    // Link the previous node with the left node
                    if (prev != null)
                        prev.next = node.left;
                    // Set the next of left node to the right node
                    node.left.next = node.right;
                    // Now the previously linked node becomes the right node
                    prev = node.right;
                    // If the current node only has a right node
                } else if (node.left == null && node.right != null){
                    // If the starting node of the next level hasn't set, set it to the right node
                    if (levelStart == null)
                        levelStart = node.right;
                    // If we previously linked a node (this is not the first node on the current level)
                    // Link the previous node with the right node
                    if (prev != null)
                        prev.next = node.right;
                    // Now the previously linked node becomes the right node
                    prev = node.right;
                    // If the current node only has a left node
                } else if (node.left != null && node.right == null){
                    // If the starting node of the next level hasn't set, set it to the left node
                    if (levelStart == null)
                        levelStart = node.left;
                    // If we previously linked a node (this is not the first node on the current level)
                    // Link the previous node with the left node
                    if (prev != null)
                        prev.next = node.left;
                    // Now the previously linked node becomes the left node
                    prev = node.left;
                }
                // Move to the next node on the current level
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        connect(t1);
        System.out.println("done");
    }
}
