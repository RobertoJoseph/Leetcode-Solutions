class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        int open =0;
        int close =0;
        char[]ch = s.toCharArray();
        for(int i =0; i<ch.length; i++){
            if(ch[i]=='('){
                open++;
                st.push(ch[i]);}
            else{
                if(!st.isEmpty()){
                    st.pop();
                    open--;
                }else{
                    close++;
                }
            }
        
    }
        return open+close;
        
}
}