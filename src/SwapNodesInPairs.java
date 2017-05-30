/**
 * Created by udingji on 2/9/17.
 */
public class SwapNodesInPairs {

    // Given a linked list, swap every two adjacent nodes and return its head.

    // For example,
    // Given 1->2->3->4, you should return the list as 2->1->4->3.

    // our algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Use recursive
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

        public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
        ListNode result = swapPairs(n1);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
