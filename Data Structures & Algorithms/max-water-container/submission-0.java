class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max_area = 0;
        while (l < r) {
            int product = Math.min(heights[l],heights[r]) * (r - l);
            max_area = Math.max(product,max_area);

            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }

        return max_area;
    }
}
