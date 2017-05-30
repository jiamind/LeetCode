/**
 * Created by udingji on 5/5/17.
 */
public class LinkedListCycle {

    //Given a linked list, determine if it has a cycle in it.

    //Follow up:
    //Can you solve it without using extra space?

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Idea: Use two pointers initially point to the head
    // p2 moves twice as fast as p1
    // If p1 and p2 meet at any time, there is a loop/cycle in the linked list
    public boolean hasCycle(ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                return true;
        }

        return false;
    }
}
