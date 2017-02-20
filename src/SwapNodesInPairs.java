/**
 * Created by udingji on 2/9/17.
 */
public class SwapNodesInPairs {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp;
        ListNode result = head;
        ListNode p1 = head.next;
        ListNode p2 = head;
        ListNode p3 = null;

        p2.next = p1.next;
        p1.next = p2;
        result = p1;
        temp = p1;
        p1 = p2;
        p2 = temp;

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
            if (p3 == null){
                p3 = result;
            }else {
                p3 = p3.next;
            }
            if (p1 == null) return result;
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
            if (p1 == null){
                return result;
            }else {
                p2.next = p1.next;
                p1.next = p2;
                p3.next = p1;
                temp = p1;
                p1 = p2;
                p2 = temp;
            }
        }
        return result;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }

        public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
        ListNode result = swapPairs(n1);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
