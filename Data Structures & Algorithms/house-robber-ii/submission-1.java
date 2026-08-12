class Solution {
    public int rob(int[] nums) {
        // Base case: If there are no houses, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Base case: If there is only one house, rob it
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Scenario 1: Rob from the first house to the second-to-last house
        int max1 = robLinear(nums, 0, nums.length - 2);
        // Scenario 2: Rob from the second house to the last house
        int max2 = robLinear(nums, 1, nums.length - 1);
        
        // The result is the maximum profit of both scenarios
        return Math.max(max1, max2);
    }
    
    // Helper function to solve the standard, linear House Robber I problem
    private int robLinear(int[] nums, int start, int end) {
        int prevRob = 0; // Represents the max money if we robbed the previous house
        int currentMax = 0; // Represents the overall max money up to the current house
        
        for (int i = start; i <= end; i++) {
            // Options: Rob current house + max from 2 houses ago, OR skip current house
            int temp = Math.max(prevRob + nums[i], currentMax);
            prevRob = currentMax;
            currentMax = temp;
        }
        
        return currentMax;
    }
}
