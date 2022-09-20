class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String>hs = new HashSet<>();
        int count =0;
        for(int i =0; i<emails.length; i++){
            StringBuilder sb = new StringBuilder();
            int plus=0;
            String work = emails[i];
            for(int j=0; j<emails[i].length(); j++){
                if(work.charAt(j)=='@')
                    plus=1;
                if(plus==1){
                    sb.append(work.charAt(j));
                }
                else
                if(plus==0){
                    if(work.charAt(j)=='+'){
                        plus=2;
                    }else
                      if(work.charAt(j)!='.')sb.append(work.charAt(j));
                 }
            }
            System.out.println(sb);
                
            if(!hs.contains(sb.toString())){
                count++;
                hs.add(sb.toString());
            }
            
        }
        return count;
    }
}