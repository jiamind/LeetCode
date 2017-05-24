/**
 * Created by udingji on 5/24/17.
 */
public class DeleteNodeInALinkedList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Idea: copy the value of the next node to the node to be removed
    // Rmove the next node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//    public void deleteNode(ListNode node) {
//        if (node == null)
//            return;
//
//        ListNode p1 = node;
//        ListNode p2 = node.next;
//
//        while (p2 != null){
//            p1.val = p2.val;
//
//            if (p2.next == null)
//                p1.next = null;
//
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//
//    }


}
