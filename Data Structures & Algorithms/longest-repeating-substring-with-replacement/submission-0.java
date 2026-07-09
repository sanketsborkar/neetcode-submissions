class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int charIdx = s.charAt(right) - 'A';
            count[charIdx]++;
            maxFreq = Math.max(maxFreq, count[charIdx]);

            // If characters to replace exceed k, shrink the window from the left
            if ((right - left + 1) - maxFreq > k) {
                int leftCharIdx = s.charAt(left) - 'A';
                count[leftCharIdx]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
