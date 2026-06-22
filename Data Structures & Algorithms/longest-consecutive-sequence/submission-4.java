class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        Arrays.sort(nums);

        for (int num : nums)
            System.out.print(num+",");

        System.out.println();
       
        int init_num = nums[0];
        int count = 1;
        int[] countArr = new int[nums.length];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == init_num + 1) {
                count++;    
            }   
            else if (nums[i] == init_num)
                continue;
            else {
                countArr[j++] = count;
                count = 1;
            }
            init_num = nums[i];  
        }
        countArr[j++] = count;

        Arrays.sort(countArr);

        for (int num : countArr)
            System.out.print(num+",");

        return countArr[countArr.length-1];
    }
}
