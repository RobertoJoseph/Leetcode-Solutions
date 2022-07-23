class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int ans =-1;
        for(int i =nums.length-1; i>=0; i--){
            if(k==0)break;
            ans = nums[i];
            k--;
            
            
        }//1 2 3 4 5 6
        return ans;
    }
}