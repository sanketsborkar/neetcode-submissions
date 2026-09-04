class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Use StringBuilder for memory efficiency during string manipulation
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: If the current string reaches the maximum required length
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Decision 1: Add an opening parenthesis if we haven't reached the limit 'max'
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Decision 2: Add a closing parenthesis if it wouldn't exceed the opening ones
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
