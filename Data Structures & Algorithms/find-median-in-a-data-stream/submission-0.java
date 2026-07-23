class MedianFinder {
    // Max-heap to store the smaller half of the stream
    private PriorityQueue<Integer> smallMaxHeap;
    // Min-heap to store the larger half of the stream
    private PriorityQueue<Integer> largeMinHeap;

    public MedianFinder() {
        smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Always add to the max-heap first
        smallMaxHeap.offer(num);
        
        // Step 2: Balance the value by moving the largest of the small half to the min-heap
        largeMinHeap.offer(smallMaxHeap.poll());
        
        // Step 3: Keep heaps sizes balanced (max-heap can have at most 1 more element than min-heap)
        if (smallMaxHeap.size() < largeMinHeap.size()) {
            smallMaxHeap.offer(largeMinHeap.poll());
        }
    }
    
    public double findMedian() {
        // If total count is odd, max-heap holds the extra middle element
        if (smallMaxHeap.size() > largeMinHeap.size()) {
            return smallMaxHeap.peek();
        }
        // If total count is even, average the top elements of both heaps
        return (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0;
    }
}
