/**
 * Created by jmding on 5/22/17.
 */
public class CopyListWithRandomPointer {

    // A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    // Return a deep copy of the list.

    private class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode current  = head, next;

        // Make a copy of each node
        // Point the next pointer of original node to the copy
        // Point the random pointer of the copy to its original node
        // Point the next pointer of the copy to the next node of its original node
        while (current != null){
            next = current.next;
            RandomListNode copy = new RandomListNode(current.label);

            current.next = copy;
            copy.random = current;
            copy.next = next;

            current = next;
        }

        current = head;

        // Set the random pointer of each copy node
        while (current != null){
            RandomListNode copy = current.next;
            copy.random = current.random == null ? null : current.random.next;

            current = current.next.next;
        }

        // Set the next pointer of the each original and copy node
        current = head;
        RandomListNode copyHead = current.next;

        while (current != null){
            RandomListNode copy = current.next;

            current.next = current.next.next;
            copy.next = copy.next == null ? null : copy.next.next;

            current = current.next;
        }

        return copyHead;
    }
}
