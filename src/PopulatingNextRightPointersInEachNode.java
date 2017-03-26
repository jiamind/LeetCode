import java.util.LinkedList;

/**
 * Created by udingji on 3/17/17.
 */
public class PopulatingNextRightPointersInEachNode {

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

        // Create a linked list (queue) to store the treelinknode to be linked
        LinkedList<TreeLinkNode> list = new LinkedList<>();

        // Add the root to the list
        list.add(root);

        // While there is treelinknode to be linked
        while (list.size() > 0){

            // Get the size of treelinknode to the linked at this level
            int size = list.size();
            // Iterate through the treelinknode to be linked at this level
            for (int i = 0; i < size; i++){
                // Remove the treelinknode at the top of the queue
                TreeLinkNode node = list.remove();
                // If the node is the last at this level, the next pointer of it points to null
                // Otherwise, peek the next node and makes the nex pointer of it points to the next node
                if (i == size - 1){
                    node.next = null;
                } else {
                    node.next = list.peek();
                }
                // Add any non null left or right node of the current node to the list
                if (node.left != null)
                    list.add(node.left);
                if (node.right != null)
                    list.add(node.right);
            }
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
