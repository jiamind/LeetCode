/**
 * Created by jmding on 1/24/17.
 */
public class AddTwoNumbers {

    // You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create dummy ListNode
        ListNode dummy = new ListNode(0);
        // Create pointer p points to the head of the dummy ListNode
        ListNode p = dummy;
        int sum = 0;

        // While any of the ListNode is not null
        while (l1 != null || l2 != null) {
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum /= 10;
            p = p.next;
        }

        if (sum != 0)
            p.next = new ListNode(sum);

        return dummy.next;
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
