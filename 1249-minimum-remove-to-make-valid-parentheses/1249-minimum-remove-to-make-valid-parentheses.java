class Solution {
    
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else if (s.charAt(i) == ')') {
                if (st.isEmpty())
                    chars[i] = '#';
                else
                    st.pop();
            }
        }
        while (!st.isEmpty()) {
            chars[st.pop()] = '#';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') continue;
            ;
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}