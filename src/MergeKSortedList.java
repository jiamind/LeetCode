package test;

import java.util.Arrays;

/**
 * Created by udingji on 2/9/17.
 */
public class MergeKSortedList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeListNode(lists[0],lists[1]);

        ListNode n1 = mergeKLists(Arrays.copyOfRange(lists,0,lists.length/2));
        ListNode n2 = mergeKLists(Arrays.copyOfRange(lists,lists.length/2,lists.length));
        return mergeListNode(n1,n2);
    }

    private static ListNode mergeListNode(ListNode node1, ListNode node2){
        ListNode result;
        ListNode head;
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val < node2.val){
            result = node1;
            node1 = node1.next;
        }else {
            result = node2;
            node2 = node2.next;
        }
        head = result;

        while (node1 != null || node2 != null){
            if (node1 == null){
                result.next = node2;
                break;
            }
            if (node2 == null){
                result.next = node1;
                break;
            }
            if (node1.val < node2.val){
                result.next = node1;
                node1 = node1.next;
            }else {
                result.next = node2;
                node2 = node2.next;
            }
            result = result.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int i = 3;
        System.out.println(i/2);
    }
}
