class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> numsQueue = 
            new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums)
            numsQueue.add(num);

        for (int count = 0; count < k - 1; count++)
            numsQueue.poll();

        return numsQueue.peek();
    }
}
