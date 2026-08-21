class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0 || h == 0)
            return 0;

        //Find max bananas value in piles
        int left = 1;
        int right = 0;
        for (int pile : piles) 
            right = Math.max(pile, right);
        
        //Do a binary search for every k and ceil off the result of every pile division operation and sum it up to check if its less than or equal to h, else continue.
        int ret_value = right;
        while (left <= right) {
            int mid = left + (right - left)/2;

            int sum = 0;
            for (int pile : piles) 
                sum += Math.ceil((double) pile/mid);
                
            if (sum <= h) {
                ret_value = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        //Return the result
        return ret_value;
    }
}
