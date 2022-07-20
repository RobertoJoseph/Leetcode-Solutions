class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1Ex = nums1.length-1;
        int p1 = m-1;
        int p2 = n-1;
        while(p1>=0&&p2>=0){
            if(nums1[p1]<nums2[p2]){
                nums1[p1Ex] = nums2[p2];
                p1Ex--;
                p2--;
            }else if(nums1[p1]>nums2[p2]){
                nums1[p1Ex]=nums1[p1];
                p1Ex--;
                p1--;
            }else{
                nums1[p1Ex] = nums1[p1];
                p1Ex--;
                p1--;
            }
            
        }
        if(p2>=0){
            while(p2>=0){
                nums1[p1Ex] = nums2[p2];
                p2--;
                p1Ex--;
            }
        }else if(p1>=0){
            while(p1>=0){
                nums1[p1Ex]= nums1[p1];
                p1--;
                p1Ex--;
            }
}
       
        
    }
}