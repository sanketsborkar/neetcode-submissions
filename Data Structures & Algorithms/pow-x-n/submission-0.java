class Solution {
    public double myPow(double x, int n) {
        double y = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) 
                y = y * x;
        }
        else {
            for (int i = -1; i >= n; i--)
                y = y/x;
        }
        
        return y;
    }
}
