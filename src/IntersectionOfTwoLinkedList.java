/**
 * Created by jmding on 5/26/17.
 */
public class IntersectionOfTwoLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Idea: use two pointers to move in headA and headB at the same time
    // If either reaches the end, redirect it to the head of the other list
    // When two pointers are the same, if the two list intersects, they meet at the intersection.
    // (Pointer A runs a + c + b, pointer B runs b + c + a, where c is the common length after the intersection)
    // otherwise, they are all null
    // (Pointer A run a + b, pointer B runs b + a)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA, b = headB;

        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
