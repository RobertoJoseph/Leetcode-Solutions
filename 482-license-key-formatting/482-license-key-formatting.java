class Solution {
    public String licenseKeyFormatting(String s, int k) {
        if(s == null || s.equals("")){
            return "";
        }
        s = s.replaceAll("-", "").toUpperCase();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() -1; i >=0; i--){
            sb.append(s.charAt(i));
            count++;
            if(i != 0 && count == k){
                sb.append("-");
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}