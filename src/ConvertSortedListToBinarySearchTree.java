/**
 * Created by udingji on 3/13/17.
 */
public class ConvertSortedListToBinarySearchTree {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: use two pointers point to the head. One moves twice as fast as the other. The slow one is at the mid
    public static TreeNode sortedListToBST(ListNode head) {

        // If the head is null, return null
        if (head == null)
            return null;

        return recurSortedListToBST(head,null);
    }

    private static TreeNode recurSortedListToBST(ListNode head, ListNode tail){
        // If head meets tail, we finished scanning this sub linked list. return null.
        if (head == tail)
            return null;

        // Create two pointers p1, p2 point to the head.
        ListNode p1 = head;
        ListNode p2 = head;

        // As long as p2 does not reach the tail or the next list node of p2 is not tail
        // Move p1 and p2 forward. Move p2 twice as fast as p1
        while (p2 != tail && p2.next != tail){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Create the root node using the value of p1
        TreeNode node = new TreeNode(p1.val);
        // Recursive call on the left node and right node
        node.left = recurSortedListToBST(head,p1);
        node.right = recurSortedListToBST(p1.next,tail);

        return node;
    }
}
