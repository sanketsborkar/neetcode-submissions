class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build adjacency list and track in-degree counts
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, k -> new ArrayList<>());
        int[] inDegree = new int[numCourses];
        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph[prerequisite].add(course);
            inDegree[course]++;
        }
        
        // 2. Add all courses with 0 prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process the graph
        int[] order = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            
            for (int neighbor : graph[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 4. If all courses are processed, return order; else a cycle exists
        return index == numCourses ? order : new int[0];
    }
}
