class Solution {
    public int[] replaceElements(int[] arr) {
        // Initialize max as -1 because the rightmost element always gets -1
        int max = -1; 
        
        // Traverse backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentVal = arr[i]; // Keep track of the original value
            
            arr[i] = max;            // Replace current element with the max to its right
            
            if (currentVal > max) {  // Update max for the next element to the left
                max = currentVal;
            }
        }
        
        return arr; // Modifies in-place, achieving O(1) extra space
    }
}
