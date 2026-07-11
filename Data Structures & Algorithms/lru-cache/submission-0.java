

public class LRUCache {

    // Node class representing the key-value pairs
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    
    // Dummy pointers to track boundaries
    private final Node left;  // Points to the Least Recently Used (LRU) element
    private final Node right; // Points to the Most Recently Used (MRU) element

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy boundaries
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // Helper: Remove a node from the doubly linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Helper: Insert a node right before the right dummy (marks as Most Recently Used)
    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;
        
        prev.next = node;
        next.prev = node;
        
        node.prev = prev;
        node.next = next;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node); // Move to the right side (MRU)
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // If the size exceeds capacity, evict the LRU node
        if (cache.size() > capacity) {
            Node lru = this.left.next; // The true LRU node is right after the left dummy
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
