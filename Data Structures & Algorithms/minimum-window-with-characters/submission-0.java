class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency array to store characters needed from string t
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        // Window tracking variables
        int[] window = new int[128];
        int left = 0, right = 0;
        int count = 0; // Total matched characters
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        // Expand the right boundary of the window
        while (right < s.length()) {
            char rChar = s.charAt(right);
            window[rChar]++;

            // If the character is needed and its window count matches/undergoes need count
            if (need[rChar] > 0 && window[rChar] <= need[rChar]) {
                count++;
            }

            // Shrink the window from the left when all characters are found
            while (count == t.length()) {
                // Update the minimum window metrics
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                window[lChar]--;

                // If removing this character breaks the valid window condition
                if (need[lChar] > 0 && window[lChar] < need[lChar]) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
