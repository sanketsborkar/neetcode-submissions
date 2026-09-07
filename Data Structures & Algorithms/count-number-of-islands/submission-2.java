class Solution {
    public int numIslands(char[][] grid) {
        //Edge case if grid length is 0, then return 0
        if (grid == null || grid.length == 0)
            return 0;

        //Iterate through the 2d array, increase the islands counter as you iterate through the array
        int rows = grid.length;
        int columns = grid[0].length;
        int numberOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(i, j, rows, columns, grid);
                }  
            }
        }

        return numberOfIslands;
    }

    //In separate method keep recursing until you encounter 0 or end of the row or column
    private void dfs(int r, int c, int rows, int columns, char[][] grid) {
        if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(r + 1, c, rows, columns, grid);
        dfs(r - 1, c, rows, columns, grid);
        dfs(r, c + 1, rows, columns, grid);
        dfs(r, c - 1, rows, columns, grid);
    }
}
