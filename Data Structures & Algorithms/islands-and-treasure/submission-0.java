class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Add all treasure chests (0) to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Perform Multi-Source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check boundaries and if the neighbor is an empty land cell (INF)
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
