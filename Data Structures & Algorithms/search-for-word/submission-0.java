class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Loop through every cell in the 2D grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If the word is found starting from board[r][c], return true
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base Case: If the entire word has been matched
        if (index == word.length()) {
            return true;
        }
        
        // Check for boundary conditions and character mismatch
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Temporarily mark the current cell as visited to prevent reuse
        char temp = board[r][c];
        board[r][c] = '#';
        
        // Explore all 4 orthogonal directions (Down, Up, Right, Left)
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        
        // Backtrack: Restore the cell's original character value
        board[r][c] = temp;
        
        return found;
    }
}
