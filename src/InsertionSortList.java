/**
 * Created by udingji on 5/9/17.
 */
public class InsertionSortList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // idea: use a dummy head. Iterate through the linked list
    // for each node in the linked list, move a pointer starting from the dummy head, until it reaches the first node which has greater value
    // Insert the node between p and p.next
    public ListNode insertionSortList(ListNode head) {

        // Create a dummy node
        ListNode dummy = new ListNode(0);
        // Create a pointer which represents the current node in the iteration. Initially it points to the head
        ListNode current = head;
        // Iterate through the linked list
        while (current != null){

            // Use a temporary point to point to the next node
            ListNode next = current.next;
            // Use a pointer to point to the dummy node
            // (since for each node we would like to scan from the dummy node)
            ListNode p = dummy;

            // Find the insert position. The loop stops when p reaches the end, or the value of the next p is greater than the current value
            // Therefore, the insert point is betwwen p and p.next
            while (p.next != null && p.next.val < current.val)
                p = p.next;

            // Insert the current node between p and p.next
            current.next = p.next;
            p.next = current;
            // Set the current node to next (since we are done with this node, moving to the next one)
            current = next;
        }

        return dummy.next;
    }
}
