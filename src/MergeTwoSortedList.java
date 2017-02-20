
/**
 * Created by udingji on 2/8/17.
 */
public class MergeTwoSortedList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a result ListNode
        ListNode result = null;
        // Create a head pointer points to the head of the result ListNode
        ListNode head = null;

        // If both of the list nodes are not null, set the result by comparing the two values
        // If any of the list nodes is null, return the other
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result = l1;
                l1 = l1.next;
            } else {
                result = l2;
                l2 = l2.next;
            }
        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }
        // Head pointer points to the result
        head = result;

        // If any of the list node is not null
        while (l1 != null || l2 != null) {
            // If l1 is null, the rest of result will be l2. Return head
            // If l2 is null, the rest of result will be l1. Return head
            if (l1 == null) {
                result.next = l2;
                return head;
            } else if (l2 == null) {
                result.next = l1;
                return head;
            }
            // If the value of l2 is greater than l1, set the next of result to be l1. Move l1 to the next and result to the next
            // If the value of l1 is greater than l2, set the next of result to be l2. Move l2 to the next and result to the next
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            } else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }
        // Return the head pointer
        return head;
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
