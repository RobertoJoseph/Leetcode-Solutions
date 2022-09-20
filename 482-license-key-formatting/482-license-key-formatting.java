class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder(); 
        
        int count = k; 
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) !='-') {
                if(count>0) {
                    sb.append(Character.toUpperCase(s.charAt(i))); 
                    count--;
                }else {
                    sb.append('-');
                    sb.append(Character.toUpperCase(s.charAt(i))); 
                    count = k-1;
                }   
            }
        }
        
        return sb.reverse().toString(); 
    }
}