class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges initially, return 0 minutes
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: BFS to process rotting layer by layer
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            boolean rottedInThisStep = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                
                for (int[] dir : directions) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    
                    // Check bounds and if the cell has a fresh orange
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2; // Make it rotten
                        queue.offer(new int[]{r, c});
                        freshCount--;
                        rottedInThisStep = true;
                    }
                }
            }
            
            if (rottedInThisStep) {
                minutes++;
            }
        }
        
        // Step 3: Check if all fresh oranges have rotted
        return freshCount == 0 ? minutes : -1;
    }
}
