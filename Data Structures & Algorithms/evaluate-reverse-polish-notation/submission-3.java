class Solution {
    public int evalRPN(String[] tokens) {

        if (tokens.length == 0)
            return 0;

        else if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);

        int result = 0;
        Deque<Integer> calculations = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equalsIgnoreCase("+")) {
                int operand1 = calculations.pop();
                int operand2 = calculations.pop();
                result = operand1 + operand2;
                calculations.push(result);
            }
            else if (token.equalsIgnoreCase("*")) {
                int operand1 = calculations.pop();
                int operand2 = calculations.pop();
                result = operand1 * operand2;
                calculations.push(result);
            }
            else if (token.equalsIgnoreCase("-")) {
                int operand1 = calculations.pop();
                int operand2 = calculations.pop();
                result = operand2 - operand1;
                calculations.push(result);
            }
            else if (token.equalsIgnoreCase("/")) {
                int operand1 = calculations.pop();
                int operand2 = calculations.pop();
                result = operand2 / operand1;
                calculations.push(result);
            }
            else 
                calculations.push(Integer.parseInt(token));
        }

        return result;
    }
}
