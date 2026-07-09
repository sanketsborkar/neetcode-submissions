class Solution {
    public boolean isValid(String s) {
        // A valid string must have an even number of characters
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it is an opening bracket, push its expected closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it is a closing bracket, check if it matches the top of the stack
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were correctly matched
        return stack.isEmpty();
    }    
}
