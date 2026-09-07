class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array to store net trust scores for each person (1-indexed)
        int[] trustScore = new int[n + 1];
        
        // Process every trust pair [a, b]
        for (int[] pair : trust) {
            trustScore[pair[0]]--; // Person 'a' trusts someone, decrease score
            trustScore[pair[1]]++; // Person 'b' is trusted, increase score
        }
        
        // Check who has a score equal to n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}