/**
 * Created by udingji on 5/14/17.
 */
public class ReverseLinkedList {

    // Reverse a singly linked list.

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode current = head, previous = null;
        while (current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
