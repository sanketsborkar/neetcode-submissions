
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        
        // isPrerequisite[i][j] will store if course i is a prerequisite of course j
        boolean[][] isPrereq = new boolean[numCourses][numCourses];
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // BFS for topological sort and propagating prerequisites
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next : adj.get(curr)) {
                // curr is a prerequisite of next
                isPrereq[curr][next] = true;
                
                // All prerequisites of curr are also prerequisites of next
                for (int i = 0; i < numCourses; i++) {
                    if (isPrereq[i][curr]) {
                        isPrereq[i][next] = true;
                    }
                }
                
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        // Answer the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrereq[query[0]][query[1]]);
        }
        
        return result;
    }
}
