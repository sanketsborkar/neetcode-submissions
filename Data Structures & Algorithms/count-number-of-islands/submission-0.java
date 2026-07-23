class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(char[][] grid, int r, int c, int rows, int cols) {
        // Base case: out of bounds or water ('0')
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }
        
        // Mark the current cell as visited by sinking the island
        grid[r][c] = '0';
        
        // Recursively visit all 4 adjacent directions
        dfs(grid, r + 1, c, rows, cols); // down
        dfs(grid, r - 1, c, rows, cols); // up
        dfs(grid, r, c + 1, rows, cols); // right
        dfs(grid, r, c - 1, rows, cols); // left
    }
}
