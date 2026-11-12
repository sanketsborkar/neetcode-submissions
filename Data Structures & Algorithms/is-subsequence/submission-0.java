class Solution {
    public boolean isSubsequence(String s, String t) {
        // Base edge case: an empty string is always a subsequence
        if (s.isEmpty()) {
            return true;
        }

        int sPointer = 0;
        int tPointer = 0;

        // Loop until we run out of characters in either string
        while (tPointer < t.length()) {
            // If characters match, move the s pointer forward
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;

                // If sPointer reaches the end, all characters were matched in order
                if (sPointer == s.length()) {
                    return true;
                }
            }
            // Always move the t pointer forward
            tPointer++;
        }

        return false;
    }
}