/**
 * Created by jmding on 5/26/17.
 */
public class IntersectionOfTwoLinkedList {

    // Write a program to find the node at which the intersection of two singly linked lists begins.


    // For example, the following two linked lists:

    // A:      a1 → a2
    //                ↘
    //                  c1 → c2 → c3
    //                ↗
    // B: b1 → b2 → b3
    // begin to intersect at node c1.

    // Notes:
    // If the two linked lists have no intersection at all, return null.
    // The linked lists must retain their original structure after the function returns.
    // You may assume there are no cycles anywhere in the entire linked structure.

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
