/**
 * Created by jmding on 5/7/17.
 */
public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: first, find the mid point (odd number of nodes) or the node before the mid point (even number of nodes) of the linked list
    // then, reverse the second half of the linked list ( 1->2->3->4->5->6->7-8 ==> 1->2->3->4->8->7->6->5)
    // finally, re-construct the linked list
    public static void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode current = p1.next;
        ListNode prev = null;
        while (current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        p1.next = prev;
        p1 = prev;

        p2 = head;

        while (p1 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p2.next = p1;
            p2.next.next = temp2;
            p2 = temp2;
            p1 = temp1;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode m = new ListNode(3);
        ListNode o = new ListNode(4);
        head.next = n;
        n.next = m;
        m.next = o;

        reorderList(head);
    }
}
