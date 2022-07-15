class Solution {
    public String addStrings(String num1, String num2) {
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        String result= "";
        
        while(i >= 0 || j >= 0 || carry == 1) {
            int sum= carry;
            if(i >= 0)
                sum +=num1.charAt(i) - '0';
            if(j >= 0)
                sum+= num2.charAt(j) - '0';
            
            carry = 0;
            if(sum > 9) {
                carry = 1;
                result = sum%10 + result;
            } else {
                result = sum + result;
            }
            i--;
            j--;
        }
        return result;
    }
}