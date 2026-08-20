class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // Allocate the helper array ONCE to prevent LeetCode from throwing a TLE
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Recursively divide the array
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);

        // Conquer: Merge the sorted halves
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        // Copy the current segment into the temporary helper array
        for (int k = left; k <= right; k++) {
            temp[k] = nums[k];
        }

        int i = left;      // Pointer for the left subarray
        int j = mid + 1;   // Pointer for the right subarray
        int r = left;      // Pointer for the main array

        // Merge elements back in sorted order
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[r] = temp[i];
                i++;
            } else {
                nums[r] = temp[j];
                j++;
            }
            r++;
        }

        // Copy any remaining elements from the left side
        // Remaining right elements are already in their correct destination positions
        while (i <= mid) {
            nums[r] = temp[i];
            r++;
            i++;
        }
    }
}