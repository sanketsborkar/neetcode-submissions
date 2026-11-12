class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
            else {
                countOnes = 0;
            }
            maxOnes = Math.max(maxOnes, countOnes);
        }

        return maxOnes;
    }
}