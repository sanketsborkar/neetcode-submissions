class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] dupNums = nums;
        int[] resultNums = new int[nums.length*2];
        System.arraycopy(nums, 0, resultNums, 0, nums.length);

        System.arraycopy(dupNums, 0, resultNums, nums.length, dupNums.length);

        return resultNums;
    }
}