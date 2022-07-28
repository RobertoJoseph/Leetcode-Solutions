class Solution {
    int[]memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        return countSteps(0,n);
        
    }
    
    public int countSteps(int i , int n){
        if(i>n){
            return 0;
        }
        if(i==n)return 1;
        if(memo[i]>0)return memo[i];
        memo[i] = countSteps(i+1,n)+countSteps(i+2,n);
        return memo[i];
    }
}