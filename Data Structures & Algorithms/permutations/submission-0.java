class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Keep track of elements used in the current permutation path
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: If the current list matches the input length, we found a complete permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Create a deep copy
            return;
        }

        // Iterate through all numbers to build branches
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) {
                continue;
            }

            // 1. Take choice
            used[i] = true;
            current.add(nums[i]);

            // 2. Explore further recursive possibilities
            backtrack(nums, current, used, result);

            // 3. Backtrack (undo choice)
            current.removeLast();
            used[i] = false;
        }
    }
}
