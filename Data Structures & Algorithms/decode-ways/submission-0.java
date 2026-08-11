class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int twoBack = 1; // Represents dp[i-2]
        int oneBack = 1; // Represents dp[i-1]

        for (int i = 1; i < n; i++) {
            int current = 0;
            char currentChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            // 1. Check if single digit decoding is valid (1-9)
            if (currentChar != '0') {
                current += oneBack;
            }

            // 2. Check if two-digit decoding is valid (10-26)
            if (prevChar == '1' || (prevChar == '2' && currentChar <= '6')) {
                current += twoBack;
            }

            // Move state forward
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
