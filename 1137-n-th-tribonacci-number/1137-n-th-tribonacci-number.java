class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return n;
        }
        if(n==1||n==2)return 1;
        int[]trb = new int[n+1];
        trb[0]=0;
        
        trb[1]=1;
        trb[2]=1;
        for(int i =3; i<=n; i++){
            trb[i] = trb[i-1]+trb[i-2]+trb[i-3];
        }
        return trb[n];
        
    }
}