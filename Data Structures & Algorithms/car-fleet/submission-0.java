class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        // Sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        Deque<Double> stack = new ArrayDeque<>();
        
        //time = {3,5,10,3}
        //time_new = {10,5,3,3}
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            // If the stack is empty or the car takes longer, it starts a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // If time <= stack.peek(), this car joins the fleet ahead; we do nothing
        }
        
        return stack.size();
    }
}
