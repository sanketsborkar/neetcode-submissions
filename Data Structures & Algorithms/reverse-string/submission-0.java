class Solution {
    public void reverseString(char[] s) {
        for (int i = s.length - 1, index = 0; index < i; i--, index++) {
            char temp = s[index]; 
            s[index] = s[i]; 
            s[i] = temp; 
        }
    }
}