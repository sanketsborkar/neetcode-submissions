public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] represents if the substring s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true;
        
        // Iterate through all possible substring end positions
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible split points before i
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] is valid and s[j...i-1] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Move to the next index 'i' early
                }
            }
        }
        
        return dp[s.length()];
    }
}
