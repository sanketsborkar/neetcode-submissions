class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int maxAreaOfIsland = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxAreaOfIsland = Math.max(dfs(grid, i, j, rows, cols), maxAreaOfIsland);
                }
            }
        }

        return maxAreaOfIsland;
    }

    public int dfs(int[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols ||  grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        return 1+dfs(grid, r - 1, c, rows, cols)+
        dfs(grid, r + 1, c, rows, cols)+
        dfs(grid, r, c - 1, rows, cols)+
        dfs(grid, r, c + 1, rows, cols);
    }
}
