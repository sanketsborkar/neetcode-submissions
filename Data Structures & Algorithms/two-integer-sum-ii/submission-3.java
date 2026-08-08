class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (complementMap.containsKey(complement)) {
                return new int[] {complementMap.get(complement), i+1};
            }

            complementMap.put(nums[i], i+1);
        }

        return new int[] {0, 0};
    }
}
