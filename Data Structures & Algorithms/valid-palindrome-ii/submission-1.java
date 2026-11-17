class Solution {
    public boolean validPalindrome(String s) {
        if (checkPalindrome(s)) 
            return true;

        else {
            int indexCharToDelete = 0;
            while (indexCharToDelete < s.length()) {
                String alteredString = s.substring(0, indexCharToDelete) + s.substring(indexCharToDelete+1,s.length());
                if (checkPalindrome(alteredString))
                    return true;
                indexCharToDelete++;
            } 
        }

        return false;
    }

    public boolean checkPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        if (s.equals(reversed))
            return true;
        else
            return false;
    }
}