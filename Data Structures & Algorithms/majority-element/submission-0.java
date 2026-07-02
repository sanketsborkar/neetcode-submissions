class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            // If count reaches 0, we pick the current number as the new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // Increment count if num matches the candidate, otherwise decrement
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}