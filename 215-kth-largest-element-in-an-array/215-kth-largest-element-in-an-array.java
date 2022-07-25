class Solution {
    int[]nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int N = nums.length;
        return quickSelect(0,N-1,N-k);
    }
    
    
    public void swap(int a ,int b){
        int temp = nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
        
    }
  public int partition(int left, int right, int pivot_index) {
    int pivot = this.nums[pivot_index];
    // 1. move pivot to end
    swap(pivot_index, right);
    int store_index = left;

    // 2. move all smaller elements to the left
    for (int i = left; i <= right; i++) {
      if (this.nums[i] < pivot) {
        swap(store_index, i);
        store_index++;
      }
    }

    // 3. move pivot to its final place
    swap(store_index, right);

    return store_index;
  }
    
    public int quickSelect(int left , int right ,int smallestK){
        if(left==right){
            return this.nums[left];
        }
        
        Random r = new Random();
        int pivotIndex = left+r.nextInt(right-left);
        pivotIndex = partition(left,right,pivotIndex);
        if(pivotIndex==smallestK){
            return this.nums[smallestK];
        }else if(pivotIndex>smallestK){
            return quickSelect(left,pivotIndex-1, smallestK);
        }return quickSelect(pivotIndex+1,right,smallestK);
    }
    
}