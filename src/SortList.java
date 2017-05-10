import java.util.List;

/**
 * Created by udingji on 5/10/17.
 */
public class SortList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: find the node in the middle. Recursively sort the first half and second half of the linked list
    // Then merge the two sorted linked list together
    public static ListNode sortList(ListNode head) {

        // If the node is null, or there is only one node in the linked list, return this node (no need to sort and merge)
        if (head == null || head.next == null){
            return head;
        }

        // Create a prev pointer points to the node before the mid node
        // p2 moves twice as fast as p1. Both pointers initially point to the head
        ListNode prev = null, p1 = head, p2 = head;

        // Find the middle node
        while (p2 != null && p2.next != null){
            prev = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Break the linked list into two parts by setting the next node of prev as null
        prev.next = null;

        // sort the first half and second half of the linked list
        ListNode sortedList1 = sortList(head);
        ListNode sortedList2 = sortList(p1);

        // Merge the two sorted linked list
        return merge(sortedList1,sortedList2);
    }

    private static ListNode merge(ListNode n1, ListNode n2){
        // Create a dummy node. All nodes will be inserted after it
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // while both n1 and n2 are not null, compare their values and merge them
        while (n1 != null && n2 != null){
            if (n1.val < n2.val){
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        // If there are more nodes in n1, add them to the linked list
        while (n1 != null){
            p.next = n1;
            n1 = n1.next;
            p = p.next;
        }

        // If there are more nodes in n2, add them to the linked list
        while (n2 != null){
            p.next = n2;
            n2 = n2.next;
            p = p.next;
        }
        p.next = null;

        // Return the real head of the merged linked list
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        head.next = n1;
        n1.next = n2;

        ListNode result = sortList(head);

        System.out.println("done");
    }
}
