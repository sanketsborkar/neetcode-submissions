class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1_freq = new char[26];
        char[] s2_freq = new char[26];

        int n1 = s1.length();
        int n2 = s2.length();
        
        // Edge case: If s1 is longer than s2, s2 cannot contain its permutation
        if (n1 > n2) {
            return false;
        } 

        for (int i = 0; i < n1; i++) {
            s1_freq[s1.charAt(i) - 'a']++;
            s2_freq[s2.charAt(i) - 'a']++;
        }

        for (int i = n1; i < n2; i++) {
             // Check if current window matches s1 character frequencies
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }
            
            // Move window right: Add new character, remove oldest character
            s2_freq[s2.charAt(i) - 'a']++;         // Incoming character
            s2_freq[s2.charAt(i - n1) - 'a']--;    // Outgoing character
        }

        return Arrays.equals(s1_freq, s2_freq);
    }
}
