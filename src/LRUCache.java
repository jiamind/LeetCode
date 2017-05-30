import java.util.HashMap;

/**
 * Created by udingji on 5/8/17.
 */
public class LRUCache {

    // Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    // get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    // put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    // Follow up:
    // Could you do both operations in O(1) time complexity?



    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    /*
    * Idea: use a doubly linked list of cache node to store and preserve the order of the LRU cache
    * Use a hashmap of key/cache node pair for quick access of node
    * */

    private class CacheNode {

        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, CacheNode> hashMap = new HashMap<>();
    CacheNode head = null;
    CacheNode end = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // If the key is not in the LRU cache, return -1
    // Otherwise, get the cache node from the hashmap, remove it from the linked list and add it to the head
    public int get(int key) {
        if (!hashMap.containsKey(key))
            return -1;

        CacheNode node = hashMap.get(key);
        remove(node);
        setHead(node);
        return node.value;
    }

    // If the key already exists in the LRU cache, get the cache node, update the value, and remove it from the linked list
    // Otherwise, remove the end of the linked list if the cache size exceeds the capacity. Create the new cache node
    // Set the cache node as the head and put it into/update it in the hashmap
    public void put(int key, int value) {
        CacheNode node;
        if (hashMap.containsKey(key)) {
            node = hashMap.get(key);
            node.value = value;
            remove(node);
        } else {
            node = new CacheNode(key, value);
            if (hashMap.size() >= this.capacity) {
                hashMap.remove(end.key);
                remove(end);
            }
        }
        setHead(node);
        hashMap.put(key, node);
    }

    // This private method will remove the node from the linked list
    // It will update the pointers of its previous and next cache nodes
    private void remove(CacheNode node) {
        if (node.prev == null && node.next == null) {
            head = null;
            end = null;
        } else if (node.prev == null) {
            head = node.next;
            node.next.prev = null;
        } else if (node.next == null) {
            end = node.prev;
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // This private method will set the node as the new head
    // It will update the previous and next pointers of the node
    private void setHead(CacheNode node) {
        if (head == null) {
            head = node;
            end = node;
            node.next = null;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        node.prev = null;
    }
}
