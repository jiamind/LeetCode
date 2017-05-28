import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by jmding on 4/27/17.
 */
public class LFUCache {
    // The head of the list of frequency nodes. The head stores the keys with the least count (least frequently accessed)
    private FreqNode head = null;
    private int cap = 0;
    // Key - value store for quick get access
    private HashMap<Integer, Integer> valueMap = null;
    // Key - FreqNode store for quick access the frequency node which contains the key
    private HashMap<Integer, FreqNode> nodeMap = null;

    public LFUCache(int capacity) {
        this.cap = capacity;
        valueMap = new HashMap<Integer, Integer>();
        nodeMap = new HashMap<Integer, FreqNode>();
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increaseCount(key);
            return valueMap.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cap == 0) return;
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        } else {
            if (valueMap.size() < cap) {
                valueMap.put(key, value);
            } else {
                removeOld();
                valueMap.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new FreqNode(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            FreqNode freqNode = new FreqNode(0);
            freqNode.keys.add(key);
            freqNode.next = head;
            head.prev = freqNode;
            head = freqNode;
        } else {
            head.keys.add(key);
        }
        nodeMap.put(key, head);
    }

    private void increaseCount(int key) {
        // Remove this key from it's current frequency node. Move the key to the next frequency node (has one more frequency count)
        FreqNode freqNode = nodeMap.get(key);
        freqNode.keys.remove(key);

        if (freqNode.next == null) {
            freqNode.next = new FreqNode(freqNode.count + 1);
            freqNode.next.prev = freqNode;
            freqNode.next.keys.add(key);
        } else if (freqNode.next.count == freqNode.count + 1) {
            freqNode.next.keys.add(key);
        } else {
            FreqNode tmp = new FreqNode(freqNode.count + 1);
            tmp.keys.add(key);
            tmp.prev = freqNode;
            tmp.next = freqNode.next;
            freqNode.next.prev = tmp;
            freqNode.next = tmp;
        }

        // Check the old frequency node to see if it associate with no key. If so, remove that node
        nodeMap.put(key, freqNode.next);
        if (freqNode.keys.size() == 0)
            remove(freqNode);
    }

    private void removeOld() {
        if (head == null) return;
        int old = 0;
        for (int n : head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        nodeMap.remove(old);
        valueMap.remove(old);
    }

    private void remove(FreqNode freqNode) {
        if (freqNode.prev == null) {
            head = freqNode.next;
        } else {
            freqNode.prev.next = freqNode.next;
        }
        if (freqNode.next != null) {
            freqNode.next.prev = freqNode.prev;
        }
    }

    private class FreqNode {
        public int count = 0;
        public LinkedHashSet<Integer> keys = null;
        public FreqNode prev = null, next = null;

        public FreqNode(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            prev = next = null;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(10);
        cache.set(0, 1);
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(1, 4);
        cache.set(0, 6);
    }
}
