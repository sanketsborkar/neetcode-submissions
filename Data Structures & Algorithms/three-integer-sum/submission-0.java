class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); //[-4,-1,-1,0,1,2]

        int result = 0;
        int count = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        //Keep incrementing to next index until result reaches 0 
        //and list reaches size 3.
        for (int i = 0; i < nums.length - 2; i++) {
           for (int j = i+1; j < nums.length - 1; j++) {
            for (int k = j+1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] == 0)
                    totalList.add(Arrays.asList(Integer.valueOf(nums[i]), 
                    Integer.valueOf(nums[j]), 
                    Integer.valueOf(nums[k])));
            }
           }
        }

        return totalList.stream()
            .map(list -> list.stream().sorted().toList()) 
            .distinct()
            .toList();
    }
}
