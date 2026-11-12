class Solution {
     public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
           for (int j = i + 1; j < words.length; j++) {
               if (words[i].contains(words[j]) || words[j].contains(words[i])) {
                   String resultToAdd = words[i].length() > words[j].length() ? words[j] : words[i];

                   if (!result.contains(resultToAdd))
                       result.add(resultToAdd);
               }
           }
        }

        return result;
    }
}