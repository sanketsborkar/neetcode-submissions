class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                for (int j = i; j < nums.length && nums[j] == 1; j++)
                    countOnes++;
            }
            maxOnes = Math.max(maxOnes, countOnes);
            countOnes = 0;
        }

        return maxOnes;
    }
}