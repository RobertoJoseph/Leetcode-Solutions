class Solution {

    public String licenseKeyFormatting(String s, int k) {
        int totalNumOfWords = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != '-') totalNumOfWords++;
        int rem = totalNumOfWords % k;
        StringBuilder sb = new StringBuilder();
        if (rem != 0) {
            //We need to append the first rem chars
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '-' && rem > 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    rem--;
                }
                if (rem <= 0) break;
            }
        }
        rem = sb.length();
        int groups = totalNumOfWords / k;
        int i = 0;
        while (i < s.length()) {
            int charsPerGroup = k;
            if (rem == 0) {
                while (charsPerGroup > 0 && i < s.length()) {
                    if (s.charAt(i) != '-') {
                        sb.append(Character.toUpperCase( s.charAt(i)));
                        charsPerGroup--;
                    }
                    i++;
                }
                if (charsPerGroup <= 0) sb.append("-");
            } else {
                while(rem!=0&&i<s.length()){
                if(s.charAt(i)!='-')
                 rem--;
                i++;
                }
                sb.append("-");
            }
        }
        String res=sb.toString();
        if(sb.length()>=1)
        if(sb.charAt(sb.length()-1)=='-'){
           res =  sb.substring(0,sb.length()-1);
        }
        return res;
    }
}
