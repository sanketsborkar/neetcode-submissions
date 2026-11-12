class Solution {
    public int countSeniors(String[] details) {
       int seniors = 0;
        for (String detail : details) {
            String regex = "[a-zA-Z]";
            Matcher matcher = Pattern.compile(regex).matcher(detail);

            int age = -1;
            if (matcher.find()) {
                int index = matcher.start();
                age = Integer.parseInt(detail.substring(index+1, index+3));

                if (age > 60)
                    seniors++;
            }
        }

        return seniors; 
    }
}