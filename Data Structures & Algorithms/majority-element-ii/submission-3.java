class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1)
            return List.of(nums[0]);
        else if (nums.length == 2)
            return List.of(nums[0],nums[1]);

        Arrays.sort(nums);

        List<Integer> majorityElements = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int length = 1;
            while (nums[i] == nums[i - 1]) {
                length++;
                if (length > nums.length/3 &&      !majorityElements.contains(nums[i]))
                    majorityElements.add(nums[i]);
                if (i+1 == nums.length)
                    break;
                i++;
            }
        }

        return majorityElements;
    }
}