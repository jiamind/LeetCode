/**
 * Created by udingji on 2/27/17.
 */
public class RotateList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        // If head is null, or head is the only node, or k is 0 (which means does not need to rotate), return what we have (head)
        if(head == null || head.next == null || k == 0) return head;

        // Create two pointers point to the head
        ListNode p1 = head;
        ListNode p2 = head;

        // Find the length of the list
        int length = 0;
        while (head!=null){
            length++;
            head = head.next;
        }
        head = p1;
        // If k is greater than the length, we need to start from the end again
        k %= length;

        // If k is 0, means we don't need to rotate
        if (k == 0) return head;

        // Advance p2 k steps
        for(int i = 0; i < k; i++){
            p2 = p2.next;
            if (p2 == null) return head;
        }

        // Advance both pointers until p2 reaches the end
        while (p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }

        // Save the current head
        ListNode temp = head;
        // Now the head becomes the next of p1
        head = p1.next;
        // p1 now becomes the last node in the list
        p1.next = null;
        // The next node of p2 is the original head, which is saved in temp
        p2.next = temp;

        // Return the new head
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        head.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ListNode result = rotateRight(head,2);
        while (result!=null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
