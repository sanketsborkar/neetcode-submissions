class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Update the lowest price we've seen so far
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate profit if we sold at current price and update max profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}