public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // Standard backtracking setup
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> palindromeList, int start, String s) {
        // FIX 2 & 3: Base case handles correct solution addition via deep copy
        if (start == s.length()) {
            result.add(new ArrayList<>(palindromeList));
            return;
        }

        // We can safely use a clean StringBuilder for tracking the current candidate substring
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));

            // FIX 1: Safely check for palindrome without mutating the main StringBuilder state
            if (isPalindrome(sb)) {
                // Choice: Accept the substring
                palindromeList.add(sb.toString());

                // Recurse: Move to next index
                backtrack(result, palindromeList, i + 1, s);

                // Backtrack: Remove the last added substring
                palindromeList.remove(palindromeList.size() - 1);
            }
        }
    }

    // Helper method to check palindrome efficiently without permanent reversal side effects
    private boolean isPalindrome(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
