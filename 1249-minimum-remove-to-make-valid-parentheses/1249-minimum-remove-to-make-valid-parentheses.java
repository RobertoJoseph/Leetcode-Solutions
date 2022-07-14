class Solution {
    
    
    public  String minRemoveToMakeValid(String s) {
        int opens = 0;
        char[] a = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char x : a) {
            if (x == '(') opens++;
            else if (x == ')') {
                if (opens == 0) continue;
                opens--;
            }
            sb.append(x);
        }
        StringBuilder rs2 = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && opens-- > 0) {
                continue;
            }
            rs2.append(sb.charAt(i));
        }

        return rs2.reverse().toString();

    }

}