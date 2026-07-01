class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is null or empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Initialize the prefix candidate with the first string
        String prefix = strs[0];
        
        // Compare the prefix with all other strings in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by removing its last character
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}