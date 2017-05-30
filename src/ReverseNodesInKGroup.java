/**
 * Created by jmding on 2/11/17.
 */
public class ReverseNodesInKGroup {

    // Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    // k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    // You may not alter the values in the nodes, only nodes itself may be changed.
    // Only constant memory is allowed.

    // For example,
    // Given this linked list: 1->2->3->4->5
    // For k = 2, you should return: 2->1->4->3->5
    // For k = 3, you should return: 3->2->1->4->5

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode cursor = head;
        int count = 0;

        // If the distance between current node and the end is less than k, we don't reverse, just return the head
        while (count++ < k) {
            if (cursor == null)
                return head;
            cursor = cursor.next;
        }

        // This returns the next new head after swap
        cursor = reverseKGroup(cursor, k);
        // Decrement k, while it's greater than 0
        while (k-- > 0) {
            // Save the next of head as temp
            ListNode temp = head.next;
            // Make the next of head to the cursor
            head.next = cursor;
            // Point the cursor to the head we just moved
            cursor = head;
            // Point the head to the next list node to be swapped
            head = temp;
        }
        // Return the new head
        return cursor;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = reverseKGroup(n1, 3);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

}
