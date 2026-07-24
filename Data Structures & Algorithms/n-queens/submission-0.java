
// Class to solve the N-Queens puzzle using backtracking
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, results, n);
        return results;
    }

    // Explores potential board configurations
    private void backtrack(int row, char[][] board, List<List<String>> results, int n) {
        if (row == n) {
            List<String> layout = new ArrayList<>();
            for (char[] r : board) layout.add(new String(r));
            results.add(layout);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, results, n);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    // Validates if a queen can be placed at board[row][col]
    private boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }
}
