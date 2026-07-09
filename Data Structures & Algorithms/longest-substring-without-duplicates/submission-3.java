class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        Set<Character> subStringSet = new HashSet<>();
        while (r < charArray.length) {
            if (subStringSet.contains(charArray[r])) {
                 subStringSet.remove(charArray[l]);
                 l++;
            }       
            else {
                subStringSet.add(charArray[r]);
                r++;
                maxLen = Math.max(maxLen, subStringSet.size());
            }
        }
        
        return maxLen;
    }
}
