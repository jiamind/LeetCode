/**
 * Created by udingji on 3/8/17.
 */
public class ReverseLinkedListII {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        // Create a dummy node, for easy handling if m = 0
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Create two pointers, used to point the node just before m and n
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // Move p1 pointer first, n-m times
        for (int i = 0; i < n - m; i ++){
            p1 = p1.next;
        }

        // Move p1 and p2 together, until p2 reaches just before m
        for (int i = 1; i < m; i++){
            p1 = p1.next;
            p2 = p2.next;
        }

        // (Typical reverse linked list process)
        // Create three pointers, point to the current node to be reversed, the previous node that was just reversed, and a temp pointer
        ListNode current = p2.next, pre = p1.next.next, temp;
        // We need to perform reverse action n-m times
        int i = 0;
        while (i <= n-m){
            // Save the next node of the current node
            temp = current.next;
            // Make the next node of the current node as the previous node we just reversed
            current.next = pre;
            // Now, the current node becomes the previous node we just reversed
            pre = current;
            // The current node becomes the temp node we saved
            current = temp;
            i++;
        }
        // Now the previous node is "n", set it as the next node of p2
        p2.next = pre;

        // Return the next node of dummy node. We cannot return head here since head could be reversed
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;

        ListNode result = reverseBetween(a,1,4);
        while (result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
