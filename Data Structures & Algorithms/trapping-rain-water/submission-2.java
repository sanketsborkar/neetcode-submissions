class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // Initialize pointers at opposite ends
        int left = 0;
        int right = height.length - 1;
        
        // Track the maximum wall heights from both directions
        int leftMax = 0;
        int rightMax = 0;
        
        int totalWater = 0;
        
        while (left < right) {
            // Process the side with the shorter boundary wall
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update max wall on left
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update max wall on right
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }
        
        return totalWater;
    }
}
