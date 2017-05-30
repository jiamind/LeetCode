
/**
 * Created by udingji on 2/8/17.
 */
public class MergeTwoSortedList {

    // Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: create a dummy node. Compare and append node in l1 and l2 to the dummy node
    // Return the next node of the dummy node as the new head of merged linked list
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                node.next = p1;
                p1 = p1.next;
            } else {
                node.next = p2;
                p2 = p2.next;
            }
            node = node.next;
        }

        while (p1 != null){
            node.next = p1;
            p1 = p1.next;
            node = node.next;
        }
        while (p2 != null){
            node.next = p2;
            p2 = p2.next;
            node = node.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

}
