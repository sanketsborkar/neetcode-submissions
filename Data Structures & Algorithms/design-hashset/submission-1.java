class MyHashSet {

    private static final int BUCKET_SIZE = 769;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int _hash(int key) {
        return key % BUCKET_SIZE;
    }
    
    public void add(int key) {
        int bucketIndex = _hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        // Only add if the key does not already exist (Sets allow unique elements only)
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int bucketIndex = _hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        // Remove object by value, not by index
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int bucketIndex = _hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */