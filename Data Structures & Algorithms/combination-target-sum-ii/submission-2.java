class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting helps to optimize and prune unnecessary branches early
        Arrays.sort(candidates); 
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        // Base case: if remaining target is 0, we found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Optimization: if the candidate is greater than the remaining target, 
            // all subsequent candidates will also be too large because the array is sorted.
            if (candidates[i] > remain) {
                break; 
            }

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 1. Choose the current element
            currentList.add(candidates[i]);
            
            // 2. Explore: pass 'i' as the start index instead of 'i + 1' to allow reusing the same element
            backtrack(result, currentList, candidates, remain - candidates[i], i+1);
            
            // 3. Backtrack: remove the last element before the next loop iteration
            currentList.remove(currentList.size() - 1);
        }
    }
}
