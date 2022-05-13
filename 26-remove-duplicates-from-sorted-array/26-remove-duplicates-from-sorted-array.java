class Solution {
    public int removeDuplicates(int[] nums) {
        int seen = -102;
        int j = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (seen != nums[i]) {
                nums[j] = nums[i];
                seen = nums[i];
                k++;
                j++;
            }
        }
        return k;
    }
}