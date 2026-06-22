class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0)
            return "";
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        String stringEncoded = encodedString.toString();
        System.out.println(stringEncoded);
        return stringEncoded;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        
        int i = 0;
        while (i < str.length()) {
            // Find the delimiter starting from position i
            int delimiterPos = str.indexOf('#', i);
            
            // Extract the length of the next string segment
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            
            // Move pointer past the '#' delimiter
            i = delimiterPos + 1;
            
            // Extract the actual string using the computed length
            String actual_str = str.substring(i, i + length);
            result.add(actual_str);
            
            // Advance pointer to the start of the next segment
            i += length;
        }
        return result;
    }
}
