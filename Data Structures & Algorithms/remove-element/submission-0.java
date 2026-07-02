class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0; // Tracks the position for valid elements
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value to remove
            if (nums[i] != val) {
                nums[index] = nums[i]; // Move it to the front
                index++; // Advance the valid position tracker
            }
        }
        
        // Return the count of valid elements
        return index; 
    }
}