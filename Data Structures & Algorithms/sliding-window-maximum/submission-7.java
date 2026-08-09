

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        
        // PriorityQueue stores int[] arrays: { value, index }
        // Ordered by value in descending order (Max-Heap)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // 1. Add the current element and its index to the heap
            maxHeap.add(new int[] { nums[i], i });
            
            // 2. Lazily remove the top element if it falls outside the current window
            // The left boundary of the window is at index: i - k + 1
            while (maxHeap.peek()[1] < i - k + 1) {
                maxHeap.poll();
            }
            
            // 3. Once the first window is fully formed, record the max element
            if (i >= k - 1) {
                res[resIndex++] = maxHeap.peek()[0];
            }
        }
        
        return res;
    }
}
