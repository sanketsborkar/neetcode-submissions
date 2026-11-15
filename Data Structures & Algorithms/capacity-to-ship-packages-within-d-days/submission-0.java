class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShipWithinDays(weights, mid, days)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean canShipWithinDays(int[] weights, int capacity, int days) {
        int currentWeight = 0;
        int numberOfDays = 1;
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                numberOfDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return numberOfDays <= days;
    }
}