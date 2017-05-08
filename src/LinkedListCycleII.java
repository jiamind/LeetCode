/**
 * Created by udingji on 5/5/17.
 */
public class LinkedListCycleII {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Idea: Use two pointers initially point to the head
    // p2 moves twice as fast as p1
    // If p1 and p2 meet, there is a cycle in the linked list
    // Let x be the distance between the head and the begin node of the cycle; let c be the distance between p1 and the begin node of the cycle
    // Therefore, p1 travels the distance of x + c, p2 travels twice as fast as p1, which is 2 * (x + c)
    // Let n be the number of cycles that p2 travels in the loop; let L be the length of the loop
    // Therefore, the distance that p2 travels can also be represented by x + c + n * L
    // 2 * (x + c) = x + c + n * L ===>  x = n * L - c ===> x = (n-1) * L + (L - c)
    // This means that the distance left for p1 until it reaches the begin of the loop (L-c) is equal to the distance from head to the begin of the loop (x)
    // In other word, if we move p1 and a third pointer (p3, starts from head) together,
    // when p3 travels x to the begin node of the circle, p1 travels L- c to the begin of the cycle. They meet at the begin at of the cycle
    public static ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                while (p3 != p1){
                    p1 = p1.next;
                    p3 = p3.next;
                }
                return p1;
            }
        }

        return null;
    }
}
