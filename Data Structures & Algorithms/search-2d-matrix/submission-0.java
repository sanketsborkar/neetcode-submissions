class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns
        
        // Define pointers for the virtual 1D array
        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            // Prevent overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            // Map 1D index back to 2D coordinates
            int row = mid / n;
            int col = mid % n;
            
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; 
            } else if (midValue < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false; 
    }
}
