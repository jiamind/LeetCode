import java.util.LinkedList;

/**
 * Created by udingji on 3/17/17.
 */
public class PopulatingNextRightPointersInEachNode {

    // Given a binary tree
    // Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    // Initially, all next pointers are set to NULL.

    // Note:
    // You may only use constant extra space.
    // You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    // For example,
    // Given the following perfect binary tree,
    //              1
    //            /  \
    //           2    3
    //          / \  / \
    //         4  5  6  7
    //
    // After calling your function, the tree should look like:
    //          1 -> NULL
    //        /  \
    //       2 -> 3 -> NULL
    //      / \  / \
    //     4->5->6->7 -> NULL

    private static class TreeLinkNode {

        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }


    // Use constant memory space
    public static void connect2(TreeLinkNode root) {

        // If the root is null, return
        if (root == null)
            return;

        // Create a levelStart pointer which points to the start node of each level
        // Initialize it with the root (root is the first node on the first level)
        TreeLinkNode levelStart = root;
        // While we find a new level
        while (levelStart != null){
            // Create a another pointer, initiate it with the starting node
            // This node is used to iterate through each node on the current level
            // We don't want to touch the levelStart pointer. We need it to move on to the next level
             TreeLinkNode node = levelStart;
             // While we find a node on the current level
             while (node != null){
                 // If the current node has a left node, set the next of the current node to the right of the current node (can be null)
                 if (node.left != null)
                     node.left.next = node.right;
                 // If the current node has a right node and the next node of the current node is not null
                 // Set the next of the right node to be the left of the next node
                 if (node.right != null && node.next != null)
                     node.right.next = node.next.left;
                 // Move to the next node on the current level
                 node = node.next;
             }
             // We finish with the current level, move to the next level (which is the left node of the start node of the current level)
             levelStart = levelStart.left;
        }
    }
}
