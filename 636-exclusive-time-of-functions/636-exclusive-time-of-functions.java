class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer>st = new Stack<>();
        int[]ans = new int[n];
        int lastTimeLogStamp = -1;
        for(String log : logs){
            String[]str = log.split(":");
            int functionId = Integer.parseInt(str[0]);
            boolean isStart = "start".equals(str[1]);
            int timeStamp = Integer.parseInt(str[2]);
            if(!isStart)timeStamp++;
            if(!st.isEmpty()){
                int curId = st.peek();
                ans[curId]+=timeStamp-lastTimeLogStamp;
            }
            if(isStart){
                st.push(functionId);
            }
            if(!isStart){
                st.pop();
            }
            
            lastTimeLogStamp = timeStamp;
            
        }
        return ans;
    }
}