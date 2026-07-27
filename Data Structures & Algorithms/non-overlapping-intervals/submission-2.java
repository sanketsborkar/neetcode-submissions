class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        // Keep track of the end time of the last non-overlapping interval
        int prevEnd = intervals[0][1];
        
        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the previous one ends, they overlap
            if (intervals[i][0] < prevEnd) {
                count++; // Remove the current interval
            } else {
                // No overlap, update the end time to the current interval's end
                prevEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}