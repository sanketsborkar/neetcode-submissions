class Solution {
    public double myPow(double x, int n) {
        double y = 1;
        for (int i = 1; i <= Math.abs(n); i++) 
                y = y * x;
        
        return n >= 0 ? y : 1/y;
    }
}
