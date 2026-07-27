

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list and calculate in-degrees
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        // 2. Add all courses with 0 prerequisites (in-degree = 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process the queue
        int processedCount = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCount++;
            
            // Reduce in-degree for all courses dependent on the current course
            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                // If all prerequisites are cleared, add to queue
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 4. If processed count matches total courses, no cycle exists
        return processedCount == numCourses;
    }
}
