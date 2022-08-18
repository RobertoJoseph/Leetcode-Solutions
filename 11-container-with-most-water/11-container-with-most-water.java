class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max = -1;
        int area;
        while(left<right){
           if(height[left]<height[right]){
               area = (right-left)*height[left];
               left++;
           }else{
               area = (right-left)*height[right];
               right--;
           }
            max =Math.max(max,area);
        }
     
        return max;
    }
}