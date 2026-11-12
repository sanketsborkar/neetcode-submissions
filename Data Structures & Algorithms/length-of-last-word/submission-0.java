class Solution {
    public int lengthOfLastWord(String s) {
        String[] trimmed = s.trim().split(" ");
        return trimmed[trimmed.length-1].length();
    }
}