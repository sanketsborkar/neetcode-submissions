/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // 1. Sort the intervals chronologically by their start times
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // 2. Use a Min-Heap to store the end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 3. Add the end time of the first meeting
        minHeap.offer(intervals.get(0).end);

        // 4. Iterate through the rest of the meetings
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentMeeting = intervals.get(i);

            // If the current meeting starts after or when the earliest meeting ends,
            // we can reuse that room. Pop the old meeting out.
            if (currentMeeting.start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Always add the current meeting's end time to the heap (allocates/extends a room)
            minHeap.offer(currentMeeting.end);
        }

        // 5. The heap size represents the minimum rooms required
        return minHeap.size();
    }
}
