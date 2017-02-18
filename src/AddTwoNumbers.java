/**
 * Created by jmding on 1/24/17.
 */
public class AddTwoNumbers {

    private static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;

        while (l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            if ((a + b + p.val) >= 10){
                p.val += (a + b - 10);
                p.next = new ListNode(1);
            } else {
                p.val += (a + b);
                if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null))
                    p.next = new ListNode(0);
            }
            p = p.next;
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

        ListNode result = addTwoNumbers(l1,l2);
        while (result != null){
            System.out.println(result.val + " -> ");
            result = result.next;
        }
    }
}
