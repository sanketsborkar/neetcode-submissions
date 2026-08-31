class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        
        // Map to store frequency of prefix sums
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred 1 time (empty prefix)
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            
            // If (current_sum - k) exists in the map, it means a valid subarray exists
            if (map.containsKey(diff)) {
                res += map.get(diff);
            }
            
            // Record/update the frequency of the current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}