/**
 * Created by jmding on 1/24/17.
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create result ListNode (also the head ListNode)
        ListNode result = new ListNode(0);
        // Create pointer p points to result ListNode
        ListNode p = result;

        // While any of the ListNode is not null
        while (l1 != null || l2 != null) {
            // If any ListNode is null, use 0
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            // Add two ListNode and the current value of p.
            // If sum is greater than 10, add the tenth digit to the next p
            if ((a + b + p.val) >= 10) {
                p.val += (a + b - 10);
                p.next = new ListNode(1);
            } else {
                p.val += (a + b);
                // If any of the ListNode is not null and has next, add 0 as the next p
                if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null))
                    p.next = new ListNode(0);
            }
            // Move p forward
            p = p.next;
            // Move l1 and l2 forward if they are not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val + " -> ");
            result = result.next;
        }
    }
}
