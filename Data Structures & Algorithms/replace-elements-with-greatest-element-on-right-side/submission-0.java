class Solution {
    public int[] replaceElements(int[] arr) {
        int max = 0;
        int res[] = new int[arr.length];
        res[arr.length-1] = -1;
        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] > max){
                max = arr[i];
            }

            if (i - 1 < 0)
                break;

            res[i-1] = max;
        }

        return res;
    }
}