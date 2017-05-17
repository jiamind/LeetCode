/**
 * Created by udingji on 5/16/17.
 */
public class PalindromeLinkedList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: reverse the second half of the linked list, then compare with the first half
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        // Note: p2 = head.next. so that if the length of the linked list is even, p1 will stop at the left of the mid node
        // If the length is odd, p1 will stop at the mid node
        ListNode p1 = head,p2 = head.next;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode current = p1.next, prev = null;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode p3 = head;
        while (prev != null){
            if (head.val != prev.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
