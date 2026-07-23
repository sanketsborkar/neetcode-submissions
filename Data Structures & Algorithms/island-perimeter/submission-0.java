class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    
                    // Check if there is an adjacent land cell to the right
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }
                    
                    // Check if there is an adjacent land cell below
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }
}
