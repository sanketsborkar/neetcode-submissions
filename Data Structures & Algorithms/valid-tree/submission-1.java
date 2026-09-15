public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] parent = new int[n];
        // Initialize each node as its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Process each edge
        for (int[] edge : edges) {
            int rootX = find(parent, edge[0]);
            int rootY = find(parent, edge[1]);
            
            // If roots match, a cycle is detected
            if (rootX == rootY) {
                return false;
            }
            
            // Union the components
            parent[rootX] = rootY;
        }
        
        return true;
    }
    
    // Find operation with path compression
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
}
