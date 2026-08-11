class Solution {
    //Declare parent and initialize it with i
    //Declare rank and initialize it with 1
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1]))
                result--;
        }
       
        return result;
    }

    //Create method find. It will find if the parent of the node is the node itself, else it will search for parent of that node and return the parent node.
    public int find(int node) {
        if (parent[node] == node)
            return node;

        return find(parent[node]);
    }

    //Create method union. It will check if union exists by finding if they are connected and result is decremented. If yes, then node 1 becomes parent of node 0 and node 4 of node 3. The rank of parent gets increased by 1. If it doesnt exist, then no change on result.
    public boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

}
