public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list and calculate in-degrees
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());

        int[] indegrees = new int[numCourses];

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            adjList.get(prerequisite).add(course);
            indegrees[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int neighbor : adjList.get(course)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}