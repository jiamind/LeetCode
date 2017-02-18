/**
 * Created by jmding on 2/11/17.
 */
public class ReverseNodesInKGroup {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

//        if (k < 2) return head;
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode p1 = dummy;
//        ListNode p2 = head;
//
//        ListNode p3 = dummy;
//        ListNode p4 = head;
//
//
//        while (p4 != null) {
//            for (int i = 1; i < k; i++) {
//                p3 = p3.next;
//                p4 = p4.next;
//                if (p4 == null) {
//                    return dummy.next;
//                }
//            }
//            ListNode tmp = p4.next;
//            p1.next = p4;
//            if (k != 2) {
//                p3.next = p2;
//            }
//            if (k != 2) {
//                p4.next = p2.next;
//            }else {
//                p4.next = p2;
//            }
//            p2.next = tmp;
//
//            if (k != 2) {
//                p1 = p3;
//                p4 = p2;
//            }else {
//                p3 = p4;
//                p4 = p2;
//                p1 = p3;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//            p3 = p3.next;
//            p4 = p4.next;
//        }
//
//        return dummy.next;

        ListNode cursor = head;
        int count  = 0;
        while (cursor != null && count < k){
            cursor = cursor.next;
            count ++;
        }

        if (count == k){
            cursor = reverseKGroup(cursor, k);
            while (count -- > 0){
                ListNode temp = head.next;
                head.next = cursor;
                cursor = head;
                head = temp;
            }
            head = cursor;
        }
        return  head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = reverseKGroup(n1,3);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

}
