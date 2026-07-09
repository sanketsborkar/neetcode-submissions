class MinStack {

    int minimum;
    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stackData.push(val);
        if (stackMin.isEmpty()) {
            stackMin.push(val);
        } else {
            stackMin.push(Math.min(val, stackMin.peek()));
        }
    }
    
    public void pop() {
        stackData.pop();
        stackMin.pop();
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}
