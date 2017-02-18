package test;

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
        ListNode result = null;
        ListNode head = null;

        if (l1 != null && l2 != null){
            if (l1.val < l2.val){
                result = l1;
                l1 = l1.next;
            }else {
                result = l2;
                l2 = l2.next;
            }
        }else if (l1 == null){
            return l2;
        }else {
            return l1;
        }
        head = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                return head;
            } else if (l2 == null) {
                result.next = l1;
                return head;
            }
            if (l1.val < l2.val) {
                    result.next = l1;
                    l1 = l1.next;
                    result = result.next;
            }else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1,l2);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

}
