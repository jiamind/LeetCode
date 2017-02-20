/**
 * Created by udingji on 2/7/17.
 */
public class RemoveNthNodeFromEndOfList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create two pointers point to the head
        ListNode p1 = head;
        ListNode p2 = head;
        // Move p1 first
        for (int i = 0; i < n-1; i++){
            p1 = p1.next;
        }

        // If the next node is null, remove the head
        if (p1.next == null){
            // Remove head
            head = head.next;
        } else {
            // Move p1 one more time, than move p1 and p2 at the same time until the next p1 is null.
            p1 = p1.next;
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            // Remove the node next to p2
            p2.next = p2.next.next;
        }
        return head;
    }

}
