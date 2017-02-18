package test;

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
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n-1; i++){
            p1 = p1.next;
        }

        if (p1.next == null){
            // Remove head
            head = head.next;
        } else {
            p1 = p1.next;
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = p2.next.next;
        }
        return head;
    }

}
