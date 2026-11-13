class Solution {
    public int appendCharacters(String s, String t) {
        int s_count = 0;
        int t_count = 0;

        while (s_count < s.length() && t_count < t.length()) {
            if (t.charAt(t_count) == s.charAt(s_count)) {
                t_count++;
            }
            s_count++;
        }

        return t.length() - t_count;
    }
}