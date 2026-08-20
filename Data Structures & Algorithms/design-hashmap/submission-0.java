class MyHashMap {
    private static final int CAPACITY = 10007;
    private Node[] buckets;

    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[CAPACITY];
    }

    private int getIndex(int key) {
        return Math.abs(Integer.hashCode(key)) % CAPACITY;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
