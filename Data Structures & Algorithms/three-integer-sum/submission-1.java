class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to use the two-pointer approach and easily skip duplicates
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 2. Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Optimization: If the current smallest number is > 0, three positive numbers cannot sum to 0
            if (nums[i] > 0) {
                break;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            // 3. Two-pointer search for the remaining two elements
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 4. Move pointers and skip duplicate values for second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum is too small, move left pointer right to increase sum
                } else {
                    right--; // Sum is too large, move right pointer left to decrease sum
                }
            }
        }
        
        return result;
    }
}
