class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges initially, 0 minutes needed
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS traversal level by level (each level represents 1 minute)
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            boolean rottedAny = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2; // Make it rotten
                        queue.offer(new int[]{nRow, nCol});
                        freshCount--;
                        rottedAny = true;
                    }
                }
            }
            if (rottedAny) {
                minutes++;
            }
        }

        // Step 3: Check if all fresh oranges have rotted
        return freshCount == 0 ? minutes : -1;
    }
}
