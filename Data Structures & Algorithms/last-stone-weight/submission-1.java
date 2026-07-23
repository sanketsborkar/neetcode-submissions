class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> stoneWeightQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones)
            stoneWeightQueue.add(stone); //2,2,3,4,6
        
        while(stoneWeightQueue.size() != 1) {
            Integer highest = stoneWeightQueue.poll();

            Integer second_highest = stoneWeightQueue.poll();

            Integer difference = highest - second_highest;

            stoneWeightQueue.add(difference); //2,2,2,3  //1,2,2 //
        }

        return stoneWeightQueue.peek();
    }
}
