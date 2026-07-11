class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        // Define pointers for the 4 boundaries
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        
        while (left <= right && top <= bottom) {
            // 1. Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++; // Move the top boundary down
            
            // 2. Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // Move the right boundary left
            
            // Guard check for single row / column cases
            if (!(left <= right && top <= bottom)) {
                break;
            }
            
            // 3. Traverse from right to left along the bottom row
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--; // Move the bottom boundary up
            
            // 4. Traverse from bottom to top along the left column
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++; // Move the left boundary right
        }
        
        return res;
    }
}
