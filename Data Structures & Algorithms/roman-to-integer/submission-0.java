class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = romanMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            /*if(s.charAt(i).equals("I"))
            then increment by 1
            if (equals("V"))
            then increment by 5 
            but if prev charAt's equivalent value is less than current one 
            then subtract current charAt from previous one
            then do similarly for X, L, C, D, M*/
            if (romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i-1)))
                result += romanMap.get(s.charAt(i)) - 2*(romanMap.get(s.charAt(i-1)));
            else
                result += romanMap.get(s.charAt(i));
            
        }

        return result;
    }
}