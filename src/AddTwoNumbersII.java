import java.util.List;
import java.util.Stack;

/**
 * Created by jmding on 5/23/17.
 */
public class AddTwoNumbersII {


    // You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    // Follow up:
    // What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

    // Example:
    // Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 8 -> 0 -> 7

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: use stack to store the value of two nodes (so that we have the least significant bit on top)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        ListNode node = l1;
        while (node != null){
            s1.push(node.val);
            node = node.next;
        }

        node = l2;
        while (node != null){
            s2.push(node.val);
            node = node.next;
        }

        ListNode prev = null;
        int sum = 0;
        while (!s1.empty() || !s2.empty()){
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();

            ListNode current = new ListNode(sum % 10);
            sum /= 10;

            current.next = prev;
            prev = current;
        }

        if (sum != 0){
            ListNode head = new ListNode(sum);
            head.next = prev;
            return head;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(55);
        ListNode l12 = new ListNode(55);
        l1.next = l12;

        ListNode l2 = new ListNode(55);
        ListNode l22 = new ListNode(55);
        l2.next = l22;

        ListNode node = addTwoNumbers(l1,l2);
    }
}
