class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] stores the minimum coins needed to make up amount i
        int[] dp = new int[amount + 1];
        
        // Fill the array with a sentinel value (amount + 1 is impossible to reach)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Iteratively compute the minimum coins for each amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] wasn't updated, it means the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
