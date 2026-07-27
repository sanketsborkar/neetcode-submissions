class Solution {
    private int rows, cols;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Traverse top and bottom borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, rows - 1, c, atlantic);
        }

        // Traverse left and right borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, cols - 1, atlantic);
        }

        // Find cells that can reach both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] d : directions) {
            int nextR = r + d[0];
            int nextC = c + d[1];

            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols) {
                continue;
            }
            if (visited[nextR][nextC]) {
                continue;
            }
            // Water flows from lower/equal to higher when moving backwards from ocean
            if (heights[nextR][nextC] < heights[r][c]) {
                continue;
            }

            dfs(heights, nextR, nextC, visited);
        }
    }
}
