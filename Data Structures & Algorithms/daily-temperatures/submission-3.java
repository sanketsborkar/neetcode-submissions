class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //30   -> 0
        //38   -> 1
        //38,30  -> 1,2
        //38,36  -> 1,3
        //38,36,35 -> 1,3,4
        //40 -> 5
        //40,28 -> 6
        Deque<Integer> temperatureIndexStack = new ArrayDeque<>();
        int lastPoppedIndex = 0;
        int res[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
           while (!temperatureIndexStack.isEmpty() && temperatures[i] > temperatures[temperatureIndexStack.peek()]) {
                    lastPoppedIndex = temperatureIndexStack.pop();
                    res[lastPoppedIndex] = i - lastPoppedIndex;
                }
                    
                temperatureIndexStack.push(i);    
        }
        
        return res;
    }
}
