class Solution {
    public void solve(char[][] board) {
       if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') 
                        dfs(board, i, j, row, col);
                }
            }
            else {
                for (int j = 0; j < col; j += col - 1) {
                    if (board[i][j] == 'O') 
                        dfs(board, i, j, row, col);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O')
            return;

        board[r][c] = 'T';

        dfs(board, r - 1, c, rows, cols);
        dfs(board, r + 1, c, rows, cols);
        dfs(board, r, c - 1, rows, cols);
        dfs(board, r, c + 1, rows, cols);
    }
}
