

class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    // Initializes the object with the integer k and the stream of numbers
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // Min-heap configuration

        for (int num : nums) {
            add(num); // Add initial elements via the add helper
        }
    }
    
    // Adds a new integer to the stream and returns the kth largest element
    public int add(int val) {
        minHeap.add(val);

        // If the heap exceeds size k, evict the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The top of the min-heap is the kth largest element
        return minHeap.peek();
    }
}
